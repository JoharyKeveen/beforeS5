package listener;
import windows.*;
import java.awt.event.*;

public class Mouse implements MouseListener
{
    Panel panel;
    public Mouse(Panel panel)
    {
        this.panel =panel;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getX()<panel.get_x_max()*panel.get_measure()&&e.getY()<panel.get_y_max()*panel.get_measure())
        {
            if(e.getClickCount()==2)
            {
                System.out.println("indroa izay leretsy a");
                int x=e.getX()/panel.get_measure();
                int y=e.getY()/panel.get_measure();
                panel.set_cases(x,y,1);
                panel.repaint();
            }
            for(int i=0;i<panel.get_nb_player();i++)
            {
                if(e.getX()>panel.get_tab_player(i).get_x_player()&&e.getX()<panel.get_tab_player(i).get_x_player()+panel.get_measure()&&e.getY()>panel.get_tab_player(i).get_y_player()&&e.getY()<panel.get_tab_player(i).get_y_player()+panel.get_measure()||e.getX()==panel.get_tab_player(i).get_x_player()&&e.getY()==panel.get_tab_player(i).get_y_player()||e.getX()==panel.get_tab_player(i).get_x_player()+panel.get_measure()&&e.getY()==panel.get_tab_player(i).get_y_player()+panel.get_measure())
                {
                    panel.set_player(panel.get_tab_player(i));
                }  
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
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
    {}
}