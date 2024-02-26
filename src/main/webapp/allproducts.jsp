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
	background-image: url("data:image/jpeg;base64,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");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<table align="center" border="2" cellpadding="40px">
<th><h2>ID</h2></th>
<th><h2>Name</h2></th>
<th><h2>Type</h2></th>
<th><h2>Cost</h2></th>
<th><h2>Update</h2></th>
<th><h2>Delete</h2></th>
<c:forEach var="product" items="${productslist}">
<tr><td><h2>${product.getId()}</h2></td>
<td><h2>${product.getName()}</h2></td>
<td><h2>${product.getType()}</h2></td>
<td><h2>${product.getCost()}</h2></td>
<td><h2><a href="update?id=${product.getId()}">Update</a></h2></td>
<td><h2><a href="delete?id=${product.getId()}">Delete</a></h2></td>
</tr>
</c:forEach>
</table>
</body>
</html>