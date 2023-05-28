<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<p>You can reach the form to add to your project list<a href="${pageContext.request.contextPath}/projects-form.jsp">
    here.</a></p>
</body>
</html>