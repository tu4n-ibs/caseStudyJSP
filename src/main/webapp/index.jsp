<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<style>
    .div{
        border: 1px solid;
        width: 400px;
    }
</style>
<body>
<div align="center">
    <h1>dang nhap de vao  trang chu</h1>
    <form action="/login" method="get">
        <div class="div">
            <div style="padding-top: 10px">
                <p>
                    name:
                    <input type="text" name="username" placeholder="input">
                </p>
                <p>
                    password:
                    <input type="password" name="password" placeholder="input">
                </p>
                <p>
                    <input type="submit" value="login">
                </p>
            </div>
        </div>
    </form>
    <p>
    <form action="/signup">
        <input type="submit" value="sign up">
    </form>
    </p>
</div>
</body>
</html>