package bdd;
import java.io.*;
import java.lang.reflect.*;
import java.sql.*;
import test.*;
import java.util.*;
import connection.*;

public class BddClass
{
    String prefix="PRS";
    int lengthh=7;
    String seqName="seqSong";

    public void setPrefix(String pre)
    {
        this.prefix=pre;
    }
    public String getPrefix()
    {
        return this.prefix;
    }
    public void setSeqName(String f)
    {
        this.seqName=f;
    }
    public String getSeqName()
    {
        return this.seqName;
    }
    public int getLengthh()
    {
        return this.lengthh;
    }

    public int get_sequence()throws Exception
    {
        Connex co=new Connex();
        Connection lo=co.log();
        Statement stat=lo.createStatement();
        ResultSet res=stat.executeQuery("select getSeq('"+getSeqName()+"') from dual");
        int result=0;
        while(res.next())
        {
            result=res.getInt(1);
        }
        stat.close();
        lo.close();
        return result;
    }

    public void historiser(Connection connection,String action)throws Exception
    {
        Class class1 = this.getClass();
        String tableName=class1.getSimpleName().toLowerCase();
        String dateValue=getCurrentDate(connection);
        String valeur=getValeurHistorique(connection);
        History h=new History(tableName,action,dateValue,valeur);
        h.insert(connection);
    }

    public String getCurrentDate(Connection connection)throws Exception
    {
        Statement stat=connection.createStatement();
        ResultSet res=stat.executeQuery("select current_date from dual");
        res.next();
        String result=res.getString(1);
        return result;
    }

    public String getValeurHistorique(Connection connection)throws Exception
    {
        String result="";
        Class class1 = this.getClass();
        Field field = class1.getDeclaredFields()[0];
        String primaryKey=field.getName();
        Vector<Object> valHist=select(primaryKey,connection);
        Field[] fields=class1.getDeclaredFields();
        for(int i=0;i<fields.length;i++)
        {
            Method method = class1.getDeclaredMethod(this.getterSetter(fields[i], "get"));
            result +=fields[i].getName()+":"+method.invoke(valHist.get(0))+";";
        }
        return result;
    }

    public String construirePK(int chiffre)
    {
        String end=Integer.toString(chiffre);
        String[] tempPref=getPrefix().split("");
        String[] tempChiffre=end.split("");
        int nbZero=getLengthh()-tempPref.length-tempChiffre.length;
        String zero="";
        for(int i=0;i<nbZero;i++)
        {
            zero+="0";
        }
        String result=getPrefix()+zero+end;
        return result;
    }

    public void insert(Connection connection) throws Exception 
    {
        String request = "insert into ";
        Class class1 = this.getClass();
        Field field = class1.getDeclaredFields()[0];
        request += class1.getSimpleName().toLowerCase() + " values(";
        Method method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
        if(field.getType().getSimpleName().toLowerCase().equals("string"))
        {
            request += "'" + method.invoke(this) + "'";
        }
        else if(field.getType().getSimpleName().toLowerCase().equals("date"))
        {
            request += "to_date('" + method.invoke(this) + "','DD-MM-YYYY')";
        }
        else
        {
            request += method.invoke(this);
        }
        for(int i=1;i<class1.getDeclaredFields().length;i++)
        {
            field = class1.getDeclaredFields()[i];
            method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
            if(field.getType().getSimpleName().toLowerCase().equals("string"))
            {
                request += ",'" + method.invoke(this) + "'";
            }
            else if(field.getType().getSimpleName().toLowerCase().equals("date"))
            {
                request += ",to_date('" + method.invoke(this) + "','DD-MM-YYYY')";
            }
            else
            {
                request += "," + method.invoke(this);
            }
        }
        request +=")";
        Statement statement = connection.createStatement();
        statement.executeQuery(request);
        connection.commit();
    }

    public Vector<Object> select(Connection connection) throws Exception 
    {
        String request = "select * from ";
        Class class1 = this.getClass();
        request += class1.getSimpleName().toLowerCase();
        Statement statement = connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        Vector<Object> result=new Vector<Object>();
        int i=0;
        while(res.next())
        {
            result.add(class1.newInstance());
            for(int j=0;j<class1.getDeclaredFields().length;j++)
            {
                Field field = class1.getDeclaredFields()[j];
                Method method = class1.getDeclaredMethod(this.getterSetter(field, "set"),field.getType());
                method.invoke(result.get(i),res.getObject(field.getName()));
            }
            i++;
        }
        return result;
    }

