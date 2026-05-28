package object;
import java.lang.reflect.*;
import connection.*;
import java.sql.*;
import java.util.*;

public class Person extends BddClass
{
    // create table Person(
    //     id int,
    //     nom VARCHAR2(25),
    //     genre VARCHAR2(7),
    //     nationality VARCHAR2(20),
    //     finoana VARCHAR2(6),
    //     fiaviana VARCHAR2(20),
    //     diplome int,
    //     alavana int,
    //     teint VARCHAR2(20),
    //     salaire NUMBER(7)
    // );
    int id;
    String nom;
    String genre;
    String nationality;
    boolean finoana;
    String fiaviana;
    int diplome;
    int alavana;
    String teint;
    int salaire;

    public Person()
    {}

    // MyAxe axe;
    // CritereAxe critere;

    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public void setGenre(String genre)
    {
        this.genre=genre;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setNationality(String nationality)
    {
        this.nationality=nationality;
    }
    public void setFinoana(boolean finoana)
    {
        this.finoana=finoana;
    }
    public void setFiaviana(String fiaviana)
    {
        this.fiaviana=fiaviana;
    }
    public void setDiplome(int diplome)
    {
        this.diplome=diplome;
    }
    public void setAlavana(int alavana)
    {
        this.alavana=alavana;
    }
    public void setTeint(String teint)
    {
        this.teint=teint;
    }
    public void setSalaire(int salaire)
    {
        this.salaire=salaire;
    }


    public String getNom()
    {
        return this.nom;
    }
    public String getGenre()
    {
        return this.genre;
    }
    public int getId()
    {
        return this.id;
    }
    public String getNationality()
    {
        return this.nationality;
    }
    public boolean getFinoana()
    {
        return this.finoana;
    }
    public String getFiaviana()
    {
        return this.fiaviana;
    }
    public int getDiplome()
    {
        return this.diplome;
    }
    public int getAlavana()
    {
        return this.alavana;
    }
    public String getTeint()
    {
        return this.teint;
    }
    public int getSalaire()
    {
        return this.salaire;
    }

    public Person(String nom,String genre,String nationality,String finoana,String fiaviana,String diplome,String alavana,String teint,String salaire)throws Exception
    {
        super.setSeqName("seqPerson");
        setId(get_sequence());
        setNom(nom);
        setGenre(genre);
        setNationality(nationality);
        setFinoana(Boolean.parseBoolean(finoana));
        setFiaviana(fiaviana);
        setDiplome(Integer.valueOf(diplome));
        setAlavana(Integer.valueOf(alavana));
        setTeint(teint);
        setSalaire(Integer.valueOf(salaire));
    }

    public Person(String id,String nom,String genre,String nationality,String finoana,String fiaviana,String diplome,String alavana,String teint,String salaire)throws Exception
    {
        setId(Integer.valueOf(id));
        setNom(nom);
        setGenre(genre);
        setNationality(nationality);
        setFinoana(Boolean.parseBoolean(finoana));
        setFiaviana(fiaviana);
        setDiplome(Integer.valueOf(diplome));
        setAlavana(Integer.valueOf(alavana));
        setTeint(teint);
        setSalaire(Integer.valueOf(salaire));
    }

	public Person[] get_Tab(Vector<Object> o)
	{
		Person[] result=new Person[o.size()];
		for(int i=0;i<o.size();i++)
		{
			result[i]=(Person)o.get(i);
		}
		return result;
	}

    public boolean isMarried()throws Exception
    {
        Connex co=new Connex();
        Connection lo=co.log();
        Mivady[] test=new Mivady().get_Tab(new Mivady().select("null",lo));
        for(int i=0;i<test.length;i++)
        {
            if(this.getId()==test[i].getId1()||this.getId()==test[i].getId2())
            {
                return true;
            }
        }
        lo.close();
        return false;
    }

    public double noteWithCoeff(Person p1,Connection connection)throws Exception
    {
        double result=0;
        MyAxe tempAxe=new MyAxe();
        tempAxe.setId(p1.getId());
        MyAxe[] axe=tempAxe.get_Tab(tempAxe.select("id",connection));
        tempAxe=axe[0];
        CritereAxe tempCritere=new CritereAxe();
        tempCritere.setId(this.getId());
        CritereAxe[] critAxe=tempCritere.get_Tab(tempCritere.select("id",connection));
        tempCritere=critAxe[0];
        int total=(tempAxe.getNationality()*tempCritere.getNationality())+
        (tempAxe.getFinoana()*tempCritere.getFinoana())+
        (tempAxe.getFiaviana()*tempCritere.getFiaviana())+
        (tempAxe.getDiplome()*tempCritere.getDiplome())+
        (tempAxe.getAlavana()*tempCritere.getAlavana())+
        (tempAxe.getTeint()*tempCritere.getTeint())+
        (tempAxe.getSalaire()*tempCritere.getSalaire());
        int totalCoef=tempCritere.getNationality()+tempCritere.getFinoana()+tempCritere.getFiaviana()+tempCritere.getDiplome()+tempCritere.getAlavana()+tempCritere.getTeint()+tempCritere.getSalaire();
        result=total/totalCoef;
        return result;
    }

	// public Vector<Person> get_Tab(Vector<Object> o)
	// {
	// 	Vector<Person> result=new Vector<Person>();
	// 	for(int i=0;i<o.size();i++)
	// 	{
	// 		result.add((Person)o.get(i));
	// 	}
	// 	return result;
	// }
}