import java.io.*;
import java.text.DateFormat;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PizzaClient extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ServletContext context = this.getServletContext();
        ServletOutputStream output = response.getOutputStream();

        String pizzaSpec = (String)context.getAttribute("Specialite");
        Date day = (Date)context.getAttribute("Date");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String today = dateFormat.format(day);
        output.println("Aujourd'hui ( " + today + " ) , notre specialite est : " + pizzaSpec);
    }
}