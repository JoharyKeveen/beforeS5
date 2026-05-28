<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Date Time</title>
</head>
<body>
    <h1>Page de pointage</h1>
    <form action="traitement.php" method="POST">
        <h2>
            Entrer : 
            <input type="date" name="dateE"> 
            <input type="number" max="24" min="0" name="heureE">
            <input type="number" max="60" min="0" name="minuteE">
            <input type="number" max="60" min="0" name="secondeE">
        </h2>
        <h2>
            Sortie : 
            <input type="date" name="dateS"> 
            <input type="number" max="24" min="0" name="heureS">
            <input type="number" max="60" min="0" name="minuteS">
            <input type="number" max="60" min="0" name="secondeS">
        </h2>
        <input type="submit" value="ok">
    </form>
</body>
</html>