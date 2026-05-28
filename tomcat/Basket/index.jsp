<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='object.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%@page import='java.text.*' %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>
        List matchs:
    </h1>
       
        <%
            Connex co=new Connex();
            Connection lo=co.log();
            Vector<Matche> all=new Matche().get_Tab(new Matche().select(lo)); 
                DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
                %>
                <table border="1">
                    <th>Code match</th>
                    <th>Team A</th>
                    <th>Team B</th>
                    <th>Date</th>
                <% for(int i=0;i<all.size();i++)
                { %>
                    <tr>
                        <td>
                            <% out.print(all.get(i).getIdmatche()); %>
                        </td>
                        <td>
                            <% out.print(all.get(i).getTeama()); %>
                        </td>
                        <td>
                            <% out.print(all.get(i).getTeamb()); %>
                        </td>
                        <td>
                            <% out.print(df.format(all.get(i).getDaty())); %>
                        </td>
                    </tr>
                <% }
        %>
                </table>
    <form action="result.jsp">
        <h1>Enter parameter</h1>
        <h3>
            Code match:
            <input type="text" name="id">
        </h3>
        <h3>
            Team 1:
            <input type="text" name="team1">
        </h3>
        <h3>
            Team 2:
            <input type="text" name="team2">
        </h3>
        <p>
            <input type="submit" value="check it">
        </p>
    </form>
</body>
</html>