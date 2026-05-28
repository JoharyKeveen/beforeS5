package traitement;
import com.mpatric.mp3agic.*;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.sql.*;
import connection.*;

public class TraitementMp3
{
	Mp3 song;
	long latest;
	public TraitementMp3()throws Exception
	{
		song= new Mp3();
		this.latest=get_last();
	}

	public long get_last()throws Exception
	{
		long result=0;
		Connex co=new Connex();
		Connection lo=co.log();
		Statement state=lo.createStatement();
		ResultSet rs=state.executeQuery("select max(last) from last_access");
		while(rs.next()){
			result=rs.getLong(1);
		}
		state.close();
		lo.close();
		return result;
	}
	public void set_last(long time)throws Exception
	{
		Connex co=new Connex();
		Connection lo=co.log();
		Statement state=lo.createStatement();
		String sql="insert into last_access values("+time+")";
		state.executeUpdate(sql);
		lo.commit();
		state.close();
		lo.close();
	}

	public void retrieveMetaData(String path)throws Exception
	{
		Mp3File mp3file=null;
		try
		{
			mp3file= new Mp3File(path);
		}
		catch(Exception e)
		{
			throw new Exception("file not found");
		}
		if(mp3file.hasId3v1Tag())
		{
			ID3v1 id3v1tag=mp3file.getId3v1Tag();
			song.set_title(id3v1tag.getTitle());
			song.set_artiste(id3v1tag.getArtist());
			song.set_album(id3v1tag.getAlbum());
			song.set_genre(id3v1tag.getGenre());
			song.save();
			Path file=Paths.get(path);
			BasicFileAttributes attr=Files.readAttributes(file,BasicFileAttributes.class);
			System.out.println((attr.lastAccessTime().toMillis()>latest));
	    	if (attr.lastAccessTime().toMillis()>latest) 
			{
				set_last(attr.lastAccessTime().toMillis());
			}
		}
	}

	public void reset(String directory)throws Exception
	{
		File file=new File(directory);
		File[] all_file=file.listFiles();
		Vector<String> path=new Vector<String>();
		for(int j=0;j<all_file.length;j++)
		{
			String temp=directory+"/"+all_file[j].getName();
			path.add(temp);
		}
		for(int i=0;i<path.size();i++)
		{
			this.retrieveMetaData(path.get(i));
		}
	}

	public void reset_latest_update(String directory)throws Exception
	{
		File file=new File(directory);
		File[] all_file=file.listFiles();
		Vector<String> paths=new Vector<String>();
		for(int j=0; j<all_file.length; j++) 
		{
			String temp=directory+"/"+all_file[j].getName();
			Path path=Paths.get(temp);
			BasicFileAttributes attr=Files.readAttributes(path,BasicFileAttributes.class);
			if (attr.lastAccessTime().toMillis()>latest) 
			{
				paths.add(temp);
			}
		}
		for(int i=0; i<paths.size(); i++) 
		{
			this.retrieveMetaData(paths.get(i));
		}
	}
}