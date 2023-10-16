<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 11/10/2023
  Time: 08:13
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
  <form action="/products-edit" method="post">
    <p>
      <input type="text" name="id" value="${product.id}">
    </p>
    <p>
      <input type="text" name="name" value="${product.name}">
    </p>
    <p>
      <input type="text" name="describe" value="${product.describe}">
    </p>
    <p>
      <input type="text" name="price" value="${product.price}">
    </p>
    <p>
      <input type="text" name="img" value="${product.img}">
    </p>
    <p>
      <input type="submit" value="edit">
    </p>
  </form>
  <a href="/products">back</a>
</div>
</body>
</html>
