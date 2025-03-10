<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub - 회원가입</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="container">
    <h1>TalkHub</h1>
    <h2>토크허브에 회원가입하기</h2>
    <p>TalkHub에 가입하고 자유롭게 이야기하세요! 다양한 주제에 대해 토론하고, 새로운 사람들과 소통할 수 있습니다.</p>

    <form action="${pageContext.request.contextPath}/user/join-proceed" method="post">
        <div class="form-group">
            <label for="id">아이디(*)</label>
            <input type="text" id="id" name="id" value="${param.id}" placeholder="아이디를 입력하세요"/>
            <c:if test="${idError != null}">
                <div class="error-message">${idError}</div>
            </c:if>
            <c:if test="${idDuplicatedError != null}">
                <div class="error-message">${idDuplicatedError}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="password">비밀번호(*)</label>
            <input type="password" id="password" name="password" value="${param.password}" placeholder="비밀번호를 입력하세요"/>
            <c:if test="${passwordError != null}">
                <div class="error-message">${passwordError}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="nickname">활동명(*)</label>
            <input type="text" id="nickname" name="nickname" value="${param.nickname}" placeholder="활동명을 입력하세요"/>
            <c:if test="${nicknameError != null}">
                <div class="error-message">${nicknameError}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="gender">성별(*)</label>
            <select name="gender" id="gender">
                <option value="남">남</option>
                <option value="여">여</option>
                <option value="비공개">비공개</option>
            </select>
        </div>

        <div class="form-group">
            <label for="birth">출생년도(*)</label>
            <select name="birth" id="birth">
                <c:forEach var="i" begin="1970" end="2025">
                    <option value="${i}">${i}년</option>
                </c:forEach>
            </select>
        </div>

        <c:if test="${dbError != null}">
            <div class="error-message">${dbError}</div>
        </c:if>

        <div class="form-group">
            <button type="submit" class="submit-btn">가입하기</button>
        </div>
    </form>
</div>
</body>
</html>
