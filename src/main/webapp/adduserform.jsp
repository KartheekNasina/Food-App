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
	background-image: url("data:image/jpeg;base64,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");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<form:form action="saveuser" modelAttribute="user">
<h1>Enter name:<form:input path="name"/></h1><br>
<h1>Enter email:<form:input path="email"/></h1><br>
<h1>Enter password:<form:input path="password"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>