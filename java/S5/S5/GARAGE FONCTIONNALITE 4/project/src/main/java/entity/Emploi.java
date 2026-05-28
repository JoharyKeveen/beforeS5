/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Achyl
 */
public class Emploi {
    int id;
    String nom;
    double salairemensuel;
    Date debutdureesalaire;
    Date findureesalaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalairemensuel() {
        return salairemensuel;
    }

    public void setSalairemensuel(double salairemensuel) {
        this.salairemensuel = salairemensuel;
    }

    public Date getDebutdureesalaire() {
        return debutdureesalaire;
    }

    public void setDebutdureesalaire(Date debutdureesalaire) {
        this.debutdureesalaire = debutdureesalaire;
    }

    public Date getFindureesalaire() {
        return findureesalaire;
    }

    public void setFindureesalaire(Date findureesalaire) {
        this.findureesalaire = findureesalaire;
    }

    public Emploi() {
    }

    public Emploi(int id, String nom, double salairemensuel, Date debutdureesalaire, Date findureesalaire) {
        this.id = id;
        this.nom = nom;
        this.salairemensuel = salairemensuel;
        this.debutdureesalaire = debutdureesalaire;
        this.findureesalaire = findureesalaire;
    }
    
}
