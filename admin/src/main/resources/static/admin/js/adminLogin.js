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

var token;
var adminId;
$('#login').click(function () {
    var userName = $('#username');
    var password = $('#password');

    if(userName.val().length < 1 || password.val().length < 1){
        toastr.error('请输入正确数据');
        return false;
    }else {
        $.ajax({
            url : "/admin/superAdmin/login/adminLogin",
            type : 'POST',
            cache : false,
            dataType : 'json',
            data :{
                'username' : userName.val(),
                'password' : password.val()
            },
            success : function (data) {
                if(data.status){
                    $('#check').modal('show');
                    $('#check').modal({
                        backdrop :  false
                    });
                    token = data.data.uuid;
                    adminId = data.data.adminId;
                }else {
                    toastr.error('用户名或密码错误');
                }
            }
        })
    }
});


$('#cancel').click(function () {
    $.ajax({
        url : '/admin/superAdmin/login/cancel?uuid='+token,
        type : 'GET',
        cache: false,
        dataType: 'json' ,
        success : function (data) {
            toastr.success('取消登陆成功');
        }
    })
});
var flag = true;
$('#checkCode').change(function () {
   var error =   $('#error');
    reg=/^\d{6}$/;
    if(!reg.test($(this).val())){
        error.css('display','inline');
        flag = false;
    }else {error.css('display','none');flag = true;}
});

$('#confirm').click(function () {
    console.log(flag);
    if(flag){
        var checkCode =  $('#checkCode').val();
        $.ajax({
            url : '/admin/superAdmin/login/check',
            type : 'POST',
            cache : false,
            dataType : 'json',
            data : {
                'uuid' : token,
                'verifyCode' : checkCode,
                'adminId' : adminId
            },success : function (data) {
                if(data.status){
                    $.get("/admin/", function (data, status, xhr) {
                        window.location.replace("/admin/");
                    });
                }else {
                  toastr.error('验证码不存在或验证码错误');
                }
            }
        })
    }
});