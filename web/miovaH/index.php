<?php
if(isset($_GET['num'])==true)
{
    $i=$_GET['num'];
}
else
{
    $i=1;
}
if($i>6)
{
    $i=1;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>
        <h<?php echo $i; ?> > bandy milay
            <a href="index.php?num=<?php echo $i+1; ?>"> <p>aodina</p> </a>
        </h<?php echo $i; ?> >
    </p>
</body>
</html>