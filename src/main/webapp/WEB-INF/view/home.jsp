<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

<hr>

<!-- Display user name and role -->
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<!-- Add a link to point to /leaders  -->
<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting (Only for managers)</a>
</p>

<!-- Add a link to point to /systems  -->
<p>
    <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting (Only for admins)</a>
</p>

<hr>

<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="submit" value="Logout"/>

</form:form>
</body>
</html>
