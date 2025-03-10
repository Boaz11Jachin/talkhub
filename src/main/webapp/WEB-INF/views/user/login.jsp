<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="login-container">
    <h1>TalkHub</h1>
    <h3>토크허브에 로그인하기</h3>

    <form action="${pageContext.request.contextPath}/user/login-proceed" method="post">
        <div class="form-group">
            <label for="id">아이디</label>
            <div>
                <input type="text" id="id" name="id" value="${id}" placeholder="아이디를 입력하세요"/>
            </div>
        </div>

        <div class="form-group">
            <label for="password">비밀번호</label>
            <div>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
            </div>
        </div>

        <p class="error-message">${error}</p>

        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>
