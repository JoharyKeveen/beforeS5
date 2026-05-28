package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connex {
    public static Connection getConn() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/ensemble";
        String user = "postgres";
        String pass = "stevensteven";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,user,pass);
    }
}
