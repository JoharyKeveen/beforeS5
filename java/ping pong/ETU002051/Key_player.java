package listener;
import windows.*;
import windows.*;
import java.awt.event.*;
public class Key_player implements KeyListener
{
    Player player;
    Panel panel;
    public Key_player(Player p, Panel panel)
    {
        this.player=p;
        this.panel=panel;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(panel.get_id()%2==0)
        {
            if(player.get_y()==0&&player.get_x()>0)
            {
                if(e.getKeyCode()==65)
                {
                    player.set_x(player.get_x()-panel.get_player_width());
                    if(panel.get_y_circle()>0&&panel.get_y_circle()<=panel.get_player_height()+panel.get_gama())
                    panel.set_x_circle(panel.get_player(0).get_x()+(panel.get_player_width()/2)-panel.get_circle_diameter()/2);
                    if(player.get_x()<0)
                    {
                        player.set_x(0);
                    }
                    panel.repaint();
                }
            }
            if(player.get_y()==0&&player.get_x()<(panel.get_width()-panel.get_player_width()))
            {
                if(e.getKeyCode()==68)
                {
                    player.set_x(player.get_x()+panel.get_player_width());
                    if(panel.get_y_circle()>0&&panel.get_y_circle()<=panel.get_player_height()+panel.get_gama())
                    panel.set_x_circle(panel.get_player(0).get_x()+(panel.get_player_width()/2)-panel.get_circle_diameter()/2);
                    if(player.get_x()>(panel.get_width()-panel.get_player_width()))
                    {
                        player.set_x(panel.get_width()-panel.get_player_width());
                    }
                    panel.repaint();
                }
            }
            if(player.get_y()==panel.get_height()-panel.get_player_height()&&player.get_x()>0)
            {
                if(e.getKeyCode()==37)
                {
                    player.set_x(player.get_x()-panel.get_player_width());
                    if(panel.get_y_circle()<panel.get_height()&&panel.get_y_circle()>=panel.get_height()-panel.get_player_height()-panel.get_circle_diameter()-panel.get_gama())
                    panel.set_x_circle(panel.get_player(1).get_x()+(panel.get_player_width()/2)-panel.get_circle_diameter()/2);
                    if(player.get_x()<0)
                    {
                        player.set_x(0);
                    }
                    panel.repaint();
                }
            }
            if(player.get_y()==panel.get_height()-panel.get_player_height()&&player.get_x()<(panel.get_width()-panel.get_player_width()))
            {
                if(e.getKeyCode()==39)
                {
                    player.set_x(player.get_x()+panel.get_player_width());
                    if(panel.get_y_circle()<panel.get_height()&&panel.get_y_circle()>=panel.get_height()-panel.get_player_height()-panel.get_circle_diameter()-panel.get_gama())
                    panel.set_x_circle(panel.get_player(1).get_x()+(panel.get_player_width()/2)-panel.get_circle_diameter()/2);
                    if(player.get_x()>(panel.get_width()-panel.get_player_width()))
                    {
                        player.set_x(panel.get_width()-panel.get_player_width());
                    }
                    panel.repaint();
                }
            }
        }
        else
        // if(panel.get_id()%2!=0)
        {
            if(e.getKeyCode()==110&&panel.get_y_circle()==panel.get_height()-panel.get_circle_diameter()-panel.get_player_height()-panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()-1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(0);
            }
            else if(e.getKeyCode()==71&&panel.get_y_circle()==panel.get_player_height()+panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()+1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(1);
            }
            else if(e.getKeyCode()==96&&panel.get_y_circle()==panel.get_height()-panel.get_circle_diameter()-panel.get_player_height()-panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()-1);
                panel.set_x_circle(panel.get_x_circle()-1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(2);
            }
            else if(e.getKeyCode()==10&&panel.get_y_circle()==panel.get_height()-panel.get_circle_diameter()-panel.get_player_height()-panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()-1);
                panel.set_x_circle(panel.get_x_circle()+1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(3);
            }
            else if(e.getKeyCode()==70&&panel.get_y_circle()==panel.get_player_height()+panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()+1);
                panel.set_x_circle(panel.get_x_circle()-1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(4);
            }
            else if(e.getKeyCode()==72&&panel.get_y_circle()==panel.get_player_height()+panel.get_gama())
            {
                panel.set_y_circle(panel.get_y_circle()+1);
                panel.set_x_circle(panel.get_x_circle()+1);
                panel.set_id(panel.get_id()+1);
                panel.set_path(5);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }    
}