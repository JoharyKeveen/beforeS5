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
public class Devis extends ObjectBDD{
    private Integer id;
    private Double totalDevis;
    private Double grammage;
    private Integer isRectoVerso;
    private Integer isCouleur;
    private Double quantite;
    private Integer typeFormatId;
    private Integer typePapierId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalDevis() {
        return totalDevis;
    }

    public void setTotalDevis(Double totalDevis) {
        this.totalDevis = totalDevis;
    }

    public Double getGrammage() {
        return grammage;
    }

    public void setGrammage(Double grammage) {
        this.grammage = grammage;
    }

    public Integer getIsRectoVerso() {
        return isRectoVerso;
    }

    public void setIsRectoVerso(Integer isRectoVerso) {
        this.isRectoVerso = isRectoVerso;
    }

    public Integer getIsCouleur() {
        return isCouleur;
    }

    public void setIsCouleur(Integer isCouleur) {
        this.isCouleur = isCouleur;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Integer getTypeFormatId() {
        return typeFormatId;
    }

    public void setTypeFormatId(Integer typeFormatId) {
        this.typeFormatId = typeFormatId;
    }

    public Integer getTypePapierId() {
        return typePapierId;
    }

    public void setTypePapierId(Integer typePapierId) {
        this.typePapierId = typePapierId;
    }
    public void init(){
        this.setNomDeTable("Devis");
        this.setPkey("id");
    }
    public Devis(){
        this.init();
    }
    
}
