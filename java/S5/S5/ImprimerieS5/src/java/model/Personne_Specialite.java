/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ObjectBDD;

/**
 *
 * @author Tolotra
 */
public class Personne_Specialite extends ObjectBDD{
    private Integer personneId;
    private Integer specialieteId;

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getSpecialieteId() {
        return specialieteId;
    }

    public void setSpecialieteId(Integer specialieteId) {
        this.specialieteId = specialieteId;
    }
    public void init(){
        this.setNomDeTable("Personne_Specialite");
        this.setPkey("id");
    }
}
