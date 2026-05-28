import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Formulaire extends HttpServlet {
    private int count = 10;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        out.println("Nom : " + request.getParameter("nom"));
        out.println("Prenom : " + request.getParameter("prenom"));

        if( request.getParameterValues("radio1")[0].equals("Male")){ 
            out.println("It's a man");
        }else{
            out.println("It's a woman");
        }
    }
}