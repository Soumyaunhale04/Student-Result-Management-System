<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Name: ${student.name}
	Roll no: ${student.rollno}
	Branch: ${student.branch}
	Semester : ${student.semester}
	
	<table border="2px">
	<tr>
	<th>Subject</th>
	<th>Marks</th>
	</tr>
	
	<c:forEach var="r" items="${results}">
	<tr>
	<td>${r.subject}</td>
	<td>${r.marks}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>