<?php
error_reporting(0);

$con = mysqli_connect('XXXXXXX', 'XXXXXXX', 'XXXXXXX', 'XXXXXXX');

$getemail = mysqli_real_escape_string($con, $_REQUEST["email"]);

$statement = mysqli_prepare($con, "SELECT * FROM emailsheet WHERE email = ?");
mysqli_stmt_bind_param($statement, "s", $getemail);
mysqli_stmt_execute($statement);
mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $colemail, $colsheetlink, $colscriptlink);

$response = array();


while(mysqli_stmt_fetch($statement)){
    if ($getemail = "") {
        $response["success"] = false;
} else {
        $response["success"] = true;
        $response["email"] = $colemail;
        $response["sheetlink"] = $colsheetlink;
        $response["scriptlink"] = $colscriptlink;
}
}
echo json_encode($response);
?>
<title>Notenformular Authentifizierung | blnet App</title>