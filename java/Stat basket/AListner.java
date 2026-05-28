package listener;
import windows.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import connection.*;
import java.sql.*;
import object.*;

public class AListner implements ActionListener
{
    int etatMatch;
    public int getEtatMatch() {
        return etatMatch;
    }

    public void setEtatMatch(int etatMatch) {
        this.etatMatch = etatMatch;
    }

    Chrono chrono;
    Frame frame;
    Panel panel;
    String action;
    int point;
    Player ballon;
    String preAction;
    Player preBallon;
    Vector<Player> playerA;
    Vector<Player> playerB;
    Matche matche;

    public Chrono getChrono() {
        return chrono;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public Vector<Player> getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Vector<Player> playerA) {
        this.playerA = playerA;
    }

    public Vector<Player> getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Vector<Player> playerB) {
        this.playerB = playerB;
    }

    public Matche getMatche() {
        return matche;
    }

    public void setMatche(Matche matche) {
        this.matche = matche;
    }

    public Player getPreBallon() {
        return preBallon;
    }

    public void setPreBallon(Player preBallon) {
        this.preBallon = preBallon;
    }

    public String getPreAction() {
        return preAction;
    }

    public void setPreAction(String preAction) {
        this.preAction = preAction;
    }

    public Player getBallon() {
        return ballon;
    }

    public void setBallon(Player ballon) {
        this.ballon = ballon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public AListner(Frame frame,Panel panel,Vector<Player> playerA,Vector<Player> playerB,Matche matche)
    {
        this.frame=frame;
        this.panel=panel;
        this.playerA=playerA;
        this.playerB=playerB;
        this.matche=matche;
        this.action="";
        this.point=0;
        this.etatMatch=0;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            Connex co=new Connex();
            Connection lo=co.log();
            if(getEtatMatch()!=0)
            {
                for(int i=0;i<panel.getPlayer1().length;i++)
                {
                    if(e.getSource()==panel.getPlayer1()[i])
                    {
                        int currentTime=panel.getSeconde()+panel.getMinute()*60+panel.getHeure()*60*60;
                        if(this.action.equals("tir")&&this.ballon!=null)
                        {
                            if(this.ballon.getName().equals(panel.getPlayer1()[i].getText()))
                            {
                                new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"tir",this.point).insert(lo);
                                this.matche.setScora(this.matche.getScora()+this.point);
                                this.matche.update("idmatche","scora", lo);
                                // tir 
                                if(this.point!=0)
                                {
                                    this.ballon=playerB.get(0);
                                    System.out.println(this.ballon.getName()+" a le ballon");
                                }
                                if(this.point!=0&&this.preBallon!=null)
                                {
                                    for(int k=0;k<playerB.size();k++)
                                    {
                                        if(this.preBallon==playerB.get(k)) return;
                                    }
                                    new Statis(this.preBallon.getIdplayer(),this.matche.getIdmatche(),"passD",1).insert(lo);
                                    // passD if maty
                                }
                                this.preAction=this.action;
                            }
                            else
                            {
                                System.out.println("tsy manana baolina izy donc pas de tir possible");
                            }
                        }
                        else if(this.action.equals("passe"))
                        {
                            this.preBallon=this.ballon;
                            this.ballon=playerA.get(i);
                            new Chrono(this.matche.getIdmatche(),this.preBallon.getIdplayer(),this.ballon.getIdplayer(),currentTime).insert(lo);
                            if(this.preAction.equals("tir")&&this.point==0)
                            {
                                for(int j=0;j<playerA.size();j++)
                                {
                                    if(this.preBallon==playerA.get(j))
                                    {
                                        new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"rebondOff",1).insert(lo);
                                        // rebond offensif
                                        this.action="";
                                        return;
                                    }
                                }
                                new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"rebondDeff",1).insert(lo);
                                // rebond deffensif
                                this.action="";
                                return;
                            }
                            //  porteur de bal
                            this.preAction=this.action;
                        }
                    }
                    else if(e.getSource()==panel.getPlayer2()[i])
                    {
                        int currentTime=panel.getSeconde()+panel.getMinute()*60+panel.getHeure()*60*60;
                        if(this.action.equals("tir")&&this.ballon!=null)
                        {
                            if(this.ballon.getName().equals(panel.getPlayer2()[i].getText()))
                            {
                                new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"tir",this.point).insert(lo);
                                this.matche.setScorb(this.matche.getScorb()+this.point);
                                this.matche.update("idmatche","scorb", lo);
                                // tir
                                if(this.point!=0)
                                {
                                    this.ballon=playerA.get(0);
                                    System.out.println(this.ballon.getName()+" a le ballon");
                                }
                                if(this.point!=0&&this.preBallon!=null)
                                {
                                    for(int k=0;k<playerA.size();k++)
                                    {
                                        if(this.preBallon==playerA.get(k)) return;
                                    }
                                    new Statis(this.preBallon.getIdplayer(),this.matche.getIdmatche(),"passD",1).insert(lo);
                                    // passD if maty
                                }
                                this.preAction=this.action;
                            }
                            else
                            {
                                System.out.println("tsy manana baolina izy donc pas de tir possible");
                            }
                        }
                        else if(this.action.equals("passe"))
                        {
                            this.preBallon=this.ballon;
                            this.ballon=playerB.get(i);
                            new Chrono(this.matche.getIdmatche(),this.preBallon.getIdplayer(),this.ballon.getIdplayer(),currentTime).insert(lo);
                            if(this.preAction.equals("tir")&&this.point==0)
                            {
                                for(int j=0;j<playerB.size();j++)
                                {
                                    if(this.preBallon==playerB.get(j))
                                    {
                                        new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"rebondOff",1).insert(lo);
                                        // rebond offensif
                                        this.action="";
                                        return;
                                    }
                                }
                                new Statis(this.ballon.getIdplayer(),this.matche.getIdmatche(),"rebondDeff",1).insert(lo);
                                // rebond deffensif
                                this.action="";
                                return;
                            }
                            // porteur ball
                            this.preAction=this.action;
                        }
                    }
                }
                this.action="";
            }
            if(e.getSource()==panel.getStart())
            {
                if(panel.getStart().getText().equals("start"))
                {
                    panel.getStart().setText("stop");
                    setEtatMatch(1);
                    panel.getTimer().start();
                }
                else
                {
                    panel.getStart().setText("start");
                    setEtatMatch(0);
                    panel.getTimer().stop();
                }
            }
            else if(e.getSource()==panel.getPause())
            {
                if(panel.getPause().getText().equals("||"))
                {
                    panel.getPause().setText(">");
                    setEtatMatch(0);
                    panel.getTimer().stop();
                }
                else
                {
                    panel.getPause().setText("||");
                    setEtatMatch(1);
                    panel.getTimer().start();
                }
            }
            lo.close();
        }
        catch(Exception exc)
        {}
    }
}