<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

    <!-- Check for login error -->

    <c:if test="${param.error != null}">

        <i class="failed">Sorry! You entered invalid username/password.</i>
    </c:if>

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
