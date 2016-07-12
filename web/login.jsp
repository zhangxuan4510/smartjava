<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/10
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link type="text/css" href="css/login.css" rel="stylesheet">
    <script src="jquery/jquery-1.8.3.js"></script>
    <script src="js/login.js"></script>
    <script>

    </script>
</head>
<body>
<div id="container">
    <iframe id="header" src="head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
    <img src="images/pic1.png">
    <hr/>

    <div id="content">
        <div id="box1">
            <form method="post">
                <table width="330">
                    <tr>
                        <td width="70" height="40">登录名:</td>
                        <td width="180"><input type="text" name="userName" id="userName"/></td>
                    </tr>
                    <tr>
                        <td >密&nbsp;&nbsp;码:</td>
                        <td colspan="2"><input type="password" name="userPwd" id="rowlogin"/></td>
                    </tr>
                </table>
            </form>
            <div id="boxlogin">
                <input type="image" src="images/login4.png" id="sub" onclick="loginByUserName()"/>
            </div>
            <div id="boxregister">
                <a href="register.jsp">立即注册</a>
                <a href="">忘记密码？</a>
            </div>
        </div>
    </div>
    <iframe id="footer" src="foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>
</body>
</html>