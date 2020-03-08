$(function () {

    toastr.options = {
        closeButton: true,
        debug: false,
        progressBar: false,
        positionClass: "toast-top-center",
        onclick: null,
        showDuration: "300",
        hideDuration: "1000",
        timeOut: "5000",
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",
        hideMethod: "fadeOut"
    };
    var loading_all_id = null;
    // 使用第三方账号github登陆
    $('#github').click(function () {
        // 加载过度动画
        loading_all_id = $(document.body).NZ_Loading("show", {
            content: "正在和github请求授权...",
        });
        $.ajax({
            url: '/api/authorize_url/github',
            type: 'GET',
            dataType: 'json',
            cache: false,
            success: function (data) {
                $(document.body).NZ_Loading("hide", {loadingid: loading_all_id});
               if(data.code === 400){
                   toastr.error(data.message);
               }else if(data.message === "登陆成功"){
                   window.location.replace('/');
               }else if(data.message == '账号已被锁定，不可以登陆') {
                   toastr.error(data.message);
               }
            }
        })
    });

    $('#login').click(function(){
       var username =  $('#username').val();
       var password = $('#password').val();
        if(username == '' || password == ''){
            toastr.error('用户名和密码不能为空');
            return;
        }
        $.ajax({
            url : '/user/login',
            type : 'POST',
            data : {'username' : username , 'password' : password},
            dataType : 'json',
            cache : false,
            success : function(data){
                if(data.status){
                    toastr.success(data.message+'，将在3秒后跳转至主页');
                    setTimeout(function(){
                        window.location.replace('/');
                    },3000);
                }else{
                    toastr.error(data.message);
                }
            }
        })

    })

});