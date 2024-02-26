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
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRThvR9W33V29f7PiqABWCp3Gl09jAMKzd-TQ&usqp=CAU");
	background-size:cover;
	color: black;
}
</style>
</head>
<body>
<form:form action="savefoodorder" modelAttribute="foodorder">
<h1>Enter Name:<form:input path="name"/></h1><br>
<h1>Enter Mobile number:<form:input path="mobilenumber"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>