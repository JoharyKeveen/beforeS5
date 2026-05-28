package table;
import connection.BddClass;
import java.util.Vector;

public class SezaL extends BddClass{
    int id;
    int idEvent;
    int nombre;
    float prix;
    public SezaL(int id, int idEvent, int nombre) {
        this.id = id;
        this.idEvent = idEvent;
        this.nombre = nombre;
    }
    public SezaL() {
    }
    public SezaL(int idEvent) {
        this.idEvent=idEvent;
    }
    public SezaL(int id, int idEvent, int nombre, float prix) {
        this.id = id;
        this.idEvent = idEvent;
        this.nombre = nombre;
        this.prix = prix;
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
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public Vector<SezaL> get_Tab(Vector<Object> o)
    {
        Vector<SezaL> result=new Vector<SezaL>();
        for(int i=0;i<o.size();i++)
        {
            result.add((SezaL)o.get(i));
        }
        return result;
    }
}
