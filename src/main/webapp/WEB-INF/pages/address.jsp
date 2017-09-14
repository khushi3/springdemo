<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Screen</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%-- <h2>Welcome ${name}</h2>
 --%>	<div align="center">
		<h1><spring:message code="label.address.header"/></h1>
		<div class="container">
		<div class="pull-right">
			<spring:message code="label.address.header"/>
			 <a class="btn btn-primary" href="addemployeeAddress"><spring:message code="label.newEmployee.button"/></a>
		</div>
		<table  class="table table-striped">
          <tr>
			<th><spring:message code="label.pincode"/></th>
			<th><spring:message code="label.city"/></th>
			<th><spring:message code="label.state"/></th>
			<th><spring:message code="label.country"/></th>
           </tr>
			<c:forEach var="address" items="${listOfaddress}">
			
				<tr>

					<td>${address.pincode}</td>
					<td>${address.city}</td>
					<td>${address.state}</td>
					<td>${address.country}</td>
				</tr>
			</c:forEach>
		</table>
		
		</div>
		
	<div>
			<spring:message code="label.goBackToPreviousPage.address"/>
			 <a class="btn btn-primary" href="backToEmployee"><spring:message code="label.newEmployee.button"/></a>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>