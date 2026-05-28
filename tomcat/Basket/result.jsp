<%@page import='connection.Connex' %>
<%@page import='connection.BddClass' %>
<%@page import='object.*' %>
<%@page import='java.util.*' %>
<%@page import='java.sql.*' %>
<%
String id=request.getParameter("id");
String team1=request.getParameter("team1");
String team2=request.getParameter("team2");
try
{
    Connex co=new Connex();
    Connection lo=co.log();
    Vector<Chrono> result=new Chrono().get_Tab(new Chrono(id).select("idmatche",lo));
    double total=result.get(result.size()-1).getFotoana();
    int t1=0;
    int t2=0;
    Matche actuel=new Matche(id,team1,team2);
    Vector<Matche> all=new Matche().get_Tab(actuel.select("idmatche",lo)); 
    Vector<Team> teama=new Team().get_Tab(new Team("TEA01",team1).select("name",lo));
        Player playera=new Player();
        playera.setIdteam(teama.get(0).getIdteam());
        Vector<Player> playerA=new Player().get_Tab(playera.select("idteam",lo));
    
    Vector<Team> teamb=new Team().get_Tab(new Team("TEA02",team2).select("name",lo));
        Player playerb=new Player();
        playerb.setIdteam(teamb.get(0).getIdteam());
        Vector<Player> playerB=new Player().get_Tab(playerb.select("idteam",lo));
    for(int k=0;k<playerA.size();k++)
    {
        if(result.get(0).getIdsend().equals(playerA.get(k).getIdplayer()))
        {
            t2+=result.get(0).getFotoana();
        }
    }
    if(t2==0)
    {
        t1+=result.get(0).getFotoana();
    }
    for (int i = 1; i < result.size()-1; i++)
    {
        for(int j=0;j<playerA.size();j++)
        {
            if(playerA.get(j).getIdplayer().equals(result.get(i).getIdsend()))
            {
                if(result.get(i).getIdreceive().equals(result.get(i+1).getIdsend()))
                {
                    t2+=result.get(i+1).getFotoana()-result.get(i).getFotoana();
                }
            }
        }
        for(int j=0;j<playerB.size();j++)
        {
            if(playerB.get(j).getIdplayer().equals(result.get(i).getIdsend()))
            {
                if(result.get(i).getIdreceive().equals(result.get(i+1).getIdsend()))
                {
                    t1+=result.get(i+1).getFotoana()-result.get(i).getFotoana();
                }
            }
        }
    }
    for(int j=0;j<playerA.size();j++)
    {
        if(playerA.get(j).getIdplayer().equals(result.get(result.size()-1).getIdsend()))
        {
            if(result.get(result.size()-2).getIdreceive().equals(result.get(result.size()-1).getIdsend()))
            {
                t1+=result.get(result.size()-1).getFotoana()-result.get(result.size()-2).getFotoana();
            }
        }
    }
    for(int j=0;j<playerB.size();j++)
    {
        if(playerB.get(j).getIdplayer().equals(result.get(result.size()-1).getIdsend()))
        {
            if(result.get(result.size()-2).getIdreceive().equals(result.get(result.size()-1).getIdsend()))
            {
                t2+=result.get(result.size()-1).getFotoana()-result.get(result.size()-2).getFotoana();
            }
        }
    }
    double pourc1=(t1*100)/total;
    double pourc2=(t2*100)/total;
        %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body style="margin-left: 20%;">
                <h1 style="display: flex;gap: 50%;text-align: center;">
                    <p>
                        <%
                            out.print(all.get(0).getTeama());
                            %>
                            <br>
                            <%
                            out.print(all.get(0).getScora());
                            %>
                            <br>
                            <%
                            out.print(Math.round(pourc1*100.0)/100.0+" %");
                        %>
                    </p>
                    <p>
                        <%
                            out.print(all.get(0).getTeamb());
                            %>
                            <br>
                            <%
                            out.print(all.get(0).getScorb());
                            %>
                            <br>
                            <%
                            out.print(Math.round(pourc2*100.0)/100.0+" %");
                        %>
                    </p>
                </h1>
            <div style="display:flex; gap: 50px;margin-left: -24%;">
                <table border="1" style="border-collapse: collapse;" width="50%">
                    <tr>
                        <th>

                        </th>
                        <th>
                            PD
                        </th>
                        <th>
                            RD
                        </th>
                        <th>
                            RO
                        </th>
                        <th>
                            R
                        </th>
                        <th>
                            tir
                        </th>
                        <th>
                            possession
                        </th>
                    </tr>
                    <%
                        for(int j=0;j<playerA.size();j++)
                        { int sumTira=0;
                             %>
                             <tr>
                            <% Vector<VTir> vtira=new VTir().get_Tab(new VTir(playerA.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                            for(int i=0;i<vtira.size();i++)
                            {
                                if(vtira.get(i).getNb()!=0)
                                sumTira++;
                            }
                            int temp1=0;
                            if(result.get(0).getIdsend().equals(playerA.get(j).getIdplayer()))
                            {
                                temp1+=result.get(0).getFotoana();
                            }
                            for (int i = 1; i < result.size()-1; i++)
                            {
                                if(playerA.get(j).getIdplayer().equals(result.get(i).getIdsend()))
                                {
                                    if(result.get(i).getIdreceive().equals(result.get(i+1).getIdsend()))
                                    {
                                        temp1+=result.get(i).getFotoana()-result.get(i-1).getFotoana();
                                    }
                                }
                            }
                            if(playerA.get(j).getIdplayer().equals(result.get(result.size()-1).getIdsend()))
                            {
                                if(result.get(result.size()-2).getIdreceive().equals(result.get(result.size()-1).getIdsend()))
                                {
                                    temp1+=result.get(result.size()-1).getFotoana()-result.get(result.size()-2).getFotoana();
                                }
                            }
                            double pc1=(temp1*100)/total;
                            Vector<PassD> passDa=new PassD().get_Tab(new PassD(playerA.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                Vector<RebondD> rebondDa=new RebondD().get_Tab(new RebondD(playerA.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                    Vector<RebondO> rebondOa=new RebondO().get_Tab(new RebondO(playerA.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                    %>
                            <td>
                                <%out.print(playerA.get(j).getName());%>
                            </td>
                            <td>
                                <%out.print(passDa.size());%>
                            </td>
                            <td>
                                <%out.print(rebondDa.size());%>
                            </td>
                            <td>
                                <%out.print(rebondOa.size());%>
                            </td>
                            <td>
                                <%out.print(rebondDa.size()+rebondOa.size());%>
                            </td>
                            <td>
                                <%out.print(sumTira);%>/<%out.print(vtira.size());%>
                            </td>
                            <td>
                                <%out.print(Math.round(pc1*100.0)/100.0+" %");%>
                            </td>
                        </tr>
                        <%}
                    %>
                </table>
                <table border="1" style="border-collapse: collapse;" width="50%">
                    <tr>
                        <th>

                        </th>
                        <th>
                            PD
                        </th>
                        <th>
                            RD
                        </th>
                        <th>
                            RO
                        </th>
                        <th>
                            R
                        </th>
                        <th>
                            tir
                        </th>
                        <th>
                            possession
                        </th>
                    </tr>
                    <%
                        for(int j=0;j<playerB.size();j++)
                        { int sumTirb=0;
                            %>
                            <tr>
                            <%Vector<VTir> vtirb=new VTir().get_Tab(new VTir(playerB.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                            for(int i=0;i<vtirb.size();i++)
                            {
                                if(vtirb.get(i).getNb()!=0)
                                sumTirb++;
                            }
                            int temp2=0;
                            if(result.get(0).getIdsend().equals(playerB.get(j).getIdplayer()))
                            {
                                temp2+=result.get(0).getFotoana();
                            }
                            for (int i = 1; i < result.size()-1; i++)
                            {
                                if(playerB.get(j).getIdplayer().equals(result.get(i).getIdsend()))
                                {
                                    if(result.get(i).getIdreceive().equals(result.get(i+1).getIdsend()))
                                    {
                                        temp2+=result.get(i).getFotoana()-result.get(i-1).getFotoana();
                                    }
                                }
                            }
                            if(playerB.get(j).getIdplayer().equals(result.get(result.size()-1).getIdsend()))
                            {
                                if(result.get(result.size()-2).getIdreceive().equals(result.get(result.size()-1).getIdsend()))
                                {
                                    temp2+=result.get(result.size()-1).getFotoana()-result.get(result.size()-2).getFotoana();
                                }
                            }
                            double pc2=(temp2*100)/total;
                            Vector<PassD> paddDb=new PassD().get_Tab(new PassD(playerB.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                Vector<RebondD> rebondDb=new RebondD().get_Tab(new RebondD(playerB.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                    Vector<RebondO> rebondOb=new RebondO().get_Tab(new RebondO(playerB.get(j).getIdplayer(),id,"tir").select("idmatche","idplayer",lo));
                                    %>
                            <td>
                                <%out.print(playerB.get(j).getName());%>
                            </td>
                            <td>
                                <%out.print(paddDb.size());%>
                            </td>
                            <td>
                                <%out.print(rebondDb.size());%>
                            </td>
                            <td>
                                <%out.print(rebondOb.size());%>
                            </td>
                            <td>
                                <%out.print(rebondDb.size()+rebondOb.size());%>
                            </td>
                            <td>
                                <%out.print(sumTirb);%>/<%out.print(vtirb.size());%>
                            </td>
                            <td>
                                <%out.print(Math.round(pc2*100.0)/100.0+" %");%>
                            </td>
                        </tr>
                        <%}
                    %>
                </table>
            </div>
        <% }
        catch(Exception e)
        {
            out.print("Le match n'existe pas...veuillez verifier vos parametre");
            out.print(e.getMessage());
        }
    %>
</body>
</html>