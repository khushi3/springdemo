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
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/springMvcCrud/login" method="POST">
        Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" />
    </form>
</body>
</html>