
<?php

if(isset($_POST['submit']))
{
	$username = mysql_real_escape_string($_POST['username']);
	$username = mysql_real_escape_string($_POST['pass1']);
	$password = mysql_real_escape_string($_POST['pass']);
	$email = mysql_real_escape_string($_POST['email']);
	if($username && $pass && $pass1 && $email)
	{
		if($pass==$pass1)
		{
			$connect = mysql_connect("localhost","root","");
			mysql_select_db("auction");
			$query = mysql_query("INSERT INTO reg VALUES('$username','$pass','$email');");
			echo "You have registered.";		
		}
		else
		{
			echo "Password must match";
		}
	}
	else
	{
		echo "All fields are required.";
	}
}

?>