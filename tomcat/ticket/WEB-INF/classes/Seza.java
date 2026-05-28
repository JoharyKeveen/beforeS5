package table;
import connection.BddClass;
import java.util.Vector;

public class Seza extends BddClass{
    int id;
    int idZone;
    int idEvent;
    int num;
    String etat;
    public Seza() {
    }
    public Seza(int id) {
        this.id = id;
    }
    public Seza(int idEvent, int num) {
        this.idEvent = idEvent;
        this.num = num;
    }
    public Seza(int idZone,String etat)
    {
        this.idZone=idZone;
        this.etat = etat;
    }
    public Seza(int id, int idZone, int num,String etat) {
        this.id = id;
        this.idZone = idZone;
        this.num=num;
        this.etat = etat;
    }
    public Seza(int id, int idZone, int idEvent, int num, String etat) {
        this.id = id;
        this.idZone = idZone;
        this.idEvent = idEvent;
        this.num = num;
        this.etat = etat;
    }
    public int getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
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
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void verif() throws Exception
    {
        if(!this.getEtat().equalsIgnoreCase("vert"))
        {
            throw new Exception("Verifier dans la liste que la place est bien libre");
        }
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
