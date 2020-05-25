<?php
error_reporting(0);
require("password.php");

$con = mysqli_connect('XXXXXXX', 'XXXXXXX', 'XXXXXXX', 'XXXXXXX');

$logemail = mysqli_real_escape_string($con, $_REQUEST["email"]);
$logpasswort = mysqli_real_escape_string($con, $_REQUEST["passwort"]);

$statement = mysqli_prepare($con, "SELECT * FROM androidlogin WHERE email = ?");
mysqli_stmt_bind_param($statement, "s", $logemail);
mysqli_stmt_execute($statement);
mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $coluser_id, $colvorname, $colnachname, $colemail, $colpasswort, $colerstelldatum);

$response = array();
$response["success"] = false;  

while(mysqli_stmt_fetch($statement)){
    if (password_verify($logpasswort, $colpasswort)) {
    $response["success"] = true;
    $response["vorname"] = $colvorname;
    $response["nachname"] = $colnachname;
    $response["email"] = $colemail;
}
}

echo json_encode($response);
?>
    <title>Login Anfrage | blnet App</title>