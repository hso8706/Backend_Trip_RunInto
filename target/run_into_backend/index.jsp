<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div>div1</div>
<div>
    <jsp:include page="views/F02-03.jsp"/>
    <a href="category?categoryNum=12">관광지</a>
    <jsp:include page="views/triplist.jsp"/>
</div>
</body>
</html>