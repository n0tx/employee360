<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Employee List</title>
</head>
<body>
	<h2>Employee List</h2>
	<form action="${pageContext.request.contextPath}/employees" method="get">
		Search: <input type="text" name="keyword" value="${keyword}"/>
		Page Size: 
		<select name="size">
			<option value="5" ${size == 5 ? 'selected' : ''}>5</option>
			<option value="10" ${size == 10 ? 'selected' : ''}>10</option>
			<option value="15" ${size == 15 ? 'selected' : ''}>15</option>
			<option value="20" ${size == 20 ? 'selected' : ''}>20</option>
			<option value="50" ${size == 50 ? 'selected' : ''}>50</option>
		</select>
		<input type="submit" value="Search"/>
	</form>
	<table border="1">
		<tr>
			<th>Employee No</th>
			<th>Name</th>
			<th>Position</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${String.format("%03d", employee.id)}</td>
				<td><a href="${pageContext.request.contextPath}/employees/edit/${employee.id}">${employee.name}</a></td>
				<td>${employee.position}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>
					<a href="${pageContext.request.contextPath}/employees/edit/${employee.id}">Edit</a> |
					<a href="${pageContext.request.contextPath}/employees/delete/${employee.id}" onclick="return confirm('Are you sure?');">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		Page ${currentPage} of ${totalPages}
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/employees?keyword=${keyword}&page=${currentPage-1}&size=${size}">Previous</a>
		</c:if>
		<c:if test="${currentPage < totalPages}">
			<a href="${pageContext.request.contextPath}/employees?keyword=${keyword}&page=${currentPage+1}&size=${size}">Next</a>
		</c:if>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/employees/addForm">Add New Employee</a>
	</div>
</body>
</html>