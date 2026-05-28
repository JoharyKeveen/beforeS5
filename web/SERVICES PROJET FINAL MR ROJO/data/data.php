<?php

/*------------------------------Menu---------------------------------*/
//Horizontal
    $menuH[] = array(
        'nom'=>"HOME",
        'emplacement'=>"index.php",
        'icon'=>"fas fa-home"
    );;
    $menuH[] = array(
        'nom'=>"SERVICES",
        'emplacement'=>"services.php",
        'icon'=>"fas fa-hands-helping "
    );;
    $menuH[] = array(
        'nom'=>"GALLERY",
        'emplacement'=>"gallery.php",
        'icon'=>"fas fa-images"
    );;
    $menuH[] = array(
        'nom'=>"INFORMATION",
        'emplacement'=>"About Us.php",
        'icon'=>"fas fa-exclamation-circle"
    );;
//Vertical
    $menuV[] = array(
        'nom'=>"Miandrivazo",
        'emplacement'=>"#"
    );;
    $menuV[] = array(
        'nom'=>"Mahabo",
        'emplacement'=>"#"
    );;
    $menuV[] = array(
        'nom'=>"Morondava",
        'emplacement'=>"#"
    );;
    $menuV[] = array(
        'nom'=>"Manja",
        'emplacement'=>"#"
    );;
    $menuV[] = array(
        'nom'=>"Belo sur Tsiribihina",
        'emplacement'=>"#"
    );;


