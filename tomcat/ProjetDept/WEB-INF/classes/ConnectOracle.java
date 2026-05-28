package connect;

import java.sql.*;
public class ConnectOracle
{
  public Connection connect()
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:orcl","scott","tiger");
      return con;
    }
    catch(Exception e){ 
      System.out.println(e); 
    }
    return null;
  }
}