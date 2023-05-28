<%--
  Created by IntelliJ IDEA.
  User: Spencer Griffin
  Date: 12/11/2021
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Project List Application</title>
</head>
<body>
    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                   url = "jdbc:mysql://localhost/myprojects"
                   user = "root"  password = "password"/>

    <sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from projects;
    </sql:query>
<center>
    <h1>Project List Management</h1>
    <h2>
        <a href="new">Add New Project</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/projects-list.jsp">List All Projects</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Projects</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Budget</th>
            <th>Time</th>
            <th>Importance</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="projects" items="${listProjects}">
            <tr>
                <td><c:out value="${projects.id}"/></td>
                <td><c:out value="${projects.title}"/></td>
                <td><c:out value="${projects.budget}"/></td>
                <td><c:out value="${projects.time}"/></td>
                <td><c:out value="${projects.importance}"/></td>
                <td>
                    <a href="edit?id=<c:out value='${projects.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${projects.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>