<?php 
    function featured_product()
    {
        $requete=$bdd->query("SELECT*FROM product");
        $requete->setFetchMode(PDO::FETCH_OBJ);
            while($st=$requete->fetch())
            {
                echo `
                    <div class="col-lg-3 col-md-4 col-sm-6 mix `+$st->typ+`?>
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/`+$st->img+`">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">`+$st->nom+`</a></h6>
                            <h5>`<?php echo '$'.$st->prix+`</h5>
                        </div>
                        </div>
                `;
            }
    }
?>