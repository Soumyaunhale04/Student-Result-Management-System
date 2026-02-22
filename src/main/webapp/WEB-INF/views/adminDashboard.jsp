<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css"></link>
</head>
<body>
	<div id="header">Welcome!</div>
	<div id="content">
	<a href="${pageContext.request.contextPath}/AddStudent">
	<button>Add Student</button>
	</a>
	
	<a href="${pageContext.request.contextPath}/SetMarks">
	<button>Set Marks</button>
	</a>
	
	<a href="${pageContext.request.contextPath}/DeleteMarks">
	<button>Delete Marks</button>
	</a>
	</div>
	<div id="footer"></div>
</body>
</html>