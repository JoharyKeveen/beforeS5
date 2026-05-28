package com.example.project;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.*;

import entity.*;

import java.util.ArrayList;
import connexion.Connex;

import javax.swing.plaf.nimbus.State;

public class Fonction
{
    static Connex conn = new Connex();
    public static boolean majeurOrNot(Date datenaissance)
    {
        boolean res=false;
        LocalDate localDate=LocalDate.now();
        Date now=Date.valueOf(localDate);
        int diff=now.getYear()-datenaissance.getYear();
        if(diff>=18)
        {
            res=true;
        }
        return res;
    }

    public static void insertionEmploye(String nom,String prenom,int idgenre,Date datedenaissance,int iddiplome) throws Exception {
        Connection connection = conn.getConn();
        try
        {
            Statement state=connection.createStatement();
            state.executeUpdate("insert into employe(nom,prenom,idgenre,datedenaissance,iddiplome) values('"+nom+"','"+prenom+"',"+idgenre+",'"+datedenaissance+"',"+iddiplome+")");
            state.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void insertionSpecialite(int idemployee,int idspecialite) throws Exception {
        Connection connection = conn.getConn();
        try
        {
            Statement state=connection.createStatement();
            state.executeUpdate("insert into lienspecialiteemploye values("+idemployee+","+idspecialite+")");
            state.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Employe> getAllEmploye()throws Exception
    {
        Connection connection = conn.getConn();
        String request = "select * from emplyee order by id";
        Statement statement = connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        ArrayList<Employe> result=new ArrayList<Employe>();
        Employe temp=null;
        while(res.next())
        {
            temp=new Employe(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getDate(5),res.getInt(6),res.getInt(7));
            result.add(temp);
        }
        statement.close();
        connection.close();
        return result;
    }

    public static ArrayList<Diplome> getAllDiplome()throws Exception
    {
        Connection connection=conn.getConn();
        String request = "select * from diplome order by id";
        Statement statement = connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        ArrayList<Diplome> result=new ArrayList<Diplome>();
        Diplome temp=null;
        while(res.next())
        {
            temp=new Diplome(res.getInt(1),res.getString(2));
            result.add(temp);
        }
        statement.close();
        connection.close();
        return result;
    }

    public static ArrayList<Specialite> getAllSpecialite()throws Exception
    {
        Connection connection = conn.getConn();
        String request = "select * from specialite order by id";
        Statement statement = connection.createStatement();
        ResultSet res=statement.executeQuery(request);
        ArrayList<Specialite> result=new ArrayList<Specialite>();
        Specialite temp=null;
        while(res.next())
        {
            temp=new Specialite(res.getInt(1),res.getString(2));
            result.add(temp);
        }
        statement.close();
        connection.close();
        return result;
    }
    public static ResultSet executeSelect(Connection con,String sql){
        ResultSet rs=null;
        try {
            con.setAutoCommit(false);
            Statement st=con.createStatement();
            rs=st.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("erreur");
        }

        return rs;
    }

    public ArrayList<EmploieeService> getEmployeeService(int idService) throws Exception {
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        String sql="select * from v_listeemployer where serviceid="+idService;
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<EmploieeService> empServ=new ArrayList<>();
        while(rs.next()){
            empServ.add(new EmploieeService(rs.getInt("EmployeeId"),rs.getInt("ServiceId"),rs.getDouble("dureeminuteemployee")));
        }
        connection.close();
        return empServ;
    }

    public double getSalaireMensuel(int idemploye) throws Exception{
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        String sql = "select * from v_salairemensuel where idemploye="+idemploye;
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("salaire");
        return res;
    }

    public double calculPrix(int idService) throws Exception {
        double totalsalariale = 0;
        ArrayList<EmploieeService> empServ=getEmployeeService(idService);
        ArrayList<Double> somme = new ArrayList<>();
        for(int i=0; i<empServ.size(); i++){
            somme.add((getSalaireMensuel(empServ.get(0).getEmployeeId())/(24*30*60))*empServ.get(i).getDureeminuteEmployee());
        }
        for(int i=0; i<somme.size(); i++){
            totalsalariale = totalsalariale + somme.get(i);
        }
        return totalsalariale;
    }
    public double totalMateriel(int idservice) throws Exception{
        String sql = "select sum(somme) somme from vSommeMateriel where idservice="+idservice;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("somme");
        return res;
    }

    public ArrayList<Service> getAllService() throws Exception{
        String sql = "select * from service";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Service> res = new ArrayList<>();
        while(rs.next()){
            Service service = new Service();
            service.setId(rs.getInt("id"));
            service.setNom(rs.getString("nom"));
            service.setMontant(rs.getDouble("montant"));
            res.add(service);
        }
        connection.close();
        return res;
    }

    public double getMarge(int idservice) throws Exception{
        String sql = "select margebeneficiaire from service where id="+idservice;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("margebeneficiaire");
        return res;
    }

    public double renduService(int idservice) throws Exception{
        double margebeneficiaire = getMarge(idservice);
        double sommemateriel = totalMateriel(idservice);
        double sommesalaire = calculPrix(idservice);
        return ((sommemateriel+sommesalaire)*margebeneficiaire)/100;
    }

    public static void main(String[] args) {
        try{
            System.out.println(getAllDiplome().get(1).getId());
            System.out.println(getAllDiplome().get(1).getNom());
            System.out.println("-------");
            System.out.println(getAllDiplome().get(2).getId());
            System.out.println(getAllDiplome().get(2).getNom());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
