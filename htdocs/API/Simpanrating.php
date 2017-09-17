<?php
 
require_once 'include/DB_Function.php';
$db = new DB_Function();
 
// json response array
$response = array("error" => FALSE);
 
if (!empty($_POST['email']) && !empty($_POST['item_id']) && !empty($_POST['rating'])) {
 
    // menerima parameter POST ( email, item id, rating value )
    $email = $_POST['email'];
    $item_id = $_POST['item_id'];
    $rating = $_POST['rating'];
 
    // Cek jika user ada dengan email yang sama
    $simpan = $db->simpanRating($email,$item_id,$rating);
    if ($simpan) {
            // simpan rating berhasil
            $response["error"] = FALSE;
            echo json_encode($response);
        } else {
            // gagal menyimpan rating
            $response["error"] = TRUE;
            $response["error_msg"] = "Terjadi kesalahan saat menyimpan rating";
            echo json_encode($response);
        }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Parameter (userEmail, itemId, atau ratingValue) ada yang kurang.";
    echo json_encode($response);
}
?>