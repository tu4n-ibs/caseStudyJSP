<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 10/10/2023
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>

</head>
<style>
    .menu {
        float: left;
        top: 105px;
    }

    .header {
        margin-bottom: 10px;
        background: antiquewhite;
        height: 150px;
        width: 1805px;
    }

    .header-list {
        background: pink;
    }

    .title {
        float: left;
        font-family: "Courier 10 Pitch";
    }

    .ul-nav {
        display: block;
        float: left;
        padding-left: 60px;
        padding-top: 70px;
    }

    .ul-nav a:hover {
        padding-right: 10px;
        color: red;
    }

    #border-list {
        text-align: center;
        border-radius: 10px 10px 10px 10px;
    }

    .footer {
        padding: 2.5rem 0;
        text-align: center;
        background-color: rgba(128, 128, 128, 0.62);
        border-top: .05rem solid;
    }
</style>

<body>
<div class="div-list" align="center">
    <header class="header-list">
        <i class="material-icons">cloud</i>
        <h1 style="font-family: 'Courier 10 Pitch' ">PhoneShop</h1>
    </header>
    <nav class="header">
        <h3 class="title"><a href="/products">Menu</a></h3>
        <ul class="menu">
            <p>
            <form action="/products-search" method="get" class="search">
                <input type="submit" value="search">
                <input type="text" name="search" placeholder="input...">
            </form>
            </p>
            <button><a href="/products-myCart">show my cart</a></button>
            <button><a class="create" href="/products-create">create product</a></button>
            <button><a class="logout" href="index.jsp">logout</a></button>
        </ul>
    </nav>
    <div class="h1">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img height="500"
                         src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20kv%2020.10%20T10_Banner%20PC.jpg"
                         class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img height="500"
                         src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20iphone%2015%20pro%20max%20TH_PC%20(3).jpg"
                         class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img height="500"
                         src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20iphone%2014%20Pro%20Max%20T10_Banner%20PC.jpg"
                         class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</div>
<main class="container">
    <div class="row mb-2">
        <c:forEach items="${list}" var="list">
            <div class="col-md-3 col-6" style="border: 1px solid" id="border-list">
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
                    <p>
                        <input type="submit" value="add to cart">
                    </p>
                </form>
                <p>
                    <a href="/products-edit?action=edit&id=${list.id}"><input type="submit" value="edit"></a>
                    <a href="/products-delete?action=delete&id=${list.id}"><input type="submit" value="delete"></a>
                </p>
            </div>
        </c:forEach>
    </div>
</main>
</div>
<footer class="footer">
    <p>
        <a href="#">Gioi Thieu</a>
        |
        <a href="#">Tro Giup</a>
    </p>
    <p>
        <a href="#">Lien He</a>
    </p>
</footer>
</body>
</html>
