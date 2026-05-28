<%-- 
    Document   : index
    Created on : 17 janv. 2023, 15:32:13
    Author     : Tolotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Activite" %>
<%
    Object[] lA = new Activite().find(null);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

                    <h1 class="text-center">Les activites</h1>
                    <% for(int i=0; i<lA.length; i++){ %>
                    <p class="text-center"><a href="prixVente.jsp?idActivite=<%= ((Activite)lA[i]).getId()%>"><%= ((Activite)lA[i]).getNomActivite()%></a></p>
                        <% } %>
                </div>
                <div class="footer-basic">
                    <footer>
                        <p class="copyright">ITU © 2022</p>
                    </footer>
                </div>
                </body>
                </html>
