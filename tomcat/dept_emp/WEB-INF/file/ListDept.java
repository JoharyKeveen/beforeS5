import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class ListDept extends HttpServlet {
	
	ArrayList<Dept> list_dept=new ArrayList<Dept>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		res.setContentType("text/plain");
	 	PrintWriter out = res.getWriter();
	 	
	 	try{
		 	Dept temp=new Dept(
		 		Integer.valueOf(req.getParameter("deptno")),
		 		req.getParameter("dname")
		 	);
		 	set_list_dept(temp);
	 		RequestDispatcher dispat = req.getRequestDispatcher("/DeptList.jsp");
	 		req.setAttribute("list_dept",(ArrayList<Dept>)list_dept);
 			dispat.forward(req,res);
	 	}
	 	catch(Exception e){
	 		out.println("error"+e.getMessage());
	 	}
	 	
	}
	
	public void set_list_dept(Dept e){
		if (e!=null) {
			this.list_dept.add(e);
		}
	}
}