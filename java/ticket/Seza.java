package table;
import connection.BddClass;
import java.util.Vector;

public class Seza extends BddClass{
    int id;
    int idZone;
    String etat;
    public Seza() {
    }
    public Seza(int id, int idZone, String etat) {
        this.id = id;
        this.idZone = idZone;
        this.etat = etat;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdZone() {
        return idZone;
    }
    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Vector<Seza> get_Tab(Vector<Object> o)
    {
        Vector<Seza> result=new Vector<Seza>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Seza)o.get(i));
        }
        return result;
    }
}
