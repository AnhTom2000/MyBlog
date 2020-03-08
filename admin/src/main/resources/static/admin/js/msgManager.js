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
$('.exit').click(function () {
    exit(this);
});
function exit(btn){
    $.ajax({
        url : '/admin/superAdmin/exit/adminExit',
        type :'POST',
        data : {
            'adminId' : $(btn).attr('id')
        },cache : false,
        dataType : 'json',
        success : function (data) {
            $.get("/admin/login", function (data, status, xhr) {
                window.location.replace("/admin/login");
            });
        }
    })
}
$.ajax({
    url: '/admin/user/findAll',
    type: 'POST',
    dataType: 'json',
    cache: false,
    data: {
        'pageNo': 1,
        'pageSize': 5,
    },
    success: function (data) {
        var str = "";
        $.each(data.data, function (index, obj) {
            str += "<option value='" + obj.userId + "'>" + obj.userName + "</option>"
        });
        $('#user').append(str);
    }, error: function () {

    }
});

// 发送消息
$('#send').click(function () {
    var userId = $('#user').val();
    var Content = $('#content').val();
    if (userId == null) {
        toastr.error('请选择用户');
        return false;
    }
    if (Content == null || Content.length < 1) {
        toastr.error('通知消息不能为空');
        return false;
    }
    else {
        console.log(userId);
        $.ajax({
            url: '/admin/superAdmin/sendToUser',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'userId': userId,
                'content': Content
            }, success: function (data) {
                if (data.code == 200) {
                    toastr.success('发送成功');
                    $('#content').val('');
                } else if (data.code == 404) {
                    toastr.error('请先登录');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                }else {
                    toastr.error('服务器异常，请重试');
                }
            }, error: function () {

            }
        })
    }
});