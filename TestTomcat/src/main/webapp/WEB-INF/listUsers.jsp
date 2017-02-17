<%--
  Created by IntelliJ IDEA.
  User: arparnuch
  Date: 2/15/2017 AD
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<html>
<head>
    <title>UserList</title>
</head>
<body>
<h1>Users List</h1>
<h2>Welcome ${notallowuser.username} !!</h2>
<h3>Your profile : </h3>
<h4>Firstname : ${notallowuser.firstname}</h4>
<h4>Lastname : ${notallowuser.lastname}</h4>
<h4>Email : ${notallowuser.email}</h4>
<table class="table table-striped\">
    <thead>
    <tr>
        <td>Username</td>
        <td>First name</td>
        <td>Last name</td>
        <td>E-mail</td>
        <td></td>
        <td></td>
    </tr>
    </thead>

    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.username}</td>
            <td>${u.firstname}</td>
            <td>${u.lastname}</td>
            <td>${u.email}</td>
            <c:choose>
                <c:when test="${u.username!=notallowuser.username}">
                    <td><a class="btn btn-danger" href="/deleteusers?username=${u.username}">Delete</a></td>
                </c:when>
                <c:otherwise>
                    <td><p>NOT ALLOW!</p></td>
                </c:otherwise>
            </c:choose>
            <td>

            <td><a class="btn btn-warning" href="/edit?username=${u.username}&amp;password=${u.password}&amp;firstname=${u.firstname}&amp;lastname=${u.lastname}&amp;email=${u.email}">Edit</a></td>

            </td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-success" href="/register">Add</a>
<form action="/userslists" method="post">
    <input class="btn btn-danger" type="submit" name="logout" value="Logout"/>
</form>

</body>
</html>
