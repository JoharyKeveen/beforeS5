<%-- 
    Document   : produil
    Created on : 26 janv. 2023, 15:28:29
    Author     : Tolotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Materiel" %>
<%
    Object [] mat = new Materiel().find(null);   
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produit</title>
        <link href="./assets/css/bootstrap.css" rel="stylesheet"> 
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <div id="viewport">
            <!-- Sidebar -->
            <div id="sidebar">
                <header>
                    <a href="#">Imprimerie</a>
                </header>
                <ul class="nav">
                    <li>
                        <a href="produit.jsp">
                            Produit benefice
                        </a>
                    </li>
                   <li>
                        <a href="index.jsp">
                            Prix de vente et benefice
                        </a>
                    </li>
                </ul>
            </div>

            <!-- Content -->
            <div id="content">
                <div class="container-fluid">
                    <!-- ato no atao ny code -->
                    <div class="row" style="margin-top: 5%">
                        <div class="col-md-offset-2 col-md-4 col-md-offset-4">
                            <h1>Produit</h1>
                            <form action="resultProduit.jsp" method="GET">
                                <select class="form-control" name="produit">
                                    <%
                            for(int i = 0; i<mat.length; i++ ){ %>
                                    <option value="<%= ((Materiel)mat[i]).getId() %>"><%= ((Materiel)mat[i]).getNomMateriel() %></option>
                                    <%}%>
                                </select>
                                <input class="btn btn-primary" style="margin-top: 10px" type="submit" value="confirmer"/>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
            <div class="footer-basic">
                <footer>
                    <p class="copyright">ITU © 2022</p>
                </footer>
            </div>

    </body>
</html>
