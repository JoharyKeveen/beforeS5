<?php
    function random()
    {
        include("data.php");
        if(isset($_SESSION['word'])==false)
        {
            $rdm=rand(0,4);
            $_SESSION['a']=$rdm;
            $a=$_SESSION['a'];
            $_SESSION['word']=$mot[$a];
        }
        elseif(isset($_SESSION['word'])==true)
        {
            $_SESSION['word'];
        }
    }
    
    function soratra()
    {
        $WR=$_SESSION['word'];
        if(isset($_POST['teny'])==true)
        {
            $teny=$_POST['teny'];
            for($i=0;$i<strlen($WR);$i++)
            {
                if($teny==$WR[$i])
                {
                    $_SESSION['soratra'][$i]=$teny;
                }
            }
            for($i=0;$i<strlen($WR);$i++)
            {
                echo $_SESSION['soratra'][$i];
            }
        }
        else
        {
            for($i=0;$i<strlen($WR);$i++)
            {
                echo $_SESSION['soratra'][$i]=' _ ';
            }
        }
    }

    function isa()
    {
        $WR=$_SESSION['word'];
        if(isset($_POST['teny'])==false)
        {
            $_SESSION['isa']=0;
            return $_SESSION['isa'];
        }
        else
        {
            $teny=$_POST['teny'];
            for($i=0;$i<strlen($WR);$i++)
            {
                if($teny==$WR[$i])
                {
                    return $_SESSION['isa'];
                }
            }
            $_SESSION['isa']=$_SESSION['isa']+1;
            return $_SESSION['isa'];
        }
    }
?>