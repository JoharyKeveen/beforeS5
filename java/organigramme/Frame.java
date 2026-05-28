package windows;
import connection.*;
import object.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Frame extends JFrame
{

    public Frame()
    {
        State st=new State();
            //       Connex co=new Connex();
            // Connection lo=co.log();
            // System.out.println(lo);
        Emp e=new Emp();
        Emp[] individu=st.result();
        Emp deba=e.debaO(individu);
        Panel p=new Panel();
        this.add(p.hierarchisation(deba,individu));
        this.setTitle("Organigramme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}