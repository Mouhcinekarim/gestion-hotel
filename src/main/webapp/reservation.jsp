<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>JustTable</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    
</head>

<body>
    <div class="container" style="width: 1098px;">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th style="text-align: center;">Votre Id</th>
                        <th style="text-align: center;">Date Début</th>
                        <th style="text-align: center;">Date Fin</th>
                        <th style="text-align: center;">Editer</th>
                        <th style="text-align: center;">Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${customers} " var="Customers" >
                             <tr>
                        <td style="text-align: center;font-size: 21px;"><c:out value="${ Customers.getIdCustomer()} "></c:out> </td>
                        <td style="text-align: center;font-size: 21px;"> ${ Customers.getDateStart()} </td>
                        <td style="text-align: center;font-size: 21px;"> ${ Customers.getDateEnd()} </td>
                        <td style="text-align: center;"><a class="btn btn-primary" href="ModifierDate" role="button" style="color: var(--bs-white);background: var(--bs-green);font-size: 5px;"><i class="fa fa-pencil-square-o" style="font-size: 25px;"></i></a></td>
                        <td style="text-align: center;"><a class="btn btn-primary" href="SupprimerCustomer" role="button" style="color: var(--bs-white);background: var(--bs-danger);font-size: 8px;"><i class="fa fa-trash" style="font-size: 25px;"></i></a></td>
                             </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
 