<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyNFPh_cBUgwOtITaXByLzB_k-oyPrXA1FBQ&usqp=CAU");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<form:form action="saveitem" modelAttribute="item">
<h1>Name: <form:input path="name" readonly="true"/></h1><br>
<h1>Cost: <form:input path="cost" readonly="true"/></h1><br>
<h1>Quantity: <form:input path="quantity"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>