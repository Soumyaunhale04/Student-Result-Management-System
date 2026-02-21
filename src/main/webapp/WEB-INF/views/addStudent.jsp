<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action= "${pageContext.request.contextPath}/AddStudent">
	Roll no: <input type="text" name="rollno"/>
	Name: <input type ="text" name="name"/>
	Branch: <input type="text" name="branch"/>
	Semester: <input type="text" name="semester"/>
	Password: <input type="password" name = "password"/>
	<input type="submit">
</form>
</body>
</html>