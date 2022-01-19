<%-- 
    Document   : addconcert.jsp
    Created on : Aug 3, 2021, 12:33:46 PM
    Author     : Amirah Hasya
--%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Add new concert</title>
  <link rel="stylesheet" href="css/bookinguser.css">
  <nav>
    <ul>
      <li><a href = "homee.jsp">&#9900; Home</a></li>
      <li><a href = "addconcert.jsp">&#9900; Add Concert</a></li>
       <li><a href = "concertdetails.jsp">&#9900; Concert Details</a></li>
      <li><a href = "displayreport.jsp">&#9900; Report</a></li>
    </ul>
  </nav>
  <script>
        function validate(){
            var username = document.iconcert.admin_username.value;
            var email = document.iconcert.admin_email.value;
            var confirm = document.iconcert.confirm.value;
            var concertname = document.iconcert.concert_name.value;
            var concertdate = document.iconcert.concert_date.value;
            var concerttime = document.iconcert.concert_time.value;
                
            if(username == null || username==""){
                alert("Please enter your name!");
                return false;
            }else if(email==null || email==""){
                alert("Please enter your password!");
                return false;
            }else if(confirm==null || confirm==""){
                alert("Please enter confirmation email!");
                return false;
            }else if(section==null || section==""){
                alert("Please enter your section!")
                return false;
            }else if(quantity==null || quantity==""){
                alert("Please enter your quantity!")
                return false;
        }
    </script>
</head>
<body>
<div class="booking-box">
<form method="POST" action="/Concert/addconcert" name="iconcert" id="iconcert" onsubmit="return validate()">
  <center>Book New Concert</center>
  <center>
    <div class="textbox">
      <input type="text" placeholder="Username" name="admin_username" id="admin_username" >
    </div>
     <div class="textbox">
      <input type="text" placeholder="Email" name="admin_email" id="admin_email">
    </div>
    <div class="textbox">
      <input type="text" placeholder="Re-enter email" name="confirm" id="confirm" >
    </div>
    <div class="textbox">
      <input type="text" placeholder="Concert name" name="concert_name" id="concert_name">
    </div>
    <div class="textbox">
      <input type="text" placeholder="Date: x/x/xxxx" name="concert_date" id="concert_date">
    </div>
    <div class="textbox">
      <input type="text" placeholder="Time: 0000pm - 0000pm" name="concert_time" id="concert_time">
    </div>
      <br><input class="btn" type="submit" name="submit" value="Confirm">
  </center>
</form>
</div>
</body>
</html>
