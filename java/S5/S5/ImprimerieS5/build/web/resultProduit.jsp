<%-- 
    Document   : resultProduit
    Created on : 26 janv. 2023, 15:39:47
    Author     : Tolotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Materiel" %>
<%
    int id = Integer.parseInt(request.getParameter("produit"));
    Materiel v_mat = new Materiel();
    v_mat.setId(id);
    v_mat = (Materiel)v_mat.find(null)[0];
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
        
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                <h3><%= v_mat.getNomMateriel()%></h3>
                <table class="table">
                    <tr class="info">
                        <th>Prix conseillé</th>
                        <th>Prix d'achat</th>
                        <th>Benefice</th>
                     
                    </tr>
                   
                    <tr>
                        <td><%= v_mat.getPrixConseille()%> Ariary</td>
                        <td> <%= v_mat.getPrix()%> Ariary</td>
                        <td> <%= v_mat.getBenefice()%> Ariary</td>
                        
                    </tr>
                </table>
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
