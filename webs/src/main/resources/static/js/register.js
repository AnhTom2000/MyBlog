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

    // 检查用户名是否重复
    $('#username').change(function () {
        $(this).keyup(function () {
            if ($('#username').val() == '') return;
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
                        key = 0;
                    }
                }
            })
        })
    });


    $('#getCode').click(function () {
        //  邮箱的正则表达式
        var email = $('#email').val();
        var partten = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if (email == '' || !partten.exec(email)) {
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


    $('#email').blur(function () {
        if ($(this).val() == '') {
            toastr.warning('尚未填写邮箱噢');
        }
    });

    // 本平台用户注册
    $('#register').click(function () {
        var username = $('#username').val();
        var email = $('#email').val();
        var checkCode = $('#checkCode').val();
        var password = $('#password').val();

        if (!user_flag || username == '') {
            toastr.error('请输入正确的用户名');
            return;
        }
        if (!email_flag || email == '') {
            toastr.error('请输入正确的邮箱');
            return;
        }
        if (!checkCode_flag || checkCode == '') {
            toastr.error('请输入正确的验证码');
            return;
        }
        if (password == '') {
            toastr.error('密码不能为空');
            return;
        };
        $.ajax({
            url: '/user/register',
            type: 'post',
            data: {'username': username, 'email': email, 'verificationCode': checkCode, 'password': password},
            cache: false,
            dataType: 'json',
            success: function (data) {
                if (data.status) {
                    toastr.success('操作成功，将在三秒后跳转至主页');
                    setTimeout(function () {
                        window.location.replace('/');
                    }, 3000);
                } else {
                    toastr.error('操作失败，请正确操作');
                }
            }, error: function () {
                toastr.error('服务器异常');
            }
        })

    })

})