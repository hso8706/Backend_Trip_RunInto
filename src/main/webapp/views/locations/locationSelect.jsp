<%--
  Created by IntelliJ IDEA.
  User: LeeYeEun
  Date: 2023/03/26
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        let url = 'http://localhost:8080/sidos';

        fetch(url, {method: 'GET'})
            // .then((response) => console.log(response.body));
            .then((response) => response.json())
            .then((data) => makeOptionSido(data));

        function makeOptionSido(data) {
            console.log(data);
            let areas = data;
            // console.log(areas);
            let sel = document.getElementById('search-sido');
            areas.forEach((area) => {
                let opt = document.createElement('option');
                opt.setAttribute('value', area);
                opt.appendChild(document.createTextNode(area));
                sel.appendChild(opt);
            });
            sel.setAttribute('onchange', 'getGugun()');
        }

        function getGugun() {
            let sido = document.getElementById('search-sido').value;

            let gugun = 'http://localhost:8080/guguns?sidoName=' + encodeURIComponent(sido);
            // let gugun = 'http://localhost:8080/guguns?sidoName=';
            fetch(gugun, {method: 'GET'})
                .then((res) => res.json())
                // .then((response) => response.json())
                .then((data) => makeOptionGugun(data));
        }

        function makeOptionGugun(data) {
            console.log(data);
            let areas = data;
            // console.log(areas);
            let sel = document.getElementById('search-gugun');
            sel.innerHTML = ''; // sel의 모든 선택지 삭제
            areas.forEach((area) => {
                let opt = document.createElement('option');
                opt.setAttribute('value', area);
                opt.appendChild(document.createTextNode(area));
                sel.appendChild(opt);
            });
        }

        function search() {
            let sido = document.getElementById('search-sido').value;
            let gugun = document.getElementById('search-gugun').value;
            let keyword = document.getElementById('search-keyword').value;
            let url = 'http://localhost:8080/locationsResult?sidoName=' + encodeURIComponent(sido) +
                '&gugunName=' + encodeURIComponent(gugun) +
                '&keyword=' + encodeURIComponent(keyword);
            fetch(url, {method: 'GET'})
                .then((res) => res.json())
                // .then((response) => response.json())
                .then((data) => makeList(data));
        }
        function makeList(data) {
            document.querySelector('table').setAttribute('style', 'display: ;');
            let trips = data;
            let tripList = ``;
            positions = [];
            trips.forEach((area) => {
                tripList += `
            <tr onclick="moveCenter(${area.mapy}, ${area.mapx});">
              <td><img src="${area.firstImage}" width="100px"></td>
              <td>${area.title}</td>
              <td>${area.addr1} ${area.addr2}</td>
              <%--<td>${area.latitude}</td>--%>
              <%--<td>${area.longitude}</td>--%>
            </tr>
          `;
            });
            //     let markerInfo = {
            //         title: area.title,
            //         latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
            //     };
            //     positions.push(markerInfo);
            // });
            document.getElementById('trip-list').innerHTML = tripList;
            // displayMarker();
        }
    </script>

    <div class="container px-4 px-lg-5 mb-5 pb-5">
        <div style="height: 5px"></div>
        <div class="row">
            <div class="col">
                <h1>관광지 정보 검색하기</h1>
                <!-- 관광지 검색 start -->
                <form class="d-flex my-3" onsubmit="return false;" role="search">
                    <select id="search-sido" class="form-select me-2">
                        <option value="0" selected>검색 할 시/도 선택</option>
                    </select>

                    <select id="search-gugun" class="form-select me-2">
                        <option value="0" selected>검색 할 군/구 선택</option>
                    </select>
                    <input
                            id="search-keyword"
                            class="form-control me-2"
                            type="search"
                            placeholder="검색어"
                            aria-label="검색어"
                    />
                    <button onclick="search()" id="btn-search" class="btn btn-outline-success" type="button">
                        검색
                    </button>
                </form>
                <!-- kakao map start -->
<%--                <div id="map" class="mt-3" style="width: 100%; height: 400px"></div>--%>
                <!-- kakao map end -->
                <div class="row">
                    <table class="table table-striped" style="display: none">
                        <thead>
                        <tr>
                            <th>대표이미지</th>
                            <th>관광지명</th>
                            <th>주소</th>
                        </tr>
                        </thead>
                        <tbody id="trip-list"></tbody>
                    </table>
                </div>
                <!-- 관광지 검색 end -->
            </div>
        </div>
        <!-- 중앙 content end -->
    </div>

</body>
</html>
