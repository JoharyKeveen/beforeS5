/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ObjectBDD;
import java.sql.Date;

/**
 *
 * @author Tolotra
 */
public class Personne extends ObjectBDD{
    private Integer id;
    private String nom;
    private Date dateNaissance;
    private String prenom;
    private Integer genreId;
    private Integer niveauEtudeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getNiveauEtudeId() {
        return niveauEtudeId;
    }

    public void setNiveauEtudeId(Integer niveauEtudeId) {
        this.niveauEtudeId = niveauEtudeId;
    }
    public void init(){
        this.setNomDeTable("personne");
        this.setPkey("id");
    }
    public Personne(){
        this.init();
    }
    
}
