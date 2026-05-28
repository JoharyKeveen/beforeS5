<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='table.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
    Connex co=new Connex();
    Connection lo=co.log();
    String listSeza=request.getParameter("chaise");
    String id=request.getParameter("id");
    String client=request.getParameter("client");
    int idEvent=Integer.valueOf(id);

    String[] splits=listSeza.split(",");
    Vector<String> list=new Vector<String>();
    for(int x=0;x<splits.length;x++)
    {
        list.add(splits[x]);
    }
    for(int i=0;i<list.size();i++)
    {
        if(list.get(i).contains("->"))
        {
            String[] temp=list.get(i).split("->");
            int first=Integer.valueOf(temp[0]);
            int between=Integer.valueOf(temp[1])-Integer.valueOf(temp[0]);
            list.remove(i);
            for(int j=i;j<=i+between;j++)
            {
                list.insertElementAt(Integer.toString(first), j);
                first+=1;
            }
        }
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
        try
        {
            for(int k=0;k<list.size();k++)
            {
                Vector<Seza> tempSeza=new Seza().get_Tab(new Seza(idEvent,Integer.valueOf(list.get(k))).select("idEvent","num",lo));
                tempSeza.get(0).verif();
            }

            Reservation res=new Reservation(Integer.valueOf(client),Integer.valueOf(id),0);
            res.insertRes(lo);
            
            for(int l=0;l<list.size();l++)
            {
                Vector<Seza> tempSeza=new Seza().get_Tab(new Seza(idEvent,Integer.valueOf(list.get(l))).select("idEvent","num",lo));
                tempSeza.get(0).setEtat("orange");
                tempSeza.get(0).update("id","etat",lo);
                new Detres(res.getId(),tempSeza.get(0).getId()).insert(lo);
            }
            %>
            <h1>Achat reussi!!</h1>
            <a href="emplacement.jsp?id=<% out.print(id); %>&&client=<% out.print(client); %>"><button>OK</button></a>
            <%
        }
        catch(Exception excep)
        {
            out.print(excep.getMessage());
        }
        finally
        {
            lo.close();
        }
    %>
</body>
</html>