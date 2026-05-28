package object;
public class Human
{
    String nom;
    String prenom;
    double age;
    String date;
    boolean olona;

    public Human()
    {}

    public Human(String nom,String prenom,double age,String date)
    {
        this.nom=nom;
        this.age=age;
        this.prenom=prenom;
        this.date=date;
    }
    
    public String get_date()
    {
        return this.date;
    }
    public String get_nom()
    {
        return this.nom;
    }
    public double get_age()
    {
        return this.age;
    }
    public String get_prenom()
    {
        return this.prenom;
    }
}