/*-------------------------------------Utilisateur et Mot de passe------------------------------------*/

    $user[]=array('nom'=>"Faly",'pass'=>1234);;

    $user[]=array('nom'=>"Johary",'pass'=>1234);;

    $user[]=array('nom'=>"Emmanuel",'pass'=>1234 );;

    $user[]=array( 'nom'=>"Tsinjo",'pass'=>1234 );;

    $user[]=array( 'nom'=>"Rojo", 'pass'=>1234 );;

    /*-------------------SERVICES------------------*/

    $service[] = array(
        'nom'=>"Aventures",
        'icon'=>"fas fa-hiking",
        'description'=>"lorem ipsum",
        'id'=>0
    );;

    $service[] = array(
        'nom'=>"Hotels",
        'icon'=>"fas fa-hotel",
        'description'=>"lorem ipsum",
        'id'=>1
    );;
    
    $service[] = array(
        'nom'=>"Transports",
        'icon'=>"fas fa-car-side",
        'description'=>"lorem ipsum",
        'id'=>2
    );;

    $service[] = array(
        'nom'=>"Restorants",
        'icon'=>"fas fa-utensils",
        'description'=>"lorem ipsum",
        'id'=>3
    );;
   
    
    $service[] = array(
        'nom'=>"Guides",
        'icon'=>"fas fa-bullhorn",
        'description'=>"lorem ipsum",
        'id'=>4
    );;
     
    $service[] = array(
        'nom'=>"Agences de Voyage",
        'icon'=>"fas fa-building",
        'description'=>"lorem ipsum",
        'id'=>5
    );;

    /*-------------------------------------AVENTURES----------------------------------------------------*/
    $result[]=array(
        'nom'=>"Le Village de Bengy",
        'info'=>"Origine des souverains des deux grands royaumes Sakalava",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"La grotte d’Ikomby",
        'info'=>"ancien refuge des «vazimba»",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Marais de Bekola",
        'info'=>"ancien refuge des «vazimba»",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Tamarinier de Tsimanango",
        'info'=>"Lieu vénéré par les «dahalo»",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Plage d’Andranompasy",
        'info'=>"Lieu vénéré par les «dahalo»",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Plage d’Andranompasy",
        'info'=>"Lieu vénéré par les «dahalo»",
        'service'=>0,
        'lieu'=>4,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;

    $result[]=array(
        'nom'=>"Tombeaux royaux de Tsianihy",
        'info'=>"Ces tombeaux renferment le corps du roi Toera ainsi que ceux des princes Pierre et Georges Kamamy. Le roi Toera fut tué avec ses guerriers en août 1897 au cours de l’attaque du village royal d’Ambiky par les troupes françaises du commandant Gérard, qui voulait obtenir la reddition des Sakalava du Menabe",
        'service'=>0,
        'lieu'=>5,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Gorges du Manambolo",
        'info'=>"Une piste saisonnière de 50 km relie Belo-sur-Tsiribihina à Bekopaka, village riverain du Manambolo et porte méridionale de la réserve de Bemaraha (classée Patrimoine mondiale par l’UNESCO); et de ses « Tsingy » totalement préservés. En amont de Bekopaka, le fleuve a taillé des gorges spectaculaires dans le plateau calcaire de Bemaraha. Certaines des grottes qui s’ouvrent à flanc de falaise sont d’anciennes nécropoles vazimba.",
        'service'=>0,
        'lieu'=>5,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;
    $result[]=array(
        'nom'=>"Réserve naturelle intégrale du Bemaraha",
        'info'=>"La réserve des Tsingy du Bemaraha est le plus vaste site protégé de Madagascar (152.000 a);. Elle s’étend sur près de 90 km de long sur une largeur comprise entre10 et 20 km. Elle recouvre les limites d’un vaste plateau calcaire que l’érosion pluviale a hérissé en spectaculaire lapiaz, arêtes et crêtes acérées qui portent le nom de « Tsingy » en malgache. Le massif contient de nombreuses grottes et résurgences. Les dolines et les avens qui trouent, par endroits, ce karst érodé sont les seuls îlots de verdure dans cet univers minéral, des sanctuaires pour la forêt sèche de l’Ouest.",
        'service'=>0,
        'lieu'=>5,
        'image'=>"",
        "prix"=> 0,
        "note"=>0
    );;

    /*--------------------------------HOTElS------------------------------*/
    //0: bon marche , 1 : abordable , 2 : cher 

    
    $result[]=array(
        'nom'=>"Cap Kimony",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Morondava",
        'image'=>"",
        'etoile'=>3.9
    );

    $result[]=array(
        'nom'=>"Trecicogne",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Morondava",
        'image'=>"",
        'etoile'=>4
    );

    $result[]=array(
        'nom'=>"Select Hotel",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.8
    );

    $result[]=array(
        'nom'=>"Palissandre",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>4.6
    );

    $result[]=array(
        'nom'=>"Kimony resort",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.6
    );

    $result[]=array(
        'nom'=>"Chez Maggie",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>4.8
    );
    $result[]=array(
        'nom'=>"Cap kimony",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.9
    );
    $result[]=array(
        'nom'=>"Sun-Beach",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>4.3
    );
    $result[]=array(
        'nom'=>"Laguna Beach",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.5
    );
    $result[]=array(
        'nom'=>"Havana",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.5
    );
    $result[]=array(
        'nom'=>"Maison La Nomea",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>4
    );
    $result[]=array(
        'nom'=>"Trois Cocotiers",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3
    );
    $result[]=array(
        'nom'=>"Baobab Cafe",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.6
    );
    $result[]=array(
        'nom'=>"Vezo Hotel",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>2.9
    );
    $result[]=array(
        'nom'=>"Bougainvilliers",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        
        'etoile'=>3.6
    );
    $result[]=array(
        'nom'=>"Renala au sable",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.8
    );

    $result[]=array(
        'nom'=>"Eden Rock",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.3
    );

    $result[]=array(
        'nom'=>"Le Cheval de Mer",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>4.6
    );
    $result[]=array(
        'nom'=>"Maeva",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3.3
    );
    $result[]=array(
        'nom'=>"Menabe",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>3
    );
    $result[]=array(
        'nom'=>"Villa A.TIA",
        'info'=>"",
        'service'=>1,
        'lieu'=>"",
        'image'=>"",
        'etoile'=>5
    );
    $result[]=array(
        'nom'=>"Ecolodge du Menabe",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Belo-sur-Mer",
        'image'=>"",
        'etoile'=>5
    );
    $result[]=array(
        'nom'=>"BELO BEACH",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Belo-sur-Mer",
        'image'=>"",
        'etoile'=>5
    );
    $result[]=array(
        'nom'=>"Hotel Entremer",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Belo-sur-Mer",
        'image'=>"",
        'etoile'=>4.6
    );
    $result[]=array(
        'nom'=>"Ecolodge du Menabe",
        'info'=>"",
        'service'=>1,
        'lieu'=>"Belo-sur-Mer",
        'image'=>"",
        'etoile'=>5
    );
    /*------------------------------------TRANSPORT--------------------------------------------*/
        //type 0 : terrestre , 1 : aerien , 2 : maritime
        $result[] = array(
            'type' => 0 ,
            'nom' => "" ,
            'service'=>2
        );;


     /*-------------------------------------------------RESTAURANT--------------------------------------------------------------------*/
     $result[]=array(
        'nom'=>'Mad Zebu',
        'service'=>3,
        'lieu'=>'Belo-sur-Tsiribina',
        'prix'=>'45113 MGA - 135340 MGA',
        'localisation'=>'Face au marche, Belo Tsiribihina 608 Madagascar',
        'image'=>'IMG/resu$result/Belo-sur-Tsiribihina/MAD_ZEBU.jpg'
    );;
    $result[]=array(
        'nom'=>'Karibo Hotel',
        'service'=>3,
        'lieu'=>'Belo-sur-Tsiribina',
        'prix'=>'45113 MGA - 135340 MGA',
        'localisation'=>'Face au marche, Belo Tsiribihina 608 Madagascar',
        'image'=>'IMG/resu$result/Belo-sur-Tsiribihina/Karibo_Hotel.jpg'
    );;
    $result[]=array(
        'nom'=>'Hôtel Restaurant du Menabe',
        'service'=>3,
        'lieu'=>'Belo-sur-Tsiribina',
        'prix'=>'18045 MGA - 27068 MGA',
        'localisation'=>'10 Bp Hotel du Menabe Belo, Belo Tsiribihina 608 Madagascar',
        'image'=>'IMG/resu$result/Belo-sur-Tsiribihina/Hotel_restaurant_du_Menabe.jpg'
        );;
    $result[]=array(
        'nom'=>'Blue soleil',
        'service'=>3,
        'lieu'=>"Morondava",
        'prix'=>'10000 MGA - 30000 MGA',
        'localisation'=>'Route de nosy kely, Morondava 619 Madagascar',
        'image'=>'IMG/resu$result/Morondava/Blue_Soleil.jpg',    );;
    $result[]=array(
        'nom'=>'La Capannina',
        'service'=>3,
        'lieu'=>"Morondava",
        'prix'=>'18045 MGA - 40068 MGA',
        'localisation'=>'Nosy Kely Beach Nosy Kely, Morondava 619 Madagascar',
        'image'=>'IMG/resu$result/Morondava/la-capannina.jpg'
    );;
    $result[]=array(
        'nom'=>'Le Coreil',
        'service'=>3,
        'lieu'=>"Morondava",
        'prix'=>'8000 MGA - 30000 MGA',
        'localisation'=>'Rue de Independance, Morondava 619 Madagascar',
        'image'=>'IMG/resu$result/Morondava/Le_Coreil.jpg'
    );;  
    $result[]=array(
        'nom'=>'Le Masoandro',
        'service'=>3,
        'lieu'=>"Morondava",
        'prix'=>'13534 MGA - 67670 MGA',
        'localisation'=>'Nosy Kely P.O Box 73, Morondava 619 Madagascar',
        'image'=>'IMG/resu$result/Morondava/chez-maggie-result-restaurant.jpg'
    );;
    $result[]=array(
        'nom'=>'Madabar',
        'service'=>3,
        'lieu'=>"Morondava",
        'prix'=>'18000 MGA - 45000 MGA',
        'localisation'=>'Entree de la Ville, Morondava 619 Madagascar',
        'image'=>'IMG/resu$result/Morondava/madabar.jpg'
    );;
    $result[]=array(
        'nom'=>'Eden De La Tsiribihina',
        'service'=>3,
        'lieu'=>'Miandrivazo',
        'prix'=>'10000 MGA - 30000 MGA',
        'localisation'=>'Masiakampy Miandrivazo Menabe Miandrivazo, 617',
        'image'=>'IMG/resu$result/Miandrivazo/Eden.jpg'
    );;
    $result[]=array(
    'nom'=>'Soafivehy',
    'service'=>3,
    'lieu'=>'Miandrivazo',         
    'prix'=>'8000 MGA - 30000 MGA',
    'localisation'=>'Miandrivazo, Madagascar',
    'image'=>'IMG/resu$result/Miandrivazo/Soafivehy.jpg'
    );;


    /*-----------------------------------------GUIDE---------------------------------------------*/
    $result[] = array(
        'service'=>4,
        'nom'=> "",
        'image'=>""
    );;


/*----------------------------------------DISTRICTS------------------------------------------------------*/

    $lieu[0]=array(
    'nom'=>"Miandrivazo",
    'info'=>"Située sur les bords de la rivière Mahajilo, affluent de la Tsiribihina, Miandrivazo est très encaissée. Coincée entre la chaîne du Bongolava à l’est et le plateau de Bemaraha à l’Ouest, cette situation lui assure le statut de « ville la plus chaude de Madagascar » avec une moyenne annuelle de 28 °C. 
    Du point de vue tourisme"
    );;

    $lieu[1]=array(

    'nom'=>"Mahabo",
    'info'=>"Mahabo signifie « qui est élevé ». Elle se trouve à 43 km de Morondava, sur la RNS 35. Ancien village royal de Tsima Nongarivo, roi Sakalava du début du XVIIIe siècle réputé pour sa cruauté"
    );;    

    $lieu[2]=array(
        'nom'=>"Morondava",
        'info'=>"Capitale économique et administrative de Menabe, Morondava est située sur le delta de la rivière du même nom. La ville est depuis toujours en lutte avec la mer. Elle a aussi concédé 2 km de riches plaines cultivées (Mahamasy et Betsimpagnato); jusqu’au lieu dit « la passe Betania » en l’espace d’un siècle et demi seulement.",
    );;
    $lieu[3]=array(
        'nom'=>" Belo-sur-Mer",
        'info'=>"Ce charmant village de pêcheurs et constructeurs de goélettes, est accessible par voie terrestre (80 km); mais surtout maritime (2 h de traversée); à partir de Morondava. Sa belle plage invite au farniente, tandis que son lagon attire véliplanchistes et amateurs de plongées, d’autant qu’il sert de refuge aux tortues marines. Avec l’accord des autorités locales, on peut aussi rallier en pirogue ou goélettes Nosy Andrahovo, Nosy Tania, Nosy Andriangory et Nosy Angarahoka. A l’est de Belo/Mer, la réserve forestière de KIRINDY offre de multiples possibilités de promenade à qui veut observer lémuriens, caméléons, papillons et oiseaux",
    );;

    $lieu[4] = array(
  
        'nom' => "District de Manja",
        'info' => " Une cité qui fut , au XIXe siècle , la capitale d’un petit royaume"
    );;

    
    $lieu[5] = array(
  
        'nom' => "Belo-sur-Tsiribihina",
        'info' => " Bourgade installée sur l’estuaire de la Tsiribihina abrittant les reliques des anciens rois du Menabe"
    );;
    




    

    /*----------------------------------------------Images PAYSAGE------------------------------------------------------*/

    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"arraigne",'image'=>"image/kirindy/paysage/arraigne.jpg"
     );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"baobab amoureux",'image'=>"image/kirindy/paysage/bao.jpg"        );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"serpent",'image'=>"image/kirindy/paysage/boa.jpg");;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"baobab",'image'=>"image/kirindy/paysage/caption.jpg");;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"couchee du soleil",'image'=>"image/kirindy/paysage/couche.jpg");;    
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"baobab",'image'=>"image/kirindy/paysage/ed.jpg");;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"fleuve kirindy",'image'=>"image/kirindy/paysage/fleuve.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"fosa",'image'=>"image/kirindy/paysage/fosa.jpg");;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"kirindy mitea",'image'=>"image/kirindy/paysage/kirindy mitea.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"lemurien",'image'=>"image/kirindy/paysage/lemur.jpg");;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"oiseau",'image'=>"image/kirindy/paysage/oiseau.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"oiseau",'image'=>"image/kirindy/paysage/oiseau1.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"parc",'image'=>"image/kirindy/paysage/Parc-National.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"petit",'image'=>"image/kirindy/paysage/petit.jpg" );;
    $paysage[]=array(
        'lieu'=>"kirindy",
        'nom'=>"flamand rose",'image'=>"image/kirindy/paysage/rose.jpg" );;

    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"allee des baobabs",'image'=>"image/morondava/paysage/Allée-des-Baobabs.jpg");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"allee des baobabs",'image'=>"image/morondava/paysage/baobab.jpg");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"plage",'image'=>"image/morondava/paysage/gorge.jpg");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"plage",'image'=>"image/morondava/paysage/i1.jpg");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"plage",'image'=>"image/morondava/paysage/i2.jpg");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"plage",
        'image'=>"image/morondava/paysage/i3.jpg"
    );;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"plage"
        ,'image'=>"image/morondava/paysage/i4.jpg"
    );;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"gorge de manambola"
        ,'image'=>"image/morondava/paysage/i5.jpg"
    );;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"gorge de manambola",
        'image'=>"image/morondava/paysage/i6.jpg"
    );;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"gorge de manambola",
        'image'=>"image/morondava/paysage/gorge2.jpg
        ");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"gorge de manambola",
        'image'=>"image/morondava/paysage/gorge3.jpg
        ");;
    $paysage[]=array(
        'lieu'=>"morondava",
        'nom'=>"",'image'=>"image/morondava/paysage/gorge4.jpg"
    );;
    
?>
    