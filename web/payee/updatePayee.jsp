<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/11
  Time: 14:53
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
    <script type="text/javascript" src="<%=path%>/js/updatePayee.js"></script>
</head>

<body>
<div id="container">
    <iframe id="header" src="<%=path%>/head.jsp" width="980" height="136" frameborder="0" scrolling="no" marginwidth="0px;"></iframe>
    <div id="content">
        <img src="<%=path%>/images/pic1.png">
        <div class="content">
            <form id="updatePayeeForm" action="../PayeeServlet">
                <table id="tab">
                    <tr>
                        <td class="right" colspan="3">收款人账号:</td>
                        <td class="left" colspan="3"><input type="text" name="account" size="50" value="${payee.account}" id="account" onblur="checkAccount()"/><span id="saccount"></span></td>
                    </tr>
                    <tr>
                        <td class="right" colspan="3">收款人姓名:</td>
                        <td class="left" colspan="3"><input type="text" name="name" size="50" value="${payee.name}" id="name" onblur="checkName()"/><span id="sname"></span></td>
                    </tr>
                    <tr>
                        <td class="right" colspan="3" >收款人地址:</td>
                        <td class="left" colspan="3"><input type="text" name="address" size="50" value="${payee.address}"/></td>
                    </tr>

                    <tr>
                        <td colspan="3" class="right">
                            收款人银行
                        </td>
                        <td colspan="3" class="left">
                            <input type="radio" name="bankKind" value="swift" id="bankRadio" onclick="swiftOrName()" />银行swift代码
                            <input type="radio" name="bankKind" value="name" onclick="swiftOrName()" />银行名称地址
                        </td>
                    </tr>

                    <tr id="swiftTr">
                        <td class="right" colspan="3">收款人开户行SWIFT代码:</td>
                        <td class="left" colspan="3"><input type="text" name="swiftCode" size="50" value="${payee.swiftCode}" id="swiftCode"/><span id="sswiftCode"></span></td>
                    </tr>
                    <tr id="nameTr">
                        <td class="right" colspan="3">收款人开户行名称:</td>
                        <td class="left" colspan="3"><input type="text" name="bankName" size="50" value="${payee.bankName}" id="bankName" onblur="checkNameAddress()"/></td>
                    </tr>
                    <tr id="addressTr">
                        <td class="right" colspan="3">收款人开户行地址:</td>
                        <td class="left" colspan="3"><input type="text" name="bankAddress" size="50" value="${payee.bankAddress}" id="bankAddress" onblur="checkNameAddress()"/></td>
                    </tr>
                    <tr>
                        <td colspan="6"  align="center"> <input type="button" value="保存修改" onclick="checkUpdate()"/>
                            <a href="<%=path%>/payee/payeeList.jsp"><input type="button" value="返回" /></a>
                        </td>
                    </tr>
                    <input type="text" name="method" value="updatePayee" hidden="hidden">
                    <input type="text" name="oldAccount" value="${oldAccount}" hidden="hidden">
                </table>
            </form>
        </div>
    </div>
    <iframe id="footer" src="<%=path%>/foot.jsp" width="980" height="136" frameborder="0" scrolling="no marginwidth="0px;"></iframe>
</div>
<script type="text/javascript">
    $("#swiftTr").hide();
    $("#nameTr").hide();
    $("#addressTr").hide();
</script>
</body>
</html>
