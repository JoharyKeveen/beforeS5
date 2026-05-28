package humain;
public class Etudient
{
    String numero;
    boolean estScientifique;
    String province;
    String remarque;

    public String get_numero()
    {
        return this.numero;
    }
    public boolean get_estScientifique()
    {
        return this.estScientifique;
    }
    public String get_province()
    {
        return this.province;
    }
    public String get_remarque()
    {
        return this.remarque;
    }

    public void set_numero(String n)
    {
        this.numero=n;
    }
    public void set_estScientifique(boolean e)
    {
        this.estScientifique=e;
    }
    public void set_province(String p)
    {
        this.province=p;
    }
    public void set_remarque(String r)
    {
        this.remarque=r;
    }
}