<%-- 
    Document   : prixVente
    Created on : 17 janv. 2023, 15:41:26
    Author     : Tolotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="model.V_employeActivite" %>
<%@page  import="model.V_materielActivite" %>
<%@page  import="model.Marge" %>


<%
    Marge m = (Marge)new Marge().find(null)[0];
    int idA = Integer.parseInt(request.getParameter("idActivite"));
    V_employeActivite vm = new V_employeActivite();
    vm.setActiviteId(idA);
    Object [] lem = vm.find(null);
    double totalRs = vm.getTotalRs(idA);
    
 V_materielActivite vm1 = new V_materielActivite();
    vm1.setActiviteId(idA);
    Object [] lem1 = vm1.find(null);
    double totalRM = vm1.getTotalRM(idA);
    
 double vingt = new Marge().getPrixdevente(idA);
 double benefice = new Marge().getbenefice(idA);
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
            <div class="row">
                <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                    <h3>Charge salariale</h3>
                    <table class="table">
                        <tr class="info">
                            <th>Specialité</th>
                            <th>Duree</th>
                            <th>Prix/h</th>
                            <th>Total</th>
                        </tr>
                        <% for(int i = 0 ;i<lem.length; i++){ %>
                        <tr>
                            <td><%= ((V_employeActivite)lem[i]).getNomSpecialite()%></td>
                            <td> <%= ((V_employeActivite)lem[i]).getDuree()%> h</td>
                            <td> <%= ((V_employeActivite)lem[i]).getValeur()%> ar</td>
                            <td> <%= ((V_employeActivite)lem[i]).getValeur()*((V_employeActivite)lem[i]).getDuree()%> ar</td>  
                        </tr>
                        <% } %>
                    </table>

                    <p><b>Total R.S:</b> <%= totalRs %> Ariary</p>
                    <h3>Materiel</h3>
                    <table class="table">
                        <tr class="info">
                            <th>Specialité</th>
                            <th>Quantite</th>
                            <th>Prix/q</th>
                            <th>Total</th>
                        </tr>
                        <% for(int i = 0 ;i<lem1.length; i++){ %>
                        <tr>
                            <td><%= ((V_materielActivite)lem1[i]).getNomMateriel()%></td>
                            <td><%= ((V_materielActivite)lem1[i]).getDuree()%> </td>
                            <td><%= ((V_materielActivite)lem1[i]).getPrix()%> ar</td>
                            <td><%= ( ((V_materielActivite)lem1[i]).getDuree()*((V_materielActivite)lem1[i]).getPrix())%> ar</td>
                        </tr>
                        <% } %>
                    </table>
                    <p><b>Total R.M:</b> <%= totalRM %> Ariary</p>
                    <h4 style="margin-left:80%"><b>Prix de vente:</b> <%=vingt %> Ariary</h4>
                    <h4 style="margin-left:80% "><b>Benefice:</b> <%=benefice %> Ariary</h4>
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
