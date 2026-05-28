<?php
    function nbpremier($chiffre)
    {
        $divi=0;
        for($i=1;$i<=$chiffre;$i++)
        {
            if($chiffre%$i==0)
            {
                $divi++;
            }
        }?>
        <?php if($divi==2) {?>
        <td class="vert"><span><a href="2p.php?num=<?php echo $i-1; ?>"><?php echo $chiffre;?></a></span></td>    
        <?php }?>
        <?php if($divi!=2) {?>
        <td class="rouge"><span><a href="2p.php?num=<?php echo $i-1; ?>"><?php echo $chiffre;?></a></span></td>    
        <?php }?>
        
    <?php }?>