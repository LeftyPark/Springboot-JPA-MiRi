<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@include file="../layout/header.jsp" %>

        <!-- 바디 -->
        <div class="container">
            <form>
                <input type="hidden" id="id" value="${principal.user.id}">
                <div class="form-group">
                    <label for="username">Username</label> <input type="text" class="form-control"
                       value="${principal.user.username}" placeholder="Enter username" id="username" readonly>
                </div>
                <div class="form-group">
                    <label for="password">Password</label> <input type="password" class="form-control"
                        placeholder="Enter password" id="password">
                </div>
                <div class="form-group">
                    <label for="email">Email</label> <input type="email" class="form-control" placeholder="Enter email"
                        value="${principal.user.email}" id="email">
                </div>
            </form>
            <button id="btn-update" class="btn btn-primary">수정완료</button>
        </div>

        <br>

        <script src="/miri/js/user.js"></script>
        <%@include file="../layout/footer.jsp" %>