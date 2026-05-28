import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PushServer extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletOutputStream output = response.getOutputStream();
        response.setContentType("multipart/x-mixed-replace;boundary=End");
        output.println("");
        output.println("--End");

        for( int i = 10 ; i > 0 ; i-- ){
            output.println("Content-Type : text/plain");
            output.println("");
            output.println(i + " ... ");
            output.println("");
            output.println("--End");
            output.flush();

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        output.println("Content-Type : text/plain");
        output.println("");
        output.println("Fin");
        output.println("--End--");
        output.flush();
    }
}