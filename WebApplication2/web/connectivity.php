<?php
define('DB_HOST', 'localhost');
define('DB_NAME', 'auction');
define('DB_USER','root');
define('DB_PASSWORD','');

$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: " . mysql_error());
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error());

function SignIn()
{
session_start();   
if(!empty($_POST['userid']))   
{
	$query = mysql_query("SELECT *  FROM reg where id = '$_POST[userid]' AND pwd = '$_POST[password]'") or die(mysql_error());
	$row = mysql_fetch_array($query) or die(mysql_error());
	if(!empty($row['id']) AND !empty($row['pwd']))
	{
		$_SESSION['id'] = $row['pwd'];
		echo "SUCCESSFULLY LOGIN TO USER PROFILE PAGE...";

	}
	else
	{
		echo "SORRY... YOU ENTERD WRONG ID AND PASSWORD... PLEASE RETRY...";
	}
}
}
if(isset($_POST['submit']))
{
	SignIn();
}

?>


