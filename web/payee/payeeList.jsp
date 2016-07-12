<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/10
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String path=request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>境外收款人</title>
    <link type="text/css" href="<%=path%>/css/overseasmman.css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=path%>/js/payeeList.js"></script>
</head>

<body>
<div id="container">
    <iframe id="header" src="<%=path%>/head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
    <div id="content">
        <img src="<%=path%>/images/pic1.png">
        <div id="box">
            <div>
                <table id="tab">
                    <tr>
                        <td width="90"><input type="checkbox" id="allCheckbox" onclick="allSelect()"></td>
                        <td width="160">收款人账号</td>
                        <td width="144">收款人姓名</td>
                        <td width="150">收款人地址</td>
                        <td width="230">收款人开户行SWIFT代码</td>
                        <td width="205">收款人开户行名称</td>
                        <td width="205">收款人开户行地址</td>
                    </tr>
                    <c:forEach items="${payees}" var="p">
                        <tr>
                            <td><input type="checkbox" name="oneCheckbox" onclick="oneSelect()" value="${p.account}"></td>
                            <td>${p.account}</td>
                            <td>${p.name}</td>
                            <td>${p.address}</td>
                            <td>${p.swiftCode}</td>
                            <td>${p.bankName}</td>
                            <td>${p.bankAddress}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="7" align="center">
                            <a href="<%=path%>/PayeeServlet?method=queryPayee"><input type="button" value="查询"/></a>
                            <a href="<%=path%>/payee/addPayee.jsp"><input type="button" value="添加"/></a>
                            <input type="button" value="修改" onclick="checkUpdate()"/>
                            <input type="button" value="删除" onclick="deletePayee()"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <iframe id="footer" src="<%=path%>/foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>
</body>
</html>
