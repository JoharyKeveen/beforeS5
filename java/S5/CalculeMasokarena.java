import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.*;
import javax.servlet.http.*;
public class Servlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse res)
   throws ServletException, IOException {
      int id=Integer.valueOf(req.getParameter("id"));
      String nom=req.getParameter("nom");
      String prenom=req.getParameter("prenom");
      int genre=Integer.valueOf(req.getParameter("genre"));
      Date dtn= new Date(Long.valueOf(req.getParameter("date")));
      int niv_etd= Integer.valueOf(req.getParameter("etude"));
      Personne p=new Personne(id,nom,prenom,genre,dtn,niv_etd);
      Boolean ampitaona=p.ampitaonave(dtn);
      Connect c=new Connect("nom", "motdepasse");
      Connection ct=c.connex();
        if(ampitaona==true){
           try{
            Employe emp=new Employe(p,Date.valueOf(LocalDate.now()));
            p.insert(ct);
           }
           catch(Exception e){

           }
        }else{
            Exception e=new Exception("Age invalide");
        }
    }
}

