<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="layout/header.jsp" %>

        <link rel="stylesheet" href="./css/header.css">
        <!-- 바디 -->
        <div class="container">

            <!-- 본문 01 -->
            <c:forEach var="board" items="${boards.content}">
                <div class="card m-2">
                    <!-- <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
                    <div class="card-body">
                        <h4 class="card-title">${board.title}</h4>
                        <a href="board/${board.id}" class="btn btn-primary">상세보기</a>
                    </div>
                </div>
            </c:forEach>





            <!-- 페이징 -->
            <ul class="pagination justify-content-center">
                <c:choose>
                    <c:when test="${boards.first}">
                        <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="i" begin="1" end="${boards.totalPages}">
                    <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
                </c:forEach>

                <c:choose>
                    <c:when test="${boards.last}">
                        <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>




            <!-- <div style="background: rgb(205, 205, 205); height: 50px; padding: 1px;">
            </div> -->

            <!-- 추가 본문 -->
            <div class="content--back">
                <div class="content--w">
                    <div class="content--img">
                        <img src="img/lebron.jpeg" alt="">
                        <div class="content--text">1-1</div>
                    </div>
                    <div class="content--img">
                        <div class="content--text">2-1</div>
                    </div>
                    <div class="content--img">
                        <div class="content--text">3-1</div>
                    </div>
                </div>
            </div>



        </div>
        <br>


        <%@include file="layout/footer.jsp" %>