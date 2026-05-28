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
public class V_prixMateriel extends ObjectBDD{;
    private Integer id;
    private Double prix;
    private String nomMateriel;
    private Double minimum;
    private Float maximum;
    private Float marge;
    private Double prixConseille;
    private Double benefice;

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getPrixConseille() {
        if(this.prix >= 1 && this.prix < 1000){
            this.prixConseille = this.prix + (this.prix * (50.0/100.0));
        }
        else if(this.prix >= 1000 && this.prix < 10000){
            this.prixConseille = this.prix + (this.prix * (10.0/100.0));
        }
        else{
            this.prixConseille = this.prix + (this.prix * (5.0/100.0));
        }
        return prixConseille;
    }

    public void setPrixConseille(Double prixConseille) {
        this.prixConseille = prixConseille;
    }

    public Double getBenefice() {
        if(this.prix >= 1 && this.prix < 1000){
            this.benefice =  (this.prix * (50.0/100.0));
        }
        else if(this.prix >= 1000 && this.prix < 10000){
            this.benefice =  (this.prix * (10.0/100.0));
        }
        else{
            this.benefice =  (this.prix * (5.0/100.0));
        }
        return benefice;
    }

    public void setBenefice(Double benefice) {
        this.benefice = benefice;
    }
    
   
    
    public void init(){
        this.setNomDeTable("v_prixMateriel");
        this.setPkey("id");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Float getMaximum() {
        return maximum;
    }

    public void setMaximum(Float maximum) {
        this.maximum = maximum;
    }

    public Float getMarge() {
        return marge;
    }

    public void setMarge(Float marge) {
        this.marge = marge;
    }

    
    public V_prixMateriel(){
        this.init();
    }
}
