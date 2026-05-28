package object;
public class Dog
{
    String race;
    String name;
    double age;
    String genre;
    boolean nationality;
    boolean vaccine;

    public Dog()
    {}
    public Dog(String race,String name, double age,String genre)
    {
        this.race=race;
        this.name=name;
        this.age=age;
        this.genre=genre;
    }
    public String get_race()
    {
        return this.race;
    }
    public String get_name()
    {
        return this.name;
    }
    public double get_age()
    {
        return this.age;
    }
    public String get_genre()
    {
        return this.genre;
    }
}