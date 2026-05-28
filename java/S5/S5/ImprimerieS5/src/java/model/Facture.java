/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ObjectBDD;
import Util.Util;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author Tolotra
 */
public class Facture extends ObjectBDD{
    private Integer id;
    private Date dateFacture;
    private Double total;
    private Integer clientId;

    public void insert(Facture_detail[] list) throws Exception
    {
        Connection con=Util.getConnection();
        int idFacture=this.insertReturningId(con);
        for(int i=0;i<list.length;i++)
        {
            list[i].setFactureId(idFacture);
            list[i].insert(con);
        }
        con.close();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    public void init(){
        this.setNomDeTable("facture");
        this.setPkey("id");
    }
    public Facture(){
        this.init();
    }
}
