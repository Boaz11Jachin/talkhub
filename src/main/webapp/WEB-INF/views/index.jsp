<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <h1>TalkHub</h1>

    <!-- 로그인 여부에 따른 메뉴 표시 -->
    <c:choose>
        <c:when test="${authentication}">
            <div class="menu">
                <a href="${pageContext.request.contextPath}/user/profile">마이페이지</a>
                <a href="${pageContext.request.contextPath}/user/logout-proceed">로그아웃</a>
                <a href="${pageContext.request.contextPath}/post/write">글쓰기</a>
                <a href="${pageContext.request.contextPath}/post/list">글목록</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="menu">
                <a href="${pageContext.request.contextPath}/user/login">로그인</a>
                <a href="${pageContext.request.contextPath}/user/join">회원가입</a>
            </div>
        </c:otherwise>
    </c:choose>

    <p>TalkHub에 오신 것을 환영합니다!</p>
</div>
</body>
</html>
