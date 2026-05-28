import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CouleurSession extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        String choice = (String) session.getAttribute("color");
        Integer count = (Integer) session.getAttribute("count");
        
        if (choice == null) {
            count = new Integer(1);
            choice = req.getParameter("color");
            session.setAttribute("color", choice );
            session.setAttribute("count", count);
            out.println("Vous avez choisi la couleur : " + choice);
        } else {
            count = new Integer(count.intValue() + 1);
            session.setAttribute("count", count);
            out.println("Vous avez deja choisi la couleur : " + choice);
        }
        
        out.println("Vous avez visité cette page " + count + " fois.");
        if(count == 150){
            out.println("VICTORY");
        }
    }
}