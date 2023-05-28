<%--
  Created by IntelliJ IDEA.
  User: Spencer Griffin
  Date: 12/11/2021
  Time: 12:19 PM
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
<center>
    <h1>Project list Management</h1>
    <h2>
        <a href="new">Add New Project</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/projects-list.jsp">List All Projects</a>

    </h2>
</center>
<div align="center">
    <c:if test="${projects != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${projects== null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${projects != null}">
                            Edit Project
                        </c:if>
                        <c:if test="${projects == null}">
                            Add New Project
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${projects != null}">
                    <input type="hidden" name="id" value="<c:out value='${projects.id}' />"/>
                </c:if>
                <tr>
                    <th>Title:</th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${projects.title}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Budget:</th>
                    <td>
                        <input type="text" name="budget" size="45"
                               value="<c:out value='${projects.budget}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Time:</th>
                    <td>
                        <input type="text" name="time" size="15"
                               value="<c:out value='${projects.time}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Importance:</th>
                    <td>
                        <input type="text" name="importance" size="15"
                               value="<c:out value='${projects.importance}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>