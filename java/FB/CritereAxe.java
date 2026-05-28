package object;
import java.lang.reflect.*;
import connection.*;
import java.util.*;

public class CritereAxe extends BddClass
{
    // create table CritereAxe(
    //     id int,
    //     nationality int,
    //     finoana int,
    //     fiaviana int,
    //     diplome int,
    //     alavana int,
    //     teint int,
    //     salaire int,
    //     noteMinimal int
    // );
    int id;
    int nationality;
    int finoana;
    int fiaviana;
    int diplome;
    int alavana;
    int teint;
    int salaire;
    int noteMinimal;

    public CritereAxe()
    {}

    public CritereAxe(int id)
    {
        setId(id);
    }

    public CritereAxe(int id,int nationality,int finoana,int fiaviana,int diplome,int alavana,int teint,int salaire,int noteMinimal)
    {
        setId(id);
        setNationality(nationality);
        setFinoana(finoana);
        setFiaviana(fiaviana);
        setDiplome(diplome);
        setAlavana(alavana);
        setTeint(teint);
        setSalaire(salaire);
        setNoteMinimal(noteMinimal);
    }

    public int getId()
    {
        return this.id;
    }
    public int getNationality()
    {
        return this.nationality;
    }
    public int getFinoana()
    {
        return this.finoana;
    }
    public int getFiaviana()
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
    public int getTeint()
    {
        return this.teint;
    }
    public int getSalaire()
    {
        return this.salaire;
    }
    public int getNoteMinimal()
    {
        return this.noteMinimal;
    }

    public void setId(int id)
    {
        this.id=id;
    }
    public void setNationality(int nationality)
    {
        this.nationality=nationality;
    }
    public void setFinoana(int finoana)
    {
        this.finoana=finoana;
    }
    public void setFiaviana(int fiaviana)
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
    public void setTeint(int teint)
    {
        this.teint=teint;
    }
    public void setSalaire(int salaire)
    {
        this.salaire=salaire;
    }
    public void setNoteMinimal(int noteMinimal)
    {
        this.noteMinimal=noteMinimal;
    }

    public boolean testNUmber(String numb)
    {
        Class class1=this.getClass();
        Field[] fields=class1.getDeclaredFields();
        String nombr="0123456789.";
        String[] nombrSplit=nombr.split("");
        String[] numbSplit=numb.toLowerCase().split("");
        for(int i=0;i<fields.length;i++)
        {
            if(fields[i].getType().getSimpleName().toLowerCase().equals("int")||fields[i].getType().getSimpleName().toLowerCase().equals("double"))
            {
                for(int j=0;j<numbSplit.length;j++)
                {
                    for(int k=0;k<nombrSplit.length;k++)
                    {
                        if(numbSplit[j].equals(nombrSplit[k]))
                        {}
                        else
                        return false;
                    }
                }
            }
        }
        return true;
    }
	public CritereAxe[] get_Tab(Vector<Object> o)
	{
		CritereAxe[] result=new CritereAxe[o.size()];
		for(int i=0;i<o.size();i++)
		{
			result[i]=(CritereAxe)o.get(i);
		}
		return result;
	}
}