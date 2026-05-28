
import assets.Dept;
import java.io.*;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;




public class DeptAddServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        int deptno = Integer.valueOf(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept d = new Dept(deptno,deptname,location);
        d.save();
        RequestDispatcher dispat = req.getRequestDispatcher("DeptListServlet");
        dispat.forward(req, res);
    }
}
