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
public class PrixPapier extends ObjectBDD{
    private Integer id;
    private Double valeur;
    private Date datePrix;
    private Integer typePapierId;

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

    public Date getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }

    public Integer getTypePapierId() {
        return typePapierId;
    }

    public void setTypePapierId(Integer typePapierId) {
        this.typePapierId = typePapierId;
    }
    public void init(){
        this.setNomDeTable("PrixPapier");
        this.setPkey("id");
    }
}
