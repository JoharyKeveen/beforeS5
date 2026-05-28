package windows;
import java.awt.*;
import javax.swing.*;
import object.*;
import humain.*;
public class Frame extends JFrame
{
    public Frame()
    {
        Panel jo=new Panel();
        this.add(jo.creerForm(new Etudient()));
        String[] args={"Antananarivo","Fianarantsoa","Toamasina","Toliara","Mahajanga","Antsiranana"};
        // String[] arguments={"nom","olona","age","date","prenom"};
        // String[] arguments={"nom","prenom","age","date","olona"};
        // String[] arguments={"race","name","age","genre","nationality","vaccine"}; 
        // jo.get_formulaire().ordre(arguments,jo);
        // String[] genre={"male","female"}; 
        // jo.get_formulaire().set_visible("race",false,jo);
        // jo.get_formulaire().set_visible("olona",false,jo);
        jo.get_formulaire().set_value("numero","ETU002051",jo);
        // jo.get_formulaire().ordre(arguments,jo);
        jo.get_formulaire().textfield_to_combobox("province",jo,args);
        // jo.get_formulaire().textfield_to_combobox("date",jo,arguments);
        // jo.get_formulaire().set_name_label("genre","dooote",jo);
        this.setTitle("Formulaire");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}