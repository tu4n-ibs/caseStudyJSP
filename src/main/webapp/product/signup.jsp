<%--
  Created by IntelliJ IDEA.
  User: tuan
  Date: 11/10/2023
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" >
    <form action="/signup" method="post">
        <fieldset style="width: 60px">
            <legend>Create</legend>
            <table>
                <tr>
                    <td>username:</td>
                    <td><input type="text" name="username" placeholder="input..."></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input type="text" name="password" placeholder="input..."></td>
                </tr>
                <tr>
                    <a href="index.jsp"><input type="submit" value="sign up"></a>
                </tr>
            </table>
        </fieldset>
    </form>
    <form action="index.jsp">
        <input type="submit" value="back">
    </form>
</div>
</body>
</html>
