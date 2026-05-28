package listener;
import graph.*;
import java.awt.event.*;
import java.sql.*;

public class Mouse implements MouseListener
{
    Panel p;
    public Mouse(Panel p)
    {
        this.p =p;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        for(int i=0;i<p.get_listBall().length;i++)
        {
            if(p.get_listBall()[i].get_vitesseX()>0.01||p.get_listBall()[i].get_vitesseX()<-0.01)
            {
                return;
            }
        }
        p.set_xline(e.getX()-(int)(p.get_listBall()[0].get_diameter()/2));
        p.set_yline(e.getY()-(int)(p.get_listBall()[0].get_diameter()/2));
        p.get_listBall()[0].set_vitesseX((p.get_xline()-p.get_listBall()[0].get_posX())/p.get_listBall()[0].get_diameter());
        p.get_listBall()[0].set_vitesseY((p.get_yline()-p.get_listBall()[0].get_posY())/p.get_listBall()[0].get_diameter());
        if(p.get_tour()==0)
        {
            p.set_actif(p.get_listJoueur()[0]);
            System.out.println(p.get_actif().get_nom());
            p.set_tour(1);
        }
        else if(p.get_tour()==1)
        {
            p.set_actif(p.get_listJoueur()[1]);
            System.out.println(p.get_actif().get_nom());
            p.set_tour(0);
        }
        p.get_actif().set_tir(p.get_actif().get_tir()+1);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }
}