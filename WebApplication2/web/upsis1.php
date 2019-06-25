<a target="bottom" href="new3.html">Click here</a>
<?php
mysql_connect("localhost","root","");
mysql_select_db("auction");
$query ="UPDATE `sister` SET `s_no`=`s_no`-1 WHERE `s_id`='110'";
mysql_query($query) or die(mysql_error());
echo "You have successfully updated!!";
mysql_close();
?>


