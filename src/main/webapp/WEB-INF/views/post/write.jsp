<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub 글쓰기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="container">
    <h1>TalkHub</h1>
    <h3>토크허브에 글쓰기</h3>

    <form action="${pageContext.request.contextPath}/post/write-proceed" method="post">
        <div class="form-group">
            <label for="category">카테고리</label>
            <input type="text" id="category" name="category" required placeholder="카테고리를 입력하세요"/>
        </div>

        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required placeholder="글 제목을 입력하세요"/>
        </div>

        <div class="form-group">
            <label for="content">본문</label>
            <textarea id="content" name="content" rows="5" required placeholder="글 내용을 작성하세요"></textarea>
        </div>

        <button type="submit" class="submit-btn">글쓰기</button>
    </form>
</div>
</body>
</html>
