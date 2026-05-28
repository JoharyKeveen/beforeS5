package table;
import connection.BddClass;
import java.util.Vector;

public class Client extends BddClass
{
    int id;
    String nom;
    public Client() {
    }
    public Client(int id, String nom) {
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
    public Vector<Client> get_Tab(Vector<Object> o)
    {
        Vector<Client> result=new Vector<Client>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Client)o.get(i));
        }
        return result;
    }
}