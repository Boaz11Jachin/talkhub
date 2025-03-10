<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TalkHub 게시글 보기</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="container">
  <h1>게시글 보기 | <small>TalkHub</small></h1>
  <p class="post-info">
    ${post.id}번째 게시글 입니다.
  </p>
  <hr/>
  <ul class="post-details">
    <li><strong>작성자:</strong> ${post.writerId}</li>
    <li><strong>카테고리:</strong> ${post.category}</li>
    <li><strong>글제목:</strong> ${post.title}</li>
    <li><strong>내용:</strong> ${post.content}</li>
    <li><strong>조회수:</strong> ${post.views}</li>
    <li><strong>좋아요:</strong> ${post.likes}</li>
    <li><strong>작성시간:</strong> ${post.writedAt}</li>
    <li><strong>수정시간:</strong> ${post.modifiedAt}</li>
  </ul>

  <div class="button-container">
    <a href="${pageContext.request.contextPath}/post/list">
      <button class="btn">목록으로</button>
    </a>

    <c:choose>
      <c:when test="${alreadyLiked == true}">
        <button class="btn" disabled>추천하기</button>
      </c:when>
      <c:otherwise>
        <a href="${pageContext.request.contextPath}/post/like-proceed?id=${post.id}">
          <button class="btn">추천하기</button>
        </a>
      </c:otherwise>
    </c:choose>
  </div>
</div>
</body>
</html>
