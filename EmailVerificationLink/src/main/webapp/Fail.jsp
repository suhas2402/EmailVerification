<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="Login.jsp" />
	<%    out.println("<h2 style='text-align:center; color: red'>"+"Invalid Credentials"+"</h2>"); %>



</body>
</html>