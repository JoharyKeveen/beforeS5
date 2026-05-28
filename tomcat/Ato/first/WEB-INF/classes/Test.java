import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Test extends HttpServlet{

    public Test() {
        super();
    }

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
        String name = "Kenny" ;
        request.setAttribute("nom", name);
        this.getServletContext().getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
    }
    
    protected void doGPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{

    }
}
