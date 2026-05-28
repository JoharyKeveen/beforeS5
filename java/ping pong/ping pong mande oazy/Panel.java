package windows;
import listener.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.Random;
import java.awt.*;

public class Panel extends JPanel
{
    int id;
    int path;
    int turn;
    int gama;
    static int player_width=75;
    static int player_height=10;
    int circle_diameter;
    int x_circle;
    int y_circle;
    Player[] all_player;
    JPanel table_de_jeux;
    int y_net;
    int width;
    int height;
    public void set_id(int i)
    {
        this.id=i;
    }
    public int get_path()
    {
        return this.path;
    }
    public void set_path(int p)
    {
        this.path=p;
    }
    public int get_turn()
    {
        return this.turn;
    }
    public void set_turn(int t)
    {
        this.turn=t;
    }
    public Player get_player(int nb)
    {
        return this.all_player[nb];
    }
    public int get_gama()
    {
        return this.gama;
    }
    public int get_circle_diameter()
    {
        return this.circle_diameter;
    }
    public int get_y_circle()
    {
        return this.y_circle;
    }
    public void set_y_circle(int y)
    {
        this.y_circle=y;
    }
    public int get_x_circle()
    {
        return this.x_circle;
    }
    public void set_x_circle(int x)
    {
        this.x_circle=x;
    }
    public int get_height()
    {
        return this.height;
    }
    public int get_player_height()
    {
        return this.player_height;
    }
    public int get_width()
    {
        return this.width;
    }
    public int get_player_width()
    {
        return this.player_width;
    }
    public void init_player()
    {
        this.all_player=new Player[2];
        this.all_player[0]=new Player((this.width-player_width)/2,0);
        this.all_player[1]=new Player((this.width-player_width)/2,this.height-player_height);
    }
    public Panel()
    {
        this.id=1;
        this.turn=1;
        this.gama=5;
        this.circle_diameter=20;
        this.width=400;
        double temp_height=this.width*1.7;
        this.height=(int)temp_height;
        this.y_net=height/2;
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(width,height));
        init_player();
        this.x_circle=this.width/2-this.circle_diameter/2;
        this.y_circle=player_height+this.gama;
        this.addKeyListener(new Key_player(all_player[0],this));
        this.addKeyListener(new Key_player(all_player[1],this));
        this.setFocusable(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        draw_net(g);
        draw_player(g);
        draw_ball(g);
        draw_score(g);
        move_ball();
        check_victory();
		try {
			Thread.sleep(10);
		} catch (Exception e) {

		}
        repaint();
        draw_victory(g);
    }
    public void draw_victory(Graphics g)
    {
        if(this.all_player[0].get_score()>=11)
        {
            super.paint(g);
            this.setBackground(Color.black);
            g.setColor(Color.blue);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Le Joueur 1 a gagne", this.width/6, (this.height/2)-10);
        }
        else if(this.all_player[1].get_score()>=11)
        {
            super.paint(g);
            this.setBackground(Color.black);
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Le Joueur 2 a gagne", this.width/6, (this.height/2)-10);
        }
    }
    public void draw_net(Graphics g)
    {
        g.setColor(Color.white);
        g.drawLine(0,this.y_net,width,this.y_net);
    }
    public void draw_player(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(all_player[0].x,all_player[0].y,player_width,player_height);
        g.setColor(Color.red);
        g.fillRect(all_player[1].x,all_player[1].y,player_width,player_height);
    }
    public void draw_ball(Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval(this.x_circle,this.y_circle,this.circle_diameter,this.circle_diameter);
    }
    public void draw_score(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,60));
        g.drawString(String.valueOf(all_player[0].get_score()), 0, (this.height/2)-10);
        g.drawString(String.valueOf(all_player[1].get_score()), 0, (this.height/2)+55);
    }
    public void check_victory()
    {
        //esorina raha tiana hidona
        // if(this.x_circle<=0)
        // {
        //     if(this.turn==1)
        //     {
        //         this.path=3;
        //     }
        //     else if(this.turn==2)
        //     {
        //         this.path=6;
        //     }
        // }
        // if(this.x_circle+this.circle_diameter>=this.width)
        // {
        //     if(this.turn==1)
        //     {
        //         this.path=1;
        //     }
        //     else if(this.turn==2)
        //     {
        //         this.path=4;
        //     }
        // }
        int valeur1=this.y_circle-this.all_player[0].get_y();
        if(valeur1<0)
        valeur1=valeur1*(-1);
        int valeur2=this.y_circle-this.all_player[1].get_y();
        if(valeur2<0)
        valeur2=valeur2*(-1);
            if(this.x_circle<0||this.x_circle>this.width)
            {
                if(valeur2<valeur1)
                {
                    this.all_player[0].set_score(all_player[0].get_score()+1);
                    this.y_circle=this.player_height+this.gama;
                    this.x_circle=this.width/2-this.circle_diameter/2;
                    this.all_player[0].set_x((this.width-player_width)/2);
                    this.all_player[1].set_x((this.width-player_width)/2);
                    this.id=1;
                    this.path=0;
                    return;
                }
                else
                {
                    this.all_player[1].set_score(all_player[1].get_score()+1);
                    this.y_circle=this.height-player_height-this.gama;
                    this.x_circle=this.width/2-this.circle_diameter/2;
                    this.all_player[0].set_x((this.width-player_width)/2);
                    this.all_player[1].set_x((this.width-player_width)/2);
                    this.id=1;
                    this.path=0;
                    return;
                }
            }
            if(this.y_circle>=this.height)
            {
                this.all_player[0].set_score(all_player[0].get_score()+1);
                this.y_circle=this.player_height+this.gama;
                this.x_circle=this.width/2-this.circle_diameter/2;
                this.all_player[0].set_x((this.width-player_width)/2);
                this.all_player[1].set_x((this.width-player_width)/2);
                this.id=1;
                this.path=0;
                return;
            }
            if(this.y_circle<=0)
            {
                this.all_player[1].set_score(all_player[1].get_score()+1);
                this.y_circle=this.height-player_height-this.gama;
                this.x_circle=this.width/2-this.circle_diameter/2;
                this.all_player[0].set_x((this.width-player_width)/2);
                this.all_player[1].set_x((this.width-player_width)/2);
                this.id=1;
                this.path=0;
                return;
            }
    }
    public int check_player_ball()
    {
        if(this.x_circle<=all_player[1].x+player_width&&this.y_circle<=this.height&&this.y_circle>=this.height-player_height-this.circle_diameter-this.gama&&this.x_circle+this.circle_diameter>all_player[1].x)
        {
            this.turn=2;
            return 2;
        }
        if(this.x_circle<=all_player[0].x+player_width&&this.y_circle>=0&&this.y_circle<=player_height+this.gama&&this.x_circle+this.circle_diameter>all_player[0].x)
        {
            this.turn=1;
            return 1;
        }
        return 0;
    }
    public void move_ball()
    {
            if(this.path==1)
            {
                this.y_circle+=10;
                this.x_circle-=2;
            }
            if(this.path==2)
            {
                this.y_circle+=10;
            }
            if(this.path==3)
            {
                this.y_circle+=10;
                this.x_circle+=2;
            }
            if(this.path==4)
            {
                this.y_circle-=10;
                this.x_circle-=2;
            }
            if(this.path==5)
            {
                this.y_circle-=10;
            }
            if(this.path==6)
            {
                this.y_circle-=10;
                this.x_circle+=2;
            }
        if(check_player_ball()==1)
        {
            if(id==0)
            {
                this.path=2;
            }
            else
            this.y_circle=this.player_height+this.gama;
        }
        if(check_player_ball()==2)
        {
            if(id==0)
            {
                this.path=5;
            }
            else
            this.y_circle=this.height-this.player_height-this.circle_diameter-this.gama;
        }
    }
}