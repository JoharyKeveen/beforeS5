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
public class MargeDePrix extends ObjectBDD{
    private Integer id;
    private Double minimum;
    private Double maximum;
    private Double marge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Double getMarge() {
        return marge;
    }

    public void setMarge(Double marge) {
        this.marge = marge;
    }
    public void init(){
        this.setNomDeTable("margedeprix");
        this.setPkey("id");
    }
    public MargeDePrix(){
        this.init();
    }
}
