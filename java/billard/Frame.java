package graph;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Frame extends JFrame
{

    public Frame()
    {
        this.add(new Panel());
        this.setTitle("billard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }
}