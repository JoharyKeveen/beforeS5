package traitement;
import java.sql.*;
import java.util.*;
import java.sql.*;
import connection.Connex;
public class Mp3
{
	String title;
	public void set_title(String t)
	{
		this.title=t;
	}
	public String getTitle()
	{
		return this.title;
	}
	String artiste;
	public void set_artiste(String t)
	{
		this.artiste=t;
	}
	public String getArtiste()
	{
		return this.artiste;
	}	
	String album;
	public void set_album(String t)
	{
		this.album=t;
	}
	public String getAlbum()
	{
		return this.album;
	}
	int genre;
	public void set_genre(int g)
	{
		this.genre=g;
	}
	public int getGenre()
	{
		return this.genre;
	}



	public Mp3()
	{

	}

	public Mp3(String title,String artiste,String album,int genre)
	{
		set_title(title);
		set_artiste(artiste);
		set_album(album);
		set_genre(genre);
	}

	public void save()throws Exception
	{
		Connex co=new Connex();
        Connection lo=co.log();
		try
		{
			Statement stat=lo.createStatement();
			stat.executeQuery("insert into song values('"+this.getTitle()+"','"+this.getArtiste()+"','"+this.getAlbum()+"','"+this.getGenre()+"')");
			lo.commit();
		}
		catch(Exception e)
		{
			lo.rollback();
		}
		lo.close();
	}
}