<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"></link>
</head>
<body>
<form action ="${pageContext.request.contextPath}/Login" method = "post" id="info">


	<input type ="hidden" name = "role" value="${role}" />

<table >	
<tr>
	<td>ID: </td>
	<td><input type ="text" name="id"></td>
</tr>
<tr>
	<td>Password: </td>
	<td><input type ="text" name="password"></td>
</tr>	
	<tr>
	<td><button type="submit">Login</button><td>
	<tr>
</table>
</form>
</body>
</html>