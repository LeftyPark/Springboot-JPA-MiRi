<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@include file="../layout/header.jsp" %>


        <!-- 바디 -->
        <div class="container">
            <br>

            <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
            <c:if test="${board.user.id == principal.user.id}">
                <a href="${board.id}/updateForm" class="btn btn-warning">수정</a>
                <button id="btn-delete" class="btn btn-danger">삭제</button>
            </c:if>
            <br><br>

            <div>
                글번호 : <span id="boardId"><i>${board.id}</i></span> &nbsp;&nbsp;&nbsp;
                작성자 : <span><i>${board.user.username}</i></span>
            </div>
            <br>

            <div class="form-group">
                <h3>${board.title}</h3>
            </div>
            <hr>

            <div class="form-group">
                <div>${board.content}</div>
            </div>
            <hr>
            <br>

            <div class="card">
                <form>
                    <input type="hidden" id="boardIdRe" value="${board.id}">
                    <div class="card-body">
                        <textarea id="reply-content" class="form-control" rows="1"></textarea>
                    </div>
                    <div class="card-footer">
                        <button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
                    </div>
                </form>
            </div>

            <br>




            <div class="card">
                <div class="card-header">댓글 리스트</div>
                <ul id="reply--box" class="list-group">

                    <c:forEach var="reply" items="${board.replys}">

                        <li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
                            <div>${reply.content}</div>
                            <div class="d-flex">
                                <div class="font-italic">작성자 : ${reply.user.username} &nbsp; 날짜 : ${reply.createDate}&nbsp;&nbsp;</div>

                                <c:if test="${reply.user.id eq principal.user.id}">
                                    <input type="hidden" id="replyId" value=${reply.id}>
                                    <!-- <input type="hidden" id="boardId" value=${board.id}> -->
                                    <span id="boardId" style="display: none;">${board.id}</span>
                                    <button type="button" id="deleteRe" class="badge">삭제</button>
                                </c:if>

                            </div>
                        </li>

                    </c:forEach>
                </ul>
            </div>


        </div>
        <br>
        <br>


        <script src="/miri/js/board.js"></script>
        <%@include file="../layout/footer.jsp" %>