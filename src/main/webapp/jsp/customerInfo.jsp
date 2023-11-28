<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CustomerInfo" method="post">
        <label for="Phone"> Phone :  : </label><br><br>
        <input type="tel" name="Phone" id="Phone"><br><br>
        <label for="Cin"> Cin :  : </label><br><br>
        <input type="text" name="Cin" id="Cin"><br><br>
        <label for="CardNumber"> Card :  : </label><br><br>
        <input type="number" name="CardNumber" id="CardNumber"><br><br>
        <label for="DateStart"> DateStart :  : </label><br><br>
        <input type="text" name="DateStart" id="DateStart"><br><br>
        <label for="DateEnd"> DateEnd :  : </label><br><br>
        <input type="text" name="DateEnd" id="DateEnd"><br><br>
        <input type="submit" value="verifier">
    </form>
</body>
</html>