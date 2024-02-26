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
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYlbjgwxq1x-8ZTlF8_3KbuKW5yVDAIYfagw&usqp=CAU");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<form:form action="validateuser" modelAttribute="user">
<h1>Enter email:<form:input path="email"/></h1><br>
<h1>Enter password:<form:input path="password"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>