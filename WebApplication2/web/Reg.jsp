<%@ page import="java.util.Random;" %>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>New Page 1</title>
<script>
function si()
{
alert("hai")
var name=document.forms[0].p1.value;
var userid=document.forms[0].p2.value;
var password=document.forms[0].p31.value;
var male=document.forms[0].p4.value;
var contact=document.forms[0].p5.value;
 
if(name==""||userid==""||password==""||male==""||contact=="")
alert("Please Enter all fields")
else if(password.length<8)
alert("Password must greater than 7 Letter")
else
{
alert("correct")
document.forms[0].action="http://localhost:8080/WebApplication12/Reg";
document.forms[0].submit();
}

}
function hom()
{
document.forms[0].action="mainframe.html";
document.forms[0].submit();
}
</script>
</head>
<body background="image.jpg">
<div style="position: absolute; width: 100px; height: 100px; z-index: 4; left: 610px; top: 13px" id="layer7">
	<div style="position: absolute; width: 246px; height: 33px; z-index: 2; left: -317px; top: 104px" id="layer10">
		<div style="position: absolute; width: 100px; height: 27px; z-index: 1; left: -292px; top: -118px" id="layer11">
<input type=image src="logo.jpg" onclick="hom()"><br>
&nbsp;<p>&nbsp;</div>
		<u><font face="Book Antiqua" size="4" color="#008000">Registration Form</font></u></div>
	<input border="0" src="image/globe1.gif" name="I5" width="86" height="83" type="image"><div style="position: absolute; width: 100px; height: 19px; z-index: 1; left: 4px; top: 34px" id="layer8">
		<b><font face="French Script MT" color="#00FFFF" size="5">
		<marquee width="78">Hearts & Hugs</marquee></font></b></div>
	<p>&nbsp;</div>

<p>&nbsp;</p>
<p>
<%! String co; %>
<%
Random r=new Random();
String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";
char c=s.charAt(r.nextInt(60));
char c1=s.charAt(r.nextInt(60));
char c2=s.charAt(r.nextInt(60));
char c3=s.charAt(r.nextInt(60));
char c4=s.charAt(r.nextInt(60));
co=""+c+c1+c2+c3+c4;
%>
<!--<marquee behavior=slide bgcolor=#FFFFCC><font size=7 color=red face="Arial"><%=co%></font></marquee>
-->
</p>
<div style="position: absolute; width: 465px; height: 134px; z-index: 1; left: 165px; top: 15px" id="layer1">
	<div style="position: absolute; width: 195px; height: 21px; z-index: 1; left: 164px; top: 57px" id="layer5">
		<i><b><font color="#800000" face="Bodoni MT" size="2">Connecting People 
		Globally !</font></b></i></div>
	<blockquote>
		<h1 align="left"><b>
		&nbsp;<font size="7" face="Century Schoolbook" color="#800080">H</font><font size="7" face="French Script MT" color="#800080">earts & 
		Hugs </font></b></h1>
		<p align="left">&nbsp;</p>
	</blockquote>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<blockquote>
	<p>&nbsp;</p>
	
		<blockquote>
			<div style="position: absolute; width: 100px; height: 100px; z-index: 5; left: 56px; top: 118px" id="layer9">
				<input border="0" src="image/signup2.gif" name="I6" width="114" height="145" type="image"></div>
	<form method=post>		<blockquote>
				<blockquote>
					<blockquote>
						<pre><b><font color="#000080">Name</font></b>		   <font color="#008081"><input type=text name=p1></font><br>
<b><font color="#000080">UserName</font></b>	   <input type=text name=p2><br>
<b><font color="#000080">Password</font></b>	   <input type=password name=p31><br>
<b><font color="#000080">Gender</font></b>	   <input type=male name=p4><br>
        <b><font color="#000080">Contact</font></b>	   <input type=contact name=p5><br>
  
		     <input type=button onclick="si()" style="border:0px solid #FFFFFF; background-image: url('image/signup1.gif')" value="                    ">
</pre>
					</blockquote>
				</blockquote>
			</blockquote>
		</blockquote>
	</form>
</blockquote>
</body>

</html>