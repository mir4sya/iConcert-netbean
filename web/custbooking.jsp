<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Booking ticket</title>
  <link rel="stylesheet" href="css/bookinguser.css">
  <nav>
    <ul>
      <li><a href = "home.jsp">&#9900 Home</a></li>
      <li><a href = "section.html">&#9900; Section</a></li>
      <li><a href = "custbooking.jsp">&#9900; Booking</a></li>
    </ul>
  </nav>
  <script>
        function validate(){
            var username = document.custConcert.cust_username.value;
            var phoneno = document.custConcert.cust_phoneno.value;
            var confirm = document.custConcert.confirm.value;
            var section = document.custConcert.cust_section.value;
            var quantity = document.custConcert.cust_quantity.value;
                
            if(username == null || username==""){
                alert("Please enter your name!");
                return false;
            }else if(phoneno==null || phoneno==""){
                alert("Please enter your password!");
                return false;
            }else if(confirm==null || confirm==""){
                alert("Please enter confirmation phone no!");
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
<form method="POST" action="/Concert/bookinguser" name="custConcert" id="custConcert" onsubmit="return validate()">
  <center>Booking Concert Ticket</center>
  <center>
    <div class="textbox">
      <input type="text" placeholder="Username" name="cust_username" id="cust_username" >
    </div>
     <div class="textbox">
      <input type="text" placeholder="Phone no" name="cust_phoneno" id="cust_phoneno">
    </div>
    <div class="textbox">
      <input type="text" placeholder="Re-enter phone no" name="confirm" id="confirm" >
    </div>
    <div class="textbox">
      <input type="text" placeholder="Section A/B/C" name="cust_section" id="cust_section">
    </div>
    <div class="textbox">
      <input type="text" placeholder="Quantity" name="cust_quantity" id="cust_quantity">
    </div>
    <input class="btn" type="submit" name="submit" value="Confirm">
  </center>
</form>
</div>
</body>
</html>