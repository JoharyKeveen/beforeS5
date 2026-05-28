<%@ page import = "assets.*" %>
<%@ page import = "java.util.Vector" %>
<%@ page import = "java.lang.reflect.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%

        Vector<Dept> depts = (Vector<Dept>) request.getAttribute("depts");
          Dept tabl=new Dept();
          %>
          <table border="1">
            
              <%
              for(int i=0;i<tabl.getClass().getDeclaredFields().length;i++)
              { %>
                <th>
                  <%
                    out.print(tabl.getClass().getDeclaredFields()[i].getName());
                  %>
                </th>
              <% }
              %>
            
            <%for (Dept dept : depts) {%>
              <tr>
                <td>
                  <% out.println(dept.getDeptno()); %>
                </td>
                <td>
                  <a href="ListEmpDeptServlet?deptno=<% out.println(dept.getDeptno()); %>"><% out.println(dept.getDeptName()); %></a>
                </td>
                <td>
                  <% out.println(dept.getLocation()); %>
                </td>
              </tr>
             <% } %>
          </table>
</body>
</html>