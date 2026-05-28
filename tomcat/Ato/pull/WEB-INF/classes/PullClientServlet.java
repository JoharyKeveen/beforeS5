import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PullClientServlet extends HttpServlet {
    private int count = 10;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if( count > 0 ){
            response.setHeader("Refresh", "1");
            count--;
            out.println(count + " ... ");
        }else{
            out.println("Decompte detrminE ... ") ;
        }
    }
}