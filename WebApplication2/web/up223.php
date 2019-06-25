<a target="bottom" href="new3.html">Click here</a>
<?php
mysql_connect("localhost","root","");
mysql_select_db("auction");
$query ="UPDATE `brother` SET `b_no`=`b_no`-1 WHERE `b_id`='211'";
mysql_query($query) or die(mysql_error());
echo "You have successfully updated!!";
mysql_close();
?>


