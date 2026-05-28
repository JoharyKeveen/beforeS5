package windows;
import javax.swing.*;
import java.awt.*;
import listener.*;
import java.lang.reflect.*;
import object.*;
import connection.*;
import java.sql.*;

public class Panel extends JPanel
{
    Frame thisFrame;
    Object o;
    int width;
    int height;
    JLabel[] legend;
    public Frame getThisFrame() {
        return thisFrame;
    }
    public void setThisFrame(Frame thisFrame) {
        this.thisFrame = thisFrame;
    }
    public Object getO() {
        return o;
    }
    public void setO(Object o) {
        this.o = o;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    JTextField textIndex;
    JPanel result;
    Formulaire f;
    JButton butt;
    JButton[] buttIndex;
    AListner al;
    AListner[] listAL;
    public Panel(Frame fr)
    {
        this.thisFrame=fr;
    }
    public AListner getAl()
    {
        return this.al;
    }
    public JTextField getTextIndex()
    {
        return this.textIndex;
    }
    public JButton[] getButtIndex()
    {
        return this.buttIndex;
    }
    public JButton getButt()
    {
        return this.butt;
    }
    public int get_width()
    {
        return this.width;
    }
    public int get_height()
    {
        return this.height;
    }
    public Formulaire get_formulaire()
    {
        return this.f;
    }
    public Object get_object()
    {
        return this.o;
    }
    public JPanel get_result()
    {
        return this.result;
    }
    public JLabel[] get_legend()
    {
        return this.legend;
    }
    public JPanel sad()
    {
        result=new JPanel();
        result.setLayout(null);
        int x=10;
        int y=10;
        this.width=100;
        this.height=50;
        JLabel title=new JLabel("Malheuresement personne ne vous correpond");
        title.setBounds(20,y,width*5,height);
        result.add(title);
        result.setPreferredSize(new Dimension(width*3+x,y+height));
        return result;
    }
    public JPanel index()
    {
        result=new JPanel();
        result.setLayout(null);
        int x=10;
        int y=10;
        this.width=100;
        this.height=50;
        JLabel title=new JLabel("Index Page");
        title.setBounds(width+width/4,y,width,height);
        y+=height;
        legend=new JLabel[1];
        legend[0]=new JLabel();
        legend[0].setBounds(x,y,width,height);
        legend[0].setText("Nom");
        textIndex=new JTextField();
        textIndex.setBounds(width,y,width+width/2,height);
        y+=height;
        this.buttIndex=new JButton[2];
        buttIndex[0]=new JButton();
        buttIndex[0].setText("Connexion");
        buttIndex[0].setBounds((width*2+x)/2,y+10,(width*2+x)/2,height/2);
        y+=height/2+2;
        buttIndex[1]=new JButton();
        buttIndex[1].setText("Inscription");
        buttIndex[1].setBounds((width*2+x)/2,y+10,(width*2+x)/2,height/2);
        buttIndex[0].addActionListener(new AListner(thisFrame,buttIndex[0],this));
        buttIndex[1].addActionListener(new AListner(thisFrame,buttIndex[1],this));
        result.add(buttIndex[1]);
        result.add(buttIndex[0]);
        result.add(textIndex);
        result.add(legend[0]);
        result.add(title);
        result.setPreferredSize(new Dimension(width*3+x,y+height));
        return result;
    }
    public JPanel listDeDmd(Person inLive)throws Exception
    {
        result= new JPanel();
        result.setLayout(null);
        Connex co=new Connex();
        Connection lo=co.log();
        Mivady res= new Mivady();
        res.setId2(inLive.getId());
        Mivady[] tabPers=res.get_Tab(res.select("id2",lo));
        legend=new JLabel[tabPers.length];
        int x=10;
        int y=10;
        this.width=100;
        this.height=35;
        Person[] resPers;
        Person tempPers=new Person();
        buttIndex=new JButton[tabPers.length];
        for(int i=0;i<tabPers.length;i++)
        {
            System.out.println("id1: "+tabPers[i].getId1()+" ; id2: "+tabPers[i].getId2()+" ; date: "+tabPers[i].getDateNivady());
            tempPers.setId(tabPers[i].getId1());
            resPers=tempPers.get_Tab(tempPers.select("id",lo));
            legend[i]=new JLabel(resPers[0].getNom());
            legend[i].setBounds(x,y,width,height);
            result.add(legend[i]);
            buttIndex[i]=new JButton("marry");
            buttIndex[i].setBounds(x+width+2,y,width,height);
            buttIndex[i].setFocusable(false);
            result.add(buttIndex[i]);
            buttIndex[i].addActionListener(new AListner(thisFrame,buttIndex[i],this,resPers[0],inLive));
            y+=height;
        }
        lo.close();
        result.setPreferredSize(new Dimension(width*2+20,y+height/2));
        return result;
    }
    public JPanel list(String[][] pers,Object o,Person inLive)
    {
        this.o=o;
        result=new JPanel();
        Class class1=o.getClass();
        String[] entete={"nom","note"};
        JButton[] validation=new JButton[pers.length];
        JTable tab=new JTable(pers,entete);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(pers.length,1));
        listAL=new AListner[pers.length];
        for(int i=0;i<pers.length;i++)
        {
            validation[i]=new JButton("match");
            listAL[i]=new AListner(thisFrame,validation[i],this,pers[i][0],inLive);
            validation[i].addActionListener(listAL[i]);
            validation[i].setBounds(0,0,25,25);
            validation[i].setFocusable(false);
            jp.add(validation[i]);
        }
        tab.setRowHeight(validation[0].getHeight());
        int height=validation[0].getHeight()*pers.length+20;
        if(height>500)
        {
            height=500;
        }
        result.add(tab);
        result.add(jp);
        legend=new JLabel[1];
        legend[0]=new JLabel("Listes des demandes de mariage: ");
        legend[0].setBounds(10,10,400,20);
        JButton listDMD=new JButton("view");
        listDMD.addActionListener(new AListner(thisFrame,listDMD,this,inLive));
        result.add(legend[0]);
        result.add(listDMD);
        listDMD.setFocusable(false);
        return result;
    }
    public JPanel creerForm(Object o)
    {
        String[] on={"true","false"};
        this.o=o;
        result=new JPanel();
        result.setLayout(null);
        int x=10;
        int y=10;
        this.width=100;
        this.height=50;
        this.f=new Formulaire(o);
        legend=new JLabel[f.get_liste_champ().length];
        for(int i=0;i<o.getClass().getDeclaredFields().length;i++)
        {
            f.set_liste_champ(i);
        }
        for(int i=0;i<o.getClass().getDeclaredFields().length;i++)
        {
            legend[i]=new JLabel();
            legend[i].setBounds(x,y,width,height);
            legend[i].setText(f.get_liste_champ()[i].get_label());
            f.get_liste_champ()[i].get_texte_field().setBounds(width,y,width*2,height);
            if(f.get_liste_champ()[i].get_texte_field() instanceof JTextField)
            {
                ((JTextField)f.get_liste_champ()[i].get_texte_field()).setText(f.get_liste_champ()[i].get_default_value());
            }
            if(o.getClass().getDeclaredFields()[i].getType()==boolean.class)
            {
                f.textfield_to_combobox(o.getClass().getDeclaredFields()[i].getName(),this,on);
            }
            if(f.get_liste_champ()[i].get_is_visible()==true)
            {
                result.add(legend[i]);
                result.add(f.get_liste_champ()[i].get_texte_field());
                y+=height;
            }
        }
        
        butt=new JButton();
        butt.setText("Valider");
        butt.setBounds((width*2+x)/2,y+10,(width*2+x)/2,height/2);
        butt.setFocusable(false);
        al=new AListner(thisFrame,butt,this);
        butt.addActionListener(al);
        result.add(butt);
        result.setPreferredSize(new Dimension(width*3+x,y+height));
        return result;
    }
}