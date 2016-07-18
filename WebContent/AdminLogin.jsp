<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


WELCOME : <%= session.getAttribute("WelcomeName")  %>
<br>
User Id: <input type="text" id="searchid">
<input type="button" onclick="getdetails" value="search">
<div id="table"></div>

<input type="button" onclick=window.open("\adduser.jsp") value="Add">
<img src="ImageServlet?imgid=<%=session.getAttribute("user_name")%>" width="600" height="200"></body>
</html>