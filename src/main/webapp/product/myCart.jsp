<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 10/10/2023
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<style>
    .header-list {
        background: pink;
    }
    .nav{
        float: left;
        position: fixed;
    }
</style>

<body>
<div class="div-list" align="center">
    <header class="header-list">
        <h1>My Cart</h1>
    </header>
    <nav>
        <div class="nav">
            <form action="/products">
                <button class="btn btn-dark">Home</button>
            </form>
        </div>
    </nav>
    <main class="container">
        <div class="row mb-2">
            <c:forEach items="${product}" var="list">
                <div class="col-md-3 col-xs-6">
                    <form action="/products-cart" method="get">
                        <p>
                            <img src="${list.img}" width="100%" alt="">
                        </p>
                        <p><input type="hidden" name="img" value="${list.img}"></p>
                        <p>name: ${list.name}</p>
                        <input type="hidden" name="name" value="${list.name}">
                        <p>Describe: ${list.describe}</p>
                        <input type="hidden" name="describe" value="${list.describe}">
                        <p>Price: ${list.price}</p>
                        <input type="hidden" name="price" value="${list.price}">
                        </p>
                    </form>
                </div>
            </c:forEach>
        </div>
    </main>
</div>
</body>
