package listener;
import windows.*;
import javax.swing.JButton;
import java.awt.event.*;

public class Mouse implements ActionListener
{
    Panel panel;
    public Mouse(Panel panel)
    {
        this.panel =panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.get_player2().set_nom("P2");
        if(e.getSource()==panel.get_haut())
        {
            if(panel.get_cases(panel.get_player2().get_x_player()/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases(panel.get_player2().get_x_player()/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_bas())
        {
            if(panel.get_cases(panel.get_player2().get_x_player()/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases(panel.get_player2().get_x_player()/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_droite())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,panel.get_player2().get_y_player()/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,panel.get_player2().get_y_player()/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_gauche())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,panel.get_player2().get_y_player()/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,panel.get_player2().get_y_player()/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_bas_droite())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas ()+" pas");
            }
            if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_bas_gauche())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,(panel.get_player2().get_y_player()+panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_haut_gauche())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player2().get_x_player()-panel.get_measure())/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()-panel.get_measure(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        else if(e.getSource()==panel.get_haut_droite())
        {
            if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player2().get_x_player()/30,panel.get_player2().get_y_player()/30,3);
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()+1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player2().get_x_player()+panel.get_measure())/30,(panel.get_player2().get_y_player()-panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player2().set_coord(panel.get_player2().get_x_player()+panel.get_measure(),panel.get_player2().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player2().set_pas(panel.get_player2().get_pas()-1);
                System.out.println(panel.get_player2().get_nom()+" : "+panel.get_player2().get_pas()+" pas");
            }
        }
        panel.repaint();
    }
}