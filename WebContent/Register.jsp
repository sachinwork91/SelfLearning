<!DOCTYPE html>
<html>
<head>

<style>
input[type=text] {
    width: 40%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: none;
    background-color: #3CBC8D;
    color: white;
}
input[type=button]{
    color:#08233e;
    font:2.4em Futura, 'Century Gothic', AppleGothic, sans-serif;
    font-size:70%;
    cursor:pointer;
 }
 input[type=button]:hover {
    background-color:rgba(255,204,0,0.8);
}
</style>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("#va").show();
        $("#professional").hide();
    });
    $("#show").click(function(){
        $("#professional").show();
        $("#va").hide();    
    });
});
</script>
</head>
<body>
<center>
        <h1>File Upload to Database Demo</h1>
        <form method="post" action="uploadServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" size="50"/></td>
                </tr>
                <tr>
                    <td>Portrait Photo: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td> Password : </td>
                    <td><input type="password" name="password" size="50"/>
                    </td>
                </tr>
            
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            
            </table>
       </center>
       

 	
<p >Enter your Personal Details </p>
<div id="va">
<input type="text" value="address" name="addr" id="addr">
<input type="text" value="contact Number" name="contactnum" id="contactnum">
<input type="text" value="Emailid"  name="email" id="email">
<div id="professional">
<p >Enter your Personal Details </p>
<input type="text" value="Company" name="company" id="company">
<input type="text" value="Experience" name="experience" id="experience">
<input type="text" value="Skills" name="skills" id="skills">
</div>

<button id="hide" onclick="return false" >Hide</button>
<button id="show" onclick="return false">Show</button>
 <input type="submit" value="SAVE MY DETAILS">
 </form>
       
</body>
</html>
