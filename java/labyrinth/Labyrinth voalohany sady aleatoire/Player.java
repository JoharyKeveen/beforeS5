package windows;
import listener.*;
import javax.swing.JPanel;
import java.awt.*;
public class Player extends JPanel
{
    String nom;
    public String get_nom()
    {
        return this.nom;
    }
    public void set_nom(String nom)
    {
        this.nom=nom;
    }
    int pas;
    public int get_pas()
    {
        return this.pas;
    }
    public void set_pas(int pas)
    {
        this.pas=pas;
    }
    int x_player, y_player;
    public int get_x_player()
    {
        return this.x_player;
    }
    public int get_y_player()
    {
        return this.y_player;
    }
    public void set_coord(int x,int y)
    {
        this.x_player=x;
        this.y_player =y;
    }
    public Player(int x,int y)
    {
        this.x_player=x;
        this.y_player=y;
    } 
}