<?php  


$server ="localhost";
$username   = "root"; 
$password   =""; 
$database   ="pampo";
 
$conn = mysql_connect($server, $username, $password) or die("Koneksi tidak ada");
mysql_select_db($database) or die("Database tidak ditemukan");
 
 $query = "Select * from tbl_user";

 $hasil        = mysql_query($query, $conn) or die(mysql_error());
 $json_response = array();
 
if(mysql_num_rows($hasil)> 0){
 while ($row = mysql_fetch_array($hasil)) {
     $json_response[] = $row;
 }
 echo json_encode(array('user' => $json_response));
}
?>