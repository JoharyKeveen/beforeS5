package bin;

import java.util.ArrayList;

public class Composant {
    String idComposant;
    String produit;
    String nom;
    double quantite;
    double prixUnitaire;

    int rang=1;

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    ArrayList<Composant> allComp = new ArrayList<>();

    public ArrayList<Composant> getAllComp() {
        return allComp;
    }

    public void setAllComp(ArrayList<Composant> allComp) {
        this.allComp = allComp;
    }

    boolean premier;

    public String getIdComposant() {
        return idComposant;
    }

    public void setIdComposant(String idComposant) {
        this.idComposant = idComposant;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
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

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public boolean isPremier() {
        return premier;
    }

    public void setPremier(boolean premier) {
        this.premier = premier;
    }

    public Composant(String idC, String produit, double quantite, String nom, double prixunitaire){
        setIdComposant(idC);
        setProduit(produit);
        setQuantite(quantite);
        setNom(nom);
        setPrixUnitaire(prixunitaire);
    }

    public void addToList(ArrayList<Composant> allComp){
        for(int i=0;i<allComp.size();i++){
            if(getProduit().equalsIgnoreCase(allComp.get(i).getIdComposant())){
                getAllComp().add(allComp.get(i));
            }
        }
    }

    public void setPrice(){
        if(!isPremier()){
            for(int i=0; i<getAllComp().size();i++){
                setPrixUnitaire(getPrixUnitaire()+getAllComp().get(i).getPrixUnitaire()*quantite);
            }
        }
    }

    public int isRang(){
        int n=0;
        for(int i = 0; i < getAllComp().size(); i++){
            if(getAllComp().get(i).getRang()==0){
                n++;
            }
        }
        return n;
    }

}
