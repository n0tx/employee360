<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<h2>Add Employee</h2>
	<form action="${pageContext.request.contextPath}/employees/add" method="post">
		<label>Name: </label>
		<input type="text" name="name" required pattern="[a-zA-Z ]{1,10}" /><br/>
		<label>Position: </label>
		<input type="text" name="position" required /><br/>
		<label>Phone: </label>
		<input type="text" name="phone" required pattern="[0-9]{2-3}-[0-9]{3,4}-[0-9]{4}" /><br/>
		<label>Email: </label>
		<input type="email" name="email" required pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" /><br/>
		<input type="submit" value="Submit" />
	</form>
	<div>
		<a href="${pageContext.request.contextPath}/">Back to Hello</a>
	</div>
</body>
</html>