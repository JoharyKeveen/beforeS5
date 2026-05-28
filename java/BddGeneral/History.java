package bdd;
import java.sql.*;
import java.util.*;
import java.sql.*;
import connection.Connex;
public class History extends BddClass
{
    String id;
    String tablee;
    String action;
    String datee;
    String valeur;

    // create table History(
    //     id CHAR(7),
    //     tablee VARCHAR2(25),
    //     action VARCHAR2(25),
    //     datee VARCHAR2(25),
    //     valeur VARCHAR2(100)
    // );

    public void setId(String id)
    {
        this.id=id;
    }
    public void setTablee(String tablee)
    {
        this.tablee=tablee;
    }
    public void setAction(String action)
    {
        this.action=action;
    }
    public void setDatee(String datee)
    {
        this.datee=datee;
    }
    public void setValeur(String valeur)
    {
        this.valeur=valeur;
    }

    public String getId()
    {
        return this.id;
    }
    public String getTablee()
    {
        return this.tablee;
    }
    public String getAction()
    {
        return this.action;
    }
    public String getDatee()
    {
        return this.datee;
    }
    public String getValeur()
    {
        return this.valeur;
    }

    public History(String tablee,String action,String datee,String valeur)throws Exception
    {
		super.setPrefix("HST");
		super.setSeqName("seqHist");
		setId(super.construirePK(get_sequence()));
        setTablee(tablee);
        setDatee(datee);
        setAction(action);
        setValeur(valeur);
    }
}