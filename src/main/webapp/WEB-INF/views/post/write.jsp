<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TalkHub 글쓰기</title>
  </head>
  <body>
    <h1>TalkHub</h1>

    <h3>토크허브에 글쓰기</h3>
    <form action="${pageContext.request.contextPath}/post/write-proceed" method="post">

        <div>
            <label>카테고리</label>
            <div>
                <input type="text" name="category"/>
            </div>
        </div>

        <div>
            <label>제목</label>
            <div>
                <input type="text" name="title"/>
            </div>
        </div>

        <div>
            <label>본문</label>
            <div>
                <input type="text" name="content"/>
            </div>
        </div>

        <button type="submit">글쓰기</button>
    </form>
  </body>
</html>
