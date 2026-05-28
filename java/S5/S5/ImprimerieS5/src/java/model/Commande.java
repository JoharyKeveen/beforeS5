/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.ObjectBDD;
import java.sql.Date;

/**
 *
 * @author Achyl
 */
public class Commande extends ObjectBDD{
    Integer id;
    Integer devisid;
    Date dateCommande;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

   

    public Integer getDevisid() {
        return devisid;
    }

    public void setDevisid(Integer devisid) {
        this.devisid = devisid;
    }
    
    public void init(){
        this.setNomDeTable("Commande");
        this.setAutoIncrement(true);
        this.setPkey("id");
    }
    public Commande() {
        this.init();
    }

    
}
