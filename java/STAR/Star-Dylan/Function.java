package bin;

import java.sql.*;
import java.util.ArrayList;

public class Function {
    ArrayList<Composant> allComp = new ArrayList<>();

    public ArrayList<Composant> getAllComp() {
        return allComp;
    }
    public void setAllComp(ArrayList<Composant> allComp) {
        this.allComp = allComp;
    }

    public Function(){

    }

    public void getAllComposant(Connection conn, String produit) throws Exception{
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * FROM AllC start with IDCOMPOSANT='"+produit+"' connect by prior PRODUIT=IDCOMPOSANT");
        while(rst.next()){
            getAllComp().add(new Composant(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4), rst.getDouble(5)));
        }
        stmt.close();
    }

    public void setSiblings(){
        for(int i=0; i<getAllComp().size(); i++){
            getAllComp().get(i).addToList(getAllComp());
            if(getAllComp().get(i).getAllComp().size()==0){
                getAllComp().get(i).setPremier(true);
                getAllComp().get(i).setRang(0);
            }
        }
    }

    public void setPrix(){
        for(int y=0; y<getAllComp().size(); y++){
            for(int i=0; i<getAllComp().size(); i++){
                if(getAllComp().get(i).isRang()==getAllComp().get(i).getAllComp().size() && getAllComp().get(i).getRang()==1){
                    getAllComp().get(i).setRang(0);
                    getAllComp().get(i).setPrice();
                }
            }
        }
    }
}