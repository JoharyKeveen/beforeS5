package listener;
import windows.*;
import javax.swing.*;
import java.awt.event.*;
import object.*;
import java.io.*;
import java.util.*;
public class Mouse implements ActionListener
{
    JButton b;
    Panel p;
    public Mouse(JButton b,Panel p)
    {
        this.b=b;
        this.p=p;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            String txt=null;
            if(p.get_formulaire().get_liste_champ()[0].get_texte_field() instanceof JTextField)
            {
                txt=((JTextField)p.get_formulaire().get_liste_champ()[0].get_texte_field()).getText();
            }
            else if(p.get_formulaire().get_liste_champ()[0].get_texte_field() instanceof JComboBox)
            {
                txt=(String)((JComboBox)p.get_formulaire().get_liste_champ()[0].get_texte_field()).getSelectedItem();
            }
            for(int i=1;i<p.get_formulaire().get_liste_champ().length;i++)
            {
                if(p.get_formulaire().get_liste_champ()[i].get_texte_field() instanceof JTextField)
                {
                    txt=txt+";;"+((JTextField)p.get_formulaire().get_liste_champ()[i].get_texte_field()).getText();
                }
                else if(p.get_formulaire().get_liste_champ()[i].get_texte_field() instanceof JComboBox)
                {
                    txt=txt+";;"+(String)((JComboBox)p.get_formulaire().get_liste_champ()[i].get_texte_field()).getSelectedItem();
                }
            }
            try
            {
                if(teste_write()==true)
                {
                    write("file.txt",txt);
                }
            }
            catch(Exception exep)
            {}
        }
    }

    public boolean teste_write()
    {
        String test=";;";
        String txt=null;
        if(p.get_formulaire().get_liste_champ()[0].get_texte_field() instanceof JTextField)
        {
            txt=((JTextField)p.get_formulaire().get_liste_champ()[0].get_texte_field()).getText();
        }
        else if(p.get_formulaire().get_liste_champ()[0].get_texte_field() instanceof JComboBox)
        {
            txt=(String)((JComboBox)p.get_formulaire().get_liste_champ()[0].get_texte_field()).getSelectedItem();
        }
        for(int i=1;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_texte_field() instanceof JTextField)
            {
                txt=txt+";;"+((JTextField)p.get_formulaire().get_liste_champ()[i].get_texte_field()).getText();
            }
            else if(p.get_formulaire().get_liste_champ()[i].get_texte_field() instanceof JComboBox)
            {
                txt=txt+";;"+(String)((JComboBox)p.get_formulaire().get_liste_champ()[i].get_texte_field()).getSelectedItem();
            }
        }
        for(int i=0;i<p.get_formulaire().get_liste_champ().length-2;i++)
        {
            test=test+";;";
        }
        if(txt.equalsIgnoreCase(test)==true)
        {
            return false;
        }
        for(int k=0;k<p.get_formulaire().get_liste_champ().length;k++)
        {
            if(p.get_formulaire().get_liste_champ()[k].get_texte_field() instanceof JTextField)
            {
                if(((JTextField)p.get_formulaire().get_liste_champ()[k].get_texte_field()).getText().equalsIgnoreCase("")==true)
                {
                    return false;
                }
            }
            else if(p.get_formulaire().get_liste_champ()[k].get_texte_field() instanceof JComboBox)
            {
                if(String.valueOf(((JComboBox)p.get_formulaire().get_liste_champ()[k].get_texte_field()).getSelectedItem()).equalsIgnoreCase("")==true)
                {
                    return false;
                }
            }
        }
        for(int l=0;l<p.get_object().getClass().getDeclaredFields().length;l++)
        {
            if(p.get_object().getClass().getDeclaredFields()[l].getType()==Number.class)
            {
                if(isDouble(((JTextField)p.get_formulaire().get_liste_champ()[l].get_texte_field()).getText())==false)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDouble(String testena)
    {
        String[] te=new String[26];
        te[0]="a";
        te[1]="b";
        te[2]="c";
        te[3]="d";
        te[4]="e";
        te[5]="f";
        te[6]="g";
        te[7]="h";
        te[8]="i";
        te[9]="j";
        te[10]="k";
        te[11]="l";
        te[12]="m";
        te[13]="n";
        te[14]="o";
        te[15]="p";
        te[16]="q";
        te[17]="r";
        te[18]="s";
        te[19]="t";
        te[20]="u";
        te[21]="v";
        te[22]="w";
        te[23]="x";
        te[24]="y";
        te[25]="z";
        for(int i=0;i<te.length;i++)
        {
            if(testena.toLowerCase().contains(te[i].toLowerCase())==true)
            {
                return false;
            }
        }
        return true;
    }

    public void write(String field_name,String txt)
    {
        try
        {
            BufferedWriter bufferedwriter=new BufferedWriter(new FileWriter(new File(field_name),true));
            bufferedwriter.write(txt);
            bufferedwriter.newLine();
            bufferedwriter.close();
        }
        catch(Exception e)
        {}
    }
}