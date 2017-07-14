<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>购物车</title>
    <meta name="author" content="Mango Team">
    <meta name="copyright" content="Mango">
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

</head>
<body>
<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="http://localhost:8080/mango/">
                <img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客">
            </a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
        </div>
    </div>
    <div class="span10 last">
        <div class="topNav clearfix">
            <ul>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="login.jsp">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="regist.jsp">注册</a>|
                </li>
                <li id="headerUsername" class="headerUsername"></li>
                <li id="headerLogout" class="headerLogout">
                    <a href="index.jsp">[退出]</a>|
                </li>
                <li>
                    <a>会员中心</a>
                    |
                </li>
                <li>
                    <a>购物指南</a>
                    |
                </li>
                <li>
                    <a>关于我们</a>

                </li>
            </ul>
        </div>
        <div class="cart">
            <a href="cart.jsp">购物车</a>
        </div>
        <div class="phone">
            客服热线:
            <strong>96008/53277764</strong>
        </div>
    </div>
    <div class="span24">
        <ul class="mainNav">
            <li>
                <a href="index.jsp">首页</a>
                |
            </li>
            <li>
                <a href="list.jsp">定制套餐</a>
                |
            </li>
            <li>
                <a>安全频道</a>
                |
            </li>
            <li>
                <a>亿家卡</a>
                |
            </li>
            <li>
                <a>蔬菜基地</a>
                |
            </li>
            <li>
                <a>节气养生</a>
                |
            </li>
            <li>
                <a>便民服务</a>
                |
            </li>

        </ul>
    </div>

</div>
<div class="container cart">
    <div class="span24">
        <div class="step step1">

        </div>
        <table>
            <tbody>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <tr>
                <td width="60">
                    <input type="hidden" name="id" value="22">
                    <img src="${pageContext.request.contextPath}/image/dadonggua.jpg">
                </td>
                <td>
                    <a target="_blank"> 有机蔬菜 大冬瓜...</a>
                </td>
                <td>
                    ￥298.00
                </td>
                <td class="quantity" width="60">
                    <input type="text" name="quantity" value="1" maxlength="4" onpaste="return false;">
                    <div>
                        <span class="increase">&nbsp;</span>
                        <span class="decrease">&nbsp;</span>
                    </div>
                </td>
                <td width="140">
                    <span class="subtotal">￥596.00</span>
                </td>
                <td>
                    <a href="javascript:;" class="delete">删除</a>
                </td>
            </tr>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            <em>
                登录后确认是否享有优惠
            </em>
            赠送积分: <em id="effectivePoint">596</em>
            商品金额: <strong id="effectivePrice">￥596.00元</strong>
        </div>
        <div class="bottom">
            <a href="javascript:;" id="clear" class="clear">清空购物车</a>
            <a href="login.jsp" id="submit" class="submit">提交订单</a>
        </div>
    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
        </div>
    </div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a>关于我们</a>
                |
            </li>
            <li>
                <a>联系我们</a>
                |
            </li>
            <li>
                <a>招贤纳士</a>
                |
            </li>
            <li>
                <a>法律声明</a>
                |
            </li>
            <li>
                <a>友情链接</a>
                |
            </li>
            <li>
                <a target="_blank">支付方式</a>
                |
            </li>
            <li>
                <a target="_blank">配送方式</a>
                |
            </li>
            <li>
                <a>服务声明</a>
                |
            </li>
            <li>
                <a>广告声明</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
    </div>
</div>
</body>
</html>