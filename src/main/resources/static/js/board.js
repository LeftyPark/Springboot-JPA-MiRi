let index = {
    init: function(){
        $('#btn-save').on('click', ()=>{
            this.save();
        });
        $('#btn-delete').on('click', ()=>{
            this.deleteById();
        });
        $('#btn-update').on('click', ()=>{
            this.update();
        });
        $('#btn-reply-save').on('click', ()=>{
            this.replySave();
        });

        $('#deleteRe').on('click', ()=>{
            this.replyDelete();
        });

    },

    save: function(){
        // alert("오라이")
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
      console.log(data);

        $.ajax({
            type:"POST",
            url:"/miri/api/board",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("글 쓰기 완료");
            console.log(resp);
            location.href="/miri";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },



    deleteById: function(){
        let id = $("#boardId").text();

        $.ajax({
            type:"DELETE",
            url:"/miri/api/board/"+id,
            dataType:"json",
        }).done(function(resp){
            alert("글 삭제 완료");
            location.href="/miri";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },


    update: function(){
        let id = $("#id").val();
        // url에 필요한 id와 수정할 데이터들 title과 content를 문서에서 가져온다 (문서의 id셀렉터로)
        // 문서의 input태그의 타입을 히든으로 한것은 board.id가 보일 이유가 없기 때문에 숨기고 값만 가져온 것...
        let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

        $.ajax({
            type:"PUT",
            url:"/miri/api/board/"+id,
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("글 수정 완료");
            console.log(resp);
            location.href="/miri";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },


    replySave: function(){
        // alert("오라이")
        let data = {
            boardId: $('#boardIdRe').val(),
            content: $('#reply-content').val()
        };

      console.log(data);

        $.ajax({
            type:"POST",
            url:`${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("댓글 쓰기 완료");
            console.log(resp);
            location.href=`/miri/board/${data.boardId}`;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },


    replyDelete: function(){
        
        let data = {
            repId: $("#replyId").val(),
            boardId: $("#boardId").text()
        };

        console.log(data);
        
        $.ajax({
            type:"DELETE",
            url:`${data.boardId}/reply/${data.repId}`,
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("댓글 삭제 성공");
            console.log(resp);
            location.href=`/miri/board/${data.boardId}`;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },



}


index.init();