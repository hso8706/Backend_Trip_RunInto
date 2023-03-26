<%--
  Created by IntelliJ IDEA.
  User: ggk14
  Date: 2023-03-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>triplist</title>
</head>
<body>
<!-- 중앙 content start -->
<div class="container px-4 px-lg-5 mb-5 pb-5">
  <div style="height: 5px"></div>
  <div class="row">
    <div class="col">
      <h1>관광지 정보 검색하기</h1>
      <!-- 관광지 검색 start -->
<%--      <form class="d-flex my-3" onsubmit="return false;" role="search">--%>
      <form class="d-flex my-3" role="search">
<%--        <select id="search-area" class="form-select me-2">--%>
<%--          <option value="0" selected>검색 할 지역 선택</option>--%>
<%--        </select>--%>
        <select id="search-content-id" class="form-select me-2" name="temp">
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
        <input
                id="search-keyword"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
        />
        <input type="submit" value="검색">
        <script>console.log()</script>
      </form>
    </div>
  </div>
  <!-- 중앙 content end -->
</div>

</body>
</html>
