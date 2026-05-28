<%@ page import="java.util.* , java.sql.*" %>
<%@ page import="connect.ConnectOracle" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>Entrez infos Emp : </p>
    <form action="http://localhost:8080/ProjetDept/DeptAddServlet" method="post">
        <input type="text" name="deptno" placeholder="deptno">
        <input type="text" name="deptname" placeholder="deptname">
        <input type="text" name="location" placeholder="location">

        <input type="submit" value="valider">
    </form>
</body>
</html>