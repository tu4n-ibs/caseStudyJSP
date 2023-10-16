<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 11/10/2023
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Products</h1>
    <form action="/products-delete" method="post">
        <p>
            <img width="100" src="${list.img}" alt="">
        </p>
        <p>
            <input type="hidden" name="id" value="${list.id}">
        </p>
        <p>
            <input type="text" name="name" value="${list.name}" disabled>
        </p>
        <p>
            <input type="text" name="describe" value="${list.describe}" disabled>
        </p>
        <p>
            <input type="text" name="price" value="${list.price}" disabled>
        </p>
        <p>
            <input type="submit" value="delete">
        </p>
    </form>
    <a href="/products">back</a>
</div>
</body>
</html>
