package table;
import connection.BddClass;

import java.util.Vector;

public class DiffTime extends BddClass {
    int id;
    Long diff;
    public DiffTime() {
    }
    public DiffTime(int id) {
        this.id = id;
    }
    public DiffTime(int id, Long diff) {
        this.id = id;
        this.diff = diff;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Long getDiff() {
        return diff;
    }
    public void setDiff(Long diff) {
        this.diff = diff;
    }
    public Vector<DiffTime> get_Tab(Vector<Object> o)
    {
        Vector<DiffTime> result=new Vector<DiffTime>();
        for(int i=0;i<o.size();i++)
        {
            result.add((DiffTime)o.get(i));
        }
        return result;
    }
}
