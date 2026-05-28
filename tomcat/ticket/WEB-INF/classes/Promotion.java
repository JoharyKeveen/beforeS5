package table;
import connection.BddClass;

import java.sql.Date;
import java.sql.*;
import java.util.Vector;

public class Promotion extends BddClass{
    int id;
    int idEvent;
    Date debut;
    Date fin;
    float valeur;
    public Promotion() {
    }
    public Promotion(int idEvent) {
        this.idEvent = idEvent;
    }
    public Promotion(int id, int idEvent, Date debut, Date fin) {
        this.id = id;
        this.idEvent = idEvent;
        this.debut = debut;
        this.fin = fin;
    }
    public Promotion(int id, int idEvent, Date debut, Date fin, float valeur) {
        this.id = id;
        this.idEvent = idEvent;
        this.debut = debut;
        this.fin = fin;
        this.valeur = valeur;
    }
    public float getValeur() {
        return valeur;
    }
    public void setValeur(float valeur) {
        this.valeur = valeur;
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
    public Date getDebut() {
        return debut;
    }
    public void setDebut(Date debut) {
        this.debut = debut;
    }
    public Date getFin() {
        return fin;
    }
    public void setFin(Date fin) {
        this.fin = fin;
    }
    public Vector<Promotion> get_Tab(Vector<Object> o)
    {
        Vector<Promotion> result=new Vector<Promotion>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Promotion)o.get(i));
        }
        return result;
    }
    public Vector<Promotion> getPromo(Connection lo)throws Exception 
    {
        String request = "select * from promotion where idEvent="+this.idEvent+" and debut<=current_timestamp and fin>=current_timestamp";
        Statement statement = lo.createStatement();
        ResultSet res=statement.executeQuery(request);
        Vector<Promotion> result=new Vector<Promotion>();
        Promotion temp=null;
        while(res.next())
        {
            temp=new Promotion(res.getInt(1),res.getInt(2),res.getDate(3),res.getDate(4),res.getFloat(5));
            result.add(temp);
        }
        statement.close();
        return result;
    }
}
