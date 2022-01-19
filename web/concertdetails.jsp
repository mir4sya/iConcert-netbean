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
        <title>iConcert Record</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/background.css">
        <nav>
         <ul>
           <li><a href = "homee.jsp">&#9900; Home</a></li>
           <li><a href = "addconcert.jsp">&#9900; Add Concert</a></li>
           <li><a href = "concertdetails.jsp">&#9900; Concert Details</a></li>
           <li><a href = "displayreport.jsp">&#9900; Report</a></li>
        </ul>
        </nav>
        <style>
            table, th, td {
              border: 1px solid #d8bfd8;
              border-collapse: collapse;
            }
            .button {
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
        
    </head>
    <body>
    <center>
        <!--fetch session attribute-->
         <% HttpSession sess = request.getSession(false); //use false to use the existing session
            String id = (String)sess.getAttribute("admin_id");
//            out.println(id);
        %>
        <div class="table"><br><br><br><br><br>
       <br><br><br><br><b><font face = "Arial" size = "6" color = "#d8bfd8">Concert Record</font></b>
        <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM APP.CONCERT 
        </sql:query>
            <table id="status"><br><br>
            <tr>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Username &nbsp; &nbsp;</font></th>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Email &nbsp; &nbsp;</font></th>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Concert Name &nbsp; &nbsp;</font></th>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Concert Date &nbsp; &nbsp;</font></th>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Concert Time &nbsp; &nbsp;</font></th>
                <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp; Update/Delete &nbsp; &nbsp;</font></th>
            </tr>
            
            <c:forEach var="column" items="${result.rows}">
            <tr>
                <td><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${column.admin_username}"/>&nbsp; &nbsp;</font></td><br>
                <td><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${column.admin_email}"/>&nbsp; &nbsp;</font></td>
                <td><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${column.concert_name}"/>&nbsp; &nbsp;</font></td>
                <td><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${column.concert_date}"/>&nbsp; &nbsp;</font></td>
                <td><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${column.concert_time}"/>&nbsp; &nbsp;</font></td>
                <c:set var="admin_username" value="${column.admin_username}"/>
                <td><button class="button button1" onclick="window.location.href='concertUpdate.jsp?id=${admin_username}';">Update</button>&nbsp
                    <button class="button button2" onclick="remove()">Delete</button></td>
            </tr>
            </c:forEach>
            <script>
                function remove(){
                   if (window.confirm("Do you want to delete this record?")) {
                        window.location.href = "delete.jsp?id=${admin_username}";
                    } else {
                        return false;
                    }
                }
            </script>
        </table>
        </div>
        <!--set session attribute-->
             <% HttpSession sessw = request.getSession(); 
                sessw.setAttribute("admin_id", id);%>
    </center>
    </body>
</html>