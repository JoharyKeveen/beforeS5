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
public class TypePapier extends ObjectBDD{
    private Integer id;
    private String designatioPapier;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignatioPapier() {
        return designatioPapier;
    }

    public void setDesignatioPapier(String designatioPapier) {
        this.designatioPapier = designatioPapier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void init(){
        this.setNomDeTable("typePapier");
        this.setPkey("id");
    }
    public TypePapier() {
    }
    
}
