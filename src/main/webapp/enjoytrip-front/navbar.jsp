<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid px-4 px-lg-5">
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <!-- 로고 -->
    <a class="navbar-brand" href="index.jsp">Run Into</a>

    <!-- 검색창 -->
    <form style="width: 200px;">
<%--      <input class="form-control me-2" type="text" placeholder="Search" />--%>
          <button class="btn btn-primary " type="button"><a href="locations" style="color: whitesmoke; text-decoration-line: none; font-weight: bold;">지역</a></button>
          <button class="btn btn-primary " type="button"><a href="category" style="color: whitesmoke; text-decoration-line: none; font-weight: bold;">유형</a></button >
    <%--      <a href="locations" style="background-color: dodgerblue; color: whitesmoke; text-decoration-line: none; font-weight: bold">지역별 검색</a>--%>
<%--      <a href="category" style="background-color: dodgerblue; color: whitesmoke; text-decoration-line: none; font-weight: bold">유형별 검색</a>--%>
    </form>

    <!-- 로그인 섹션 -->
    <div
      class="collapse navbar-collapse justify-content-end"
      id="navbarSupportedContent1"
    >
      <!--로그인 섹션 -->
      <form class="d-flex">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
          <li class="nav-item">
            <a
              class="nav-link active"
              data-bs-toggle="modal"
              aria-current="page"
              href="#adminLoginModal"
            >
              <button
                class="nav-link btn btn-light"
                type="button"
                data-toggle="modal"
              >
                로그인
              </button></a
            >
            <div class="modal fade" id="adminLoginModal" role="dialog">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title">로그인</h5>
                    <button
                      type="button"
                      class="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>
                  <div class="modal-body">
                    <div class="contasiner">
                      <!-- <h2>로그인폼</h2> -->
                      <form action="login.jsp" method="post">
                        <div class="mb-3">
                          <label class="form-label" for="id">아이디</label>
                          <input
                            class="form-control"
                            type="text"
                            name="id"
                            id="id"
                          />
                        </div>
                        <div class="mb-3">
                          <label class="form-label" for="pwd">비밀번호</label>
                          <input
                            class="form-control"
                            type="password"
                            name="pwd"
                            id="pwd"
                          />
                        </div>
                      </form>
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button
                      class="btn btn-outline-primary btn-sm"
                      type="submit"
                    >
                      로그인
                    </button>
                    <button
                      class="btn btn-outline-primary btn-sm"
                      type="submit"
                    >
                      비밀번호 찾기
                    </button>
                    <button
                      type="button"
                      class="btn btn-outline-primary btn-sm"
                      data-bs-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </li>

          <li class="nav-item">
            <a class="nav-link active" href="#">
              <button
                class="nav-link btn btn-light"
                type="button"
                onclick="logout();"
              >
                로그아웃
              </button></a
            >
          </li>

          <!-- 로그아웃 -->
          <li class="nav-item">
            <a
              class="nav-link active"
              href="/enjoytrip-front/enjoytrip-front/mypage.html"
              target="_self"
            >
              <button class="nav-link btn btn-light" type="button">
                마이페이지
              </button>
            </a>
          </li>

          <!-- 회원가입 섹션 -->
          <li class="nav-item">
            <a
              class="nav-link active"
              data-bs-toggle="modal"
              aria-current="page"
              href="#joinMembership"
            >
              <button
                class="nav-link btn btn-light"
                type="button"
                data-toggle="modal"
              >
                회원가입
              </button></a
            >
            <div class="modal fade" id="joinMembership" role="dialog">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title">회원 가입</h4>
                    <button
                      type="button"
                      class="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>

                  <!-- 회원가입 내용 -->
                  <div class="modal-body">
                    <div class="container">
                      <form action="login.jsp" method="post">
                        <div class="mb-3">
                          <label class="form-label" for="name">이름</label>
                          <input
                            class="form-control"
                            type="text"
                            name="name"
                            id="navName"
                          />
                        </div>

                        <div class="mb-3">
                          <label class="form-label" for="id">아이디</label>
                          <input
                            class="form-control"
                            type="text"
                            name="navid"
                            id="navId"
                          />
                        </div>

                        <div class="mb-3">
                          <label class="form-label" for="pwd">비밀번호</label>
                          <input
                            class="form-control"
                            type="password"
                            name="pwd"
                            id="navPwd"
                          />
                        </div>

                        <div class="mb-3">
                          <label class="form-label" for="pwdCheck"
                            >비밀번호 확인</label
                          >
                          <input
                            class="form-control"
                            type="password"
                            name="pwCheck"
                            id="navPwCheck"
                          />
                        </div>
                      </form>
                    </div>
                  </div>

                  <div class="modal-footer">
                    <button
                      class="btn btn-outline-primary btn-sm"
                      type="submit"
                      onclick="mypageSet()"
                    >
                      회원가입
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </form>
    </div>
  </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid px-4 px-lg-5">
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
      <form class="d-flex">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#!">항공권</a>
          </li>
          <li class="nav-item"><a class="nav-link" href="#!">숙소</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="#!">투어 티켓</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="#!">국내 렌터카</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="#!">패키지</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="#!">호텔 특가</a>
          </li>
          <li>
            <a
              class="nav-link dropdown-toggle"
              id="navbarDropdown"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
              >더보기</a
            >
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#!">All Products</a></li>
              <li><hr class="dropdown-divider" /></li>
              <li><a class="dropdown-item" href="#!">Popular Items</a></li>
              <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
            </ul>
          </li>
        </ul>
      </form>
    </div>
  </div>
</nav>
