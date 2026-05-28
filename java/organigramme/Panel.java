package windows;
import java.sql.*;
import object.Emp;
import connection.Connex;
import connection.State;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.*;

public class Panel extends JPanel
{
    public Panel()
    {
        this.p=new JPanel();
        set_j(1);
        set_x(0);
        set_y(10);
        this.nb=0;
    }
    int nb;
    JPanel p;
    int x;
    public void set_x(int l)
    {
        this.x=l;
    }
    public int get_x()
    {
        return this.x;
    }
    int y;
    public void set_y(int l)
    {
        this.y=l;
    }
    public int get_y()
    {
        return this.y;
    }
    int j;
    public void set_j(int l)
    {
        this.j=l;
    }
    public int get_j()
    {
        return this.j;
    }
    public JPanel hierarchisation(Emp deba,Emp[] indi)
    {
        int width=100;
        int height=100;
        deba.find_child(indi);
        p.setLayout(null);
        p.setPreferredSize(new Dimension(500,500));
        JLabel[] legend=new JLabel[indi.length];
        if(nb==0)
        {
            legend[0]=new JLabel();
            legend[0].setBounds(x,y,width,y);
            legend[0].setText(deba.get_ename());
            p.add(legend[0]);
        }
        for(int i=0;i<deba.get_child().length;i++)
        {
            set_x((deba.get_level()+1)*60);
            this.nb=1;
            legend[this.j]=new JLabel();
            legend[this.j].setBounds(this.x,this.y,width,height);
            legend[this.j].setText(deba.get_child()[i].get_ename());
            p.add(legend[this.j]);
            deba.get_child()[i].set_level(deba.get_level()+1);
            deba.get_child()[i].find_child(indi);
            this.j=this.j+1;
            set_y(get_y()+35);
            if(deba.get_child()[i].get_child().length!=0)
            {
                Emp temp=deba.get_child()[i];
                this.hierarchisation(temp,indi);
            }
        }
        return p;
    }
}