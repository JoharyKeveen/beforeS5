package table;
import connection.BddClass;
import java.util.Vector;

public class SezaL extends BddClass{
    int id;
    int idEvent;
    int nombre;
    public SezaL() {
    }
    public SezaL(int id) {
        this.id=id;
    }
    public SezaL(int id, int idEvent, int nombre) {
        this.id = id;
        this.idEvent = idEvent;
        this.nombre = nombre;
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
    public static void main(String[] args) {
        Vector<SezaL> sezaLibre=new SezaL().get_Tab(new SezaL(1).select("id",lo));
    }
}
