package print;
import windows.*;
import connection.*;
import java.sql.*;
import java.util.*;
import object.*;

public class Main
{
    public static void main(String[] args)throws Exception
    {
        // System.out.println(System.currentTimeMillis());
        // Connex co=new Connex();
        // Connection lo=co.log();
        // new Matche("E1","EA",System.currentTimeMillis()).insert(lo);
        // Vector<Statis> all=new Statis().get_Tab(new Statis("PLR07","MTC01","tir").select("idmatche","idplayer",lo));
        // System.out.println(all.size());
        // System.out.println(co);
        new Frame().createSTAT();
        // new Team("EA").insert(lo);
        // new Player("TEA22", "JA5").insert(lo);
        // new Matche("E1", "EA").insert(lo);
        // lo.close();
    }
}