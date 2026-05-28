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
public class Client extends ObjectBDD{
    private Integer id;
    private String login;
    private String mdp;
    private String matriculeClient;
    private String nom;
    private String prenom;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMatriculeClient() {
        return matriculeClient;
    }

    public void setMatriculeClient(String matriculeClient) {
        this.matriculeClient = matriculeClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public void init(){
        this.setAutoIncrement(true);
        this.setNomDeTable("client");
        this.setPkey("id");
    }
    public Client() {
        this.init();
    }
    
    
}
