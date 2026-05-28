package object;
import connection.*;
import java.sql.Date;
import java.sql.*;
import java.lang.reflect.*;
import java.util.*;

public class Mivady extends BddClass
{
    // create table Mivady(
    //     id1 int,
    //     id2 int,
    //     dateNivady date
    // );

    int id1;
    int id2;
    Date dateNivady;

    public void setId1(int id1)
    {
        this.id1=id1;
    }
    public void setId2(int id2)
    {
        this.id2=id2;
    }
    public void setDateNivady(Date dateNivady)
    {
        this.dateNivady=dateNivady;
    }

    public int getId1()
    {
        return this.id1;
    }
    public int getId2()
    {
        return this.id2;
    }
    public Date getDateNivady()
    {
        return this.dateNivady;
    }

	public Mivady[] get_Tab(Vector<Object> o)
	{
		Mivady[] result=new Mivady[o.size()];
		for(int i=0;i<o.size();i++)
		{
			result[i]=(Mivady)o.get(i);
		}
		return result;
	}


    public void update(Connection connection) throws Exception 
    {
        String request = "update ";
        Class class1 = this.getClass();
        Field[] fields=class1.getDeclaredFields();
        request += class1.getSimpleName().toLowerCase() + " set datenivady=(select current_date from dual) where "+fields[0].getName()+"=" ;
        Method method = class1.getDeclaredMethod(this.getterSetter(fields[0], "get"));
        request +=method.invoke(this) + " and "+fields[1].getName()+"=";
        method = class1.getDeclaredMethod(this.getterSetter(fields[1], "get"));
        request +=method.invoke(this);
        Statement statement = connection.createStatement();
        statement.executeQuery(request);
        connection.commit();
    }
    public Vector<Object> select(String test,Connection connection)throws Exception
    {
        Class class1 = this.getClass();
        Vector<Object> result=new Vector<Object>();
        String request="select * from mivady where datenivady is not null";
        Statement statement=connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        int i=0;
        while(res.next())
        {
            result.add(class1.newInstance());
            for(int j=0;j<class1.getDeclaredFields().length;j++)
            {
                Field field = class1.getDeclaredFields()[j];
                Method method = class1.getDeclaredMethod(this.getterSetter(field, "set"),field.getType());
                if(field.getType()==int.class)
                {
                    method.invoke(result.get(i),res.getInt(field.getName()));
                }
                else if(field.getType()==String.class)
                {
                    method.invoke(result.get(i),res.getString(field.getName()));
                }
                else if(field.getType()==Boolean.class)
                {
                    method.invoke(result.get(i),res.getBoolean(field.getName()));
                }
                else if(field.getType()==Double.class)
                {
                    method.invoke(result.get(i),res.getDouble(field.getName()));
                }
            }
            i++;
        }
        return result;
    }
}