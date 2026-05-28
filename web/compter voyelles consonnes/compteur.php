<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style1.css">
    <title>Nombre de consonne</title>
</head>
<body>
<?php

$text=$_POST['text'];
$string=$text;
$lim=strlen($string);

$voy=0;
$cons=0;
    
$consonne='BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz';
 $alpha= 'AEIOUYaeiouy';

for($t=0;$t<$lim;$t++)
    {
       
        for($a=0;$a<12;$a++)
        {
            if($string[$t]==$alpha[$a])
            {
                $voy++;
            }
        }
            for($a=0;$a<40;$a++)
            {
                if ($string[$t]==$consonne[$a])
                {$cons++; }
            }
    }
?>
    <p>Texte:<?php echo $string ?></p><br>
        <p>Consonne:<?php echo $cons ?></p><br>
        <p>Voyelle:<?php echo $voy ?></p>
 </body>
</html>