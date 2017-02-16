<%--
  Created by IntelliJ IDEA.
  User: arparnuch
  Date: 2/16/2017 AD
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<html>
<head>
    <title>Edit User info</title>
</head>
<body>
<h1>Edit Page </h1>
<h2>Selected User : ${u}</h2>
<form action="/edit" method="post">
    <input type="hidden" name="username" value="${u}"> <BR>
    Enter password : <input type="password" name="password" value="${p}"> <BR>
    Enter firstname : <input type="text" name="firstname" value="${f}"> <BR>
    Enter lastname : <input type="text" name="lastname" value="${l}"> <BR>
    Enter email : <input type="text" name="email" value="${e}"> <BR>
    <input class="btn btn-success" type="submit" name="" value="Submit"/>
</form>
<a class="btn btn-primary" href="/userslists">Back</a>
</body>
</html>
