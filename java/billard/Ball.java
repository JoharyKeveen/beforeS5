package graph;
import java.awt.*;

public class Ball
{
    float posX;
    float posY;
    float diameter;
    float vitesseX;
    float vitesseY;

    public float get_vitesseX()
    {
        return this.vitesseX;
    }
    public void set_vitesseX(float v)
    {
        this.vitesseX=v;
    }
    public float get_vitesseY()
    {
        return this.vitesseY;
    }
    public void set_vitesseY(float v)
    {
        this.vitesseY=v;
    }
    public float get_posX()
    {
        return this.posX;
    }
    public void set_posX(float n)
    {
        this.posX=n;
    }
    public float get_posY()
    {
        return this.posY;
    }
    public void set_posY(float n)
    {
        this.posY=n;
    }
    public float get_diameter()
    {
        return this.diameter;
    }
    public void set_diameter(float n)
    {
        this.diameter=n;
    }

    public Ball(float x,float y,float n)
    {
        set_posX(x);
        set_posY(y);
        set_diameter(n);
    }
}