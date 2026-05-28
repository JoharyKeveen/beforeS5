package listener;
import windows.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import object.*;
import connection.*;
import java.sql.*;
import java.lang.reflect.*;
public class AListner implements ActionListener
{
    JButton b;
    Panel p;
    Frame f;
    CritereAxe ca;
    Person inLive;
    Person[] other;
    String nomPers;
    Person nandefadmd;
    public AListner(Frame f,JButton b,Panel p)
    {
        this.b=b;
        this.p=p;
        this.f=f;
    }
    public AListner(Frame f,JButton b,Panel p,String nomPersonSelect,Person inLive)
    {
        this.b=b;
        this.p=p;
        this.f=f;
        this.nomPers=nomPersonSelect;
        this.inLive=inLive;
    }
    public AListner(Frame f,JButton b,Panel p,Person nandefadmd,Person inLive)
    {
        this.b=b;
        this.p=p;
        this.f=f;
        this.nandefadmd=nandefadmd;
        this.inLive=inLive;
    }
    public AListner(Frame f,JButton b,Panel p,Person inLive)
    {
        this.b=b;
        this.p=p;
        this.f=f;
        this.inLive=inLive;
    }
    public AListner(Frame f,JButton b,Panel p,CritereAxe ca)
    {
        this.b=b;
        this.p=p;
        this.f=f;
        this.ca=ca;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            Connex co=new Connex();
            Connection lo=co.log();
            try
            {
                Statement stat=lo.createStatement();
                if(b.getText().equals("validPerson"))
                {
                    if(checkBeforeWrite(new Person())==true)
                    {
                        f.hide();
                        Person pers=new Person(((JTextField)p.get_formulaire().get_liste_champ()[1].get_texte_field()).getText(),
                        (String)((JComboBox)p.get_formulaire().get_liste_champ()[2].get_texte_field()).getSelectedItem(),
                        (String)((JComboBox)p.get_formulaire().get_liste_champ()[3].get_texte_field()).getSelectedItem(),
                        (String)((JComboBox)p.get_formulaire().get_liste_champ()[4].get_texte_field()).getSelectedItem(),
                        (String)((JComboBox)p.get_formulaire().get_liste_champ()[5].get_texte_field()).getSelectedItem(),
                        ((JTextField)p.get_formulaire().get_liste_champ()[6].get_texte_field()).getText(),
                        ((JTextField)p.get_formulaire().get_liste_champ()[7].get_texte_field()).getText(),
                        (String)((JComboBox)p.get_formulaire().get_liste_champ()[8].get_texte_field()).getSelectedItem(),
                        ((JTextField)p.get_formulaire().get_liste_champ()[9].get_texte_field()).getText()
                        );
                        pers.insert(lo);
                        MyAxe myaxe=new MyAxe(pers.getId(),pers.getNationality(),pers.getFinoana(),pers.getFiaviana(),pers.getDiplome(),pers.getAlavana(),pers.getTeint(),pers.getSalaire());
                        myaxe.insert(lo);
                        new Frame(new CritereAxe(pers.getId())).infoCritereAxe();
                    }
                }
                else if(b.getText().equals("validCritere"))
                {
                    if(checkBeforeWrite(new Person())==true)
                    {
                        f.hide();
                        ca.setNationality(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[1].get_texte_field()).getText()));
                        ca.setFinoana(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[2].get_texte_field()).getText()));
                        ca.setFiaviana(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[3].get_texte_field()).getText()));
                        ca.setDiplome(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[4].get_texte_field()).getText()));
                        ca.setAlavana(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[5].get_texte_field()).getText()));
                        ca.setTeint(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[6].get_texte_field()).getText()));
                        ca.setSalaire(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[7].get_texte_field()).getText()));
                        ca.setNoteMinimal(Integer.valueOf(((JTextField)p.get_formulaire().get_liste_champ()[8].get_texte_field()).getText()));
                        ca.insert(lo);
                        new Frame().createIndex();
                    }
                }
                else if(b.getText().equals("Connexion"))
                {
                    if(checkLogin(p.getTextIndex().getText(),lo)==true)
                    {
                        f.hide();
                        Person live=new Person();
                        live.setNom(p.getTextIndex().getText());
                        Person[] iLive=live.get_Tab(live.select("nom",lo));
                        this.inLive=iLive[0];
                        other=live.get_Tab(live.select(lo));
                        String[][] res=canMatch(lo);
                        if(inLive.isMarried()==false)
                        {
                            if(res.length==0)
                            {
                                new Frame().createSadText();
                            }
                            new Frame(new Person()).createList(res,inLive);
                        }
                        else
                        System.out.println("Manambady i "+live.getNom());
                    }
                }
                else if(b.getText().equals("Inscription"))
                {
                    f.hide();
                    new Frame(new Person()).infoPerson();
                }
                else if(b.getText().equals("match"))
                {
                    Person temp=new Person();
                    temp.setNom(nomPers);
                    Person[] res=temp.get_Tab(temp.select("nom",lo));
                    Mivady dm=new Mivady();
                    dm.setId1(this.inLive.getId());
                    dm.setId2(res[0].getId());
                    dm.insert(lo);
                }
                else if(b.getText().equals("view"))
                {
                    new Frame().createListDmd(inLive);
                }
                else if(b.getText().equals("marry"))
                {
                    Mivady ins=new Mivady();
                    ins.setId1(nandefadmd.getId());
                    ins.setId2(inLive.getId());
                    ins.update(lo);
                }
                stat.close();
                lo.close();
            }
            catch(Exception exc)
            {
                System.out.println(exc.getMessage());
            }
        }
    }

    public boolean checkLogin(String testena,Connection connect)throws Exception
    {
        Statement statement=connect.createStatement();
        ResultSet res=statement.executeQuery("select * from Person where nom='"+testena+"'");
        res.next();
        if(res.getObject(1)!=null)
        {
            return true;
        }
        return false;
    }

    public String[][] canMatch(Connection connection)throws Exception
    {
        int index=0;
        int size=0;
        CritereAxe tempCritere1=new CritereAxe();
        tempCritere1.setId(inLive.getId());
        CritereAxe[] critAxe1=tempCritere1.get_Tab(tempCritere1.select("id",connection));
        CritereAxe tempCritere2=new CritereAxe();
        tempCritere2.setId(other[0].getId());
        CritereAxe[] critAxe2=tempCritere2.get_Tab(tempCritere2.select("id",connection));
        for(int i=0;i<other.length;i++)
        {
            tempCritere2.setId(other[i].getId());
            critAxe2=tempCritere2.get_Tab(tempCritere2.select("id",connection));
            if(inLive.isMarried()==false&&other[i].isMarried()==false&&inLive.noteWithCoeff(other[i],connection)>=critAxe1[0].getNoteMinimal()&&other[i].noteWithCoeff(inLive,connection)>=critAxe2[0].getNoteMinimal()&&inLive.getGenre().equals(other[i].getGenre())==false)
            {
                // System.out.println("fijeriny "+inLive.getNom()+" an'i "+other[i].getNom()+" dia "+noteWithCoeff(other[i],inLive,connection));
                // System.out.println("fijeriny "+other[i].getNom()+" an'i "+inLive.getNom()+" dia "+noteWithCoeff(inLive,other[i],connection));
                size++;
            }
        }
        String[][] result=new String[size][2];
        for(int j=0;j<other.length;j++)
        {
            tempCritere2.setId(other[j].getId());
            critAxe2=tempCritere2.get_Tab(tempCritere2.select("id",connection));
            if(inLive.isMarried()==false&&other[j].isMarried()==false&&inLive.noteWithCoeff(other[j],connection)>=critAxe1[0].getNoteMinimal()&&other[j].noteWithCoeff(inLive,connection)>=critAxe2[0].getNoteMinimal()&&inLive.getGenre().equals(other[j].getGenre())==false)
            {
                result[index][0]=other[j].getNom();
                result[index][1]=Double.toString(inLive.noteWithCoeff(other[j],connection));
                index++;
            }
        }
        return result;
    }

    // public boolean testNumber(Object o,String numb,int index)
    // {
    //     Class class1=o.getClass();
    //     Field fields=class1.getDeclaredFields()[index];
    //     String nombr="0123456789.";
    //     String[] nombrSplit=nombr.split("");
    //     String[] numbSplit=numb.toLowerCase().split("");
    //     if(fields.getType()==int.class||fields.getType()==Double.class)
    //     {
    //         for(int j=0;j<numbSplit.length;j++)
    //         {
    //             for(int k=0;k<nombrSplit.length;k++)
    //             {
    //                 if(numbSplit[j].equals(nombrSplit[k]))
    //                 {
    //                 }
    //                 else
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    public boolean checkBeforeWrite(Object object)
    {
        Class class1=object.getClass();
        Field[] field = class1.getDeclaredFields();
        String txt;
        for(int i=1;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_texte_field() instanceof JTextField)
            {
                txt=((JTextField)p.get_formulaire().get_liste_champ()[i].get_texte_field()).getText();
                if(txt.equals("")||txt.equals(" "))
                {
                    System.out.println("misy banga: "+i);
                    return false;
                }
                // if(field[i].getType()==int.class||field[i].getType()==Double.class)
                // {
                //     if(testNumber(object,txt,i)==false)
                //     {
                //         return false;
                //     }
                // }
            }
        }
        return true;
    }
}