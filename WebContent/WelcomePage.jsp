<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.UserDetails" %>
<% System.out.println("Inside WelcomPage "); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
            .round {
                border-radius: 50%;
                overflow: hidden;
                width: 150px;
                height: 150px;
            }
            .round img {
                display: block;
            /* Stretch 
                  height: 100%;
                  width: 100%; */
            min-width: 100%;
            min-height: 100%;
            }
        </style>
        
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <br> <br>
 <div class="round">
<img src="ImageServlet?username=<%=request.getAttribute("username")%>" width="600" height="200">
</div>
<% System.out.println("Inside WelcomPage 1"); %>
<br>  Welcome <%= request.getAttribute("username") %> 
<% UserDetails ud= (UserDetails)request.getAttribute("userdetails") ;%>
Your Details are As Follows :
<% System.out.println("Inside WelcomPage 2") ;%>
 Name :<%=request.getAttribute("username") %>
 <% System.out.println("Inside WelcomPage 3"); %>
 Address :<%= request.getAttribute("addr")%>
 Contact Number: <%=request.getAttribute("contactnum") %>

<h3>PROFESSIONAL DETAILS :</h3>
Company Name: <%= request.getAttribute("company")%>
Experience: <%= request.getAttribute("exp") %>
Skills: <%=request.getAttribute("skills") %>

<% %>
</body>
</html>