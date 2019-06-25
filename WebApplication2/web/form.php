<html>
<style>
div.transbox {
    width: 700px;
    height: 400px;
    margin: 0px 20px;
    background-color: #ffffff;
    border: 1px solid black;
    opacity: 0.7;
    filter: alpha(opacity=10); /* For IE8 and earlier */
}

div.transbox p {
    margin: 0px 20px;
    font-weight: bold;
    color: #000000;
}
body{
background-image:url("PREG.jpg");
background-size: 100% 100%;
position:absolute;}
</style>
<body>


<?php


mysql_connect("localhost","root","") or die(mysql_error());

$dbase_name="registration";
mysql_select_db($dbase_name) or die(mysql_error());

 $fname = $_POST["fname"];
 $mname = $_POST["mname"];
 $sname =$_POST["sname"];
 $gname =$_POST["gname"];
 $address =$_POST["address"];

 $phno = $_POST["phno"];
 $contno = $_POST["contno"];
   $email = $_POST["email"];
   $comment = $_POST["comment"];
   
   $wgt = $_POST["wgt"];
   $height = $_POST["height"];
 $batch= $_POST["batch"];





$query="INSERT INTO `reg` values('$fname','$mname','$sname','$address','$phno','$email','$gname','$contno','$height','$wgt','$batch','$comment')";
mysql_query($query) or die(mysql_error());
echo "<h2>Your Input:</h2>";
echo $fname;
echo "<br>";
echo $address;
echo "<br>";
echo $phno;
echo "<br>";
echo $email;
echo "<br>";
echo $batch;
echo "<br>";

echo $comment;

  

mysql_close();
?>
<div class="navBox">
<div class="transbox">

<h1>You have registered successfully!!</h1>
<h4>Kindly keep checking your mailbox for further updates and details.Thank You</h4></div>
</body>
</html>
