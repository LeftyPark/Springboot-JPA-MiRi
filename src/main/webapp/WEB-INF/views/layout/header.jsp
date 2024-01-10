<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal" var="principal" />
            </sec:authorize>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <title>Bootstrap Example</title>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
                <link rel="stylesheet" href="../css/header.css">

                <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <!-- bg-dark -->

                <!-- <div 네브바>
                    <a href="">로고</a>
                    <a href=""></a>
                    <a href=""></a>
                </div> -->

                <nav class="navbar navbar-expand-md header--navbar">
                    <a class="navbar-brand" href="/miri">MiriBogo</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">

                        <c:choose>
                            <c:when test="${empty principal}">
                                <ul class="navbar-nav">
                                    <li class="nav-item"><a class="nav-link" href="/miri/auth/loginForm">로그인</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/miri/auth/joinForm">회원가입</a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul class="navbar-nav">
                                    <li class="nav-item"><a class="nav-link" href="/miri/board/saveForm">글쓰기</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/miri/user/updateForm">회원정보</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/miri/logout">로그아웃</a></li>
                                    <h4>${board.user.username}</h4>
                                </ul>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </nav>
                <br>