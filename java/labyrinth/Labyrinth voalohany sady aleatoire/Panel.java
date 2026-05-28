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
    JPanel panel;
    JButton haut;
    JButton bas;
    JButton gauche;
    JButton droite;
    Player player1;
    Player player2;
    Random random;
    int measure;
    int wall;
    int x_exit, y_exit;
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

    public void start()
    {
        this.panel=new JPanel();
        this.haut=new JButton("haut");
        this.bas=new JButton("bas");
        this.gauche=new JButton("gauche");
        this.droite=new JButton("droite");

        haut.setFocusable(false);
        bas.setFocusable(false);
        gauche.setFocusable(false);
        droite.setFocusable(false);

        this.measure=30;
        this.wall=67;
        this.x_max=15;
        this.y_max=15;
        rand_exit();
    }

    public void init_Game()
    {
        cases = new int[x_max][y_max];
        for (int i = 0; i < wall; i++)
        {
            int x = this.random.nextInt(x_max);
            int y = this.random.nextInt(y_max);
            if(x!=this.x_exit&&x!=this.player1.get_x_player()&&x!=this.player2.get_x_player()&&y!=this.y_exit&&y!=this.player1.get_y_player()&&y!=this.player2.get_y_player())
            {
                cases[x][y] = 1;
            }
        }
    }

    public Panel()
    {
        this.random = new Random();
        start(); 
        Mouse mouse=new Mouse(this);
        this.player1=new Player(0,0);
        this.setPreferredSize(new Dimension(450, 500));
        this.setFocusable(true);
        this.addKeyListener(new Key(this)); 
        haut.addActionListener(mouse);
        bas.addActionListener(mouse);
        gauche.addActionListener(mouse);
        droite.addActionListener(mouse);
        this.player2=new Player((this.x_max-1)*this.measure,(this.y_max-1)*this.measure);
        init_Game();
        panel.add(haut);
        panel.add(bas);
        panel.add(gauche);
        panel.add(droite);
        this.panel.setBounds(0,460,450,150);
        this.add(panel);
        this.setLayout(null);
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
        if(this.x_exit==this.player1.get_x_player()&&this.y_exit==this.player1.get_y_player()||this.x_exit==this.player2.get_x_player()&&this.y_exit==this.player2.get_y_player())
        {
            for(int x=0;x<x_max;x++)
            {
                for(int y=0;y<y_max;y++)
                {
                    this.cases[x][y]=0;
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

    public void rand_exit()
    {
        this.x_exit=this.random.nextInt(x_max)*this.measure;
        this.y_exit=this.random.nextInt(y_max)*this.measure;
    }
}