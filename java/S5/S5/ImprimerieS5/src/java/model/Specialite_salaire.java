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
public class Specialite_salaire extends ObjectBDD{
    private Integer id;
    private Double valeur;
    private Integer speciliteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Integer getSpeciliteId() {
        return speciliteId;
    }

    public void setSpeciliteId(Integer speciliteId) {
        this.speciliteId = speciliteId;
    }
    public void init(){
        this.setNomDeTable("specialite_salaire");
        this.setPkey("id");
    }
    public Specialite_salaire(){
        this.init();
    }
            
}
