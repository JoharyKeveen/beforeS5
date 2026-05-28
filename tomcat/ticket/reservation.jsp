<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='table.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
    String client=request.getParameter("client");
    Connex co=new Connex();
    Connection lo=co.log();
    try{
    Vector<Reservation> list=new Reservation().get_Tab(new Reservation(Integer.valueOf(client)).select("idClient",lo));

        try
        {
            Vector<Reservation> allres=new Reservation().get_Tab(new Reservation().select(lo));
                for(int i=0;i<allres.size();i++)
                {
                    Vector<Evenement> evtemp=new Evenement().get_Tab(new Evenement(allres.get(i).getIdEvent()).select("id",lo));
                    Vector<DiffTime> difftime=new DiffTime().get_Tab(new DiffTime(allres.get(i).getId()).select("id",lo));
                    if(difftime.get(0).getDiff()>=evtemp.get(0).getValidation())
                    {
                        Vector<Detres> detres=new Detres().get_Tab(new Detres(allres.get(i).getId()).select("idReservation",lo));
                            for(int j=0;j<detres.size();j++)
                            {
                                Vector<Seza> sezasss=new Seza().get_Tab(new Seza(detres.get(j).getIdSeza()).select("id",lo));
                                sezasss.get(0).setEtat("vert");
                                sezasss.get(0).update("id","etat",lo);
                            }
                        detres.get(0).delete("idReservation",lo);
                        new Reservation(allres.get(i).getId(),allres.get(i).getIdClient()).delete("id",lo);
                    }
                }
        }
        catch(Exception exc)
        {
            out.print(exc.getMessage());
        }

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
    <div style="text-align: center;">
        <h1>Vos reservation :</h1>
        <p>---------------------------------------------------------------------------------------------------------------</p>
        <%
            for(int i=0;i<list.size();i++)
            {
                Vector<Detres> detres=new Detres().get_Tab(new Detres(list.get(i).getId()).select("idReservation",lo));
                    for(int j=0;j<detres.size();j++)
                    {
                        Vector<Seza> seza=new Seza().get_Tab(new Seza(detres.get(j).getIdSeza()).select("id",lo));
                            if(j==0)
                            {
                                Vector<Evenement> event=new Evenement().get_Tab(new Evenement(seza.get(0).getIdEvent()).select("id",lo));
                                %>
                                    <h3>
                                        <% out.print(event.get(0).getNom()); %>
                                    </h3>
                                <%
                            }
                        %>
                        <p><% out.print(seza.get(0).getNum()); %></p> 
                        <%
                    }
                    %>
                    <p>
                        <a href="traitementPaye.jsp?client=<% out.print(client); %>&&idres=<% out.print(list.get(i).getId()); %>">Payer</a>
                    </p>
                    <p>---------------------------------------------------------------------------------------------------------------</p>
                    <%
            }
        }
        catch(Exception exc)
        {
            out.print("vous n'avez aucune reservation en cours");
        }
            lo.close();
        %>
    </div>
</body>
</html>