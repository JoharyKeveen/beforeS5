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
public class EmployeActivite extends ObjectBDD{
    private Integer id;
    private Double duree;
    private Integer activiteId;
    private Integer specialiteId;

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
    public void init(){
        this.setNomDeTable("employeactivite");
        this.setPkey("id");
    }
    public EmployeActivite(){
        this.init();
    }
    
}
