
$('.userList .clickLi').click(function () {
    var flag = $(this).attr('class').substring(8);
    $('#personalDate,#basicSetting,#commentMessage,#leaveMessage,#leaveWord,#privateWord').css("display", "none");
    $("#" + flag).css("display", "block");
});

$('.basicSetting').click(function () {
    $('#phone').val("");
    $('#authCode').val("");
    $('#password').val("");
    $('#surePassword').val("");
});

// 初始化弹框元素
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



$('#exit').click(function () {
    console.log('退出');
    $.ajax({
        url: '/api/exit/userExit',
        type: 'GET',
        dataType: 'json',
        success: function () {
            window.location.reload();
        }
    })
});

//更改头像
function imgChange(e) {
    var fromdata = new FormData($("#img")[0]);
    $.ajax({
        type: 'POST',
        url: '/api/uploadUserImg',
        dataType: 'json',
        async: false,
        cache: false,
        contentType: false,//ajax上传图片需要添加
        processData: false,//ajax上传图片需要添加
        data: fromdata,
        success: function (data) {
            if (data.message == '请先登陆') {
                    toastr.warning('请先登录');
                    $.get("/login", function (data, status, xhr) {
                        window.location.replace("/login");
                    });
            } else {
                if (data.success == 1) {
                    $('#headPortrait').attr("src", data.url);
                    toastr.success("更改头像成功");
                } else {
                    toastr.error("更改头像失败")
                }
            }

        },
        error: function () {
        }
    });
};



//保存个人资料
var savePersonalDateBtn = $('#savePersonalDateBtn');
var age = $('#age');
var phone = $('#phone');
var gender = $('.genderTable input');
var email = $('#email');
var area = $('#area');
var profession = $('#profession');
var description = $('#description');

//限制个人简介长度，不能超过五十个字
var flag = true;
$('#description').on("keydown",function () {
    if($(this).val().length>50){
       if(flag)  {toastr.warning('个人简介最多50个字噢');flag = false}
        var lenText = $(this).val().substring(0, 50);
        description.val(lenText);
    }
})
savePersonalDateBtn.click(function () {
    var genderValue = "male";
    if (!gender[0].checked && !gender[1].checked) {
        toastr.error("性别不能为空");
    } else {
        if (gender[0].checked) {
            genderValue = true;
        } else {
            genderValue = false;
        }
        $.ajax({
            type: 'post',
            url: '/user/modify/savePersonalUpdate',
            dataType: 'json',
            data: {
                'age': age.val(),
                'gender': genderValue,
                'email': email.val(),
                'area': area.val(),
                'phone': phone.val(),
                'profession': profession.val(),
                'description': description.val()
            },
            success: function (data) {
                if (!data.status) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/login", function (data, status, xhr) {
                        window.location.replace("/login");
                    });
                } else {
                    if (data.code == 200) {
                        toastr.success("更改成功,刷新页面后生效");
                        setTimeout(function () {
                            location.reload();
                        }, 3000);
                    } else if (data.code == 400) {
                        toastr.error("该用户名已被使用");
                    } else {
                        toastr.error("更改个人信息失败");
                    }
                }
            },
            error: function () {
            }
        });
    }
});

var email = $('#email');
var authCode = $('#checkCode');
var password = $('#modifyPassword');
var surePassword = $('#checkPassword');

email.blur(function () {
    var pattren = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
    var emailValue = email.val();
    if (pattren.test(emailValue)) {
        email.removeClass("wrong");
        email.addClass("right");
    } else {
        email.removeClass("right");
        email.addClass("wrong");
    }
});
email.focus(function () {
    $('.notice').css("display", "none");
});


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

//  发送邮箱的验证码
$('#getCode').click(function () {
    //  邮箱的正则表达式
    var email = $('#email');
    var partten = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    $('.notice').css("display", "none");
    if (email.val().length == 0 || !partten.exec(email.val())) {
        toastr.error('请输入正确的邮箱');
        email_flag = false;
        return;
    }
    document.getElementById('getCode').setAttribute("disabled", true); 
    $('#getCode').css('cursor','not-allowed');
    $.ajax({
        url: '/api/send/email/' + email.val() + '/checkCode',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function (data) {
            if (data.status) {
                toastr.success(data.message);
                timeCount();
            } else {
                toastr.error("验证码发送异常");
                document.getElementById('getCode').removeAttribute('disabled');
                $('#getCode').css('cursor','pointer');
            }
        }, error: function () {

        }
    })
});


//修改密码
$('#changePasswordBtn').click(function () {
    $('.notice').css("display", "none");
    if (email.val().length === 0) {
        toastr.error("邮箱不能为空");
    } else if (email.hasClass("wrong")) {
        toastr.error("邮箱不正确");
    } else if (authCode.val().length === 0) {
        toastr.error("验证码不能为空");
    } else if (password.val().length === 0) {
        toastr.error("新密码不能为空");
    } else if (surePassword.val().length === 0) {
        toastr.error("确认密码不能为空");
    } else {
        if (password.val() !== surePassword.val()) {
            toastr.error("确认密码不正确");
        } else {
            console.log(password.val());
            
            $.ajax({
                type: 'post',
                url: '/user/modify/password',
                dataType: 'json',
                data: {
                    'email': email.val(),
                    'verificationCode': authCode.val(),
                    'modifyPassword': password.val()
                },
                success: function (data) {
                    if (data.code == 400) {
                        toastr.error("验证码不正确")
                    } else if (data.code == 404) {
                        toastr.error(data.message);
                    } else if (data.code == 500) {
                        toastr.error(data.message);
                    } else {
                        toastr.success("密码修改成功,请重新登录");
                        setTimeout(function () {
                            window.location.replace("/login");
                        }, 3000);
                    }
                },
                error: function () {
                    toastr.error("修改密码失败");
                    document.getElementById('getCode').removeAttribute('disabled');
                    $('#getCode').css('cursor','pointer');
                }
            })
        }
    }
});

