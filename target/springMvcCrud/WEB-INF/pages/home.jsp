<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1><spring:message code="label.employee.header"/></h1>
		
		<table border="1">
          <tr>
			<th><spring:message code="label.name"/></th>
			<th><spring:message code="label.email"/></th>
			<th><spring:message code="label.address"/></th>
			<th><spring:message code="label.telephone"/></th>
			<th><spring:message code="label.action"/></th>
           </tr>
			<c:forEach var="employee" items="${listOfEmployee}">
			
				<tr>

					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			Add New Employee <a href="newEmployee">here</a>
		</h4>
	</div>
</body>
</html>