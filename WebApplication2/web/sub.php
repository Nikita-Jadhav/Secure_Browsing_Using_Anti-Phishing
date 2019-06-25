
<?php




mysql_connect("localhost","root","") or die(mysql_error());
echo "Connection to the server was successful!";
$dbase_name="registration";
mysql_select_db($dbase_name) or die(mysql_error());
echo "Database is selected";
$query="insert into `reg`(userid,password,username,email) values('$_POST["userid"]','$_POST["password"]','$_POST["username"]','$_POST["email"]')";
mysql_query($query) or die(mysql_error());
echo "Data Successfully inserted";
mysql_close();
?>
