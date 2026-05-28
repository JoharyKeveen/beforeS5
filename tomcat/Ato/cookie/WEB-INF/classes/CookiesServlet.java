import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        PrintWriter out = res.getWriter();
        String sessionId = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("sessionid")) {
        sessionId = cookies[i].getValue();
        }}}
        if (sessionId == null) {
        sessionId = new java.rmi.server.UID().toString();
        Cookie c = new Cookie("sessionid", sessionId);
        res.addCookie(c);
        out.println("Bonjour le nouveau"); 
        } else {
        out.println("Encore vous"); }
        }
}
