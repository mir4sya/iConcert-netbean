<%-- 
    Document   : displayreport
    Created on : Aug 3, 2021, 10:10:25 AM
    Author     : Amirah Hasya
--%>

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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Report iConcert</title>
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
    </style> 
    </head>
    <body>
    <center><br><br><br><br><br><br>
        <br><br><h1><font face = "Arial" color = "#d8bfd8"> Report :</font></h1>
    <sql:query var="result" dataSource="${myDatasource}">
        SELECT *  FROM REPORT
    </sql:query>
    
    <table border="1">
        <!-- column headers -->
        <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><font face = "Arial" color = "#d8bfd8">&nbsp; &nbsp;<c:out value="${columnName}"/>&nbsp; &nbsp;</font></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
        <c:forEach var="column" items="${row}">
            <td><font face = "Arial" color = "#d8bfd8"><c:out value="${column}"/>&nbsp; &nbsp;</font></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
    </center>
    </body>
</html>

