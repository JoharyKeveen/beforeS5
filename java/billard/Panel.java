package graph;
import connection.Connex;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.Random;
import java.awt.*;
import listener.*;
import java.sql.*;

public class Panel extends JPanel
{
    int fin=0;
    Joueur[] listJoueur;
    public Joueur[] get_listJoueur()
    {
        return this.listJoueur;
    }
    public void set_listJoueur(Joueur[] lj)
    {
        this.listJoueur=lj;
    }
    Joueur actif;
    public Joueur get_actif()
    {
        return this.actif;
    }
    public void set_actif(Joueur a)
    {
        this.actif=a;
    }
    int tour=1;
    public int get_tour()
    {
        return this.tour;
    }
    public void set_tour(int t)
    {
        this.tour=t;
    }
    int nb_ball;
    int xline;
    public void set_xline(int x)
    {
        this.xline=x;
    }
    public int get_xline()
    {
        return this.xline;
    }
    int yline;
    public int get_yline()
    {
        return this.yline;
    }
    public void set_yline(int y)
    {
        this.yline=y;
    }
    int width;
    int height;
    int[] trouX;
    int[] trouY;
    int diamTrou;
    Ball[] listBall;
    public Ball[] get_listBall()
    {
        return this.listBall;
    }
    public Panel()
    {
        this.nb_ball=2;
        this.height=400;
        double temp_width=this.height*1.84;
        this.width=(int)temp_width;
        create_player();
        trouer();
        createBall();
        this.xline=(int)listBall[0].get_posX();
        this.yline=(int)listBall[0].get_posY();
        this.addMouseListener(new Mouse(this));
        this.setBackground(new Color(40,135,0));
        this.setPreferredSize(new Dimension(width,height));
        this.setFocusable(true);
    }
    void trouer()
    {
        this.diamTrou=70;
        this.trouX=new int[3];
        this.trouY=new int[2];
        this.trouX[0]=0-this.diamTrou/2;
        this.trouX[1]=width/2-this.diamTrou/2;
        this.trouX[2]=width-this.diamTrou/2;
        this.trouY[0]=0-this.diamTrou/2;
        this.trouY[1]=height-this.diamTrou/2;
    }
    void create_player()
    {
        this.listJoueur=new Joueur[2];
        this.listJoueur[0]= new Joueur("J1",0);
        this.listJoueur[1]= new Joueur("J2",1);
        this.actif=this.listJoueur[0];
    }
    void createBall()
    {
        this.listBall=new Ball[nb_ball];
        this.listBall[0]=new Ball(width/7,height/2-35,35);
        int randX=0;
        int randY=0;
        for(int l=1;l<this.listBall.length;l++)
        {
            this.listBall[l]=new Ball(0,0,listBall[0].get_diameter());
        }
        int x=this.width/2;
        int y=this.height/2-(int)listBall[0].get_diameter();
        int dirx=x;
        int diry=y;
        int nb=1;
        int reste=this.listBall.length-1;
        while(nb<this.listBall.length)
        {
            for(int i=nb;i<=nb;i++)
            {
                this.listBall[i]=new Ball(dirx,diry,listBall[0].get_diameter());
                diry-=this.listBall[0].get_diameter();
            }
            dirx=x+(int)this.listBall[0].get_diameter();
            x=dirx;
            diry=(int)(this.listBall[nb].get_posY()+this.listBall[0].get_diameter()/2);
            nb++;
        }
    }
    void check_maty()
    {
        for(int i=0;i<this.trouX.length;i++)
        {
            for(int j=0;j<this.trouY.length;j++)
            {
                for(int x=0;x<this.listBall.length;x++)
                {
                    double a=Math.abs(this.listBall[x].get_posX()-this.trouX[i]);
                    double b=Math.abs(this.listBall[x].get_posY()-this.trouY[j]);
                    double distance=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                    if(distance<=this.listBall[x].get_diameter()*2)
                    {
                        if(x!=0)
                        {
                            this.listBall[x].set_diameter(0);
                            actif.set_point(actif.get_point()+1);
                            System.out.println(actif.get_point());
                        }
                    }
                }
            }
        }
    }
    public void ralentir()
    {
        float reduc=(float)0.98;
        for(int i=0;i<this.listBall.length;i++)
        {
            this.listBall[i].set_vitesseX(this.listBall[i].get_vitesseX()*reduc);
            this.listBall[i].set_vitesseY(this.listBall[i].get_vitesseY()*reduc);
        }
    }
    public void draw_trou(Graphics g)
    {
        for(int i=0;i<this.trouY.length;i++)
        {
            for(int j=0;j<this.trouX.length;j++)
            {
                g.setColor(Color.black);
                g.fillOval(this.trouX[j],this.trouY[i],this.diamTrou,this.diamTrou);
            }
        }
    }
    public void draw_Ball(Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval((int)this.listBall[0].get_posX(),(int)this.listBall[0].get_posY(),(int)this.listBall[0].get_diameter(),(int)this.listBall[0].get_diameter());
        for(int i=1;i<this.listBall.length;i++)
        {
            g.setColor(new Color(135,0,0));
            g.fillOval((int)this.listBall[i].get_posX(),(int)this.listBall[i].get_posY(),(int)this.listBall[i].get_diameter(),(int)this.listBall[i].get_diameter());
        }
    }
    public void draw_help(Graphics g)
    {
        int x,y;
        PointerInfo pointer= MouseInfo.getPointerInfo();
        Point location= pointer.getLocation();
        x=(int) location.getX()-5;
        y=(int) location.getY()-30;
        g.drawLine((int)listBall[0].get_posX()+(int)(listBall[0].get_diameter()/2),(int)listBall[0].get_posY()+(int)(listBall[0].get_diameter()/2),x,y);
    }
    public void moov()
    {
        for(int i=0;i<listBall.length;i++)
        {
            listBall[i].set_posX(listBall[i].get_posX()+listBall[i].get_vitesseX());
            listBall[i].set_posY(listBall[i].get_posY()+listBall[i].get_vitesseY());
        }
    }

