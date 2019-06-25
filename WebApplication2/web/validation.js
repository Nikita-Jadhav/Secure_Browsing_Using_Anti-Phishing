function formValidation()
{
var uid=document.registration.userid;
var passid=document.registration.password;
var uname=document.registration.username;
  
var uemail = document.registration.email;  

if(userid_validation(uid,5,12))
 {
 if(password_validation(passid,7,12))
  {
  if(username_validation(uname))
   {
   
    if(countryselect(ucountry))
     {
     
      if(ValidateEmail(uemail))
       {
       
       }
     }     
    } 
   }
  }
 
alert('Form successfully submitted');  
return true;
}

function userid_validation(uid,mx,my)
	{
	var uid_len=uid.value.length;
	if(uid_len==0 || uid_len>my || uid_len<mx)
		{
		alert("User id should not be empty/ Length should be between "+mx+" to "+my);
		uid.focus();
		return false;
		}
	return true;
	}

function password_validation(passid,mx,my)
	{
	var passid_len=passid.value.length;
	if(passid_len==0 || passid_len > my || passid_len < mx)
		{
		alert("Password should not be empty/ Length should be between " +mx+ " to " +my);
		passid.focus();
		return false;
		}
	return true;
	}

function username_validation(uname)
	{
	var letters=/^[A-Z a-z]+$/;
	if(uname.value.match(letters))
		{
		return true;
		}
	else
		{
		alert("Name should contain Alphabets only");
		uname.focus();
		return false;
		}
	}



function ValidateEmail(uemail)  
	{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(uemail.value.match(mailformat))  
		{  
		return true;  
		}  
	else  
		{  
		alert("You have entered an invalid email address!");  
		uemail.focus();  
		return false;  
		}  
	}  

