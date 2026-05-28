package object;
import connection.*;
import java.util.*;

public class MyAxe extends BddClass
{
    // create table MyAxe(
        // id int,
        // nationality int,
        // finoana int,
        // fiaviana int,
        // diplome int,
        // alavana int,
        // teint int,
        // salaire int
    // );
    
    int id;
    int nationality;
    int finoana;
    int fiaviana;
    int diplome;
    int alavana;
    int teint;
    int salaire;

    public MyAxe()
    {}

    public MyAxe(int id,String nationality,boolean finoana,String fiaviana,int diplome,int alavana,String teint,int salaire)throws Exception
    {
        set_Id(id);
        set_Nationality(nationality);
        set_Finoana(finoana);
        set_Fiaviana(fiaviana);
        set_Diplome(diplome);
        set_Alavana(alavana);
        set_Teint(teint);
        set_Salaire(salaire);
    }

    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getNationality()
    {
        return this.nationality;
    }
    public void setNationality(int nationality)
    {
        this.nationality=nationality;
    }
    public int getFinoana()
    {
        return this.finoana;
    }
    public void setFinoana(int finoana)
    {
        this.finoana=finoana;
    }
    public int getFiaviana()
    {
        return this.fiaviana;
    }
    public void setFiaviana(int fiaviana)
    {
        this.fiaviana=fiaviana;
    }
    public int getDiplome()
    {
        return this.diplome;
    }
    public void setDiplome(int diplome)
    {
        this.diplome=diplome;
    }
    public int getAlavana()
    {
        return this.alavana;
    }
    public void setAlavana(int alavana)
    {
        this.alavana=alavana;
    }
    public int getTeint()
    {
        return this.teint;
    }
    public void setTeint(int teint)
    {
        this.teint=teint;
    }
    public int getSalaire()
    {
        return this.salaire;
    }
    public void setSalaire(int salaire)
    {
        this.salaire=salaire;
    }




    public void set_Id(int id)
    {
        this.id=id;
    }
    public void set_Nationality(String nationality)
    {
        if(nationality.equals("africain"))
        {
            this.nationality=1;
        }
        else if(nationality.equals("europeen"))
        {
            this.nationality=2;
        }
        else if(nationality.equals("asiatique"))
        {
            this.nationality=3;
        }
        else if(nationality.equals("americain"))
        {
            this.nationality=4;
        }
        this.nationality=this.nationality*5;
    }
    public void set_Finoana(boolean finoana)
    {
        if(finoana==true)
        {
            this.finoana=2;
        }
        else
        {
            this.finoana=1;
        }
        this.finoana=this.finoana*10;
    }
    public void set_Fiaviana(String fiaviana)
    {
        if(fiaviana.equals("afro"))
        {
            this.fiaviana=1;
        }
        else if(fiaviana.equals("blanc"))
        {
            this.fiaviana=2;
        }
        else if(fiaviana.equals("jaune"))
        {
            this.fiaviana=3;
        }
        this.fiaviana=this.fiaviana*6;
    }
    public void set_Diplome(int diplome)
    {
        if(diplome<0)
        {
            this.diplome=0;
        }
        else
        this.diplome=diplome*3;
        if(this.diplome>20)
        {
            this.diplome=20;
        }
    }
    public void set_Alavana(int alavana)
    {
        if(alavana<150)
        {
            this.alavana=1;
        }
        else if(alavana<175)
        {
            this.alavana=2;
        }
        else
        {
            this.alavana=3;
        }
        this.alavana=this.alavana*6;
    }
    public void set_Teint(String teint)
    {
        if(teint.equals("sombre"))
        {
            this.teint=1;
        }
        else if(teint.equals("marron foncer"))
        {
            this.teint=2;
        }
        else if(teint.equals("marron"))
        {
            this.teint=3;
        }
        else if(teint.equals("marron clair"))
        {
            this.teint=4;
        }
        else if(teint.equals("clair"))
        {
            this.teint=5;
        }
        this.teint=this.teint*4;
    }
    public void set_Salaire(int salaire)
    {
        this.salaire=salaire/1000;
        this.salaire=this.salaire*2;
    }
	public MyAxe[] get_Tab(Vector<Object> o)
	{
		MyAxe[] result=new MyAxe[o.size()];
		for(int i=0;i<o.size();i++)
		{
			result[i]=(MyAxe)o.get(i);
		}
		return result;
	}
}