package windows;
import listener.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel extends JPanel
{
    int nb_player;
    Player[] all_player;
    Player player;
    JPanel table_jeux;
    JPanel panel;
    JButton haut;
    JButton bas;
    JButton gauche;
    JButton droite;
    JButton blanc_1;
    JButton blanc_2;
    JButton blanc_3;
    JButton blanc_4;
    JButton automatique;
    Random random;
    int measure;
    int wall;
    int x_exit, y_exit;
    public int get_x_exit()
    {
        return this.x_exit;
    }
    public int get_y_exit()
    {
        return this.y_exit;
    }
    public void set_x_exit(int x)
    {
        this.x_exit=x;
    }
    public void set_y_exit(int y)
    {
        this.y_exit=y;
    }
    int x_max, y_max;
    int[][] cases;
    public JButton get_haut()
    {
        return this.haut;
    }
    public JButton get_droite()
    {
        return this.droite;
    }
    public JButton get_gauche()
    {
        return this.gauche;
    }
    public JButton get_bas()
    {
        return this.bas;
    }
    public Player get_player()
    {
        return this.player;
    }
    public Player get_tab_player(int indice)
    {
        return this.all_player[indice];
    }
    public int get_nb_player()
    {
        return this.nb_player;
    }
    public void set_player(Player p)
    {
        this.player=p;
    }
    public int get_measure()
    {
        return this.measure;
    }
    public int get_x_max()
    {
        return this.x_max;
    }
    public int get_y_max()
    {
        return this.y_max;
    }
    public int get_cases(int x,int y)
    {
        if(x>=0&&y>=0&&x<this.x_max&&y<this.y_max)
        {
            return this.cases[x][y];
        }
        return 1;
    }
    public void set_cases(int x,int y,int valeur)
    {
        this.cases[x][y]=valeur;
    }
    public void liberer_chemin()
    {
        for(int x=0;x<x_max;x++)
        {
            for(int y=0;y<y_max;y++)
            {
                if(this.cases[x][y]==3)
                {
                    this.cases[x][y]=0;
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void start()
    {
        this.nb_player=3;
        this.all_player=new Player[nb_player];
        this.table_jeux=new JPanel();
        this.panel=new JPanel();
        this.blanc_2=new JButton("blanc_2");
        this.haut=new JButton("^");
        this.bas=new JButton("v");
        this.gauche=new JButton("<");
        this.droite=new JButton(">");
        this.blanc_4=new JButton();
        this.blanc_1=new JButton();
        this.blanc_3=new JButton();
        this.automatique=new JButton("A");
        // blanc.setVisible(false);

        blanc_3.setVisible(false);
        blanc_1.setVisible(false);
        blanc_4.setVisible(false);
        blanc_2.setVisible(false);
        haut.setFocusable(false);
        bas.setFocusable(false);
        gauche.setFocusable(false);
        droite.setFocusable(false);
        automatique.setFocusable(false);

        this.measure=30;
        this.x_max=5;
        this.y_max=5;
        put_exit(3,2);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // public void placer_mur(int x,int y)
    // {
    //     this.cases[x][y]=1;
    // }

    public void init_Game()
    {
        cases = new int[x_max][y_max];
    }

    public Panel()
    {
        this.random = new Random();
        start(); 
        Bouton bouton=new Bouton(this);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.all_player[0]=new Player(3*this.measure,0,"Player 1");
        this.all_player[1]=new Player(0,4*this.measure,"Player 2");
        this.all_player[2]=new Player(2*this.measure,2*this.measure,"Player 3");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.setPreferredSize(new Dimension((x_max*this.measure)+(x_max*this.measure)/2, y_max*this.measure));
        this.setFocusable(true);
        this.addKeyListener(new Key(this)); 
        haut.addActionListener(bouton);
        bas.addActionListener(bouton);
        gauche.addActionListener(bouton);
        droite.addActionListener(bouton);
        automatique.addActionListener(bouton);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // this.player2=new Player(0,4*this.measure);
        this.get_closest_player();
        this.addMouseListener(new Mouse(this));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        init_Game();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // placer_mur(0,0);
        // placer_mur(1,0);
        // placer_mur(1,1);
        // placer_mur(2,3);
        // placer_mur(3,4);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panel.setLayout(new GridLayout(3,3,2,2));
        panel.add(blanc_2);
        panel.add(haut);
        panel.add(blanc_1);
        panel.add(gauche);
        panel.add(automatique);
        panel.add(droite);
        panel.add(blanc_4);
        panel.add(bas);
        panel.add(blanc_3);
        this.panel.setBounds(x_max*this.measure,0,(x_max*this.measure)/2,(y_max*this.measure)/2);
        this.add(panel);
        this.setLayout(null);
    }
    public void put_exit(int x,int y)
    {
        this.x_exit=/*this.random.nextInt(x_max)*/x*this.measure;
        this.y_exit=/*this.random.nextInt(y_max)*/y*this.measure;
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        drawGrid(g);
        draw_player(g);
        draw_exit(g);
    }

    public void check_victory()
    {
        for(int i=0;i<nb_player;i++)
        {
            if(this.x_exit==this.all_player[i].get_x_player()&&this.y_exit==this.all_player[i].get_y_player())
            {
                for(int x=0;x<x_max;x++)
                {
                    for(int y=0;y<y_max;y++)
                    {
                        this.cases[x][y]=i*i+4;
                    }
                }
            }
        }
    }

    public void get_closest_player()
    {
        this.player=all_player[0];
        double result=Math.sqrt(Math.pow((this.all_player[0].get_x_player()-this.x_exit),2)+Math.pow((this.all_player[0].get_y_player()-this.y_exit),2));
        for(int i=1;i<this.nb_player;i++)
        {
            if(Math.sqrt(Math.pow((this.all_player[i].get_x_player()-this.x_exit),2)+Math.pow((this.all_player[i].get_y_player()-this.y_exit),2))<result)
            {
                result=Math.sqrt(Math.pow((this.all_player[i].get_x_player()-this.x_exit),2)+Math.pow((this.all_player[i].get_y_player()-this.y_exit),2));
                this.player=all_player[i];
            }
        }
    }

    public void drawGrid(Graphics g)
    {
        for (int x = 0; x < x_max; x++)
        {
            for (int y = 0; y < y_max; y++)
            {
                Color color;
                if(this.cases[x][y]==1)
                {
                    color = Color.orange;
                }
                else if(this.cases[x][y]==4)
                {
                    color = Color.cyan;
                }
                else if(this.cases[x][y]==5)
                {
                    color = Color.red;
                }
                else if(this.cases[x][y]==8)
                {
                    color = Color.gray;
                }
                else
                {
                    color = Color.black;
                }
                g.setColor(color);
                g.fillRect(x * this.measure, y * this.measure, this.measure, this.measure);
                g.setColor(Color.GRAY);
                g.drawRect(x * this.measure, y * this.measure, this.measure, this.measure);
            }
        }
    }

    public void draw_player(Graphics g)
    {
        g.setColor(Color.cyan);
        g.fillRect(this.all_player[0].get_x_player(), this.all_player[0].get_y_player(), this.measure, this.measure);
        g.setColor(Color.red);
        g.fillRect(this.all_player[1].get_x_player(), this.all_player[1].get_y_player(), this.measure, this.measure);
        g.setColor(Color.gray);
        g.fillRect(this.all_player[2].get_x_player(), this.all_player[2].get_y_player(), this.measure, this.measure);
    }


    public void draw_exit(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x_exit,y_exit,this.measure,this.measure);
    }

}