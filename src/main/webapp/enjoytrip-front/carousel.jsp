<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container px-4 px-lg-5 mt-5">
  <h1>아름다운 강산, 한국</h1>
  <div id="demo" class="carousel slide" data-bs-ride="carousel">
    <!-- Indicators/dots -->
    <div class="carousel-indicators">
      <button
        type="button"
        data-bs-target="#demo"
        data-bs-slide-to="0"
        class="active"
      ></button>
      <button
        type="button"
        data-bs-target="#demo"
        data-bs-slide-to="1"
      ></button>
      <button
        type="button"
        data-bs-target="#demo"
        data-bs-slide-to="2"
      ></button>
      <button
        type="button"
        data-bs-target="#demo"
        data-bs-slide-to="3"
      ></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img
          id="carousel-img1"
          src="image/class/slide1.jpg"
          alt="Los Angeles"
          class="d-block w-100"
        />
      </div>
      <div class="carousel-item">
        <img
          id="carousel-img2"
          src="image/class/slide2.jpg"
          alt="Chicago"
          class="d-block w-100"
        />
      </div>
      <div class="carousel-item">
        <img
          id="carousel-img3"
          src="image/class/slide3.jpg"
          alt="New York"
          class="d-block w-100"
        />
      </div>
      <div class="carousel-item">
        <img
          id="carousel-img4"
          src="image/class/slide3.jpg"
          alt="New York"
          class="d-block w-100"
        />
      </div>
    </div>

    <!-- Left and right controls/icons -->
    <button
      class="carousel-control-prev"
      type="button"
      data-bs-target="#demo"
      data-bs-slide="prev"
    >
      <span class="carousel-control-prev-icon"></span>
    </button>
    <button
      class="carousel-control-next"
      type="button"
      data-bs-target="#demo"
      data-bs-slide="next"
    >
      <span class="carousel-control-next-icon"></span>
    </button>
  </div>
</div>
