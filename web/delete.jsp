<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<sql:setDataSource var="myDatasource" 
driver="org.apache.derby.jdbc.ClientDriver" 
url="jdbc:derby://localhost:1527/ConcertDB" user="app" 
password="app"/>

<html>
    <head>
        <title>Delete Concert Record</title>
    </head>
    <body>
        <c:set var="admin_username" value="${param.id}"/>
        <%--<c:out value="${donor_ic}"/>--%>
        <sql:update var="concert" dataSource="${myDatasource}">
            delete from concert where admin_username = ?
            <sql:param value="${admin_username}"/> 
        </sql:update> 
        <script>    
            success();
            function success(){
                alert("Successfully delete record!");
                window.location.href = "concertdetails.jsp";
            }
        </script>
    </body>
</html>
 
