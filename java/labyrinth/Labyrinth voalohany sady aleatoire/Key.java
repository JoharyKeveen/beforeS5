package listener;
import windows.*;
import java.awt.event.*;

public class Key implements KeyListener
{
    Panel panel;
    public Key(Panel panel)
    {
        this.panel =panel;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        panel.get_player1().set_nom("P1");
        if(e.getKeyCode()==38)
        {
            if(panel.get_cases(panel.get_player1().get_x_player()/30,(panel.get_player1().get_y_player()-panel.get_measure())/30)!=1)
            {
                panel.get_player1().set_coord(panel.get_player1().get_x_player(),panel.get_player1().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player1().set_pas(panel.get_player1().get_pas()+1);
                System.out.println(panel.get_player1().get_nom()+" : "+panel.get_player1().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==40)
        {
            if(panel.get_cases(panel.get_player1().get_x_player()/30,(panel.get_player1().get_y_player()+panel.get_measure())/30)!=1)
            {
                panel.get_player1().set_coord(panel.get_player1().get_x_player(),panel.get_player1().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player1().set_pas(panel.get_player1().get_pas()+1);
                System.out.println(panel.get_player1().get_nom()+" : "+panel.get_player1().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==37)
        {
            if(panel.get_cases((panel.get_player1().get_x_player()-panel.get_measure())/30,panel.get_player1().get_y_player()/30)!=1)
            {
                panel.get_player1().set_coord(panel.get_player1().get_x_player()-panel.get_measure(),panel.get_player1().get_y_player());
                panel.check_victory();
                panel.get_player1().set_pas(panel.get_player1().get_pas()+1);
                System.out.println(panel.get_player1().get_nom()+" : "+panel.get_player1().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==39)
        {
            if(panel.get_cases((panel.get_player1().get_x_player()+panel.get_measure())/30,panel.get_player1().get_y_player()/30)!=1)
            {
                panel.get_player1().set_coord(panel.get_player1().get_x_player()+panel.get_measure(),panel.get_player1().get_y_player());
                panel.check_victory();
                panel.get_player1().set_pas(panel.get_player1().get_pas()+1);
                System.out.println(panel.get_player1().get_nom()+" : "+panel.get_player1().get_pas()+" pas");
            }
        }
        panel.repaint();    
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}