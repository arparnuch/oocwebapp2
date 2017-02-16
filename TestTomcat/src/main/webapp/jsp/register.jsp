<%--
  Created by IntelliJ IDEA.
  User: arparnuch
  Date: 2/13/2017 AD
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<title>Insert title here</title>--%>
</head>
<body>
<h1>Register Page</h1>
<form action="/register" method="post">
    Enter your username : <input type="text" name="username"> <BR>
    Enter your password : <input type="password" name="password"> <BR>
    Enter your firstname : <input type="text" name="firstname"> <BR>
    Enter your lastname : <input type="text" name="lastname"> <BR>
    Enter your email : <input type="text" name="email"> <BR>
    <input class="btn btn-success" type="submit" />
</form>
<a class="btn btn-primary" href="/userslists">Back</a>
</body>
</html>