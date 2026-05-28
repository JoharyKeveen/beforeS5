import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SenderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        req.setAttribute("seconde", "Veloma eh");
        RequestDispatcher dispat = req.getRequestDispatcher("ReceiverServlet?mot=Manao ahoana eh");
        dispat.forward(req,res);
        // Ne rien faire sur req et res 
    }
}
