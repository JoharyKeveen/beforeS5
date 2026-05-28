/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import java.sql.Connection;
import connection.Connex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import table.Stock;
import table.StockProd;
import windows.Client;
import windows.Serveur;
import windows.TableStock;

/**
 *
 * @author Achyl
 */
public class Alistener implements ActionListener {
    Serveur serveur;
    Client client;

    public Alistener(Client client) {
        this.client = client;
    }

    public Alistener(Serveur serveur) {
        this.serveur = serveur;
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            Connex co=new Connex();
            Connection lo=co.log();
            if(this.serveur!=null)
            {
                if(e.getSource()==serveur.getButtFabriquation())
                {
                    Vector<Stock> s=new Stock().get_Tab(new Stock(serveur.getArea2().getText()).select("idProduit",lo));
                    int total=s.get(0).getQuantite()+Integer.valueOf(serveur.getArea3().getText());
                    Stock update=new Stock(s.get(0).getIdProduit(),total);
                    update.update("idProduit","quantite",lo);
                    serveur.getArea2().setText("");
                    serveur.getArea3().setText("");   
                }
                else if(e.getSource()==serveur.getButtStock())
                {
                    Vector<StockProd> listProd=new StockProd().get_Tab(new StockProd().select(lo));
                    String[][] list=new String[listProd.size()][5];
                    Double totalStock=0.0;
                    int quantTotal=0;
                    for(int i=0;i<list.length;i++)
                    {
                        list[i][0]=listProd.get(i).getIdProduit();
                        list[i][1]=listProd.get(i).getNom();
                        list[i][2]=Integer.toString(listProd.get(i).getQuantite());
                        list[i][3]=Double.toString(listProd.get(i).getPrixUnitaire());
                        list[i][4]=Double.toString(listProd.get(i).getPrixTotal());
                        totalStock+=listProd.get(i).getPrixTotal();
                        quantTotal+=listProd.get(i).getQuantite();
                    }
                    double cump=totalStock/quantTotal;
                    new TableStock(list,totalStock.toString(),Double.toString(Math.round(cump*100.0)/100.0)).setVisible(true);
                }
            }
            else if(e.getSource()==client.getButtAcheter())
            {
                Vector<Stock> s=new Stock().get_Tab(new Stock(client.getArea2().getText()).select("idProduit",lo));
                int total=s.get(0).getQuantite()-Integer.valueOf(client.getArea3().getText());
                Stock update=new Stock(s.get(0).getIdProduit(),total);
                update.update("idProduit","quantite",lo);
                client.getArea2().setText("");
                client.getArea3().setText("");   
            }
            lo.close();
        }
        catch(Exception exc)
        {
            System.out.println(exc.getMessage());
        }
    }
}
