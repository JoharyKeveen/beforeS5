/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.ObjectBDD;
import java.sql.Date;

/**
 *
 * @author ITU
 */
public class Employe extends ObjectBDD{
    private Integer id;
    private Date dateEmbauche;
    private String matricule;
    private Integer personneId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }
    public void init(){
        this.setNomDeTable("Employe");
        this.setPkey("id");
    }
    public Employe(){
        this.init();
    }
}
