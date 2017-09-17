<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
 --%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
<!-- <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
 -->
<!-- <link rel="stylesheet" href="resources/js/bootstrap/css/bootstrap.min.css"> -->

<link rel="stylesheet" href="resources/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>

 



</head>
<body>
<h2>Welcome ${name}</h2>
	<div align="center">
		<h1><spring:message code="label.employee.header"/></h1>
		<div class="container">
		<div class="pull-right">
			<spring:message code="label.newemployee.header"/>
			 <a class="btn btn-primary" href="newEmployee"><spring:message code="label.newEmployee.button"/></a>
		</div>
		<table id="tableClient" class="table table-striped">
		<thead>
          <tr>
             <th class="col-sm-1" data-field="id">Id</th>
             <th class="col-sm-1" data-field="checkDelete"></th>
			<th  data-field="name"><spring:message code="label.name"/></th>
			<th  data-field="email"><spring:message code="label.email"/></th>
			<th  data-field="address"><spring:message code="label.address"/></th>
			<th  data-field="telephone"><spring:message code="label.telephone"/></th>
			<%-- <th><spring:message code="label.action"/></th> --%>
           </tr>
           </thead>
			<c:forEach var="employee" items="${listOfEmployee}">
			
				<tr>
                    <td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td><a href="employeeAddress?id=${employee.id}">${employee.address}</a></td>
					<td>${employee.telephone}</td>
					<%-- <td><a href="editEmployee?id=${employee.id}">Edit</a><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
						&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
						href="deleteEmployee?id=${employee.id}">Delete</a></td> --%>

				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<div class="container pull-right">
		<div class="form-group">
			<!-- <button type="button" id="buttonSearch" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
			<button type="button" id="buttonEdit" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> edit
			</button> -->
			<button type="button" id="buttonDelete" class="btn btn-danger">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete
			</button>
	<a class="btn btn-primary" href="employeeJsonData">JsonData</a>
	<a class="btn btn-primary" href="downloadPDF"><i class="glyphicon glyphicon-download" aria-hidden="true"></i>Download Pdf</a>
	<a class="btn btn-primary" href="downloadXlsx"><i class="glyphicon glyphicon-download" aria-hidden="true"></i>Download Xlsx</a>
	<a class="btn btn-primary" href="downloadCsv"><i class="glyphicon glyphicon-download" aria-hidden="true"></i>Download Csv</a>
	</div>
	</div>

<script src="resources/js/jquery-2.2.3.min.js"></script>
<script src="resources/js/bootstrap/js/bootstrap.js"></script>
<script src="resources/js/bootstrap/js/moment.js"></script>
<script src="resources/js/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<script src="resources/js/bootstrapSpringGrid.js"></script>

</body>
</html>