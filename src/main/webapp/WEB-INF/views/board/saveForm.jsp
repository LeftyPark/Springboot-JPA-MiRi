<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@include file="../layout/header.jsp" %>

        <!-- 바디 -->
        <div class="container">

            <form>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Enter title" id="title">
                </div>

                <div class="form-group">
                    <textarea class="form-control summernote" rows="5" id="content"></textarea>
                </div>
            </form>
            <button id="btn-save" class="btn btn-primary">글쓰기 완료</button>

            <input type="file" name="uplaodFiles" multiple>
            <button class="btn btn-primary uploadBtn">이미지 업로드</button>
        </div>
        <br>

        <script>

            $('.uploadBtn').click(function(){
                var formData = new FormData();
                var inputFile = $("input[type='file']");
                var files = inputFile[0].files;

                for(var i=0; i<files.length; i++){
                    console.log(files[i]);
                    formData.append("uploadFiles", files[i]);
                }

                $.ajax({
                    type: 'POST',
                    url:'/miri/uploadAjax',
                    data: formData,
                    processData: false,
                    contentType: false,
                    dataType: 'json',
                    success: function(result){
                        console.log(result);
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        console.log(textStatus);
                    }
                });
            });
        </script>


        <script src="/miri/js/board.js"></script>
        <%@include file="../layout/footer.jsp" %>