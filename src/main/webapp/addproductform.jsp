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
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwd8W6y78iSAfF4UYShiZcBNgXcZ8tOkm2ig&usqp=CAU");
	background-size:cover;
	color: white;
}
</style>
</head>
<body>
<form:form action="saveproduct" modelAttribute="product">
<h1>Enter name:<form:input path="name"/></h1><br>
<h1>Enter type:<form:input path="type"/></h1><br>
<h1>Enter cost:<form:input path="cost"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>