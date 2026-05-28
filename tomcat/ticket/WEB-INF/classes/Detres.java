package table;
import connection.BddClass;
import java.sql.*;
import java.util.Vector;

public class Detres extends BddClass {
    int idReservation;
    int idSeza;
    public Detres() {
    }
    public Detres(int idReservation) {
        this.idReservation = idReservation;
    }
    public Detres(int idReservation, int idSeza) {
        this.idReservation = idReservation;
        this.idSeza = idSeza;
    }
    public int getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
    public int getIdSeza() {
        return idSeza;
    }
    public void setIdSeza(int idSeza) {
        this.idSeza = idSeza;
    }
    public Vector<Detres> get_Tab(Vector<Object> o)
    {
        Vector<Detres> result=new Vector<Detres>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Detres)o.get(i));
        }
        return result;
    }
}
