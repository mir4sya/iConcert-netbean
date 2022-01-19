<%-- 
    Document   : adminLogin
    Created on : Aug 2, 2021, 12:58:54 AM
    Author     : Amirah Hasya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Sign in</title>
  <link rel="stylesheet" href="css/login.css">
  <script>
            function validate(){
                var username = document.adminlogin.admin_username.value;
                var pass = document.adminlogin.admin_password.value;
                
                if(username==null || username==""){
                    alert("Please enter your username!");
                    return false;
                }else if(pass==null || pass==""){
                    alert("Please enter your password!");
                    return false;
                }
            }
  </script>
</head>
<body>
<form method="POST" action="/Concert/adminlogin" name="adminlogin" id="adminlogin" onsubmit="return validate()">
<div class="login-box">
  <center>Admin</center>
  <center>
    <div class="textbox">
      <input type="text" placeholder="Username" name="admin_username" id="admin_username">
    </div>
     <div class="textbox">
      <input type="password" placeholder="Password" name="admin_password" id="admin_password">
    </div>
      <input class="btn" type="submit" name="submit" value="Sign in">
      <br><a href="adminregistration.html" target="_blank"><font face = "Arial" size = "2" color = "white">Sign up if you don't have any account</a></font><br>
  </center>
</div>
</form>
</body>
</html>