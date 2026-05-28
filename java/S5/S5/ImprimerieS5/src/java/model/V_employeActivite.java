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
public class V_employeActivite extends ObjectBDD{
    private Integer id;
    private Double duree;
    private Integer activiteId;
    private Integer specialiteId;
    private String nomActivite;
    private Double valeur;
    private String nomSpecialite;

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

    public Integer getSpecialiteId() {
        return specialiteId;
    }

    public void setSpecialiteId(Integer specialiteId) {
        this.specialiteId = specialiteId;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }
    public void init(){
        this.setNomDeTable("v_employeActivite");
        this.setPkey("id");
    }
    public V_employeActivite(){
        this.init();
    }
    public double getTotalRs(int id)throws Exception
    {
        Connection con=Util.getConnection();
        String request="select sum(duree*valeur) from v_employeActivite where activiteId="+Integer.toString(id);
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
}
