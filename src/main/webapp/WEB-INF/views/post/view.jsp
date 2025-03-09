<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 7.
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
  <h1>게시글 보기 | <small>TalkHub</small></h1>
  <p>
    ${post.id }번째 게시글 입니다.
  </p>
  <hr/>
  <ul>
    <li>작성자 : ${post.writerId }</li>
    <li>카테고리 : ${post.category }</li>
    <li>글제목 : ${post.title }</li>
    <li>내용 : ${post.content }</li>
    <li>조회수 : ${post.views }</li>
    <li>좋아요 : ${post.likes }</li>
    <li>작성시간 : ${post.writedAt }</li>
    <li>수정시간 : ${post.modifiedAt }</li>

  </ul>

    <a href="${pageContext.request.contextPath}/post/list">
      <button type="button">목록으로</button>
    </a>
    <c:choose>
      <c:when test="${sessionScope.alreadyLiked = true}">
        <button type="button" disabled>추천하기</button>
      </c:when>
      <c:otherwise>
        <a href="${pageContext.request.contextPath}/post/like-proceed?id=${post.id}">
          <button type="button" >추천하기</button>
        </a>
      </c:otherwise>
    </c:choose>

  <p>alreadyLiked 값: ${sessionScope.alreadyLiked}</p>

</body>
</html>
