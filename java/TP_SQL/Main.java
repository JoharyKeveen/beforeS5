package print;
import sql.*;

public class Main
{
    //  Vocabulaire && Grammaire

    //  create chien ( race,taille,age )
    //  insert chien ( race,taille,age )
    //  desc chien
    //  select * chien
    //  delete chien race=berger
    //  delete tab chien
    //  select race,age chien
    //  select * chien where race=berger
    //  select nom,age chien where race=berger
    //  update chien nom,age wolf,9 where race=doberman
    //  union tab1 tab2
    //  intersection tab1 tab2
    //  juncture tab1,tab2 id=idT
    //  select * tab join tab2 id=id2
    //  select nom,race chien join chat id=id2
    //  difference tab1 tab2
    //  division tab1 tab2
    //  produit tab1 tab2



    public static void main(String[] args)
    {
        Relation test=new Relation();
        try
        {
            test.sql("difference chien chat");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}