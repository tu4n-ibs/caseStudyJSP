<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 10/10/2023
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .header{
        background: pink;
    }
</style>
<body>
<div align="center">
    <header class="header">
        <h2>Create Product</h2>
    </header>
    <form action="/products-create" method="post">
        <fieldset style="width: 60px">
            <legend>Create</legend>
            <table>
                <tr>
                    <td>name:</td>
                    <td><input type="text" name="name" placeholder="input..."></td>
                </tr>
                <tr>
                    <td>describe:</td>
                    <td><input type="text" name="describe" placeholder="input..."></td>
                </tr>
                <tr>
                    <td>price:</td>
                    <td><input type="text" name="price" placeholder="input..."></td>
                </tr>
                <tr>
                    <td>img:</td>
                    <td><input type="text" name="img" placeholder="input..."></td>
                </tr>
                <tr>
                    <input type="submit" value="create">
                </tr>
            </table>
        </fieldset>
    </form>
    <form action="/products">
        <input type="submit" value="Home">
    </form>
</div>
</body>
</html>
