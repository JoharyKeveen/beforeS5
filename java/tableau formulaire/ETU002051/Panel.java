package windows;
import javax.swing.*;
import java.awt.*;
import listener.*;
public class Panel extends JPanel
{
    Object o;
    int width;
    int height;
    JLabel[] legend;
    JPanel result;
    Formulaire f;
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
        
        JButton button=new JButton();
        button.setText("Valider");
        button.setBounds((width*2+x)/2,y+10,(width*2+x)/2,height/2);
        button.setFocusable(false);
        button.addActionListener(new Mouse(button,this));
        result.add(button);
        result.setPreferredSize(new Dimension(width*3+x,y+height));
        return result;
    }
}