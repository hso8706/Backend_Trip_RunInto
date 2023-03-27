<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Run Into</title>

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap"
      rel="stylesheet"
    />

    <script src="../js/includeHTML.js"></script>
    <script src="../js/mypage.js"></script>
  </head>
  <body>
    <nav include-html="/enjoytrip-front/navbar.html"></nav>

    <hr />
    <div class="container px-4 px-lg-5 mt-5">
      <h1 id="userStatus">개인 정보 수정</h1>
      <br />
      <div class="card">
        <div class="card-header"><h2>기본 정보</h2></div>
        <div class="card-body">
          <div class="card">
            <ul class="list-group list-group-flush">
              <div class="row">
                <div class="col-md-3" style="padding-right: 0">
                  <li class="list-group-item">이름</li>
                </div>
                <div class="col-md-9" style="padding-left: 0">
                  <li class="list-group-item" id="1"></li>
                </div>
              </div>

              <div class="row">
                <div class="col-md-3" style="padding-right: 0">
                  <li class="list-group-item">아이디</li>
                </div>
                <div class="col-md-9" style="padding-left: 0">
                  <li class="list-group-item" id="2"></li>
                </div>
              </div>

              <div class="row">
                <div class="col-md-3" style="padding-right: 0">
                  <li class="list-group-item">비밀 번호</li>
                </div>
                <div class="col-md-9" style="padding-left: 0">
                  <li class="list-group-item" id="3"></li>
                </div>
              </div>

              <div class="row">
                <div class="col-md-3" style="padding-right: 0">
                  <li class="list-group-item">비밀 번호 확인</li>
                </div>
                <div class="col-md-9" style="padding-left: 0">
                  <li class="list-group-item" id="4"></li>
                </div>
              </div>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <script>
      includeHTML();
    </script>
    <script>
      if (window.localStorage.getItem(1) === null) {
        document.getElementById('userStatus').innerHTML =
          '<h1>아직 로그인 하지 않았습니다!  <br> 로그인해주세요!</h1>';
      }
      function loading(params) {
        for (let index = 1; index < 5; index++) {
          document.getElementById(index).innerText =
            window.localStorage.getItem(index);
        }
      }
      let name = document.getElementById('1');
      console.log(name.innerText);
      name.innerText = window.localStorage.getItem(1);

      window.onload = loading;
    </script>
    <script>
      includeHTML();
    </script>
  </body>
</html>
