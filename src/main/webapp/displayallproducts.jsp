<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIRKz7jlJuoTPjjCys1CHcvcr9NoywDeDCog&usqp=CAU");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<table align="center" border="2" cellpadding="30px">
<th><h2>ID</h2></th>
<th><h2>Name</h2></th>
<th><h2>Type</h2></th>
<th><h2>Cost</h2></th>
<th><h2>Add</h2></th>
<c:forEach var="product" items="${productslist}">
<tr><td><h2>${product.getId()}</h2></td>
<td><h2>${product.getName()}</h2></td>
<td><h2>${product.getType()}</h2></td>
<td><h2>${product.getCost()}</h2></td>
<td><h2><a href="additem?id=${product.getId()}">Add</a></h2></td>
</tr>
</c:forEach>
</table>
<h2 align="center"><a href="savefoodorders">Submit</a></h2><br>
<h2 align="center"><a href="useroptions.jsp ">Back</a></h2><br>
</body>
</html>