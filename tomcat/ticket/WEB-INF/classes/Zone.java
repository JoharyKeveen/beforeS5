package table;
import connection.BddClass;
import java.util.Vector;

public class Zone extends BddClass{
    int id;
    int idEvent;
    String nom;
    float prix;
    public Zone(int id, int idEvent, String nom, float prix) {
        this.id = id;
        this.idEvent = idEvent;
        this.nom = nom;
        this.prix = prix;
    }
    public Zone() {
    }
    public Zone(int idEvent)
    {
        this.idEvent=idEvent;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Vector<Zone> get_Tab(Vector<Object> o)
    {
        Vector<Zone> result=new Vector<Zone>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Zone)o.get(i));
        }
        return result;
    }
}
