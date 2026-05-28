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
            con = DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:orcl", "scott", "tiger");
            return con;
        }
        catch(Exception e)
        {}
        return null;
    }
}


/*
    create table joueur(
        id int,
        idEquipe int,
        nom varchar(20),
        tir int,
        maty int,
        passeD int,
        rebondD int,
        rebondO int
    );
    create table equipe(
        id int,
        nom varchar(50)
    );
    create table matchBasket(
        id int,
        nom1 varchar(50),
        score1 int,
        nom2 varchar(50),
        score2 int
    );
*/