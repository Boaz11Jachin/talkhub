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
    <h3>토크허브에 회원가입하기</h3>

    <form action="${pageContext.request.contextPath}/user/join-proceed" method="post">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" required placeholder="아이디를 입력하세요"/>
        </div>

        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required placeholder="비밀번호를 입력하세요"/>
        </div>

        <div class="form-group">
            <label for="nickname">활동명</label>
            <input type="text" id="nickname" name="nickname" required placeholder="활동명을 입력하세요"/>
        </div>

        <div class="form-group">
            <label>성별</label>
            <div class="radio-group">
                <label><input type="radio" value="남" name="gender" required/>남</label>
                <label><input type="radio" value="여" name="gender" required/>여</label>
                <label><input type="radio" value="비공개" name="gender" required/>비공개</label>
            </div>
        </div>

        <div class="form-group">
            <label for="birth">출생년도</label>
            <select name="birth" id="birth" required>
                <c:forEach var="i" begin="1970" end="2025">
                    <option value="${i}">${i}년</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="submit-btn">회원 가입</button>
    </form>
</div>
</body>
</html>
