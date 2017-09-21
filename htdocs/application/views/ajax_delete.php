<?php
	echo "<div id='listData'>";
	foreach ($data as $value) {
		# code...
		echo "<div class='container'>";
		echo "ID Review : ".$value['id_review']."<br>";
		echo "judul Review : ".$value['judul_review']."<br>";
		echo "<img src='".base_url('gambar_review/'.$value['gambar_review'].'')."' width='50px' height='50px' \><br>";
		echo "Deskripsi : <br>".$value['deskripsi_review']."<br>";
		echo "<input type='button' class='btn btn-info' onclick ='edit();' value='Edit'>";
		echo "&nbsp&nbsp&nbsp&nbsp";
		echo "<input type='button' class='btn btn-info' onclick ='delete_data(".$value['id_review'].");' value='Delete'>";
		echo "</div>";
		echo "<hr>";
	}
	echo "</div>";
?>