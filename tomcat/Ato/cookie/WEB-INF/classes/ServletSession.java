import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletSession extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    Integer count = (Integer)session.getAttribute("count");
    if (count == null) {
        count = 1;
    }
    else{
        count ++;
    }
    
    session.setAttribute("count", count);
    out.println("Vous avez visité cette page " + count + " fois.");
    }
}