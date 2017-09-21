<?php
	foreach ($data->result_array() as $value) {
		# code...
		echo "<div class='container'>";
		echo "<form method='GET' action='".base_url()."index.php/data/update'>";
		echo "<input type='hidden' name='id' value='".$value['id_review']."'> <br>";
		echo "<input size='100' type='text' name='judul' value='".$value['judul_review']."'> <br>";
		echo "<textarea rows='5' cols='100' name='deskripsi'>".$value['deskripsi_review']."</textarea><br> <br>";
		echo "<input type='submit' class='btn btn-info' value='Edit'> <br>";
		echo "</form>";
		echo "</div>";
	}
?>