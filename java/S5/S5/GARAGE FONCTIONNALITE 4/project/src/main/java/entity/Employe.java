package entity;

import java.util.Date;

public class Employe {
    int id;
    String nom;
    String prenom;
    int idgenre;
    Date date_naissance;
    int iddiplome;
    int idemploi;

    public Employe(){}

    public Employe(int id, String nom, String prenom, int idgenre, Date date_naissance, int iddiplome, int idemploi) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idgenre = idgenre;
        this.date_naissance = date_naissance;
        this.iddiplome = iddiplome;
        this.idemploi = idemploi;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getIddiplome() {
        return iddiplome;
    }

    public void setIddiplome(int iddiplome) {
        this.iddiplome = iddiplome;
    }

    public int getIdemploi() {
        return idemploi;
    }

    public void setIdemploi(int idemploi) {
        this.idemploi = idemploi;
    }
}
