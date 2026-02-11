<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link><link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"></link>
</head>
<body>
	<div id="container">
	
	<div id="header">
	<h1>Student Result Management System</h1>
	</div>
	
	<div id="content">
		<div id = "admin" class="card">
		<div class="card-title"><p>Admin</p></div>
		
		<div >
		<a href = "${pageContext.request.contextPath}/Login?role=admin">
		<button class="card-action">Login</button>
		</a>
		</div>
		</div>
		<div id ="student" class="card">
		<div class="card-title"><p>Student</p></div>
		
		<div >
		<a href = "${pageContext.request.contextPath}/Login?role=student">
		<button class="card-action">Login</button>
		</a>
		</div>
		</div>
	</div>
	<div id="footer">
	
	<div>Contact Us</div>
	<div>Email: example123@gmail.com</div>
	<div>Address: Flat no. 123 near colony</div>
	</div>
	
	</div>
</body>
</html>