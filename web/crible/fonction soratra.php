<?php
function diviseur($nbr)
{
    $divis=0;
    for($i=1;$i<=$nbr;$i++)
    {
        if($nbr%$i==0)
        { ?>
        <ul>
            <li>
                <?php echo   $i."   "  ;?>
            </li>
        </ul>
        <?php }
    }
}
?>

<?php
function premier($nombre)
{
    $num=$_GET['num'];
    $divi=0;
    for($i=1;$i<$num;$i++)
    {
        if($num%$i==0)
        {
            $divi++;
        }
    }
    if($divi<2)
    {
        return "est premier car ces diviseurs sont:";
    }
    else
    {
        return "n'est pas premier car ces diviseurs sont:";
    }
}
?>