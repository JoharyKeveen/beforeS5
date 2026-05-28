package connection;
import java.sql.*;
import object.Emp;
import connection.Connex;

public class State
{
    public Emp[] result()
    {
        Emp[] resu=null;
        try
        {
            Connex co=new Connex();
            Connection lo=co.log();
            Statement st = lo.createStatement();
            ResultSet n=st.executeQuery("Select count(*) from emp");
            int i=0;
            n.next();
            int numb=n.getInt(1);
            resu=new Emp[numb];
            ResultSet res = st.executeQuery("select * from emp");
            while(res.next())
            {
                resu[i]=new Emp(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getInt(6),res.getInt(7),res.getInt(8));
                i++;
            }
            lo.close();
            st.close();
            n.close();
            res.close();
        }
        catch(Exception e)
        {}
        return resu;
    }
}