<?php
error_reporting(0);
require("password.php");

$con = mysqli_connect('XXXXXXX', 'XXXXXXX', 'XXXXXXX', 'XXXXXXX');

$vorname = mysqli_real_escape_string($con, $_REQUEST["vorname"]);
$nachname = mysqli_real_escape_string($con, $_REQUEST["nachname"]);
$email = mysqli_real_escape_string($con, $_REQUEST["email"]);
$passwort = mysqli_real_escape_string($con, $_REQUEST["passwort"]);

function registerUser() {
    global $con, $vorname, $nachname, $email, $passwort;
    $passwordHash = password_hash($passwort, PASSWORD_DEFAULT);
    $statement = mysqli_prepare($con, "INSERT INTO androidlogin (vorname, nachname, email, passwort) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssss", $vorname, $nachname, $email, $passwordHash);
    mysqli_stmt_execute($statement);
    mysqli_stmt_close($statement);
}

function usernameAvailable() {
    global $con, $email;
    $statement = mysqli_prepare($con, "SELECT * FROM androidlogin WHERE email = ?"); 
    mysqli_stmt_bind_param($statement, "s", $email);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    $count = mysqli_stmt_num_rows($statement);
    mysqli_stmt_close($statement); 
    if ($count < 1){
        return true; 
    }else {
        return false; 
    }
}

$response = array();
$response["success"] = false;

if (usernameAvailable()){
    registerUser();
    $response["success"] = true;
}

echo json_encode($response);
if (!empty($_SERVER['HTTPS']) && ('on' == $_SERVER['HTTPS'])) {
    $uri = 'https://';
} else {
    $uri = 'http://';
}
$uri .= $_SERVER['HTTP_HOST'];
header('Location: '.$uri.'/manage');
exit;
?>