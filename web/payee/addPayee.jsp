<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/10
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path=request.getContextPath();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>境外收款人</title>
    <link type="text/css" href="<%=path%>/css/overseasmman.css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=path%>/js/addPayee.js"></script>
</head>

<body>
<div id="container">
    <iframe id="header" src="<%=path%>/head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
    <div id="content">
        <img src="<%=path%>/images/pic1.png">
            <div class="content">
                <form id="addPayeeForm" action="../PayeeServlet">
                    <table id="tab">
                        <tr>
                            <td class="right" colspan="3">收款人账号:</td>
                            <td class="left" colspan="3"><input type="text" name="account" size="50" id="account" onblur="checkAccount()"/><span id="saccount"></span></td>
                        </tr>
                        <tr>
                            <td class="right" colspan="3">收款人姓名:</td>
                            <td class="left" colspan="3"><input type="text" name="name" size="50" id="name" onblur="checkName()"/><span id="sname"></span></td>
                        </tr>
                        <tr>
                            <td class="right" colspan="3">收款人地址:</td>
                            <td class="left" colspan="3"><input type="text" name="address" size="50" onblur="checkAddress()"/><span id="saddress"></span></td>
                        </tr>

                        <tr>
                            <td colspan="3" class="right">
                                收款人银行
                            </td>
                            <td colspan="3" class="left">
                                <input type="radio" name="bankKind" value="swift" id="bankRadio" onclick="swiftOrName()">银行swift代码
                                <input type="radio" name="bankKind" value="name" onclick="swiftOrName()">银行名称地址
                            </td>
                        </tr>

                        <tr id="swiftTr">
                            <td class="right" colspan="3">收款人开户行SWIFT代码:</td>
                            <td class="left" colspan="3"><input type="text" name="swiftCode" size="50" id="swiftCode" onblur="checkSwiftCode()"/><span id="sswiftCode"></span></td>
                        </tr>
                        <tr id="nameTr">
                            <td class="right" colspan="3">收款人开户行名称:</td>
                            <td class="left" colspan="3"><input type="text" name="bankName" size="50" onblur="checkNameAddress()" id="bankName"/></td>
                        </tr>
                        <tr id="addressTr">
                            <td class="right" colspan="3">收款人开户行地址:</td>
                            <td class="left" colspan="3"><input type="text" name="bankAddress" size="50" onblur="checkNameAddress()" id="bankAddress"/></td>
                        </tr>
                        <tr>
                            <td colspan="6"  align="center"> <input type="button" value="添加" onclick="check()"/>
                                <a href="<%=path%>/payee/payeeList.jsp"><input type="button" value="返回" /></a>
                            </td>
                        </tr>
                        <input type="text" name="method" value="addPayee" hidden="hidden">
                    </table>
                </form>
            </div>
    </div>
    <iframe id="footer" src="<%=path%>/foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>

<script type="text/javascript">
    $("input[name='bankKind']").get(0).checked = true;
    swiftOrName();
</script>
</body>
</html>
