<%@ page import='java.util.ArrayList' %>
<%@ page import='db.*' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Liste</title>
</head>
<body>
	<center>
		<table border="1">
			<td>Empno</td>
			<td>Ename</td>
			<td>salaire</td>
			<td>Job</td>
			<td>Deptno</td>
			<tr>
	<% ArrayList<Emp> emp=(ArrayList<Emp>)request.getAttribute("list_emp");
		for (int i=0;i<emp.size();i++) { %>
			<td>
				<% out.println(emp.get(i).get_empno()); %> 
			</td>
			<td>
				<% out.println(emp.get(i).get_ename()); %> 
			</td>
			<td>
				<% out.println(emp.get(i).get_sal()); %> 
			</td>
			<td>
			 	<% out.println(emp.get(i).get_job()); %> 
			</td>
			<td>
			 	<% out.println(emp.get(i).get_deptno()); %>
			</td>
			<tr>
	<% } %>
		</table>
		<a href="http://localhost:8080/jsp/EmpForm.jsp"> Retour en arriere </a>
	</center>

</body>
</html>