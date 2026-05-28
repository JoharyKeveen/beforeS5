<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EmpForm</title>
</head>
<body>
    <form action="http://localhost:8080/testProjet/EmpAddServlet" method="post">
        <label for="Ename">Ename: </label>
        <input type="text" name="Ename">
        <label for="Empno">Empno: </label>
        <input type="text" name="Empno">
        <label for="Sal">Sal: </label>
        <input type="text" name="Sal">
        <label for="Job">Job: </label>
        <input type="text" name="Job">
        <label for="Deptno">Deptno: </label>
        <input type="text" name="Deptno">
        <input type="submit" value="OK">
    </form>
</body>
</html>