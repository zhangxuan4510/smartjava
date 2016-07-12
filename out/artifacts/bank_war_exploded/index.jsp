<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/8
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>首页</title>
  <script type="text/JavaScript" src="js/index.js"></script>
  <link type="text/css" href="css/index.css" rel="stylesheet">
</head>

<body onload="change();">
<div id="container">
  <iframe id="header" src="head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
  <div id="content">
    <div id="add">
      <img id="pic1" src="images/add1.png">
      <img id="pic2" src="images/add2.png">
      <img id="pic3" src="images/add3.png">
    </div>
    <br/><br/>
    <div id="boxleft">
      <span class="tag">优惠活动</span>
      <ul>
        <li><a href="">手拉手活动（第四季）欢乐三重奏</a></li>
        <li><a href="">博创银联信用卡悦享境外游 千元大力减</a></li>
        <li><a href="">博创银联信用卡悦享美食</a></li>
        <li><a href="">南航出行，博创银联卡礼遇</a></li>
        <li><a href="">国航出行，博创银联信用卡礼遇</a></li>
        <li><a href="">陕西：支付达人大比拼</a></li>
        <li><a href="">重庆："代发工资贷款，贷您畅游世界"</a></li>
        <li><a href="">安徽：电子银行缴费享优惠</a></li>
        <li><a href="">上海：刷博创信用卡，骑"邮"金秋</a></li>
      </ul>
    </div>
    <div id="boxright">
      <span class="tag">公告栏</span>
      <ul>
        <li><a href="">中国博创银行反假货币宣传</a></li>
        <li><a href="">"璀璨金生 博创喝彩"——中国博创银行</a></li>
        <li><a href="">中国博创银行2015年校园招聘</a></li>
        <li><a href="">博乐网半价、秒杀活动持续，亿元豪礼，天天惊喜</a></li>
        <li><a href="">短信分期，一触即"分"</a></li>
        <li><a href="">2014年凭证式国债（四期）发布公告</a></li>
        <li><a href="">博创银行夜市理财火热发售！</a></li>
        <li><a href="">95580客服中心招聘简章</a></li>
        <li><a href="">信用卡中心招聘简章</a></li>
      </ul>
    </div>
  </div>
  <iframe id="footer" src="foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>
</body>
</html>
