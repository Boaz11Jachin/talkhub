<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오후 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
    <h1>TalkHub</h1>
    <h3>토크허브에 로그인하기</h3>

    <form action="${pageContext.request.contextPath}/user/login-proceed" method="post">
        <div>
            <label>아이디</label>
            <div>
                <input type="text" name="id" value="${id}"/>
            </div>
        </div>
        <div>
            <label>비밀번호</label>
            <div>
                <input type="password" name="password"/>
            </div>
        </div>
        <p style="color:red; font-size: small">
            ${error}
        </p>

        <button type="submit">로그인</button>
    </form>

</body>
</html>
