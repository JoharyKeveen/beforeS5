package table;
import connection.*;
import java.sql.*;
import java.util.Vector;

public class Reservation extends BddClass {
    int id;
    int idClient;
    int idEvent;
    Date entre;
    public Reservation() {
    }
    public Reservation(int idClient) {
        this.idClient = idClient;
    }
    public Reservation(int id, int idClient) {
        this.id = id;
        this.idClient = idClient;
    }
    public Reservation(int idClient,int idEvent,int x)throws Exception {
        this.id=seq();
        this.idClient = idClient;
        this.idEvent=idEvent;
    }
    public Reservation(int idClient, Date entre)throws Exception {
        this.id=seq();
        this.idClient = idClient;
        this.entre = entre;
    }
    public void insertRes(Connection lo)throws Exception
    {
        Statement state=lo.createStatement();
        state.executeUpdate("insert into reservation values("+this.getId()+","+this.getIdClient()+","+this.getIdEvent()+",CURRENT_TIMESTAMP)");
        state.close();
    }
    public Reservation(int id, int idClient, int idEvent, Date entre) {
        this.id = id;
        this.idClient = idClient;
        this.idEvent = idEvent;
        this.entre = entre;
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
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public Date getEntre() {
        return entre;
    }
    public void setEntre(Date entre) {
        this.entre = entre;
    }
    public int seq()throws Exception
    {
        Connex co=new Connex();
        Connection lo=co.log();
        Statement stat=lo.createStatement();
        ResultSet res=stat.executeQuery("select SEQRESERVATION.nextval from dual");
        int result=0;
        while(res.next())
        {
            result=res.getInt(1);
        }
        stat.close();
        lo.close();
        return result;
    }
    public Vector<Reservation> get_Tab(Vector<Object> o)
    {
        Vector<Reservation> result=new Vector<Reservation>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Reservation)o.get(i));
        }
        return result;
    }
}
