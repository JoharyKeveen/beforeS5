import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PizzaAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/plain");
        PrintWriter output = response.getWriter();
        ServletContext context = this.getServletContext();
        context.setAttribute("Specialite", "Pizza akoho");
        context.setAttribute("Date", new Date());
        output.println("La pizza du jour a ete definie ... :3");
    }
}