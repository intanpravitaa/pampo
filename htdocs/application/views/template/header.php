<!DOCTYPE html>
<html lang="en">
  <head>
	<title>Pampo Web Admin</title>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<?=base_url()?>assets/bootstrap/css/bootstrap.min.css">
	<!--<link rel="stylesheet" href="<?=base_url()?>assets/bootstrap/css/bootstrap-container.css">-->
    <!-- jQuery library -->
    <script src="<?=base_url()?>assets/jquery.js"></script>
    <script src="<?=base_url()?>assets/act.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="<?=base_url()?>assets/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<?=base_url()?>assets/style.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<?=base_url()?>assets/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<?=base_url()?>assets/dataTable/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="<?=base_url()?>assets/dataTable/media/css/jquery.dataTables.min.css">
    <link rel="shortcut icon" href="<?=base_url()?>assets/pampo.jpg">    
    <script src="<?=base_url()?>assets/dataTable/media/js/jquery.dataTables.min.js"></script>

  </head>
  <body>
<div class="container" style="background:#fff;margin-top:0px; padding-top:30px; padding-bottom:15px; border-bottom:solid thin #e8e8e8; box-shadow:         0px -6px 22px 0px rgba(0, 0, 0, 0.2); border-radius: 3px;">

      <div class="container">
      <div class="row ">
        <div class="col-md-1">
            <a href="<?=base_url()?>">
              <img src="<?=base_url()?>assets/pampo.jpg" width="100px" style="margin-bottom:10px; "/>
              
            </a>
            
        </div>
        <div class="col-md-5">
          <h3>Pampoo</h3>
          <p><em>"Intan Pravitasari"</em></p>
        </div>
        <div class="col-md-6">
            
            <form role="search" id="searchform" class="searchform " action="#" method="get">
                <input type="text" class="text-cari " name="s" placeholder="keyword.." />
                <button type="submit" class=" button-cari " id="searchsubmit">Cari</button>
            </form>
            <p class="text-right" >
            <span class="fa-stack fa-lg">
              <i class="fa fa-circle fa-stack-2x"></i>
              <a href="https://twitter.com/itera_PTN" style="color: #000;" ><i class="fa fa-twitter fa-stack-1x fa-inverse"></i></a>
            </span>&nbsp;&nbsp;&nbsp;
            <span class="fa-stack fa-lg">
              <i class="fa fa-circle fa-stack-2x"></i>
              <a href="https://www.facebook.com/itera.official/" style="color: #000;"><i class="fa fa-facebook fa-stack-1x fa-inverse"></i></a>
            </span>&nbsp;&nbsp;&nbsp;
            <span class="fa-stack fa-lg">
              <i class="fa fa-circle fa-stack-2x"></i>
              <a href="https://www.instagram.com/iteraofficial/" style="color: #000;"><i class="fa fa-instagram fa-stack-1x fa-inverse"></i></a>
            </span>&nbsp;&nbsp;&nbsp;
            <span class="fa-stack fa-lg">
              <i class="fa fa-circle fa-stack-2x"></i>
              <a href="https://www.youtube.com/results?search_query=itera" style="color: #000;"><i class="fa fa-youtube fa-stack-1x fa-inverse"></i></a>
            </span>&nbsp;&nbsp;&nbsp;
            
            
            </p>
        </div>
      </div>
    </div>
    </div>

  <!-- For AJAX -->
<script language='javascript'>

  function delete_data(id) {
    var ajaxRequest;
  
    try {
      ajaxRequest = new XMLHttpRequest(); //Opera 8.0+, Firefox, Safari
    } catch(e) {
      //Untuk IE
      try {
        ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
      } catch(e) {
        try {
          ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } catch(e) {
          alert("Gagal karena browser anda tidak mendukung ajax");
          return false;
        }
      }
    }

    ajaxRequest.onreadystatechange = function() {
      if (ajaxRequest.readyState == 4) {
        var ajaxTampil = document.getElementById('listData');
        ajaxTampil.innerHTML = ajaxRequest.responseText;
      }
    }
    
    
    var url="<?=base_url()?>index.php/data/delete_data?id="+id;
    
    ajaxRequest.open("GET",url,true);
    ajaxRequest.send(null);
  }

  function edit_data(id) {
    var ajaxRequest;
  
    try {
      ajaxRequest = new XMLHttpRequest(); //Opera 8.0+, Firefox, Safari
    } catch(e) {
      //Untuk IE
      try {
        ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
      } catch(e) {
        try {
          ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } catch(e) {
          alert("Gagal karena browser anda tidak mendukung ajax");
          return false;
        }
      }
    }

    ajaxRequest.onreadystatechange = function() {
      if (ajaxRequest.readyState == 4) {
        var ajaxTampil = document.getElementById('listData');
        ajaxTampil.innerHTML = ajaxRequest.responseText;
      }
    }
    
    
    var url="<?=base_url()?>index.php/data/edit_data?id="+id;
    
    ajaxRequest.open("GET",url,true);
    ajaxRequest.send(null);
  }
</script>