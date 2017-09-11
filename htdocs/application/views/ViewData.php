<?php
	foreach ($data as $value) {
		# code...
		echo "<div class='container'>";
		echo "ID Review : ".$value['id_review']."<br>";
		echo "judul Review : ".$value['judul_review']."<br>";
		echo "<img src='".base_url('gambar_review/'.$value['gambar_review'].'')."' width='50px' height='50px' \><br>";
		echo "Deskripsi : <br>".$value['deskripsi_review']."<br>";
		echo "</div>";
		echo "<hr>";
	}
?>