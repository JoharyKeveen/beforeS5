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
public class TypeFormat extends ObjectBDD{
    private Integer id;
    private String designationFormat;
    private String dimension;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignationFormat() {
        return designationFormat;
    }

    public void setDesignationFormat(String designationFormat) {
        this.designationFormat = designationFormat;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    public void init(){
        this.setNomDeTable("typeFormat");
        this.setPkey("id");
    }

    public TypeFormat() {
        this.init();
    }
    
    
}
