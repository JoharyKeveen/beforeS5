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
    JPanel table_jeux;
    JPanel panel;
    JButton haut;
    JButton bas;
    JButton gauche;
    JButton droite;
    JButton haut_droite;
    JButton haut_gauche;
    JButton bas_droite;
    JButton bas_gauche;
    JButton blanc;
    Player player1;
    Player player2;
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
    public JButton get_haut_droite()
    {
        return this.haut_droite;
    }
    public JButton get_haut_gauche()
    {
        return this.haut_gauche;
    }
    public JButton get_bas_droite()
    {
        return this.bas_droite;
    }
    public JButton get_bas_gauche()
    {
        return this.bas_gauche;
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
    public Player get_player1()
    {
        return this.player1;
    }
    public Player get_player2()
    {
        return this.player2;
    }
    public int get_measure()
    {
        return this.measure;
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
        this.table_jeux=new JPanel();
        this.panel=new JPanel();
        this.haut_gauche=new JButton("haut_gauche");
        this.haut=new JButton("^");
        this.bas=new JButton("v");
        this.gauche=new JButton("<");
        this.droite=new JButton(">");
        this.bas_gauche=new JButton("bas_gauche");
        this.haut_droite=new JButton("haut_droite");
        this.bas_droite=new JButton("bas_droite");
        this.blanc=new JButton();
        blanc.setVisible(false);

        bas_droite.setFocusable(false);
        haut_droite.setFocusable(false);
        bas_gauche.setFocusable(false);
        haut_gauche.setFocusable(false);
        haut.setFocusable(false);
        bas.setFocusable(false);
        gauche.setFocusable(false);
        droite.setFocusable(false);

        this.measure=30;
        this.x_max=5;
        this.y_max=5;
        put_exit(3,2);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void placer_mur(int x,int y)
    {
        this.cases[x][y]=1;
    }

    public void init_Game()
    {
        cases = new int[x_max][y_max];
    }

    public Panel()
    {
        this.random = new Random();
        start(); 
        Mouse mouse=new Mouse(this);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.player1=new Player(3*this.measure,0);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.setPreferredSize(new Dimension(x_max*30*2, y_max*30));
        this.setFocusable(true);
        this.addKeyListener(new Key(this)); 
        haut.addActionListener(mouse);
        bas.addActionListener(mouse);
        gauche.addActionListener(mouse);
        droite.addActionListener(mouse);
        haut_droite.addActionListener(mouse);
        haut_gauche.addActionListener(mouse);
        bas_gauche.addActionListener(mouse);
        bas_droite.addActionListener(mouse);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.player2=new Player(0,4*this.measure);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        init_Game();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        placer_mur(0,0);
        placer_mur(1,0);
        placer_mur(1,1);
        placer_mur(2,3);
        placer_mur(3,4);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panel.setLayout(new GridLayout(3,3,2,2));
        panel.add(haut_gauche);
        panel.add(haut);
        panel.add(haut_droite);
        panel.add(gauche);
        panel.add(blanc);
        panel.add(droite);
        panel.add(bas_gauche);
        panel.add(bas);
        panel.add(bas_droite);
        this.panel.setBounds(x_max*30,0,(x_max*30)/2,(y_max*30)/2);
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
        draw_player1(g);
        draw_player2(g);
        draw_exit(g);
    }

    public void check_victory()
    {
        if(this.x_exit==this.player1.get_x_player()&&this.y_exit==this.player1.get_y_player())
        {
            for(int x=0;x<x_max;x++)
            {
                for(int y=0;y<y_max;y++)
                {
                    this.cases[x][y]=11;
                }
            }
        }
        else if(this.x_exit==this.player2.get_x_player()&&this.y_exit==this.player2.get_y_player())
        {
            for(int x=0;x<x_max;x++)
            {
                for(int y=0;y<y_max;y++)
                {
                    this.cases[x][y]=22;
                }
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
                else if(this.cases[x][y]==11)
                {
                    color = Color.cyan;
                }
                else if(this.cases[x][y]==22)
                {
                    color = Color.red;
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

    public void draw_player1(Graphics g)
    {
        g.setColor(Color.cyan);
        g.fillRect(this.player1.get_x_player(), this.player1.get_y_player(), this.measure, this.measure);
    }
    public void draw_player2(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(this.player2.get_x_player(), this.player2.get_y_player(), this.measure, this.measure);
    }


    public void draw_exit(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x_exit,y_exit,this.measure,this.measure);
    }

}