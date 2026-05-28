package connection;
import java.sql.*;
public class Connex
{
    public Connection log()
    {
        Connection con;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:orcl", "mp3", "mp3");
            return con;
        }
        catch(Exception e)
        {}
        return null;
    }
}