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
public class Marge extends ObjectBDD{
    private Integer id;
    private Double valeur;
    private Integer activiteId;

    public Integer getActiviteId() {
        return activiteId;
    }

    public void setActiviteId(Integer activiteId) {
        this.activiteId = activiteId;
    }

   
    
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
        this.setNomDeTable("marge");
        this.setPkey("id");
    }
    public Marge(){
        this.init();
    }
    public Double Findvaleur(Integer idActivite) throws Exception{
        Marge marge = new Marge();
        marge.setActiviteId(idActivite);
        marge=(Marge)marge.find(null)[0];

        return marge.getValeur();
    }

    public Double getbenefice(Integer idActivite) throws Exception{
        Double totalrs = new V_employeActivite().getTotalRs(idActivite);
        Double totalrm = new V_materielActivite().getTotalRM(idActivite);
        System.out.println((totalrs+totalrm)*(this.Findvaleur(idActivite)/100));
        Double calcul= (totalrs+totalrm)*(this.Findvaleur(idActivite)/100);
        
        return calcul;
    }

    public Double getPrixdevente(Integer IdActivite) throws Exception{
        Double totalrs = new V_employeActivite().getTotalRs(IdActivite);
        Double totalrm = new V_materielActivite().getTotalRM(IdActivite);
        
        Double calcul=this.getbenefice(IdActivite)+(totalrs+totalrm);
        
        System.out.println(calcul);
        return calcul;
    }
}
