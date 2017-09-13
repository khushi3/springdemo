<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Screen</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="text-align: center">
    <p><font color="red">${errorMessage}</font></p>
    <form action="employeeList" method="POST">
    <fieldset class="form-group">
       <label>Name</label> 
       <input name="name" type="text" required="required" /> 
       </fieldset>
       <fieldset class="form-group">
       <label>Password</label>
        <input name="password" type="password" required="required" /> </fieldset>
        <fieldset class="form-group">
       <input type="submit" class="btn btn-success" /></fieldset>
    </form>
    </div>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>