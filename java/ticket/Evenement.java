package table;
import connection.BddClass;
import java.util.Vector;

public class Evenement extends BddClass{
    int id;
    String nom;
    public Evenement() {
    }
    public Evenement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Vector<Evenement> get_Tab(Vector<Object> o)
    {
        Vector<Evenement> result=new Vector<Evenement>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Evenement)o.get(i));
        }
        return result;
    }
}
