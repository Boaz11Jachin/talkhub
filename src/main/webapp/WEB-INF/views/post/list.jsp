<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub 글 목록</title>
</head>
<body>
    <h1>글 목록</h1>
    <p>
        총 ${count}개의 글이 등록되어 있습니다.
    </p>
    <hr/>
    <ul>
        <c:forEach var="one" items="${datas }">
            <a href="${pageContext.request.contextPath}/post/view?id=${one.id}">
            <li>${one.title }</li>
        </c:forEach>
    </ul>



</body>
</html>
