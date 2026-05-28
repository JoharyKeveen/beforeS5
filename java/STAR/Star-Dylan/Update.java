package data;

import java.sql.*;
import java.util.*;
import java.lang.reflect.*;

public abstract class Update{
    String prefix="NBA";
    int nbr=7;
    String sequenceName="idAcc";
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getNbr() {
        return nbr;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public String[] getQuerry(Object donnee) throws Exception{
        Field[] f = donnee.getClass().getDeclaredFields();
        String[] name = new String[f.length];
        String[] query=new String[2];
        query[0]="";
        query[1]="";
        Object[] data=new Object[f.length];
        for(int i = 0 ; i<f.length ; i++){
            name[i] = f[i].getName();
            query[0]=query[0]+name[i];
            data[i]=donnee.getClass().getMethod("get"+name[i]).invoke(donnee);
            if(String.valueOf(f[i].getType()).equals("class java.lang.String")){
                query[1]=query[1]+"'"+data[i]+"'";
            }
            else{
                query[1]=query[1]+data[i];
            }
            if(i!=f.length-1){
                query[0]=query[0]+",";
                query[1]=query[1]+",";
            }
        }
        return query;
    }

    public static void INSERTQUERY(Connection conn, String query) throws Exception{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    public void DELETE(Connection conn, String TableName, String row, String value) throws Exception{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM "+TableName+" WHERE "+row+"="+value+")");
        stmt.close();
    }

    public void INSERT(Connection conn, String TableName, Object obj) throws Exception{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO "+TableName+" ("+getQuerry(obj)[0]+") VALUES("+getQuerry(obj)[1]+")");
        stmt.close();
    }

    public String idMaker(Connection conn) throws Exception{
        String id=getPrefix();
        String number = String.valueOf(getSequence(conn, getSequenceName()));
        for(int i=0; i<getNbr()-(getPrefix().length()+number.length());i++){id=id+"0";}
        id=id+number;
        return id;
    }
    
    public int getSequence(Connection conn, String seq) throws Exception{
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT nextval('"+seq+"')");
        rst.next();
        int resuslt = rst.getInt(1);
        stmt.close();
        return resuslt;
    }

    public List<String> GETALL(Connection conn, String TableName) throws Exception{
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * FROM "+TableName);
        List<String> result = new ArrayList<>();
        while(rst.next()){
            result.add(rst.getString(2));
        }
        stmt.close();
        return result;
    }
    
    public void UPDATE(Connection conn, String TableName, String colonne, String newValue, String condition) throws Exception{
        Statement stmt = conn.createStatement();
        int rst = stmt.executeUpdate("UPDATE "+TableName+" SET "+colonne+"="+newValue+" where "+condition);
        stmt.close();
    }
}