    public Vector<Object> select(String primaryKey,Connection connection) throws Exception 
    {
        String request = "select * from ";
        Class class1 = this.getClass();
        request += class1.getSimpleName().toLowerCase() + " where " + primaryKey.toLowerCase() +"=";
        Field field = class1.getDeclaredField(primaryKey);
        Method method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
            if(field.getType().getSimpleName().toLowerCase().equals("string"))
            {
                request += "'" + method.invoke(this) + "'";
            }
            else if(field.getType().getSimpleName().toLowerCase().equals("date"))
            {
                request += "'" + method.invoke(this) + "'";
            }
            else
            {
                request += method.invoke(this);
            }
        Statement statement = connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        Vector<Object> result=new Vector<Object>();
        int i=0;
        while(res.next())
        {
            result.add(class1.newInstance());
            for(int j=0;j<class1.getDeclaredFields().length;j++)
            {
                field = class1.getDeclaredFields()[j];
                method = class1.getDeclaredMethod(this.getterSetter(field, "set"),field.getType());
                System.out.println(method);
                method.invoke(result.get(i),res.getObject(field.getName()));
            }
            i++;
        }
        return result;
    }

    public void delete(String primaryKey, Connection connection) throws Exception 
    {
        if (this.isAttributeNull(primaryKey))
        throw new IOException("Vous devez precisez la valeur de la cle primaire");
        String request = "delete from ";
        Class class1 = this.getClass();
        request += class1.getSimpleName().toLowerCase() + " where " + primaryKey.toLowerCase() + "='";
        Field field = class1.getDeclaredField(primaryKey);
        Method method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
        request += method.invoke(this) + "'";
        Statement statement = connection.createStatement();
        historiser(connection,"delete");
        statement.executeQuery(request);
        connection.commit();
    }

    public void update(String primaryKey,String column ,Connection connection) throws Exception 
    {
        if (this.isAttributeNull(primaryKey))
        throw new IOException("Vous devez precisez la valeur de la cle primaire");
        if (this.isAttributeNull(column))
        throw new IOException("Vous devez precisez la valeur de l'argument");
        String request = "update ";
        Class class1 = this.getClass();
        request += class1.getSimpleName().toLowerCase() + " set " + column.toLowerCase() + "=" ;
        Field field = class1.getDeclaredField(column);
        Method method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
        if(field.getType().getSimpleName().toLowerCase().equals("string"))
        {
            request +="'"+ method.invoke(this) + "' where " + primaryKey.toLowerCase() + "=";
        }
        else if(field.getType().getSimpleName().toLowerCase().equals("date"))
        {
            request +="to_date('"+ method.invoke(this) + "','DD-MM-YYYY') where " + primaryKey.toLowerCase() + "=";
        }
        else
        {
            request += method.invoke(this) + " where " + primaryKey.toLowerCase() + "=";
        }
        field = class1.getDeclaredField(primaryKey);
        method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
        if(field.getType().getSimpleName().toLowerCase().equals("string"))
        {
            request +="'"+ method.invoke(this) + "'";
        }
        else if(field.getType().getSimpleName().toLowerCase().equals("date"))
        {
            request +="to_date('"+ method.invoke(this) + "','DD-MM-YYYY')";
        }
        else
        {
            request +=method.invoke(this);
        }
        Statement statement = connection.createStatement();
        historiser(connection,"update");
        statement.executeQuery(request);
        connection.commit();
    }
    
    public boolean isAttributeNull(String string) throws Exception 
    {
        Class class1 = this.getClass();
        Field field = class1.getDeclaredField(string);
        Method method = class1.getDeclaredMethod(this.getterSetter(field, "get"));
        String result = String.valueOf(method.invoke(this));
        if (result.compareToIgnoreCase("null") != 0 && result.compareToIgnoreCase("0") != 0
            && result.compareToIgnoreCase("0.0") != 0)
        return false;
        return true;
    }

    public String getterSetter(Field field, String getOrSet) 
    {
        String retour = "";
        String fieldString = field.getName();
        retour = getOrSet + fieldString.substring(0, 1).toUpperCase() + fieldString.substring(1);
        return retour;
    }
}