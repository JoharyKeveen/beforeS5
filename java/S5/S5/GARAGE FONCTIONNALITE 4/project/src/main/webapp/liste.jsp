<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Service" %><%--
  Created by IntelliJ IDEA.
  User: STEVEN
  Date: 17/01/2023
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Service> services = (ArrayList<Service>) request.getAttribute("listeservice"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
EVALUATION
<br>
Type de service
<br>
<form action="evaluate">
    <select name="service" id="service">
        <% for(int i=0; i<services.size(); i++){ %>
        <option value="<%= services.get(i).getId() %>"><%= services.get(i).getNom() %></option>
        <% } %>
    </select>
    <input type="submit" value="valider">
</form>
</body>
</html>
