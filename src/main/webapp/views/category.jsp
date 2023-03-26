<%--
  Created by IntelliJ IDEA.
  User: 하정호
  Date: 2023-03-26
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%-- BootStrap 적용 --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container px-4 px-lg-5 mb-5 pb-5">
    <div style="height: 5px"></div>
    <div class="row">
        <div class="col">
            <h1>관광지 정보 검색하기</h1>
            <form class="d-flex my-3" role="search">
                <!-- pgno 쿼리 -->
                <input type="hidden" name="pgno" value="1"/>
                <!-- content_type_id 쿼리 -->
                <select id="search-content-id" class="form-select me-2" name="content_type_id">
                    <option value="0" selected name="0">관광지 유형</option>
                    <option value="12" name="12">관광지</option>
                    <option value="14">문화시설</option>
                    <option value="15">축제공연행사</option>
                    <option value="25">여행코스</option>
                    <option value="28">레포츠</option>
                    <option value="32">숙박</option>
                    <option value="38">쇼핑</option>
                    <option value="39">음식점</option>
                </select>
                <!-- word 쿼리 -->
                <input type="text" name="word" id="word" class="form-control" placeholder="검색어" />
                <input type="submit" value="검색">
                <script>console.log()</script>
            </form>
        </div>
    </div>
</div>
<div class="container text-center">
    <%--  <h1>F02-03</h1>--%>
    <%--  값이 오면 표 띄우기, 안 오면 표 안보임 --%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>사진</th>
            <th>명칭</th>
            <th>유형</th>
            <th>위치</th>
            <th>상세 주소</th>
            <th>자세히 보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clist}" var="category">
            <tr>
                <td><img src="${category.firstImage}" class="img-fluid" alt="등록된 사진이 없습니다."></td>
                <td><a href="category_details?content_id=${category.contentId}">${category.title}</a></td>
                <c:choose>
                    <c:when test="${category.contentTypeId=='12'}">
                        <td>관광지</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='14'}">
                        <td>문화시설</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='15'}">
                        <td>축제공연행사</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='25'}">
                        <td>여행코스</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='28'}">
                        <td>레포츠</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='32'}">
                        <td>숙박</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='38'}">
                        <td>쇼핑</td>
                    </c:when>
                    <c:when test="${category.contentTypeId=='39'}">
                        <td>음식점</td>
                    </c:when>
                    <c:otherwise>
                        <td>잘못된 입력입니다.</td>
                    </c:otherwise>
                </c:choose>
                <td>${category.sidoCode} ${category.gugunCode}</td>
                <td>${category.addr1}</td>
                <td><a href="category_details?content_id=${category.contentId}">자세히 보기</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="row">
    ${pageNavi.navigator}
</div>
</body>
</html>
