<!-- A jsp to insert record through hibernate -->  
<%@ page import="com.javaProgram.hibernate.*,org.hibernate.*,org.hibernate.cfg.*" %>  
<%!  
int id;int price;String name; Session session1 = null;  
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
 
 <form action="ProductServlet" method="get" >
 		<label for="id">id:</label><br> <input type="text" id="id"
			name="id"><br>
 
		<label for="name">Name:</label><br> <input type="text" id="name"
			name="name"><br> 
		 <label for="price">Price:</label><br> <input type="number" id="price"
			name="price"><br>
		<br> <input type="submit" value="Submit"
			onclick="addproduct_onclick()">
	</form>

	<p style="text-align: center">
		<a href="index.html">Back to Home Page</a>
	</p>
  
</body>
</html>