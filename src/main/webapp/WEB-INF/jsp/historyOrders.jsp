<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sachi
  Date: 2019/12/26
  Time: 11:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <c:forEach items="${historyOrdersList}" var="order">
        <h1>购买时间：${order.dataTime}</h1>
        <br>
        <div class="innerBlock">
            <c:forEach items="${order.ids}" var="id">
                <div class="block">
                    <img src="images/w${id}.jpg" />
                        ${names[id]}
                    <br/>
                    <h5 style="color:#F66">￥${prices[id]}</h5>
                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>
</body>
<style>
    .block {
        margin-left: 50px;
        display: flex;
        flex-direction: column;
    }
    .innerBlock {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;//拐弯
    }
    .container {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;//拐弯
    }
</style>

<script>

</script>
</html>
