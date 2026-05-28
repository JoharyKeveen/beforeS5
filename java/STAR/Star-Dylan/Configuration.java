package config;

public class Configuration {
    // =================CONNECTION=====================
    String Driver = "oracle.jdbc.driver.OracleDriver";
	String Url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String UserName = "dylan";
	String Password = "dylan";
    
    public String getDriver() {
        return Driver;
    }
    public void setDriver(String driver) {
        Driver = driver;
    }
    public String getUrl() {
        return Url;
    }
    public void setUrl(String url) {
        Url = url;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
    
    
}