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
        if(e.getKeyCode()==38)
        {
            if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,3);
                panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()+1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
            else if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()-panel.get_measure());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()-1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==40)
        {
            if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,3);
                panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()+1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
            else if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()+panel.get_measure());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()-1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==39)
        {
            if(panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,panel.get_player().get_y_player()/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,3);
                panel.get_player().set_coord(panel.get_player().get_x_player()+panel.get_measure(),panel.get_player().get_y_player());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()+1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,panel.get_player().get_y_player()/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player().set_coord(panel.get_player().get_x_player()+panel.get_measure(),panel.get_player().get_y_player());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()-1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==37)
        {
            if(panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,panel.get_player().get_y_player()/30)==0)
            {
                panel.liberer_chemin();
                panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,3);
                panel.get_player().set_coord(panel.get_player().get_x_player()-panel.get_measure(),panel.get_player().get_y_player());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()+1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
            else if(panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,panel.get_player().get_y_player()/30)==3)
            {
                panel.liberer_chemin();
                panel.get_player().set_coord(panel.get_player().get_x_player()-panel.get_measure(),panel.get_player().get_y_player());
                panel.check_victory();
                panel.get_player().set_pas(panel.get_player().get_pas()-1);
                System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
            }
        }
        else if(e.getKeyCode()==12)
        {
            int test=0;
            if(panel.get_player().get_x_player()>panel.get_x_exit())
            {
                if(panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,panel.get_player().get_y_player()/30)==0)
                {
                    panel.liberer_chemin_automatique();
                    panel.liberer_chemin();
                    panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                    panel.get_player().set_coord(panel.get_player().get_x_player()-panel.get_measure(),panel.get_player().get_y_player());
                    panel.check_victory();
                    panel.get_player().set_pas(panel.get_player().get_pas()+1);
                    System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                    panel.repaint();
                    return;
                }
                else test++;
            }
            if(panel.get_player().get_x_player()<panel.get_x_exit())
            {
                if(panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,panel.get_player().get_y_player()/30)==0)
                {
                    panel.liberer_chemin_automatique();
                    panel.liberer_chemin();
                    panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                    panel.get_player().set_coord(panel.get_player().get_x_player()+panel.get_measure(),panel.get_player().get_y_player());
                    panel.check_victory();
                    panel.get_player().set_pas(panel.get_player().get_pas()+1);
                    System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                    panel.repaint();
                    return;
                }
                else test++;
            }
            if(panel.get_player().get_y_player()<panel.get_y_exit())
            {
                if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==0)
                {
                    panel.liberer_chemin_automatique();
                    panel.liberer_chemin();
                    panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                    panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()+panel.get_measure());
                    panel.check_victory();
                    panel.get_player().set_pas(panel.get_player().get_pas()+1);
                    System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                    panel.repaint();
                    return;
                }
                else test++;
            }
            if(panel.get_player().get_y_player()>panel.get_y_exit())
            {
                if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==0)
                {
                    panel.liberer_chemin_automatique();
                    panel.liberer_chemin();
                    panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                    panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()-panel.get_measure());
                    panel.check_victory();
                    panel.get_player().set_pas(panel.get_player().get_pas()+1);
                    System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                    panel.repaint();
                    return;
                }
                else test++;
            }

            int retest=0;
            if(test!=0)
            {
                if(panel.get_player().get_x_player()<=panel.get_x_exit())
                {
                    if(panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,(panel.get_player().get_y_player())/30)==0)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player()-panel.get_measure(),panel.get_player().get_y_player());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                    else retest++;
                }
                if(panel.get_player().get_y_player()<=panel.get_y_exit())
                {
                    if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==0)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()-panel.get_measure());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                    else retest++;
                }
                if(panel.get_player().get_y_player()>=panel.get_y_exit())
                {
                    if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==0)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()+panel.get_measure());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                    else retest++;
                }
                if(panel.get_player().get_x_player()>=panel.get_x_exit())
                {
                    if(panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,(panel.get_player().get_y_player())/30)==0)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player()+panel.get_measure(),panel.get_player().get_y_player());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                    else retest++;
                }
            }



            if(retest!=0)
            {
                if(panel.get_player().get_y_player()<=panel.get_y_exit())
                {
                    if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==0||panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()+panel.get_measure())/30)==3)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()+panel.get_measure());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                }
                if(panel.get_player().get_x_player()<=panel.get_x_exit())
                {
                    if(panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,(panel.get_player().get_y_player())/30)==0||panel.get_cases((panel.get_player().get_x_player()+panel.get_measure())/30,(panel.get_player().get_y_player())/30)==3)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player()+panel.get_measure(),panel.get_player().get_y_player());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                }
                if(panel.get_player().get_y_player()>=panel.get_y_exit())
                {
                    if(panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==0||panel.get_cases(panel.get_player().get_x_player()/30,(panel.get_player().get_y_player()-panel.get_measure())/30)==3)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player(),panel.get_player().get_y_player()-panel.get_measure());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                }
                if(panel.get_player().get_x_player()>=panel.get_x_exit())
                {
                    if(panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,(panel.get_player().get_y_player())/30)==0||panel.get_cases((panel.get_player().get_x_player()-panel.get_measure())/30,(panel.get_player().get_y_player())/30)==3)
                    {
                        panel.liberer_chemin_automatique();
                        panel.liberer_chemin();
                        panel.set_cases(panel.get_player().get_x_player()/30,panel.get_player().get_y_player()/30,666);
                        panel.get_player().set_coord(panel.get_player().get_x_player()-panel.get_measure(),panel.get_player().get_y_player());
                        panel.check_victory();
                        panel.get_player().set_pas(panel.get_player().get_pas()+1);
                        System.out.println(panel.get_player().get_nom()+" : "+panel.get_player().get_pas()+" pas");
                        panel.repaint();
                        return;
                    }
                }
            }
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}