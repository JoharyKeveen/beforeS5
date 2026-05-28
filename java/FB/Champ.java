package windows;
import javax.swing.*;
public class Champ extends JComponent
{
    JComponent texte_field;
    String label;
    boolean is_visible;
    String default_value;

    public void set_label(String l)
    {
        this.label=l;
    }
    public String get_label()
    {
        return this.label;
    }
    public JComponent get_texte_field()
    {
        return this.texte_field;
    }
    public void set_texte_field(JComponent j)
    {
        this.texte_field=j;
    }
    public boolean get_is_visible()
    {
        return this.is_visible;
    }
    public void set_is_visible(boolean txt)
    {
        this.is_visible=txt;
    }
    public String get_default_value()
    {
        return this.default_value;
    }
    public void set_default_value(String v)
    {
        this.default_value=v;
    }

    public Champ(String lab)
    {
        this.texte_field=new JTextField();
        this.label=lab;
        this.is_visible=true;
        this.default_value="";
    }
}