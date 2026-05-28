package graph;

public class Joueur
{
    String nom;
    public String get_nom()
    {
        return this.nom;
    }
    public void set_nom(String n)
    {
        this.nom=n;
    }
    int tir;
    public int get_tir()
    {
        return this.tir;
    }
    public void set_tir(int t)
    {
        this.tir=t;
    }
    int point;
    public int get_point()
    {
        return this.point;
    }
    public void set_point(int p)
    {
        this.point=p;
    }
    int id;
    public int get_id()
    {
        return this.id;
    }
    public void set_id(int p)
    {
        this.id=p;
    }
    public Joueur(String n,int i)
    {
        set_nom(n);
        set_id(i);
    }
}