<?php
$servername = "XXXXXXX";
$username = "XXXXXXX";
$password = "XXXXXXX";
$dbname = "XXXXXXX";

$conn = mysqli_connect($servername, $username, $password, $dbname);
$email = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["email"]));
$sheetlink = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["sheetlink"]));
$scriptlink = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["scriptlink"]));
$statement = "INSERT INTO emailsheet (email, sheetlink, scriptlink) VALUES ('$email', '$sheetlink', '$scriptlink')";
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