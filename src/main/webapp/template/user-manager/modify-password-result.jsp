<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2015/8/22
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改结果</title>
</head>
<body>
<p>亲，<%out.print(pageContext.getRequest().getAttribute("result"));%>，<a
        href="/ChinaOil/login.html">点此</a>重新登录</p>
</body>
</html>
