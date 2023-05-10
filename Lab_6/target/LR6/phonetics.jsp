<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Records</h1>
<jsp:useBean id="phonetics" scope="request" type="java.util.List<LR6.entity.Phonetics>"/>
<c:if test="${phonetics != null}">
    <table>
        <tr>
            <th><c:out value="Id"/></th>
            <th><c:out value="Performer"/></th>
            <th><c:out value="Album"/></th>
        </tr>
        <c:forEach items="${phonetics}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.album}</td>
                <td>${p.performer}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/LR6">Home</a>
</body>
</html>
