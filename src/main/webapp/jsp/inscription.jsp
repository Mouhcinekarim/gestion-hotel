<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Inscription" method="post">
        <label for="UserName"> UserName : </label> <br><br>
        <input type="text" name="UserName" id="UserName"><br><br>
        <label for="Password"> Password : </label><br><br>
        <input type="password" name="Password" id="Password"><br><br>
        <label for="Email"> Email : </label><br><br>
        <input type="email" name="Email" id="Email"><br><br>
        <input type="submit" value="sign up">
    </form>
</body>
</html>