package windows;
import javax.swing.*;
public class Formulaire 
{
    Object o;
    Champ[] liste_champ;

    public void textfield_to_combobox(String name,Panel p,String[] args)
    {
        for(int i=0;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_label().equalsIgnoreCase(name)==true)
            {
                p.get_result().remove(p.get_formulaire().get_liste_champ()[i].get_texte_field());
                p.get_formulaire().get_liste_champ()[i].set_texte_field(new JComboBox(args));
                p.get_formulaire().get_liste_champ()[i].get_texte_field().setBounds(p.get_width(),p.get_legend()[i].getY(),p.get_width()*2,p.get_height());
                if(p.get_formulaire().get_liste_champ()[i].get_is_visible()==true)
                {
                    p.get_result().add(p.get_formulaire().get_liste_champ()[i].get_texte_field());
                }
            }
        }
    }
    public void set_champ(int i,Champ c)
    {
        this.liste_champ[i]=c;
    }
    public Champ[] get_liste_champ()
    {
        return this.liste_champ;
    }
    public void set_liste_champ(int nb)
    {
        this.liste_champ[nb]=new Champ(o.getClass().getDeclaredFields()[nb].getName());
    }
    public Formulaire(Object o)
    {
        this.o=o;
        this.liste_champ=new Champ[o.getClass().getDeclaredFields().length];
    }

    public void set_name_label(String before,String after,Panel p)
    {
        for(int i=0;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_label().equalsIgnoreCase(before)==true)
            {
                p.get_formulaire().get_liste_champ()[i].set_label(after);
                p.get_legend()[i].setText(p.get_formulaire().get_liste_champ()[i].get_label());
            }
        }
    }
    public void set_visible(String name,boolean result,Panel p)
    {
        for(int i=0;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_label().equalsIgnoreCase(name)==true)
            {
                p.get_formulaire().get_liste_champ()[i].set_is_visible(result);
                if(p.get_formulaire().get_liste_champ()[i].get_is_visible()==false)
                {
                    p.get_result().remove(p.get_legend()[i]);
                    p.get_result().remove(p.get_formulaire().get_liste_champ()[i].get_texte_field());
                }
            }
        }
    }
    public void set_value(String name,String val,Panel p)
    {
        for(int i=0;i<p.get_formulaire().get_liste_champ().length;i++)
        {
            if(p.get_formulaire().get_liste_champ()[i].get_label().equalsIgnoreCase(name)==true)
            {
                p.get_formulaire().get_liste_champ()[i].set_default_value(val);
                ((JTextField)p.get_formulaire().get_liste_champ()[i].get_texte_field()).setText(p.get_formulaire().get_liste_champ()[i].get_default_value());
            }
        }
    }
    public void ordre(String[] txt,Panel p)
    {
        for(int i=0;i<liste_champ.length;i++)
        {
            for(int j=0;j<liste_champ.length;j++)
            {
                if(txt[i].equalsIgnoreCase(liste_champ[j].get_label())==true)
                {
                    p.get_legend()[j].setBounds(10,p.get_height()*i,p.get_width()*2,p.get_height());
                    p.get_formulaire().get_liste_champ()[j].get_texte_field().setBounds(p.get_width(),p.get_legend()[j].getY(),p.get_width()*2,p.get_height());
                }
            }
        }
    }
}