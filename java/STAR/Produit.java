package object;
import connection.*;
import java.sql.*;
import java.util.ArrayList;
public class Produit extends BddClass
{    
    String id;
    String nom;
    double quantite;
    // String prodFini;
    double prix;
    ArrayList<Produit> composant;

    public ArrayList<Produit> getComposant() {
        return composant;
    }
    public void setComposant(ArrayList<Produit> composant) {
        this.composant = composant;
    }

    // public void addComposant(int num,String id,String nom, double quantite,String prodFini,double prix){
    //     this.composant[num]=new Produit(id, nom, quantite, prodFini, prix);
    // }
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
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    // public String getProdFini() {
    //     return prodFini;
    // }
    // public void setProdFini(String prodFini) {
    //     this.prodFini = prodFini;
    // }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Produit(String id,String nom, double quantite/* ,String prodFini */,double prix)
    {
        setId(id);
        setNom(nom);
        setQuantite(quantite);
        // setProdFini(prodFini);
        setPrix(prix);
    }
    public Produit(String nom, double quantite/* ,String prodFini */,double prix) throws Exception
    {
        super.setPrefix("PRD");
		super.setSeqName("seqProd");
		setId(super.construirePK(get_sequence()));
        setNom(nom);
        setQuantite(quantite);
        // setProdFini(prodFini);
        setPrix(prix);
    }

    // public void find_composant(Produit[] produit)
    // {
    //     int size=0;
    //     for(int i=0;i<produit.length;i++)
    //     {
    //         if(produit[i].getProdFini()==this.getId())
    //         {
    //             size++;
    //         }
    //     }
    //     this.createComposant(size);
    //     int inc=0;
    //     for(int j=0;j<produit.length;j++)
    //     {
    //         if(produit[j].getProdFini()==this.getId())
    //         {
    //             this.addComposant(inc,produit[j].getId(),produit[j].getNom(),produit[j].getQuantite(),produit[j].getProdFini(),produit[j].getPrix());
    //             inc++;      
    //         }
    //     }
    // }

    // public double prixDeRevient(Produit prod,Produit[] comp,double result/* =0 */)
    // {
    //     prod.find_composant(comp);
    //     for(int i=0;i<prod.getComposant().length;i++)
    //     {
    //         prod.getComposant()[i].find_composant(comp);
    //         if(prod.getComposant()[i].getComposant().length!=0)
    //         {
    //             Produit tProduit=prod.getComposant()[i];
    //             this.prixDeRevient(tProduit,comp,result);
    //         }
    //         else
    //         {
    //             result+=prod.getPrix();
    //         }
    //     }
    //     return result;
    // }

    // public Produit[] selectAllProduit(Connection connection)
    // {
    //     Produit[] result=null;
    //     try
    //     {
    //         Statement st = connection.createStatement();
    //         ResultSet n=st.executeQuery("Select count(*) from produit");
    //         int i=0;
    //         n.next();
    //         int numb=n.getInt(1);
    //         result=new Produit[numb];
    //         ResultSet res = st.executeQuery("select * from produit");
    //         while(res.next())
    //         {
    //             result[i]=new Produit(res.getString(1), res.getString(2), res.getDouble(3), res.getString(4), res.getDouble(5));
    //             i++;
    //         }
    //         st.close();
    //         n.close();
    //         res.close();
    //     }
    //     catch(Exception e)
    //     {}
    //     return result;
    // }

    public ArrayList<Produit> decomposer()
    {
        ArrayList<Produit> result=new ArrayList<Produit>();
        if(this.getComposant()!=null)
        {
            for(Produit child : this.getComposant())
            {
                result.addAll(child.decomposer());
            }
        }
        else
        {
            result.add(this);
        }
        return result;
    }
}
