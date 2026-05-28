import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class AddDept extends HttpServlet {
ArrayList<Dept> list_emp=new ArrayList<Dept>();
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		res.setContentType("text/plain");
	 	PrintWriter out = res.getWriter();
		RequestDispatcher dispat = req.getRequestDispatcher("/EmpListServlet?deptno="+req.getParameter("deptno")
			+"&&dname="+req.getParameter("dname"));
 		dispat.forward(req,res);
	}
}