<?php 
    function friend_test($id,$id_2)
    {
        include('connexion.php');
        $friend1=mysqli_query($bdd,"select * from amis where idMembre2='".$id."' and idMembre1='".$id_2."' and DateHeureconfirmation is not null");
        $friend2=mysqli_query($bdd,"select * from amis where idMembre1='".$id."' and idMembre2='".$id_2."' and DateHeureconfirmation is not null");
        while($friend_1=mysqli_fetch_assoc($friend1))
        {
            return 1;
        }
        while($friend_2=mysqli_fetch_assoc($friend2))
        {
            return 1;
        }
        return 0;
    } 
?>