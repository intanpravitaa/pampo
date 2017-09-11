<?php
	echo "<div class='container'>
			<br>
			<br>
			";
			echo form_open_multipart(base_url()."index.php/data/proc_upload_foto");
				echo "<h4><input type='file' name='userfile' size='20' ></h4><br />";
				echo "<input type='submit' value='Upload' ><hr>";
			echo "</form>";

			echo "<form method='GET' action='".base_url()."index.php/data/proc_input'>
				<h1>Input Review </h1> <hr>
				
				<h4>Judul Review	: <input type='text' name='judul'></h4><br>

				<h4>Foto	: ";

				if($pic != null){
					echo $pic;
					echo "<input type='hidden' name='pic' value='".$pic."'>";
				}

				echo "</h4><br>

				<h4>Deskripsi :<h4><br>
				<div class='form-group'><textarea class='form-control' rows='5' name='deskripsi'></textarea> </div>
			
				<h4><button name='btnSubmit' class='btn-info'> Simpan </button></h4>
			</form>
		</div>";
?>