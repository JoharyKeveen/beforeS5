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
public class Paiement_facture extends ObjectBDD{
    private Integer id;
    private Double valeur;

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
    public void init(){
        this.setNomDeTable("paiement_facture");
        this.setPkey("id");
    }
    public Paiement_facture(){
        this.init();
    }
}
