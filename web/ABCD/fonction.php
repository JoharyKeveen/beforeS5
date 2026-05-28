<?php
include("data.php");
function affiche($az,$pays)
{
	for($i=0;$i<249;$i++)
        {
        $lettre=$pays[$i];
        if($lettre[0]==$az){ ?>
                <ul>
	                <li><?php echo $pays[$i]; ?></li>
                </ul>        
                <?php } ?>
         <?php } ?>
 <?php } ?>