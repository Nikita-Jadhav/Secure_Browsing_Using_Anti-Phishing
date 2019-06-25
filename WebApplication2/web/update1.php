<?php
$con=mysqli_connect("127.0.0.1","root","");
// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

mysqli_query($con,"UPDATE `sister` SET `s_no`=`s_no`-1
WHERE `s_id`='110'");
echo "successful";

mysqli_close($con);
?>