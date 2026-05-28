<?php include('../inc/function/function.php'); 


  $mois = $_GET['mois'];
  $tab = data($mois);
  $m = explode("-", $mois);
  $i = jourdansmois($m[1], $m[0]);
  ?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <?php include('Header.php'); ?>
  <h3 style="margin-top:20px">Evolution nombre habitant du : <?php echo $mois; ?></h3>
  <canvas id="lineChart" style="max-height: 400px; display: block; box-sizing: border-box; height: 400px; width: 800px;" width="934" height="466"></canvas>

  <script src="../assets/vendor/echarts/echarts.min.js"></script>
  <script src="../assets/vendor/chart.js/chart.min.js"></script>
  
  <input type=hidden id=variableAPasser value=<?php echo $i; ?> />
  

  <script>
    var month = document.getElementById("variableAPasser").value
    var mo = <?php echo json_encode($tab); ?>;
    var dt = []
    var dt1 = []

    for (let i = 1; i <= month; i++) {
      dt.push(i)
      for (let j = 1; j < mo.length; j++) {
        if (mo[j] == i) {
          dt1.push(1)
          break
        }
         else if (j == mo.length - 1 && mo[j] != i) {
          dt1.push(0)
        
        }

      }

    }
    document.addEventListener("DOMContentLoaded", () => {
      echarts.init(document.querySelector("#lineChart")).setOption({
        xAxis: {
          type: 'category',
          data: dt
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: dt1,
          type: 'line',
          smooth: true
        }]
      });
    });
  </script>

  <?php include('Footer.php'); ?>

</body>

</html>