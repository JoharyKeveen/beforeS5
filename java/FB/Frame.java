package windows;
import java.awt.*;
import javax.swing.*;
import java.lang.reflect.*;
import listener.*;
import object.*;

public class Frame extends JFrame
{
    Object obj;
    JLabel error;
    public void setError(String message)
    {
        this.error.setText(message);
    }
    public Frame(Object o)
    {
        this.obj=o;
        this.error=new JLabel();
    }
    public Frame()
    {
        this.error=new JLabel();
    }

    public void createList(String[][] pers,Person inLive)throws Exception
    {
        Panel jo=new Panel(this);
        this.add(jo.list(pers,pers[0],inLive));
        this.setTitle("List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void createListDmd(Person inLive)throws Exception
    {
        Panel jo=new Panel(this);
        this.add(jo.listDeDmd(inLive));
        this.setTitle("Liste de demande");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void createSadText()
    {
        Panel jo=new Panel(this);
        this.add(jo.sad());
        this.setTitle("Sad");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void createIndex()
    {
        Panel jo=new Panel(this);
        this.add(jo.index());
        this.setTitle("Index");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void infoPerson()
    {
        Panel jo=new Panel(this);
        this.add(jo.creerForm(obj));
        String[] arguments={"nom","genre","nationality","finoana","fiaviana","diplome","alavana","teint","salaire","id"};
        String[] genre={"lahy","vavy"};
        jo.get_formulaire().textfield_to_combobox("genre",jo,genre);
        String[] nat={"africain","europeen","asiatique","americain"};
        jo.get_formulaire().textfield_to_combobox("nationality",jo,nat);
        String[] fiaviana={"afro","blanc","jaune"};
        jo.get_formulaire().textfield_to_combobox("fiaviana",jo,fiaviana);
        String[] teint={"sombre","marron foncer","marron","marron clair","clair"};
        jo.get_formulaire().textfield_to_combobox("teint",jo,teint);
        jo.get_formulaire().set_visible("id",false,jo);
        jo.get_formulaire().ordre(arguments,jo);
        jo.get_formulaire().setTextButt("validPerson",jo);
        this.setTitle("Info Person");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void infoCritereAxe()
    {
        Panel jo=new Panel(this);
        this.add(jo.creerForm(obj));
        String[] arguments={"nationality","finoana","fiaviana","diplome","alavana","teint","salaire","noteMinimal","id"};
        jo.get_formulaire().set_visible("id",false,jo);
        jo.get_formulaire().ordre(arguments,jo);
        jo.get_formulaire().setTextButt("validCritere",jo);
        jo.getButt().removeActionListener(jo.getAl());
        jo.getButt().addActionListener(new AListner(this,jo.getButt(),jo,(CritereAxe)obj));
        this.setTitle("Preference Coef");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}