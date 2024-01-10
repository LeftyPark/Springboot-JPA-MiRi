let index = {
    init: function(){
        $('#btn-save').on('click', ()=>{
            this.save();
        });

        $('#btn-update').on('click', ()=>{
            this.update();
        });

    },

    save: function(){
        // alert("오라이")
        let data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val()
        };
      console.log(data);

        $.ajax({
            type:"POST",
            url:"/miri/auth/joinProc",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){

            if(resp.status===500){
                console.log(resp);
                alert("회원가입 실패");
            }else{
                alert("회원가입 완료");
                location.href="/miri";
            }
            
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },


    update: function(){
        let data = {
            id: $('#id').val(),
            username: $("#username").val(),
            password: $('#password').val(),
            email: $('#email').val()
        };
      console.log(data);

        $.ajax({
            type:"PUT",
            url:"/miri/user",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("회원 수정 완료");
            console.log(resp);
            location.href="/miri";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }



}


index.init();