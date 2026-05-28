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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tolotra
 */
public class Gasoil extends ObjectBDD{
    private String idGasoil;
    private Double depense;
    private Date dateDepense;
    private double moyenneGasoil;
    public String getIdGasoil() {
        return idGasoil;
    }

    public void setIdGasoil(String idGasoil) {
        this.idGasoil = idGasoil;
    }

    public Double getDepense() {
        return depense;
    }

    public void setDepense(Double depense) {
        this.depense = depense;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }
    public void setDepense(String depense) throws Exception{
        if(depense == null){
            throw new Exception("Null");
        }
        else{
            if(depense.equals("")){
                throw new Exception("Veuillez remplir la case depense");
            }
            else{
                try{
                    double dep = Double.parseDouble(depense);
                    if(dep < 0){
                        throw new Exception("La valeur doit être supérieur ou égal à 0");
                    }
                    else{
                        this.depense = dep;
                    }
                }
                catch(NumberFormatException e){
                    throw new Exception("Veuillez inserer un chiffre");
                }
            }
        }
    }
    public void setDateDepense(String date) throws Exception{
        if(date == null){
            throw new Exception("null");
        }
        else{
            if(date.equals("")){
                throw new Exception("Veuillez remplir la case date");
            }
            else{
                Date d = Date.valueOf(date);
                this.dateDepense = d;
            }
        }
    }
    public void init(){
        this.setNomDeTable("gasoil");
        this.setPkey("idgasoil");
        this.setAutoIncrement(false);
        this.setSequence("s_gasoil");
        this.setSynchronalizable(true);
    }
    public Gasoil(){
        super();
        this.init();
    }
    public Gasoil(String depense,String date) throws Exception{
        super();
        this.init();
        this.setDepense(depense);
        this.setDateDepense(date);
    }
    public Gasoil[] sortList(Connection con) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Gasoil[] gas = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         boolean conNull = Util.connectionNull(con);
            if(conNull){
                con = Util.getConnection(); 
            }
        try{
            stmt = con.prepareStatement("SELECT * FROM v_gasoil ORDER BY Datedepense ASC");
            rs = stmt.executeQuery();
            ArrayList<Gasoil> list = new ArrayList<>();
            while(rs.next()){
                Gasoil g = new Gasoil();
                g.setIdGasoil(rs.getString("idgasoil"));
                g.setDepense(rs.getDouble("depense"));
                g.setDateDepense(rs.getDate("datedepense"));
                list.add(g);
            }
            gas = new Gasoil[list.size()];
            gas =  list.toArray(gas);
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if(stmt != null){
                stmt.close();
            }
            if(rs != null){
                rs.close();
            }
            if(conNull){
                con.close();
                }
        }
        return gas;
    }

    public double getMoyenneGasoil() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(this.moyenneGasoil == 0.0){
            Gasoil[] lg = this.sortList(null);
            double somme = 0.0;
            for(int i = 0; i<lg.length -1 ; i++){
                int intervalle = Util.jourOuvrable(lg[i].getDateDepense(), lg[i+1].getDateDepense());
                System.out.println("somme"+somme);
                System.out.println("intervalle:"+intervalle);
                System.out.println("somme"+somme);
                System.out.println("calcul:"+lg[i].getDepense()+"/"+intervalle);
                somme += lg[i].getDepense()/intervalle;
            }
            moyenneGasoil = somme/(lg.length-1);
            System.out.println("moyenne gasoil:"+moyenneGasoil);
        }
        return moyenneGasoil;
    }
    
}
