<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub 글 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="container">
    <h1>글 목록</h1>
    <p class="post-count">
        총 ${count}개의 글이 등록되어 있습니다.
    </p>

    <div class="navigation">
        <a href="${pageContext.request.contextPath}/post/write" class="nav-button">글쓰기</a>
        <a href="${pageContext.request.contextPath}/user/profile" class="nav-button">마이페이지</a>
        <a href="${pageContext.request.contextPath}/user/logout-proceed" class="nav-button">로그아웃</a>
        <a href="${pageContext.request.contextPath}/user/login" class="nav-button">로그인</a>
    </div>

    <hr/>

    <ul class="post-list">
        <c:forEach var="one" items="${datas}">
            <a href="${pageContext.request.contextPath}/post/view?id=${one.id}">
                <li class="post-item">${one.title}</li>
            </a>
        </c:forEach>
    </ul>
</div>
</body>
</html>
