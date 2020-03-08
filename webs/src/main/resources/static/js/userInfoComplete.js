$(function () {
    var user_flag = true;
    var email_flag = true;
    var checkCode_flag = true;

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

    //  邮箱的正则表达式
    var partten = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

// 定义发送时间间隔(s)
    var my_interval;
    my_interval = 120;
    var timeLeft = my_interval;
//重新发送计时函数
    var timeCount = function () {
        window.setTimeout(function () {
            if (timeLeft > 0) {
                timeLeft -= 1;
                $('#getCode').html(timeLeft + "秒重新发送");
                timeCount();
            } else {
                $('#getCode').html("重新发送");
                timeLeft = 120;
                document.getElementById("getCode").removeAttribute('disabled');
                $('#getCode').css('cursor','pointer');
            }
        }, 1000);
    };
    $('#username').change(function () {
        if ($('#username').val() == '') return false;
        var username = $('#username').val();
        $.ajax({
            url: '/api/check/user/' + username + '/exist',
            type: 'get',
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (!data.status) {
                    toastr.error("用户名已存在");
                    user_flag = false;
                } else {
                    user_flag = true;
                }
            }
        })
    });

    //发送验证码
    $('#getCode').click(function () {
        if ($('#email').val() == '' || !partten.exec($('#email').val())) {
            toastr.error('请输入正确的邮箱');
            email_flag = false;
            return;
        }
        // 加载过度动画
        var loading_all_id = null;
        loading_all_id = $(document.body).NZ_Loading("show", {
            content: "正在发送邮箱验证码...",
        });
        $.ajax({
            url: '/api/send/email/' + $('#email').val() + '/checkCode',
            type: 'GET',
            dataType: 'json',
            cache: false,
            success: function (data) {
                $(document.body).NZ_Loading("hide", {loadingid: loading_all_id});
                if (data.status) {
                    toastr.success(data.message);
                    document.getElementById('getCode').setAttribute("disabled", true);
                    $('#getCode').css('cursor','not-allowed');
                    timeCount();
                    email_flag = true;
                } else {
                    document.getElementById('getCode').removeAttribute('disabled');
                    $('#getCode').css('cursor','pointer');
                    email_flag = false;
                }
            }
        })
    });


    //  第三方用户完善登陆信息
    $('#complete').click(function () {
        if (!user_flag || $('#username').val() == '') {
            toastr.warning('请重新输入一个新的用户名');
            return;
        }
        if (!email_flag || $('#email').val() == '') {
            toastr.warning('请重新输入一个新的邮箱');
            return;
        }
        if (!checkCode_flag || $('#checkCode').val() == '') {
            toastr.warning('您的验证码输入错误，请重新输入');
            return;
        }
        $.ajax({
            url: '/user/oauth/information/complete',
            type: 'post',
            data: {
                'username': $('#username').val(),
                'email': $('#email').val(),
                'verificationCode': $('#checkCode').val()
            },
            cache: false,
            dataType: 'json',
            success: function (data) {
                if (data.status) {
                    toastr.success(data.message + ',' + '将在三秒内自动为您跳转到首页');
                    setTimeout(function () {
                        window.location.replace('/complete');
                    }, 3000);
                } else {
                    toastr.error(data.message);
                }
            }, error: function (data) {
                toastr.error('服务器错误！');
            }
        })
    })
});