<%@ page import = "assets.*" %>
<%@ page import = "java.util.Vector" %>

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

        Vector<Emp> emps = (Vector<Emp>) request.getAttribute("empDept");
            Emp tabl=new Emp();
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
                <% } %>
                <%for (Emp emp : emps) {%>
                    <tr>
                      <td>
                        <% out.println(emp.getEmpno()); %>
                      </td>
                      <td>
                        <% out.println(emp.getEname()); %>
                      </td>
                      <td>
                        <% out.println(emp.getJob()); %>
                      </td>
                      <td>
                        <% out.println(emp.getManager()); %>
                      </td>
                      <td>
                        <% out.println(emp.getHiredate()); %>
                      </td>
                      <td>
                        <% out.println(emp.getSalary()); %>
                      </td>
                      <td>
                        <% out.println(emp.getComm()); %>
                      </td>
                      <td>
                        <% out.println(emp.getDeptno()); %>
                      </td>
                    </tr>
                   <% } %>
            </table>
</body>
</html>