<%-- 
    Document   : custLogin
    Created on : Jul 30, 2021, 11:19:45 PM
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
                var username = document.custLogin.cust_username.value;
                var pass = document.custLogin.cust_password.value;
                
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
<form method="POST" action="/Concert/custlogin" name="custLogin" id="custLogin" onsubmit="return validate()">
<div class="login-box">
  <center>Customer</center>
  <center>
    <div class="textbox">
      <input type="text" placeholder="Username" name="cust_username" id="cust_username">
    </div>
     <div class="textbox">
      <input type="password" placeholder="Password" name="cust_password" id="cust_password">
    </div>
      <input class="btn" type="submit" name="submit" value="Sign in">
      <br><a href="registration.html" target="_blank"><font face = "Arial" size = "2" color = "white">Sign up if you don't have any account</a></font><br>
  </center>
</div>
</form>
</body>
</html>