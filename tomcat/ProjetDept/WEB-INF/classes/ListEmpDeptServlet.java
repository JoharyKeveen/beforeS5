
import assets.Emp;
import java.io.*;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;




public class ListEmpDeptServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        int deptno = Integer.valueOf(req.getParameter("deptno"));
        Emp e = new Emp();
        Vector<Emp> empDept = e.findByDept(deptno);

        req.setAttribute("empDept",empDept);
 
        RequestDispatcher dispat = req.getRequestDispatcher("ListeEmpDept.jsp");
        dispat.forward(req, res);

    }
}
