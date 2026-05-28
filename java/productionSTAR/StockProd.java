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
public class StockProd extends BddClass {
    String idProduit;
    String nom;
    int quantite;
    double prixUnitaire;
    double prixTotal;
    
    public double cump()
    {
        double result=this.getPrixTotal()/this.getQuantite();
        return result;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public StockProd() {
    }

    public StockProd(String idProduit, String nom, int quantite, double prixUnitaire, double prixTotal) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
    }
    
    public Vector<StockProd> get_Tab(Vector<Object> o)
    {
	Vector<StockProd> result=new Vector<StockProd>();
	for(int i=0;i<o.size();i++)
	{
            result.add((StockProd)o.get(i));
	}
            return result;
    }
}
