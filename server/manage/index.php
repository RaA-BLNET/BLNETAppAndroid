<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Notenformular Verwaltung | blnet App</title>
    <link rel="shortcut icon" href="/favicon.png" type="image/x-icon">
    <link href="style.css" type="text/css" rel="stylesheet">
    <script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
</head>
<body>
<main>
    <h1>blnet App Verwaltung</h1>
    <p>Hier können Sie den Accounts der Basislehrlinge die passenden Sheetlinks und Scriptlinks zuweisen und die Userdatenbank verwalten.</p>
    <h2>Notenformular</h2>
    <strong>Jetztiger Stand:</strong>
    <?php
$servername = "XXXXXXX";
$username = "XXXXXXX";
$password = "XXXXXXX";
$dbname = "XXXXXXX";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlnt = "SELECT * FROM emailsheet";
$result = $conn->query($sqlnt);
echo '<table id="fromsql"> <tr> <th>E-Mail</th><th>Sheet-Link</th><th>Script-Link</th></tr>';
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["email"]. "</td><td>" . $row["sheetlink"]. "</td><td>" . $row["scriptlink"]. "</td></tr>";
    }
}
echo "</table>";
?>
<div id="manager">
<form id="deleteform" onsubmit="return confirm('Möchten Sie wirklich diesen Eintrag löschen? Dieser Vorgang kann nicht rückgängig gemacht werden.')" action="deletent.php" method="POST">
<fieldset>
<h2>User löschen</h2>
<p>Die E-Mail des Users eingeben, den Sie löschen möchten und dann auf "Löschen" klicken.</p>
<label for="deleteemail">E-Mail</label>
<select id="deleteemail" name="deleteemail">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT email FROM emailsheet";
$result = $conn->query($sqlur);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '<option value="' . $row['email']. '">' . $row['email']. '</option>';
    }
}
?>
</select>
<input id="btndelete" type="submit" value="Löschen">
</fieldset>
</form>
<form action="addnt.php" method="POST">
<fieldset>
<h2>User hinzufügen</h2>
<p>Die E-Mails und die Links des neuen Users eingeben. Woher Sie die Links bekommen, wird <a href="/content/anleitungform.html">hier</a> erklärt</p>
<label for="email">E-Mail</label>
<select id="email" name="email">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT user_id, email FROM androidlogin";
$result = $conn->query($sqlur);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '<option value="' . $row['email']. '">' . $row['email']. '</option>';
    }
}
?>
</select>
<label for="sheetlink">Sheet-Link</label>
<input id="sheetlink" type="text" name="sheetlink" required="required">
<label for="scriptlink">Script-Link</label>
<input id="scriptlink" type="text" name="scriptlink" required="required">
<input id="btnadd" type="submit" value="Hinzufügen">
</fieldset>
</form>
</div>
<hr/>
<h2>Userdatenbank</h2>
<strong>Jetziger Stand</strong>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT user_id, vorname, nachname, email, erstelldatum FROM androidlogin";
$result = $conn->query($sqlur);
echo '<table id="fromsql"> <tr> <th>User-ID</th><th>Vorname</th><th>Nachname</th><th>E-Mail</th><th>Passwort</th><th>Erstelldatum</th></tr>';
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["user_id"]. "</td><td>" . $row["vorname"]. "</td><td>" . $row["nachname"]. "</td><td>" . $row["email"]. "</td><td>verschlüsselt</td><td>" . $row["erstelldatum"]. "</td></tr>";
    }
}
echo "</table>";
?>
<div id="manager">
<form id="deleteformur" onsubmit="return confirm('Möchten Sie wirklich diesen Eintrag löschen? Dieser Vorgang kann nicht rückgängig gemacht werden.')" action="deleteur.php" method="POST">
<fieldset>
<h2>User löschen</h2>
<p>Die E-Mail des Users wählen, den Sie löschen möchten und dann auf "Löschen" klicken.</p>
<label for="deleteemailur">E-Mail</label>
<select id="deleteemailur" name="deleteemail">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT email FROM androidlogin";
$result = $conn->query($sqlur);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '<option value="' . $row['email']. '">' . $row['email']. '</option>';
    }
}
?>
</select>
<input id="btndeleteur" type="submit" value="Löschen">
</fieldset>
</form>
<form action="addur.php" method="POST">
<fieldset>
<h2>User hinzufügen</h2>
<p>Hier können Sie die Zugangsdaten des neuen Users eingeben</p>
<label for="vorname">Vorname</label>
<input id="vorname" type="text" name="vorname" required="required">
<label for="nachname">Nachname</label>
<input id="nachname" type="text" name="nachname" required="required">
<label for="emailur">E-Mail</label>
<input id="emailur" type="email" name="email" required="required">
<label for="password">Passwort</label>
<input id="password" type="password" name="password" required="required">
<input id="btnaddur" type="submit" value="Hinzufügen">
</fieldset>
</form>
<form action="editur.php" method="POST">
<fieldset>
<h2>Feld bearbeiten</h2>
<p>Hier können Sie ein Feld gezielt verändern</p>
<label for="dropdown">Spaltenname</label>
<select id="dropdown" name="dropdown">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<option value="vorname">Vorname</option>
<option value="nachname">Nachname</option>
<option value="email">E-Mail</option>
</select>
<label for="selectid">User wählen</label>
<select id="selectid" name="id">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT user_id, email FROM androidlogin";
$result = $conn->query($sqlur);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '<option value="' . $row['user_id']. '">' . $row['email']. '</option>';
    }
}
?>
</select>
<label for="newval">Neuer Wert</label>
<input id="newval" type="text" name="newval" required="required">
<input id="btnchng" type="submit" value="Ändern">
</fieldset>
</form>
<form action="chngpwd.php" method="POST">
<fieldset>
<h2>Passwort ändern</h2>
<p>Hier können Sie das Passwort eines Benutzers ändern</p>
<label for="dropdownid1">User</label>
<select id="dropdownid1" name="dropdownid">
<option value="plsselect" disabled="disabled" selected="selected">Bitte auswählen</option>
<?php
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen " . $conn->connect_error);
}

$sqlur = "SELECT user_id, email FROM androidlogin";
$result = $conn->query($sqlur);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '<option value="' . $row['user_id']. '">' . $row['email']. '</option>';
    }
}
$conn->close();
?>
</select>
<label for="newpw">Neues Passwort</label>
<input id="newpw" type="password" name="newpw" required="required">
<input id="btnchngpwd" type="submit" value="Ändern">
</fieldset>
</form>
</div>
</main>
    <script src="script.js"></script>
</body>
</html>