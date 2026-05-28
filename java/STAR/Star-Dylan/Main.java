package run;

import java.sql.Connection;
import data.*;
import bin.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = new Connect().connect();
        Function fun = new Function();
        try {
            fun.getAllComposant(conn, "P0");
            fun.setSiblings();
            fun.setPrix();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0; i<fun.getAllComp().size();i++){

            System.out.println(fun.getAllComp().get(i).getNom() +" : "+ fun.getAllComp().get(i).getPrixUnitaire());
        }
    }
}
