package windows;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Player
{
    int x;
    int y;
    int score;

    public int get_score()
    {
        return this.score;
    }
    public void set_score(int nb)
    {
        this.score=nb;
    }
    public int get_x()
    {
        return this.x;
    }
    public void set_x(int x)
    {
        this.x=x;
    }

    public int get_y()
    {
        return this.y;
    }
    public void set_y(int y)
    {
        this.y=y;
    }

    public Player(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

}