<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<sql:setDataSource var="myDatasource" 
driver="org.apache.derby.jdbc.ClientDriver" 
url="jdbc:derby://localhost:1527/ConcertDB" user="app" 
password="app"/>

<!DOCTYPE html>
<html>
    <head>
        <title>iConcert Update</title>
        <link rel="stylesheet" href="css/background.css">
        <style>
             table{}
              .btn {
               background: #b48395;
               width: 70px;
               height: 30px;
               border: 2px solid #b48395;
               border-radius: 5px;
               color: white;
               padding: 5px;
               cursor: pointer;
               margin: 12px 0;
               font-size: 12px;
            }
        </style>
        <script>
        function validate(){
            var name = document.update.newadmin_username.value;
            var email= document.update.newadmin_email.value;
            var concertname = document.update.newconcert_name.value;
            var concertdate = document.update.newconcert_date.value;
            var concerttime = document.update.newconcert_time.value;
                
            if(name== null || name==""){
                alert("Please enter your name!");
                return false;
            }else if(email==null || email==""){
                alert("Please enter your email!")
                return false;
            }else if(concertname==null || concertname==""){
                alert("Please choose concert name!");
                return false;
            }else if(concertdate==null || concertdate==""){
                alert("Please enter concert date!");
                return false;
            }else if(concerttime==null || concerttime==""){
                alert("Please enter concert time!");
                return false;
            }
        }
        </script>
    </head>
    <body>
    <center><br><br><br><br><br><br>
        <br><br>
        <c:set var="admin_username" value="${param.id}"/>
        <sql:query var="concert" dataSource="${myDatasource}">
            select* from concert where admin_username = ?
            <sql:param value="${admin_username}"/> 
        </sql:query> 
            <h1><font face = "Arial" color = "#d8bfd8">Update Information</font></h1>
            <br>
            <form action="/Concert/concertupdate" method="POST" name="update" id="update" onsubmit=" return validate()">
                <table>
                    <c:forEach var="row" items="${concert.rows}">
                    <tr>
                        <td><font face = "Arial" color = "#d8bfd8">Admin Username: </font></td>
                        <td><input type="text" name="newadmin_username" id="newadmin_username" value="<c:out value="${row.admin_username}"/>" style="color:grey" readonly></td>
                    </tr>
                    <tr>
                        <td><font face = "Arial" color = "#d8bfd8">Admin Email: </font></td>
                        <td><input type="text" name="newadmin_email" id="newadmin_email" value="<c:out value="${row.admin_email}"/>" style="color:grey" readonly></td>
                    </tr>
                    <tr>
                        <td><font face = "Arial" color = "#d8bfd8">Concert name: </font></td>
                        <td><input type="text" name="newconcert_name" id="newconcert_name" value="<c:out value="${row.concert_name}"/>"></td>
                    </tr>
                    <tr>
                        <td><font face = "Arial" color = "#d8bfd8">Concert date: </font></td>
                        <td><input type="text" name="newconcert_date" id="newconcert_date" value="<c:out value="${row.concert_date}"/>"></td>
                    </tr>
                    <tr>
                        <td><font face = "Arial" color = "#d8bfd8">Concert time: </font></td>
                        <td><input type="text" name="newconcert_time" id="newconcert_time" value="<c:out value="${row.concert_time}"/>"></td>
                    </tr</font>
                    <tr><td><br><input type="submit" value="Update" class="btn"></td></tr>
                    </c:forEach>
                </table>
            </form>
        </div>
      </center>
    </body>
</html>

