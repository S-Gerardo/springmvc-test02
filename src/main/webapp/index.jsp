<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="/testModelAttribute" method="post">
        <input type="hidden" name="id" value="1" />
        name: <input type="text" name="name" value="小明">
        <br>
        age: <input type="text" name="age" value="11">
        <br>
        <input type="submit" value="修改" />
    </form>
    <br>
    <br>

    <a href="/testSessionAttributes">testSessionAttributes</a>
    <br>
    <br>

    <a href="/testMap">testMap</a>
    <br>
    <br>

    <a href="/testModelAndView">testModelAndView</a>
    <br>
    <br>

    <a href="/testServletAPI">testServletAPI</a>
    <br>
    <br>

    <form action="/testPojo" method="post">
        username: <input type="text" name="username">
        <br>
        password: <input type="text" name="password">
        <br>
        sex: <input type="text" name="sex">
        <br>
        age: <input type="text" name="age">
        <br>
        email: <input type="text" name="email">
        <br>
        city: <input type="text" name="address.city">
        <br>
        province: <input type="text" name="address.province">
        <br>
        <input type="submit" value="testPojo" />
    </form>
    <br>
    <br>

    <a href="/testCookieValue">testCookieValue</a>
    <br>
    <br>
    <a href="/testRequestHeader">testRequestHeader</a>
    <br>
    <br>
    <form action="/testDelete/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="testDelete" />
    </form>
    <br>
    <br>
    <form action="/testPut/1" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="testPut" />
    </form>
    <br>
    <br>
    <form action="/testPost" method="post">
        <input type="submit" value="testPost">
    </form>
    <br>
    <br>
    <a href="/testGet/1">testGet</a>

    <br>
    <br>
    <a href="/testPathVariable/1">testPathVariable</a>
    <br>
    <br>
    <a href="/testParamHeads">testParamHeads</a>
    <br>
    <br>
    <form action="/testMethod" method="post">
        <input type="submit" value="submit">
    </form>
    <br>
    <br>
    <a href="/testMethod">testMethod</a>
    <br>
    <br>

    <a href="/helloworld">Hello World!</a>
</body>
</html>
