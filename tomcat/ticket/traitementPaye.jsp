<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='table.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
String client=request.getParameter("client");
String idres=request.getParameter("idres");
    try
    {
        Connex co=new Connex();
        Connection lo=co.log();
    
        Vector<Detres> detres=new Detres().get_Tab(new Detres(Integer.valueOf(idres)).select("idReservation",lo));
            for(int j=0;j<detres.size();j++)
            {
                Vector<Seza> seza=new Seza().get_Tab(new Seza(detres.get(j).getIdSeza()).select("id",lo));
                seza.get(0).setEtat("rouge");
                seza.get(0).update("id","etat",lo);
            }
        detres.get(0).delete("idReservation",lo);
        new Reservation(Integer.valueOf(idres),Integer.valueOf(client)).delete("id",lo);
    
        lo.close();
    }
    catch(Exception e)
    {}
    finally
    {
        response.sendRedirect("event.jsp?client="+client);
    }
%>