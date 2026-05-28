package test;
import java.sql.*;
import java.util.*;
import java.sql.*;
import connection.Connex;
import bdd.*;

//  create table chien(id CHAR(7),nom VARCHAR(20),race VARCHAR(10));
//  create sequence seqChien start with 1;

public class Chien extends BddClass
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
	String nom;
	public void setNom(String t)
	{
		this.nom=t;
	}
	public String getNom()
	{
		return this.nom;
	}	
	String race;
	public void setRace(String t)
	{
		this.race=t;
	}
	public String getRace()
	{
		return this.race;
	}



	public Chien()
	{

	}

	public Chien(String nom,String race)throws Exception
	{
        super.setPrefix("CHN");
        super.setSeqName("seqChien");
		setId(super.construirePK(get_sequence()));
		setNom(nom);
		setRace(race);
	}

	public Vector<Chien> get_Tab(Vector<Object> o)
	{
		Vector<Chien> result=new Vector<Chien>();
		for(int i=0;i<o.size();i++)
		{
			result.add((Chien)o.get(i));
		}
		return result;
	}
}