<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="./step1.css" />
    <%@ include file = "../../common/bootstrapCommon.jsp" %>
  </head>
  <body>
    <!-- ====================[[Navbar]]==================== -->
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
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
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider" /></li>
                <li>
                  <a class="dropdown-item" href="#">Something else here</a>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">Disabled</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
            />
            <button class="btn btn-outline-success" type="submit">
              Search
            </button>
          </form>
        </div>
      </div>
    </nav>
    <!-- ====================[[Navbar end]]==================== -->
    <!-- =====================[[carousel]]===================== -->
    <div
      id="carouselExampleIndicators"
      class="carousel slide"
      data-bs-ride="true"
    >
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="2"
          aria-label="Slide 3"
        ></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://via.placeholder.com/900x250"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="https://via.placeholder.com/900x250"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="https://via.placeholder.com/900x250"
            class="d-block w-100"
            alt="..."
          />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <!-- =====================[[carousel end]]===================== -->
    <!-- ======================[[   card   ]]====================== -->
    <div class="card-group">
    <div class="card" style="width: 18rem;">
  <img src="../../images/sample/우주1.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">핑크젤리 우주</h5>
    <p class="card-text">귀여운 핑크젤리와 볼따구가 도드러지는 사진이다.</p>
    <a href="#" class="btn btn-primary">젤리 만지러가기</a>
  </div>
  </div>
  <div class="card" style="width: 18rem;">
  <img src="../../images/sample/우주2.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">스마일 우주</h5>
    <p class="card-text">이우주 인생 레전드 사진이다. 아마 더이상은 나오지 않을 사진인 것 같다.</p>
    <a href="#" class="btn btn-primary">수염 만지러가기</a>
  </div>
  </div>
  <div class="card" style="width: 18rem;">
  <img src="../../images/sample/우주3.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">학교가는 우주</h5>
    <p class="card-text">올해 학교입학하는 이우주다. 교복이 아주 멋스럽게 어울린다.</p>
    <a href="#" class="btn btn-primary">교복 벗기러가기</a>
  </div>
</div>
    <!-- ======================[[ card end ]]====================== -->
    <!-- ========================[[footer]]======================== -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom">
      <div class="container-fluid">
        <span class="navbar-brand footer">"바닥입니다</span>
      </div>
    </nav>
    <!-- ======================[[footer end]]====================== -->
  </body>
</html>
