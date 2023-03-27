<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="shortcut icon" href="./assets/img/favicon.ico"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <script src="./assets/js/key.js"></script>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <meta
            http-equiv="Content-Security-Policy"
            content="upgrade-insecure-requests"
    />
    <title>Run Into</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="/assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="./css/styles.css" rel="stylesheet"/>

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap"
            rel="stylesheet"
    />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="./js/section1.js" type="module"></script>
    <script src="./js/carousel.js" type="module"></script>
    <script src="./js/includeHTML.js"></script>
    <script src="./js/mypage.js"></script>
    <script></script>
</head>
<body>
<nav><%@include file="/enjoytrip-front/navbar.jsp"%></nav>

<hr/>
<header class="container"></header>

<section><%@include file="/enjoytrip-front/section1.jsp"%></section>

<section><%@include file="/enjoytrip-front/triplist.jsp"%></section>
<div><%@include file="/enjoytrip-front/carousel.jsp"%></div>
<section><%@include file="/enjoytrip-front/section2.jsp"%></section>
<section><%@include file="/enjoytrip-front/section3.jsp"%></section>

<footer><%@include file="/enjoytrip-front/footer.jsp"%></footer>

<script>
    includeHTML();
</script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"
></script>
<script src="./assets/js/main.js"></script>
<!--카카오맵-->
<script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9aa8d0db786b865d57c32e17da1053c4&libraries=services,clusterer,drawing"
></script>
<script>
    // index page 로딩 후 전국의 시도 설정.
    let areaUrl =
        'https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=' +
        serviceKey +
        '&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json';

    // fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
    fetch(areaUrl, {method: 'GET'})
        .then((response) => response.json())
        .then((data) => makeOption(data));

    function makeOption(data) {
        let areas = data.response.body.items.item;
        // console.log(areas);
        let sel = document.getElementById('search-area');
        areas.forEach((area) => {
            let opt = document.createElement('option');
            opt.setAttribute('value', area.code);
            opt.appendChild(document.createTextNode(area.name));

            sel.appendChild(opt);
        });
    }

    // 검색 버튼을 누르면..
    // 지역, 유형, 검색어 얻기.
    // 위 데이터를 가지고 공공데이터에 요청.
    // 받은 데이터를 이용하여 화면 구성.
    document.getElementById('btn-search').addEventListener('click', () => {
        let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;

        let areaCode = document.getElementById('search-area').value;
        let contentTypeId = document.getElementById('search-content-id').value;
        let keyword = document.getElementById('search-keyword').value;

        if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
        if (parseInt(contentTypeId))
            searchUrl += `&contentTypeId=${contentTypeId}`;
        if (!keyword) {
            alert('검색어 입력 필수!!!');
            return;
        } else searchUrl += `&keyword=${keyword}`;

        fetch(searchUrl)
            .then((response) => response.json())
            .then((data) => makeList(data));
    });

    var positions; // marker 배열.
    function makeList(data) {
        document.querySelector('table').setAttribute('style', 'display: ;');
        let trips = data.response.body.items.item;
        let tripList = ``;
        positions = [];
        trips.forEach((area) => {
            tripList += `
            <tr onclick="moveCenter(${area.mapy}, ${area.mapx});">
              <td><img src="${area.firstimage}" width="100px"></td>
              <td>${area.title}</td>
              <td>${area.addr1} ${area.addr2}</td>
              <td>${area.mapy}</td>
              <td>${area.mapx}</td>
            </tr>
          `;

            let markerInfo = {
                title: area.title,
                latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
            };
            positions.push(markerInfo);
        });
        document.getElementById('trip-list').innerHTML = tripList;
        displayMarker();
    }

    // 카카오지도
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
            level: 5, // 지도의 확대 레벨
        };

    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    function displayMarker() {
        // 마커 이미지의 이미지 주소입니다
        var imageSrc =
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';

        for (var i = 0; i < positions.length; i++) {
            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(24, 35);

            // 마커 이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image: markerImage, // 마커 이미지
            });
        }

        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
    }

    function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
    }
</script>
</body>
</html>