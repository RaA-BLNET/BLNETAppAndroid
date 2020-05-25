<?php
$servername = "XXXXXXX";
$username = "XXXXXXX";
$password = "XXXXXXX";
$dbname = "XXXXXXX";

$conn = mysqli_connect($servername, $username, $password, $dbname);
$deleteemail = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["deleteemail"]));
$statement = "DELETE FROM emailsheet WHERE email = '$deleteemail'";
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