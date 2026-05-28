<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='table.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
    Connex co=new Connex();
    Connection lo=co.log();
    String id=request.getParameter("id");
    String etat=request.getParameter("etat");
    String client=request.getParameter("client");
    Vector<SezaL> sezaLibre=new Vector<SezaL>();
    Vector<Evenement> theEvent=new Vector<Evenement>();
    Vector<Zone> zones=new Vector<Zone>();
    Vector<Seza> sezas=new Vector<Seza>();
    Vector<Promotion> promo=new Vector<Promotion>();
        float prom=0;
        int libre=0;
        float prixL=0;
        String eventName="";
        try
        {
            promo=new Promotion(Integer.valueOf(id)).getPromo(lo);
            sezaLibre=new SezaL().get_Tab(new SezaL(Integer.valueOf(id)).select("idEvent",lo));
            theEvent=new Evenement().get_Tab(new Evenement(Integer.valueOf(id)).select("id",lo));
            zones=new Zone().get_Tab(new Zone(Integer.valueOf(id)).select("idEvent",lo));
            libre=sezaLibre.get(0).getNombre();
            prixL=sezaLibre.get(0).getPrix();
            eventName=theEvent.get(0).getNom();
            prom=promo.get(0).getValeur()/100;
        }
        catch(Exception exc)
        {
        }
    int seza=1;

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
    <%
        if(etat.equals("reserve"))
        {
            %>
            <h1>
                Evenement : <% out.print(eventName); %>
            </h1>
            <div style="display: flex;column-gap: 30px;">
                <%
                    for(int i=0;i<zones.size();i++)
                    {
                        %>
                        <div>
                            <p>
                                <h3>
                                    <%
                                        out.print(zones.get(i).getNom()+" -> "+(zones.get(i).getPrix()-(zones.get(i).getPrix()*prom))+" Ar"); 
                                        try
                                        {
                                            sezas=new Seza().get_Tab(new Seza(zones.get(i).getId(),"vert").select("idZone","etat",lo));
                                        }
                                        catch(Exception exce)
                                        {
                                            out.print(exce.getMessage());
                                        }
                                    %>
                                </h3>
                                <%
                                for(int j=0;j<sezas.size();j++)
                                {
                                    %>
                                    <p>
                                        <%
                                        out.print(sezas.get(j).getNum());
                                        %>
                                    </p>
                                    <%
                                }
                                %>
                            </p>
                        </div>
                        <%
                    }
                %>
            </div>
            <div>
                <h2>
                    Veuillez remplir les informations ci-dessous pour faire une reservation
                </h2>
                <form action="traitementRes.jsp">
                    <h4>
                        numero de chaise : <input type="text" name="chaise">
                    </h4>
                    <p>
                        <input type="hidden" value="<% out.print(id); %>" name="id">
                        <input type="hidden" value="<% out.print(client); %>" name="client">
                        <input type="submit" value="reserver">
                    </p>
                </form>
            </div>
            <%
        }
        else
        {
            %>
            <h1>
                Evenement : <% out.print(eventName); %>
            </h1>
            <h1>
                Nombre de place libre : <% out.print(libre); %>
            </h1>
            <h1>
                Prix unitaire : <% out.print(prixL-(prixL*prom)); %> Ar
            </h1>
            <form action="traitementLibre.jsp">
                <h4>
                    Nombre de place : <input type="text" name="nbplace">
                </h4>
                <input type="hidden" value="<% out.print(Integer.valueOf(sezaLibre.get(0).getId())); %>" name="idEvent">
                <input type="hidden" value="<% out.print(sezaLibre.get(0).getNombre()); %>" name="libre">
                <input type="hidden" value="<% out.print(id); %>" name="id">
                <input type="hidden" value="<% out.print(sezaLibre.get(0).getId()); %>" name="idSezaL">
                <input type="hidden" value="<% out.print(client); %>" name="client">
                <p>
                    <input type="submit" value="acheter">
                </p>
            </form>
            <%
        }
        lo.close();
    %>
</body>
</html>