<?php

mysql_connect("localhost","root","");
mysql_select_db("auction");

$id=$_POST["id"];
$lname=$_POST["lname"];
$address=$_POST["address"];
$email =$_POST["email"];
$pwd =$_POST["pwd"];
$contact=$_POST["contact"];
$query ="insert into `register`(id,lname,address,email,pwd,contact) values('$id','$lname','$address','$email','$pwd','$contact')";
mysql_query($query) or die(mysql_error());
echo "You have successfully registered!!";
mysql_close();
?>

