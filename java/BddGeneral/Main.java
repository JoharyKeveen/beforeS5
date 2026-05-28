package print;
import connection.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import test.*;

public class Main
{
    public static void main(String[] args)
    {
        Connex co=new Connex();
        Connection lo=co.log();
        Song test=new Song();
        test.setId("SNG0009");
        test.setTitle("mandeLeUpdate");
        Chien alika=new Chien();
        alika.setId("CHN0010");
        alika.setNom("Jean");
        alika.setRace("Jean");
        try
        {
            // Song test=new Song("fahaefatra","Johary","testAUTO","oracle");
            // Chien ch=new Chien("Ty","Berger");
            Vector<Song> ty=test.get_Tab(test.select("title",lo));
            // test.delete("id",lo);


            // alika.update("id","nom",lo);
            // alika.update("id","race",lo);



            // test.update("id","title",lo);
            // System.out.println(test.getCurrentDate(lo));
            // test.historiser(lo,"test");
            // test.insert(lo);
            // ch.insert(lo);
            // System.out.println(test.construirePK(10));
            for(int i=0;i<ty.size();i++)
            {
                System.out.println(ty.get(i).getTitle()+ty.get(i).getArtiste());
            }
            lo.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}