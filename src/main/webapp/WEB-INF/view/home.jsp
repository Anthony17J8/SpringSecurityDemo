<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Hello!</h2>
<hr>
<p>
    This is Spring Security demo project
</p>

<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="submit" value="Logout"/>

</form:form>
</body>
</html>
