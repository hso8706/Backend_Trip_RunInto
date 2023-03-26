<%--
  Created by IntelliJ IDEA.
  User: LeeYeEun
  Date: 2023/03/26
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container text-center">
    <h1>F02-03</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>사진</th>
            <th>명칭</th>
            <th>유형</th>
            <th>위치</th>
            <th>상세 주소</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clist}" var="category">
            <tr>
                <td>${category.firstImage}</td>
                <td><a href="category">${category.title}</a></td>
                <td>${category.contentTypeId}</td>
                <td>${category.sidoCode} ${category.gugunCode}</td>
                <td>${category.addr1}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
