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
public class Stock extends BddClass {
    String idProduit;
    int quantite;

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Stock() {
    }

    public Stock(String idProduit) {
        this.idProduit = idProduit;
    }

    public Stock(String idProduit, int quantite) {
        this.idProduit = idProduit;
        this.quantite = quantite;
    }
    
    public Vector<Stock> get_Tab(Vector<Object> o)
    {
	Vector<Stock> result=new Vector<Stock>();
	for(int i=0;i<o.size();i++)
	{
            result.add((Stock)o.get(i));
	}
            return result;
    }
}
