/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ObjectBDD;
import Util.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tolotra
 */
public class V_materielActivite extends ObjectBDD{
    private Integer id;
    private Double duree;
    private Integer activiteId;
    private Integer materielId;
    private String nomMateriel;
    private Double prix;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public Integer getActiviteId() {
        return activiteId;
    }

    public void setActiviteId(Integer activiteId) {
        this.activiteId = activiteId;
    }

    public Integer getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Integer materielId) {
        this.materielId = materielId;
    }

    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public void init(){
        this.setNomDeTable("v_materielActivite");
        this.setPkey("id");
    }
     public double getTotalRM(int id)throws Exception
    {
        Connection con=Util.getConnection();
        String request="select sum(duree*prix) from v_materielActivite where activiteId="+Integer.toString(id);
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(request);
        double result=0;
        while(rs.next())
        {
            result=rs.getDouble(1);
        }
        stmt.close();
        con.close();
        return result;
    }

    public V_materielActivite() {
        this.init();
    }
     
}