    public void check_finishGame()
    {
        for(int i=1;i<this.listBall.length;i++)
        {
            if(this.listBall[i].get_diameter()!=0)
            {
                return;
            }
        }
        insert(listJoueur[0].get_point(),listJoueur[0].get_tir(),0);
        insert(listJoueur[1].get_point(),listJoueur[1].get_tir(),1);
        fin=9;
    }
    public void colision_bord()
    {
        for(int i=0;i<this.listBall.length;i++)
        {
            if(this.listBall[i].get_posX()<=0)
            {
                this.listBall[i].set_posX(0);
                this.listBall[i].set_vitesseX(this.listBall[i].get_vitesseX()*(-1));
            }
            if(this.listBall[i].get_posX()+this.listBall[i].get_diameter()>=this.width)
            {
                this.listBall[i].set_posX(width-this.listBall[i].get_diameter());
                this.listBall[i].set_vitesseX(this.listBall[i].get_vitesseX()*(-1));
            }
            if(this.listBall[i].get_posY()<=0)
            {
                this.listBall[i].set_posY(0);
                this.listBall[i].set_vitesseY(this.listBall[i].get_vitesseY()*(-1));
            }
            if(this.listBall[i].get_posY()+this.listBall[i].get_diameter()>=this.height)
            {
                this.listBall[i].set_posY(height-this.listBall[i].get_diameter());
                this.listBall[i].set_vitesseY(this.listBall[i].get_vitesseY()*(-1));
            }
        }
    }
    public void colision_ball()
    {
        double a,b;
        double distance;
        for(int i=0;i<this.listBall.length;i++)
        {
            for(int j=0;j<this.listBall.length;j++)
            {
                if(i!=j)
                {
                    a=this.listBall[i].get_posX()-this.listBall[j].get_posX();
                    b=this.listBall[i].get_posY()-this.listBall[j].get_posY();
                    distance=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                    double angle=Math.atan2(a,b);
                    if(distance<=this.listBall[i].get_diameter())
                    {
                        double vx1=this.listBall[i].get_vitesseX();
                        double vy1=this.listBall[i].get_vitesseY();
                        double vx2=this.listBall[j].get_vitesseX();
                        double vy2=this.listBall[j].get_vitesseY();
                        // double V=Math.sqrt(Math.pow(vx1,2)+Math.pow(vy1,2));
                        // listBall[i].set_vitesseX((float)(vx1*Math.cos(angle)+vy1*Math.sin(angle)));
                        // listBall[i].set_vitesseY((float)((-1)*vx1*Math.sin(angle)+vy1*Math.cos(angle)));
                        // listBall[j].set_vitesseX((float)(vx2*Math.cos(angle)+vy2*Math.sin(angle)));
                        // listBall[j].set_vitesseY((float)((-1)*vx2*Math.sin(angle)+vy2*Math.cos(angle)));
                        double setX1=(Math.pow(Math.cos(angle),2)*V)/2;
                        double setY1=-(2*Math.sin(angle)*Math.cos(angle)*V)/2;
                        double setX2=(2*V*Math.pow(Math.sin(angle),2))/2;
                        double setY2=(2*V*Math.sin(angle)*Math.cos(angle))/2;
                        listBall[i].set_vitesseX((float)setX1);
                        listBall[i].set_vitesseY((float)setY1);
                        listBall[j].set_vitesseX((float)setX2);
                        listBall[j].set_vitesseY((float)setY2);
                    }
                }
            }
        }
    }
    public void paint(Graphics g)
    {
        if(fin==0)
        {
            super.paint(g);
            if(this.listBall[0].get_vitesseX()<0.01&&this.listBall[0].get_vitesseX()>-0.01)
            {
                draw_help(g);
            }
            draw_trou(g);
            draw_Ball(g);
            ralentir();
            colision_bord();
            colision_ball();
            moov();
            try {
                Thread.sleep(8);
            } catch (Exception e) {
            }
            check_maty();
            check_finishGame();
            repaint();
        }
        else
        {
            super.paint(g);
            this.setBackground(Color.black);
        }
    }
    public void insert(int score,int tir,int id)
    {
        try
        {
            Connex co=new Connex();
            Connection lo=co.log();
            Statement st = lo.createStatement();
            ResultSet n=st.executeQuery("INSERT INTO match VALUES("+score+","+tir+","+id+")");
            lo.close();
            st.close();
            n.close();
        }
        catch(Exception e)
        {}
    }
}