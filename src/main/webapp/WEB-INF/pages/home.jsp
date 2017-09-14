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
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%-- <h2>Welcome ${name}</h2>
 --%>	<div align="center">
		<h1><spring:message code="label.employee.header"/></h1>
		<div class="container">
		<div class="pull-right">
			<spring:message code="label.newemployee.header"/>
			 <a class="btn btn-primary" href="newEmployee"><spring:message code="label.newEmployee.button"/></a>
		</div>
		<table  class="table table-striped">
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
					<td><a href="employeeAddress?id=${employee.id}">${employee.address}</a></td>
					<td>${employee.telephone}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
						&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		
		</div>
		<div class="container">
	<div class="pull-right"><spring:message code="label.exposeData"/> <a class="btn btn-primary" href="employeeJsonData">Expose jsonData</a></div>
	<div class="pull-left"><spring:message code="label.exportAsPdf"/> <a class="btn btn-primary" href="downloadPDF">Export Pdf</a></div>
	</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>