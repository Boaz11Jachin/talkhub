<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>프로필 - TalkHub</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="container">
    <h1>프로필 확인</h1>
    <hr/>

    <ul class="profile-list">
        <li><strong>아이디 :</strong> ${user.id}</li>
        <li><strong>활동명 :</strong> ${user.nickname}</li>
        <li><strong>성별 :</strong> ${user.gender}</li>
        <li><strong>생년 :</strong> ${user.birth}</li>
        <li><strong>가입시기 :</strong> ${user.createdAt}</li>
    </ul>

    <div class="button-container">
        <a href="${pageContext.request.contextPath}/user/edit">
            <button>프로필 수정</button>
        </a>
        <a href="${pageContext.request.contextPath}/user/logout-proceed">
            <button>로그아웃</button>
        </a>
    </div>
</div>
</body>
</html>
