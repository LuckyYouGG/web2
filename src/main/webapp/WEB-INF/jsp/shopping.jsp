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
     <c:forEach items="${pageScope.get('goods')}" var="good">

     </c:forEach>
</body>
</html>
