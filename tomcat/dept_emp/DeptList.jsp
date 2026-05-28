<%@ page import='java.util.ArrayList' %>
<%@ page import='bd.*' %>
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
	<% ArrayList<Dept> dept=(ArrayList<Dept>)request.getAttribute("list_dept");
		for (int i=0;i<dept.size();i++) { %>
			<td>
				<% out.println(dept.get(i).get_deptno()); %>
			</td>
			<td>
				<% out.println(dept.get(i).get_dname()); %> 
			</td>
			<td>
				<% out.println(dept.get(i).get_loc()); %> 
			</td>
			<tr>
	<% } %>
		</table>
		<a href="http://localhost:8080/jsp/DeptForm.jsp"> Retour en arriere </a>
	</center>

</body>
</html>