<?php
error_reporting(0);
require("password.php");

$con = mysqli_connect('XXXXXXX', 'XXXXXXX', 'XXXXXXX', 'XXXXXXX');

$email = mysqli_real_escape_string($con, $_REQUEST["email"]);
$passwort = mysqli_real_escape_string($con, $_REQUEST["newpassword"]);

function registerUser() {
    global $con, $email, $passwort;
    $passwordHash = password_hash($passwort, PASSWORD_DEFAULT);
    $statement = mysqli_prepare($con, "UPDATE androidlogin SET passwort = ? WHERE email = ?");
    mysqli_stmt_bind_param($statement, "ss", $passwordHash, $email);
    mysqli_stmt_execute($statement);
    mysqli_stmt_close($statement);
}

$response = array();
    registerUser();
    $response["success"] = true;

echo json_encode($response);
?>
    <title>Registration Anfrage | blnet App</title>