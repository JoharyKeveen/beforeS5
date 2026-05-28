package print;
import players.*;
public class Main
{
    public static void main(String[] args)
    {
        Joueur j=new Joueur();
        j.goal();
        Joueur j1=new Messi();
        j1.goal();
        Joueur j2=new Ronaldo();
        j2.goal();
    }
}