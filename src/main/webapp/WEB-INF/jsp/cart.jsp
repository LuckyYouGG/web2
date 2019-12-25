<%--
  Created by IntelliJ IDEA.
  User: sachi
  Date: 2019-11-14
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>阿友购物</title>
</head>
<body>

<div class="container">
     <c:forEach items="${goodsBeans}" var="good">
         <div class="block">
             <img src="images/w${good.gindex}.jpg" />>${good.gname}
             <br/>
             <h5 style="color:#F66">限时优惠￥${good.gprice}</h5>

             <div onclick="deleteCartGoods(${good.gindex})" class="mask">
<%--                 <div class="info">Quick View</div>--%>
                 删除
             </div>
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
    .container {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;//拐弯
    }
</style>
<script language="JavaScript" type="text/javascript">
    var xmlHttp = new XMLHttpRequest();
    function deleteCartGoods(id) {
        //http://47.93.221.123:8080/webhomework3/deleteCartGoods

        xmlHttp.open("post","http://localhost:8088/deleteCartGoods");
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange = handleStateChange;
        var para = "id="+id;
        console.log(para);
        xmlHttp.send(para);
    }
    function handleStateChange() {
        if(xmlHttp.readyState === 4) {
            if(xmlHttp.status === 200){
                alert("删除物品成功，请手动刷新页面");
            }else {
                alert("删除物品失败");
            }
            console.log(xmlHttp.status)
        }
    }

</script>
</html>
