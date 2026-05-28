<?php 
	include('connexion.php');
	$s1=0;$s2=0;$s3=0;$s4=0;$s5=0;$s6=0;$s7=0;
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <link href="css/fontawesome-5/css/all.css" rel="stylesheet">
</head>
<?php include('navigation.php');?>
<body> 
                <p> Reaction: </p>
                <?php 
                $pubs=mysqli_query($bdd,"select * from publications join membres on publications.idMembre=membres.idMembre where idPublication='".$_GET['pub']."'");
                while ($data=mysqli_fetch_assoc($pubs)) { ?>
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
    				</div>
    			</br>
        <div id="all_reaction">
            <div>
                <?php }
                $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=1");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=1");
                ?>
                <h2>
                <?php echo "Like:";
                while ($t=mysqli_fetch_assoc($size)) {
                	echo "(",$t['count(idTypeReaction)'],")";	
                } ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==1) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s1++; ?>
                   	 	<span>
                        	<i class="fas fa-thumbs-up"></i>
                    	</span>
                    </p>
    			</br> 
            </div>
                 <?php }} ?>
			<div>
            <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=2");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=2"); ?>
                <h2>
                    <?php
                        echo "Love:";
                        while ($t=mysqli_fetch_assoc($size)) {
                            echo "(",$t['count(idTypeReaction)'],")";	
                        }
                    ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==2) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s2++; ?>
                   	 	<span>
                        	<i class="fas fa-heart"></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
            <div>
                <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=3");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=3"); ?>
                <h2>
                    <?php
                                    echo "Haha:";
                                    while ($t=mysqli_fetch_assoc($size)) {
                                        echo "(",$t['count(idTypeReaction)'],")";	
                                    }
                    ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==3) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s3++; ?>
                   	 	<span>
                        	<i class="fas fa-grin-squint"></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
            <div>
                <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=4");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=4"); ?>
                <h2>
                    <?php
                                    echo "Ouhh:";
                                    while ($t=mysqli_fetch_assoc($size)) {
                                        echo "(",$t['count(idTypeReaction)'],")";	
                                    }
                    ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==4) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s4++; ?>
                   	 	<span>
                        	<i class="fa fa-tired"></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
            <div>
                <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=5");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=5");?>
                <h2>
                    <?php
                                    echo "Wow:";
                                    while ($t=mysqli_fetch_assoc($size)) {
                                        echo "(",$t['count(idTypeReaction)'],")";	
                                    }
                    ?>
                </h2>
                <?php
                while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==5) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s5++; ?>
                   	 	<span>
                        	<i class="far fa-surprise "></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
            <div>
                <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=6");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=6"); ?>
                <h2>
                    <?php
                                    echo "Sad:";
                                    while ($t=mysqli_fetch_assoc($size)) {
                                        echo "(",$t['count(idTypeReaction)'],")";	
                                    }
                    ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==6) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s6++; ?>
                   	 	<span>
                        	<i class="far fa-sad-tear"></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
            <div>
                <?php $reacteur=mysqli_query($bdd,"select * from reactions join membres on reactions.idMembre=membres.idMembre where idPublication='".$_GET['pub']."' and idTypeReaction=7");
                $size=mysqli_query($bdd,"select count(idTypeReaction) from reactions where idPublication='".$_GET['pub']."' and idTypeReaction=7"); ?>
                <h2>
                    <?php
                                    echo "Grr:";
                                    while ($t=mysqli_fetch_assoc($size)) {
                                        echo "(",$t['count(idTypeReaction)'],")";	
                                    }
                    ?>
                </h2>
                <?php while ($list=mysqli_fetch_assoc($reacteur)) {
                    if ($list['idTypeReaction']==7) { ?>
                    <p>
                        <?php echo "@",$list['Prenom'],"_",$list['Nom']; $s7++; ?>
                   	 	<span>
                        	<i class="far fa-angry"></i>
                    	</span> 
                    </p>
            </div>
                 <?php }} ?>
        </div>
</body>
</html>