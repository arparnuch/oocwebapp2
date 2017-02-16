<%--
  Created by IntelliJ IDEA.
  User: arparnuch
  Date: 2/15/2017 AD
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<html>
<head>
    <title>Delete user page</title>
</head>
<body>
<h1>Delete User page</h1>
<h3>Are you sure to delete this user ?</h3>
<h2>User you want to delete is : ${u}</h2>

<form action="/userslists" method="get">
    <input class="btn btn-primary" type="submit" name="back" value="cancel"/>
</form>

<form action="/deleteusers" method="post">
    <input class="btn btn-success" type="submit" name="ok" value="OK"/>
</form>



</body>
</html>
