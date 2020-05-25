<?php
$servername = "XXXXXXX";
$username = "XXXXXXX";
$password = "XXXXXXX";
$dbname = "XXXXXXX";

$conn = mysqli_connect($servername, $username, $password, $dbname);
$dropdown = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["dropdown"]));
$id = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["id"]));
$newval = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["newval"]));
$statement = "UPDATE androidlogin SET $dropdown = '$newval' WHERE user_id = $id";
mysqli_query($conn, $statement);
mysqli_close($conn);
if (!empty($_SERVER['HTTPS']) && ('on' == $_SERVER['HTTPS'])) {
    $uri = 'https://';
} else {
    $uri = 'http://';
}
$uri .= $_SERVER['HTTP_HOST'];
header('Location: '.$uri.'/manage');
exit;
?>