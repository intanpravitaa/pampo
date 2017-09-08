<div class="container top" style="background:#daa520;" >
<nav class="navbar navbar-inverse ">

	<ul class="nav navbar-nav">
		<?php
		echo "<li class=";if($link=='home'){echo 'active';}echo "><a href='".base_url()."'><i class='fa fa-home' aria-hidden='true'></i> Home </a></li>";
		echo "<li class=";if($link=='ViewData'){echo 'active';}echo "><a href='".base_url()."index.php/data'><i class='fa fa-search' aria-hidden='true'></i> View Data </a></li>";
		echo "<li class=";if($link=='InputData'){echo 'active';}echo "><a href='".base_url()."index.php/data/input'><i class='fa fa-edit' aria-hidden='true'></i> Input Data </a></li>";
		?>
	</ul>
</div>
    

<div class="container" style="background:#fff;min-height:500px; box-shadow:0px -6px 22px 0px rgba(0, 0, 0, 0.2);">
    <div class="row">