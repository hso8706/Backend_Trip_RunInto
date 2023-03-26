<%--
  Created by IntelliJ IDEA.
  User: 하정호
  Date: 2023-03-26
  Time: 오후 5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container text-center">
    <%--  <h1>F02-03</h1>--%>
    <%--  값이 오면 표 띄우기, 안 오면 표 안보임 --%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>유형</th>
            <th>사진</th>
            <th>명칭</th>
            <th>상세 주소</th>
            <th>상세 설명</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:choose>
                <c:when test="${content.contentTypeId=='12'}">
                    <td>관광지</td>
                </c:when>
                <c:when test="${content.contentTypeId=='14'}">
                    <td>문화시설</td>
                </c:when>
                <c:when test="${content.contentTypeId=='15'}">
                    <td>축제공연행사</td>
                </c:when>
                <c:when test="${content.contentTypeId=='25'}">
                <td>여행코스</td>
                </c:when>
                <c:when test="${content.contentTypeId=='28'}">
                    <td>레포츠</td>
                </c:when>
                <c:when test="${content.contentTypeId=='32'}">
                    <td>숙박</td>
                </c:when>
                <c:when test="${content.contentTypeId=='38'}">
                    <td>쇼핑</td>
                </c:when>
                <c:when test="${content.contentTypeId=='39'}">
                    <td>음식점</td>
                </c:when>
                <c:otherwise>
                    <td>잘못된 입력입니다.</td>
                </c:otherwise>
            </c:choose>
            <%--                <td>${content.contentTypeId}</td>--%>
            <td><img src="${content.firstImage}" class="img-fluid" alt="등록된 사진이 없습니다."></td>
            <td>${content.title}</td>
            <td>${content.addr1}</td>
            <td>${description.overview}</td>
        </tr>
        </tbody>
    </table>
    <a href="category">목록 보기</a>
</div>
</body>
</html>
