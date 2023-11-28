<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
</head>
<body>
	
    <form action="reservation.html" id="form" method="post">
    
    	<label for="IdCustomer"> Votre Id : </label> <input type="number" name="id" id="id" value="<%= request.getParameter("cin") %>" disabled><br><br>
        <label for="date1"> Date D�but : </label> <br><br> <input type="date" name="date1" id="date1"><br><br>
        <label for="date2"> Date End : </label> <br><br> <input type="date" name="date2" id="date2"><br><br>        
        <button type="submit" class="33333333333333333333333333btn btn-dark">Modifier</button>
        
    </form>
    <script type="text/javascript">
    var id=document.getElementById("id");
    var date1=document.getElementById("date1");
    var date2=document.getElementById("date2");
    var btn=document.getElementById("form");
    btn.addEventListener("submit",function supp(obj1,){
    	console.log("cin"+obj1);
    	var hr= new XMLHttpRequest();
    	var lien="http://localhost:8080/GestionHotliere/ModifierDate";
    	hr.onreadystatechange=writeContent;
    	hr.open("POST",lien);
    	hr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     // console.log("cus="+JSON.stringify(obj2)+"&res="+JSON.stringify(obj1)+""+obj3);
     //console.log(JSON.stringify(obj1));
    	hr.send("id="+id.value+"&date1="+date1.value+"&date2="+date2.value);
    	function writeContent(){
    		if(hr.readyState==4){
    	           if(hr.status==200){
                   
    	               console.log(hr.responseText);
    	               console.log("tout pass bient 2");
    	            
    	        	 // table_objet(list);
    	               }
    	           else{
    	        	   console.log(hr.responseText);
    	        	  
    	        	   console.log(" 2 errr1");
    	               }
    			}
    		else{
    			console.log(hr.status);
    	console.log(hr.status);
    			}
    			}
    		  
    }  )





    
    function supp(obj1,){
    	console.log("cin"+obj1);
    	var hr= new XMLHttpRequest();
    	var lien="http://localhost:8080/GestionHotliere/ModifierDate";
    	hr.onreadystatechange=writeContent;
    	hr.open("POST",lien);
    	hr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     // console.log("cus="+JSON.stringify(obj2)+"&res="+JSON.stringify(obj1)+""+obj3);
     //console.log(JSON.stringify(obj1));
    	hr.send("id="+obj1);
    	function writeContent(){
    		if(hr.readyState==4){
    	           if(hr.status==200){
                   
    	               console.log(hr.responseText);
    	               console.log("tout pass bient 2");
    	               
    	        	 
    	               }
    	           else{
    	        	   //console.log(hr.responseText);
    	        	  
    	        	   console.log(" 2 errr1");
    	               }
    			}
    		else{
    			//console.log(hr.status);
    	console.log(hr.status);
    			}
    			}
    		  
    }   



    </script>
</body>
</html>