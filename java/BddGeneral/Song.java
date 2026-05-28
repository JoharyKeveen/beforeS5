package test;
import java.sql.*;
import java.util.*;
import java.sql.*;
import connection.Connex;
import bdd.*;

//	create table Song(id CHAR(7),title VARCHAR(25),artiste VARCHAR(25),album VARCHAR(25),genre VARCHAR(25));
//	create sequence seqSong start with 1;

public class Song extends BddClass
{
	String id;
	public void setId(String t)
	{
		this.id=t;
	}
	public String getId()
	{
		return this.id;
	}
	String title;
	public void setTitle(String t)
	{
		this.title=t;
	}
	public String getTitle()
	{
		return this.title;
	}
	String artiste;
	public void setArtiste(String t)
	{
		this.artiste=t;
	}
	public String getArtiste()
	{
		return this.artiste;
	}	
	String album;
	public void setAlbum(String t)
	{
		this.album=t;
	}
	public String getAlbum()
	{
		return this.album;
	}
	String genre;
	public void setGenre(String g)
	{
		this.genre=g;
	}
	public String getGenre()
	{
		return this.genre;
	}



	public Song()
	{

	}

	public Song(String title,String artiste,String album,String genre)throws Exception
	{
		super.setPrefix("SNG");
		super.setSeqName("seqSong");
		setId(super.construirePK(get_sequence()));
		setTitle(title);
		setArtiste(artiste);
		setAlbum(album);
		setGenre(genre);
	}

	public Vector<Song> get_Tab(Vector<Object> o)
	{
		Vector<Song> result=new Vector<Song>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Song)o.get(i));
		}
		return result;
	}
}