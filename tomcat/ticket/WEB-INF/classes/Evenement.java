package table;
import connection.BddClass;

import java.util.Vector;
import java.sql.Date;

public class Evenement extends BddClass{
    int id;
    String nom;
    Long validation;
    Date daty;
    public Evenement(int id, String nom, Long validation) {
        this.id = id;
        this.nom = nom;
        this.validation = validation;
    }
    public Evenement() {
    }
    public Evenement(int id)
    {
        this.id=id;
    }
    public Evenement(int id, String nom, Long validation, Date daty) {
        this.id = id;
        this.nom = nom;
        this.validation = validation;
        this.daty = daty;
    }
    public Date getDaty() {
        return daty;
    }
    public void setDaty(Date daty) {
        this.daty = daty;
    }
    public Long getValidation() {
        return validation;
    }
    public void setValidation(Long validation) {
        this.validation = validation;
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
    public Vector<Evenement> get_Tab(Vector<Object> o)
    {
        Vector<Evenement> result=new Vector<Evenement>();
        for(int i=0;i<o.size();i++)
        {
            result.add((Evenement)o.get(i));
        }
        return result;
    }
}
