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

	$query = mysql_query("UPDATE sister SET s_no=s_no-1 WHERE s_id='110' AND s_price=700");
	echo "Succesful";
	mysqli_close($con);

}

if (mysqli_connect_errno()) 
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

if(isset($_POST['submit']))
{
	SignIn();
}
?>