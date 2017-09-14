<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
        <h1><spring:message code="Addresslabel.header"/></h1>
        <form:form action="saveEmployeeAddress" method="post" modelAttribute="address">
        <table class="table table-striped">
            <form:hidden path="addressId"/>
            <tr>
                <td>Pincode:</td>
                <td><form:input path="pincode" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><form:input path="country" /></td>
            </tr>
            <tr>
                <td><input type="submit" class="btn btn-success" value=<spring:message code="label.submitButton"/>></td>
            </tr>
        </table>
        </form:form>
    </div>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>