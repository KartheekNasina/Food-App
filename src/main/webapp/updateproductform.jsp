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
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6EZVj_w7hJZXejWK7o_PPyouVSDKflyAIhA&usqp=CAU");
	background-size:cover;
	color: Black;
}
</style>
</head>
<body>
<form:form action="updateproduct" modelAttribute="productinfo">
<h1>Enter ID:<form:input path="id" readonly="true"/></h1><br>
<h1>Enter Name:<form:input path="name"/></h1><br>
<h1>Enter Type:<form:input path="type"/></h1><br>
<h1>Enter Cost:<form:input path="cost"/></h1><br>
<input type="submit">
</form:form>
</body>
</html>