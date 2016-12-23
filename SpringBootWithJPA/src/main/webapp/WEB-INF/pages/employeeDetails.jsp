<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>Employee Details</h2>
	<hr>
	<TABLE border="1">
		<tr>
			<TD>Id</TD>
			<TD>${emp.id}</TD>
		</tr>
		<tr>
			<TD>Name</TD>
			<TD>${emp.name}</TD>
		</tr>
		<tr>
			<TD>Department</TD>
			<TD>${emp.department.name}</TD>
		</tr>
	</TABLE>
	
	<hr>
	<c:forEach items="${emplist}" var="emp">
		${emp.id} - ${emp.name} - ${emp.department.name}
		<br>	
	</c:forEach>
	
</body>
</html>
