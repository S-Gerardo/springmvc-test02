<%--
  Created by IntelliJ IDEA.
  User: zhihuizhao
  Date: 2019/12/11/011
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h3>This is successs pag</h3>

    time: ${requestScope.time}
    <br>
    <br>
    name: ${requestScope.names}
    <br>
    <br>
    request map: ${requestScope.user}
    <br>
    session map: ${sessionScope.user}
    <br>
    request string: ${requestScope.country}
    <br>
    session string: ${sessionScope.country}

</body>
</html>
