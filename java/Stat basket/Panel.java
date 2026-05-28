package windows;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import connection.*;
import listener.*;
import object.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

public class Panel extends JPanel
{
    Frame frame;
    AListner al;
    JButton[] player1;
    JButton[] player2;
    JButton pause;
    JButton start;
    Timer timer;
    int elapsedtime=0;
    int heure=0;
    int minute=0;
    int seconde=0;
    JLabel timeLabel;
    public JLabel getTimeLabel() {
        return timeLabel;
    }
    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
    public int getElapsedtime() {
        return elapsedtime;
    }
    public void setElapsedtime(int elapsedtime) {
        this.elapsedtime = elapsedtime;
    }
    public int getHeure() {
        return heure;
    }
    public void setHeure(int heure) {
        this.heure = heure;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getSeconde() {
        return seconde;
    }
    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }
    public Timer getTimer() {
        return timer;
    }
    public void setTimer(Timer timer) {
        this.timer=timer;
    }
    public JButton getStart() {
        return start;
    }
    public void setStart(JButton start) {
        this.start = start;
    }
    public JButton getPause()
    {
        return this.pause;
    }
    public void setPause(JButton pause)
    {
        this.pause=pause;
    }
    public JButton[] getPlayer1()
    {
        return this.player1;
    }
    public JButton[] getPlayer2()
    {
        return this.player2;
    }
    public Panel(Frame frame)
    {
        this.frame=frame;
    }
    public JPanel statMatch(Matche matche) throws Exception
    {
        Connex co=new Connex();
        Connection lo=co.log();

        Vector<Team> teama=new Team().get_Tab(new Team("TEA01",matche.getTeama()).select("name",lo));
        Player playera=new Player();
        playera.setIdteam(teama.get(0).getIdteam());
        Vector<Player> playerA=new Player().get_Tab(playera.select("idteam",lo));

        Vector<Team> teamb=new Team().get_Tab(new Team("TEA02",matche.getTeamb()).select("name",lo));
        Player playerb=new Player();
        playerb.setIdteam(teamb.get(0).getIdteam());
        Vector<Player> playerB=new Player().get_Tab(playerb.select("idteam",lo));

        this.al=new AListner(frame,this,playerA,playerB,matche);
        this.timer=new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                elapsedtime+=1000;
                heure=elapsedtime/3600000;
                minute=(elapsedtime/60000)%60;
                seconde=(elapsedtime/1000)%60;
                timeLabel.setText(String.format("%02d", heure)+":"+String.format("%02d", minute)+":"+String.format("%02d", seconde));
            }
        });
        int x=10;
        int y=10;
        int width=100;
        int height=50;
        JPanel result=new JPanel();
        result.setLayout(null);
        timeLabel=new JLabel();
        timeLabel.setText(String.format("%02d", heure)+":"+String.format("%02d", minute)+":"+String.format("%02d", seconde));
        timeLabel.setBounds(width+width/4, y, width, height);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        y+=timeLabel.getHeight();
        result.add(timeLabel);
        this.start=new JButton("start");
        start.setBounds(width+width/5+width/5,y,width-width/3,height/2);
        start.setFocusable(false);
        start.addActionListener(al);
        result.add(start);
        y+=start.getHeight();
        this.pause=new JButton("||");
        pause.setBounds(width+width/2,y,width/2,height/2);
        pause.setFocusable(false);
        pause.addActionListener(al);
        result.add(pause);
        JLabel title1=new JLabel(matche.getTeama());
        title1.setBounds(width-width/3,y,width,height);
        result.add(title1);
        JLabel title2=new JLabel(matche.getTeamb());
        title2.setBounds(width*2+width/3,y,width,height);
        result.add(title2);
        y+=height;
        this.player1=new JButton[playerA.size()];
        this.player2=new JButton[playerB.size()];
        for(int i=0;i<player1.length;i++)
        {
            player1[i]=new JButton(playerA.get(i).getName());
            player1[i].setBounds(x,y,width+width/2,height);
            player1[i].setFocusable(false);
            player1[i].addActionListener(al);
            result.add(player1[i]);
            player2[i]=new JButton(playerB.get(i).getName());
            player2[i].setBounds(width*2-x,y,width+width/2,height);
            player2[i].setFocusable(false);
            player2[i].addActionListener(al);
            result.add(player2[i]);
            y+=height+5;
        }
        result.setPreferredSize(new Dimension(width*4-width/2,y));
        lo.close();
        frame.addKeyListener(new KListner(al));
        return result;
    }
}