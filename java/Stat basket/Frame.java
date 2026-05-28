package windows;
import java.awt.*;
import javax.swing.*;
import connection.*;
import object.*;
import listener.*;
import java.util.*;
import java.sql.*;

public class Frame extends JFrame
{
    public void createSTAT()throws Exception
    {
        Connex co=new Connex();
        Connection lo=co.log();
        // new Matche("Teama","teamb").insert(lo);
        Matche actuel=new Matche("MTC02","E1","EA");
        Vector<Matche> all=new Matche().get_Tab(actuel.select("idmatche",lo));
        lo.close();
        Panel jo=new Panel(this);
        this.add(jo.statMatch(all.get(0)));
        this.setTitle("STAT Basket");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}