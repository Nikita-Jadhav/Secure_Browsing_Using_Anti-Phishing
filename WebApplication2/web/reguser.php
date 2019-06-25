<a target="bottom" href="new3.html">Click here</a>
<?php

mysql_connect("localhost","root","");
mysql_select_db("auction");

$id=$_POST["userid"];
$lname=$_POST["username"];
$email =$_POST["email"];
$pwd =$_POST["password"];
$query ="insert into `reg`(id,lname,email,pwd) values('$id','$lname','$email','$pwd')";
mysql_query($query) or die(mysql_error());
echo "You have successfully registered!!";
mysql_close();
?>


