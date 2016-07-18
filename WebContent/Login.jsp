<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function validate()
{
	
	var iduid=document.getElementById("username");
	var val=iduid.value;
	
	//alert(iduid);
 	
	if(val==null || val=="" )
	{ 
		alert("Please enter the username");
	     return false;
	}else
     {  return true;} 
}
function open()
{
	alert('hregd')
	//window.location.replace("Register.jsp");
	window.open("Register.jsp");
	}
</script>



</head>
<body>

<div style="width: 100%;">
   <div style="float:left; width: 50%">
 <%@ include file="Header.jsp" %>   
<form action="LoginServlet" method="post">
<br>
<br>
UserName: <input type="text" name="username" id="username"> 
<br>
<br>

Password: <input type="password" name="pwd" id="pwd"> 

<br>
<input type="submit" onclick="return validate()"></input>
</form>
   
   
   </div>
   
   
   <div style="float:right;">

      <br>
      <br>
                                      NEW USERRR ??
      <form name="rform" action="Register.jsp">
      <input type="submit" ></input>                               
       </form>                                     
                                      
                                      
   </div>
</div>
<div style="clear:both"></div>

</body>
</html>












