<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Custom Login Page</title>
</head>
<body>
<h3>Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

    <p>
        <label for="username">User name:</label> <input type="text" name="username" id="username"/>
    </p>

    <p>
        <label for="password">Password:</label> <input type="password" name="password" id="password"/>
    </p>

    <input type="submit" value="Login"/>

</form:form>

</body>
</html>
