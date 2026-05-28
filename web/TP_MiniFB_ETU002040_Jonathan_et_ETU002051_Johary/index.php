<?php
    include('connexion.php');
	if ($_SESSION['connexion']!="authorized") {
		header('location:login.php');
	}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>MyDrugs.to</title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
</head>
<?php include("navigation.php"); ?>
<body>
</br>
  <div id="pubs">
    <form action="index.php" method="post">
        <select name="audience" id="type">
            <option value="0">public</option>
            <option value="1">amis</option>
        </select>
        <span> <input type="text" name="publication" placeholder="Quel bail chakal..."> </span>
        <input type="hidden" value="publier">
        <button><input type="submit" value="publier"></button>
    </form>
  </div>
</br>
	<?php
        if(isset($_POST['publication']))
        {
            mysqli_query($bdd,"INSERT INTO publications VALUES (null,now(),'".$_POST['publication']."','".$_POST['audience']."','".$_SESSION['id']."')");
        }
    ?>
    	<?php
    	$result=mysqli_query($bdd,"select * from publications join membres on publications.idMembre=membres.idMembre");
        if(isset($_POST['commentaire']))
        {
            mysqli_query($bdd,"INSERT INTO commentaires VALUES (null,now(),'".$_POST['commentaire']."','".$_POST['idP']."','".$_SESSION['id']."')");
        }
        include('function.php');
    	 while($data=mysqli_fetch_assoc($result)){
            if($data['TypeAffichage']==0||friend_test($_SESSION['id'],$data['idMembre'])!=0||$data['idMembre']==$_SESSION['id']) { ?>
    <div id="publication">
    		<span class="name"> @<?php echo $data['Prenom']; echo "_"; echo $data['Nom'];?>
                        <span style="color:lightblue"><i class="fas fa-check-circle"></i></span>
                    </a></span></span>
    		<span class="ora"><?php echo $data['DateHeurePublication'];?></span>
            <?php if ($data['idMembre']==$_SESSION['id']) { ?>
            <span class="md"><a href="edit.php?modif=<?php echo $data['idPublication'];?>">
                        <span><i class="fas fa-edit"></i></a>
            <a href="edit.php?del=<?php echo $data['idPublication'];?>">
                        <span><i class="fas fa-trash-alt"></i></span>
                    </a></span></a></span>
                <?php } ?>
        	<p id="p"> <?php echo $data['TextePublication'];?></p>
            <div id="react_inlines"> 
              <?php $qt=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$data['idPublication']."'");
              while($coun=mysqli_fetch_assoc($qt)){ ?>
                <span> <a style="text-decoration:none;color:gray"href="listreact.php?pub=<?php echo $data['idPublication'];?>"> <?php echo $coun['count(idTypeReaction)'];?> </a> </span>
              <?php } ?>
                <span>
                <form action="react.php" method="post">
                    <input name="idP" value="<?php echo $data['idPublication'];?>" type="hidden">
                    <select style="border-radius:20px 10px;color:gray" name="TypeReact"> 
                        <option value="0">React</option>
                        <option value="1">Like</option>
                        <option value="2">Love</option>
                        <option value="3">Haha</option>
                        <option value="4">Ouhh</option>
                        <option value="5">Wow</option>
                        <option value="6">Sad</option>
                        <option value="7">Grrr</option>
                    </select>
                        <input
                         style="
                            border-color:transparent;
                            background-color: transparent;

                         "
                        type="submit" value="Ok">
                </form>
              </span>
              <?php $qtt=mysqli_query($bdd,"select count(idCommentaires) from commentaires where idPublication='".$data['idPublication']."'");
              while($count=mysqli_fetch_assoc($qtt)){ ?>
                <span> <?php echo $count['count(idCommentaires)'];?></span>
              <?php } ?>
                <span> 
                    <i class="fas fa-comment"></i>
                </span>
            </div>
        <?php
            $coms=mysqli_query($bdd,"select * from commentaires join membres on commentaires.idMembre=membres.idMembre where idPublication='".$data['idPublication']." order by DateHeureCommentaires asc'");
            $comm=mysqli_query($bdd,"select * from commentaires join publications on commentaires.idPublication=publications.idPublication");
            while($dataaa=mysqli_fetch_assoc($coms))
            { ?>
                <span id="name"> <?php  echo $dataaa['Prenom'];echo" "; echo $dataaa['Nom']; ?> </span>
                <span class="ora">  <?php echo $dataaa['DateHeureCommentaires']?> </span>
            <?php
            while($dat=mysqli_fetch_assoc($comm))
            {
             if ($dataaa['idMembre']==$_SESSION['id']&&$dat['idMembre']==$dataaa['idMembre']||$dat['idMembre']==$_SESSION['id']) { ?>
                <span class="md"> <a href="edit.php?modifc=<?php echo $dataaa['idCommentaires'];?>">
                        <span><i class="fas fa-edit"></i></span></a>
                    <a href="edit.php?delc=<?php echo $dataaa['idCommentaires'];?>"> 
                        <span><i class="fas fa-trash-alt"></i></span>
                    </a></span>
                <?php break; } } ?>
                <p id="pc"> <?php echo $dataaa['TexteCommentaire'];?> </p>
           <?php }
        ?>
		<form action="index.php" method="post">
	    <span>
            <input type="hidden" name="idP" value=<?php echo $data['idPublication'];?>>
            <span id="com"> <input type="text" name="commentaire" placeholder="Commenter"> </span>
            <span id="bcom"> <input type="submit" value="commenter"> </span>
        </span>
        </form>
    </div>
        </br>
        <?php }} ?> 
</body>
</html>