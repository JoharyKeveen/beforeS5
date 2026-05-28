<header>
        <a href="#" class="logo"><span>Visit </span>Menabe</a>
        <nav class="navbar">
            <?php
                for($i=0; $i<count($menuH); $i++)
                { ?>
                <a href = " #<?php echo $menuH[$i]; ?> " >
                    <?php echo $menuH[$i]; ?>
                </a>
                <?php }
            ?>
        </nav>
        <div class="icons">
            <i class="fas fa-user" id="login-btn"></i>
            <i class="fas fa-search" id="search-btn"></i>
        </div>
</header>