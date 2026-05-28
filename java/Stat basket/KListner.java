package listener;
import windows.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import connection.*;
import listener.AListner;

import java.sql.*;

public class KListner implements KeyListener
{
    AListner aListner;
    public KListner(AListner aListner)
    {
        this.aListner=aListner;
    }
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==84)
        {
            this.aListner.setPreAction(this.aListner.getAction());
            this.aListner.setAction("tir");
            this.aListner.setPoint(0);
        }
        else if(e.getKeyCode()==80)
        {
            this.aListner.setPreAction(this.aListner.getAction());
            this.aListner.setAction("passe");
        }
        else if(e.getKeyCode()==49)
        {
            this.aListner.setPoint(1);
            //  tir 1 pts
        }
        else if(e.getKeyCode()==50)
        {
            this.aListner.setPoint(2);
            //  tir 2 pts
        }
        else if(e.getKeyCode()==51)
        {
            this.aListner.setPoint(3);
            //  tir 3 pts
        }
    }
    public void keyReleased(KeyEvent e)
    {}
    public void keyTyped(KeyEvent e)
    {}
}
