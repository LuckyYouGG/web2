<%--
  Created by IntelliJ IDEA.
  User: sachi
  Date: 2019-11-13
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>"></base>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--  http://localhost:8088/jsp/login.jsp  --%>
        <link rel="stylesheet" type="text/css" href="http://47.93.221.123:8080/homework2/login.css">
<%--    <link rel="stylesheet" type="text/css" href="../css/login.css">--%>
<%--    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />--%>
    <title>欢迎登录</title>
</head>
<body class="login_bj">
<!-- <h1 style="font-size: 2em; text-align: center; margin-top: 30px;">用户登陆</h1> -->
<div class="zhuce_body">
    <div class="zhuce_kong login_kuang">
        <div class="zc">
            <div class="bj_bai">
                <h3 style="margin-left: 30%;">欢迎登录</h3>
                <form action="/homework2/checkLogin" method="post">
                    <label>用户名:</label>
                    <input name="mobile" type="text" class="kuang_txt possword" placeholder="手机号"><br>
                    <label>密码：</label>
                    <input name="password" type="password" class="kuang_txt" placeholder="密码"><br><br>
                    <input  name="注册" type="submit" class="btn_zhuce" value="注册">
                    <input  name="登录" type="submit" class="btn_zhuce" value="登录">
                </form>
            </div>

            <div class="bj_right">
                <p>使用以下账号直接登录</p>
                <a target="_blank" href="http://web2.qq.com/" class="zhuce_qq">QQ登录</a>
                <a target="_blank" href="https://weibo.com/" class="zhuce_wb">微博登录</a>
                <a target="_blank" href="https://wx.qq.com/" class="zhuce_wx">微信登录</a>
                <p>已有账号？<a href="#">立即登录</a></p>
            </div>

        </div>
    </div>
</div>
</body>
</html>
