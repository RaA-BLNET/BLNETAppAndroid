<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Passwortänderung | blnet App</title>
    <link rel="shortcut icon" href="/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <main>
    <?php
require("password.php");
$servername = "XXXXXXX";
$username = "XXXXXXX";
$password = "XXXXXXX";
$dbname = "XXXXXXX";

$conn = mysqli_connect($servername, $username, $password, $dbname);
$passwort = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["newpw"]));
$id = htmlspecialchars(mysqli_real_escape_string($conn, $_REQUEST["dropdownid"]));

$passwordHash = password_hash($passwort, PASSWORD_DEFAULT);

$statement = "UPDATE androidlogin SET passwort = '$passwordHash' WHERE user_id = $id";

if(mysqli_query($conn, $statement)) {
echo "<p>Ihre Anfrage wurde erfolgreich verarbeitet (Passwortänderung)</p>";
} else {
echo "<p>Ein Fehler ist aufgetreten: " . mysqli_error($conn) . " (Passwortänderung)</p>";
}
mysqli_close($conn);
?>
<button type="button" onclick="window.location.href='https://app.blnet.ch/manage/'">Ok</button>
</main>
</body>
</html>