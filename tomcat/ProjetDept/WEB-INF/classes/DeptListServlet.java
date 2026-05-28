import assets.Dept;

import java.io.*;
import java.text.DateFormat;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;

public class DeptListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        Dept d = new Dept();
        Vector<Dept> depts = d.getAll();
        req.setAttribute("depts",depts);
        RequestDispatcher dispat = req.getRequestDispatcher("ListeDept.jsp");
        dispat.forward(req, res);
    }
}