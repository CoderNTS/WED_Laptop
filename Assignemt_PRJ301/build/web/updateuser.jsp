<%-- 
    Document   : updateuser
    Created on : Mar 11, 2023, 9:55:23 PM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update User</h1>
        <c:set var="c" value="${requestScope.userById}"/>
        <form action="updateuser" method="POST">
            ID: <input type="text" value="${c.id}" readonly name="id" /><br/>
            Enter Username; <input type="text" name="username" value="${c.username}"> <br/>
            Enter Password; <input type="text" name="password" value="${c.password}"><br/>
            Enter Nickname; <input type="text" name="nickname" value="${c.nickname}"><br/>
            Enter Email; <input type="text" name="email" value="${c.email}"><br/>
            Enter Phone Number; <input type="text" name="phone_number" value="${c.phone_number}"><br/>
            Enter Address; <input type="text" name="address" value="${c.address}"><br/>
            Enter Role; <input type="text" name="roleId" value="${c.roleId}"><br/>
            <input type="submit" value="SAVE">
        </form>
    </body>
</html>
