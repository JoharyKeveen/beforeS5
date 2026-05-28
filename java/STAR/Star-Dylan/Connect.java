package data;

import java.sql.Connection;
import java.sql.DriverManager;

import config.*;

public class Connect {
    public Connection connect(){
        Connection connection = null;
        try {
            Class.forName(new Configuration().getDriver());
            connection = DriverManager.getConnection(new Configuration().getUrl(), 
                                                    new Configuration().getUserName(), 
                                                    new Configuration().getPassword());
        } catch (Exception e) {
        }
        return connection;
    }
}