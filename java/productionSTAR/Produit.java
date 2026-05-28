/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import connection.BddClass;
import java.util.Vector;

/**
 *
 * @author Achyl
 */
public class Produit extends BddClass {
    String id;
    String nom;
    Double prix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Produit() {
    }

    public Produit(String id, String nom, Double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }
    
    public Vector<Produit> get_Tab(Vector<Object> o)
    {
	Vector<Produit> result=new Vector<Produit>();
	for(int i=0;i<o.size();i++)
	{
            result.add((Produit)o.get(i));
	}
            return result;
    }
}
