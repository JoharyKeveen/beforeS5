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
public class Facture_detail extends ObjectBDD{
    private Integer id;
    private Integer quantite;
    private Double prixTotal;
    private Integer factureId;
    private Integer activiteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Integer getFactureId() {
        return factureId;
    }

    public void setFactureId(Integer factureId) {
        this.factureId = factureId;
    }

    public Integer getActiviteId() {
        return activiteId;
    }

    public void setActiviteId(Integer activiteId) {
        this.activiteId = activiteId;
    }
    public void init(){
        this.setNomDeTable("facture_detail");
        this.setPkey("id");
    }
    public Facture_detail(){
        this.init();
    }
}
