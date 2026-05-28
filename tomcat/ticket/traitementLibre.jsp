<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='table.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
    Connex co=new Connex();
    Connection lo=co.log();
    String id=request.getParameter("id");
    String client=request.getParameter("client");
    int idEvent=Integer.valueOf(request.getParameter("idEvent"));
    int libre=Integer.valueOf(request.getParameter("libre"));
    int idSezaL=Integer.valueOf(request.getParameter("idSezaL"));
    int nbplace=Integer.valueOf(request.getParameter("nbplace"));

    int reste=libre-nbplace;
    if(libre>=nbplace)
    new SezaL(idSezaL,Integer.valueOf(id),reste).update("id","nombre",lo);

    lo.close();
%>
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
        if(libre>=nbplace)
        {
            %>
                <h1>Achat reussi!!</h1>
            <%
        }
        else
        {
            %>
                <h1>Il n'y a plus assez de place libre! Il ne reste que <% out.print(libre); %> places libres</h1>
            <%
        }
    %>
    <a href="emplacement.jsp?id=<% out.print(id); %>&&client=<% out.print(client); %>"><button>OK</button></a>
</body>
</html>