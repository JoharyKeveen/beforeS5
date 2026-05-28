import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;

public class Main 
{
    public static void main(String[] args) {

    // Date de naissance
        // Date dtn=new Date(2004-1900, 02, 01);
        // LocalDate localDate=LocalDate.now();
        // Date now=Date.valueOf(localDate);
        // int diff=now.getYear()-dtn.getYear();
        // System.out.println(diff);


        // table employe:
        // id SERIAL PRIMARY KEY
        // nom VARCHAR(40)
        // prenom VARCHAR(40)
        // idgenre INT
        // date de naissance DATE
        // iddiplome INT
        // FOREIGN KEY(iddiplome) -> table DIPLOME
        // FOREIGN KEY(idgenre) -> table GENRE
    }

    // public void insertionEmploye(String nom,String prenom,int idgenre,Date datedenaissance,int iddiplome)
    // {
    //     Connex co=new Connex();
    //     Connection lo=co.log();
    //     Employe emp=new Employe(nom,prenom,idgenre,datedenaissance,iddiplome);
    //     try
    //     {
    //         emp.insert(lo);
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println(e.getMessage());
    //     }
    // }

    // public void insertionSpecialite(int idemployee,int idspecialite)
    // {
    //     Connex co=new Connex();
    //     Connection lo=co.log();
    //     Specialite emp=new Specialite(idemployee,idspecialite);
    //     try
    //     {
    //         emp.insert(lo);
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println(e.getMessage());
    //     }
    // }

    // Specialite
    // int id
    // id idemployee
    // String nom 

        // table employe:
        // id SERIAL PRIMARY KEY
        // nom VARCHAR(40)
        // prenom VARCHAR(40)
        // idgenre INT
        // date de naissance DATE
        // iddiplome INT
        // FOREIGN KEY(iddiplome) -> table DIPLOME
        // FOREIGN KEY(idgenre) -> table GENRE

    // public ArrayList<Employee> getAllEmploye() 
    // {
    //     Connex connection=new Connex();
    //     Connection lo=connection.log();
    //     String request = "select * from emplyee order by id";
    //     Statement statement = lo.createStatement();
    //     ResultSet res=statement.executeQuery(request);
    //     ArrayList<Employee> result=new ArrayList<Employee>();
    //     Employee temp=null;
    //     while(res.next())
    //     {
    //         temp=new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getDate(5),res.getInt(6));
    //         result.add(temp);
    //     }
    //     statement.close();
    //     lo.close();
    //     return result;
    // }

    // Diplome
    // int id
    // String nom

    // public ArrayList<Diplome> getAllDiplome() 
    // {
    //     Connex connection=new Connex();
    //     Connection lo=connection.log();
    //     String request = "select * from diplome order by id";
    //     Statement statement = lo.createStatement();
    //     ResultSet res=statement.executeQuery(request);
    //     ArrayList<Diplome> result=new ArrayList<Diplome>();
    //     Diplome temp=null;
    //     while(res.next())
    //     {
    //         temp=new Diplome(res.getInt(1),res.getString(2));
    //         result.add(temp);
    //     }
    //     statement.close();
    //     lo.close();
    //     return result;
    // }
    
    // public ArrayList<Specialite> getAllSpecialite() 
    // {
    //     Connex connection=new Connex();
    //     Connection lo=connection.log();
    //     String request = "select * from specialite order by id";
    //     Statement statement = lo.createStatement();
    //     ResultSet res=statement.executeQuery(request);
    //     ArrayList<Specialite> result=new ArrayList<Specialite>();
    //     Specialite temp=null;
    //     while(res.next())
    //     {
    //         temp=new Specialite(res.getInt(1),res.getString(2));
    //         result.add(temp);
    //     }
    //     statement.close();
    //     lo.close();
    //     return result;
    // }
}