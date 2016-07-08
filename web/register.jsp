<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/7
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>注册</title>
    <link href="css/register.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>

<body>
<div id="container">
    <iframe id="header" src="head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
    <div id="content">
        <img src="images/pic1.png">
        <div class="anno">带*号为必填项!</div>
        <form id="registerForm" method="post" action="RegisterServlet?method=register">
            <table class="reg" cellspacing="0px" cellpadding="0px">
                <tbody>
                <tr>
                    <td class="a_r w15p"><label for="name" >姓名：</label></td>
                    <td class="w500"><input name="name" id="name" type="text"  class="required" onblur="checkName()"/><span id="sname"></span></td>
                </tr>
                <tr>
                    <td class="a_r"><label for="userName">用户名：</label></td>
                    <td><input name="userName" id="userName" type="text"  class="required" onblur="checkUserName()"/>
                    <span id="suserName"></span></td>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r" ><label for="password" onblur="">密码：</label></td>
                        <td><input name="password" id="password" type="password" class="required"/><span id="spassword"></span></td>
                    </div>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r"><label for="password1">请再次输入密码：</label></td>
                        <td><input name="password1" id="password1" type="password" class="required" onblur="checkPassword()"/><span id="spassword1"></span></td>
                    </div>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r"><label for="cardID" >身份证号：</label></td>
                        <td><input name="cardID" id="cardID" type="text" class="required" onblur="checkCardID()"/><span id="scardID"></span></td>
                    </div>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r"><label for="phone" >电话号码：</label></td>
                        <td><input name="phone" id="phone" type="text" class="required" onblur="checkPhone()"/><span id="sphone"></span></td>
                    </div>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r"><label for="email" >邮箱：</label></td>
                        <td><input name="email" id="email" type="text" onblur="checkEmail()"/><span id="seamil"></span></td>
                    </div>
                </tr>
                <tr>
                    <div class="int">
                        <td class="a_r"><label for="address">地址：</label></td>
                        <td><input name="address" id="address" type="text"/></td>
                    </div>
                </tr>
                </tbody>
            </table>
        </form>
        <div class="sub">
            <td colspan="2" class="pl150"><input type="image" name="submit" class="b0" src="images/submit.gif" id="sub"  onclick="check()"/><img src="images/reset.gif" class="hand" alt="重置" id="res"/></td>
        </div>
    </div>
    <iframe id="footer" src="foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>
</body>
</html>

