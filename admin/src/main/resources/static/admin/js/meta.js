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
$('#comfrim').click(function () {
    var metaKeyWord = $('#metaKeyWord');
    if (metaKeyWord.val().length < 1) {
        toastr.error('meta关键字不能为空');
        return false;
    } else {
        $.ajax({
            url: '/admin/site/updateMeta',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'keywords': metaKeyWord.val(),
                'webInfoId' :   $('.meta').attr('id')
            },
            success: function (data) {
                if (data.code == 200) {
                    toastr.success('修改成功');
                }
                else if (data.code == 404) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                }
            }
        })
    }
})

$('#yes').click(function () {
    var metaDescription = $('#metaDescription');
    if (metaDescription.val().length < 1) {
        toastr.error('meta描述不能为空');
        return false;
    } else {
        $.ajax({
            url: '/admin/site/updateMeta',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'description': metaDescription.val(),
                'webInfoId' :   $('.meta').attr('id')
            },
            success: function (data) {
                if (data.code == 200) {
                    toastr.success('修改成功');
                }
                else if (data.code == 404) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                }
            }
        })
    }
})

$('#save').click(function () {
    var beianKeyWord = $('#beianKeyWord');
    if (beianKeyWord.val().length < 1) {
        toastr.error('copyRight不能为空');
        return false;
    } else {
        $.ajax({
            url: '/admin/site/updateMeta',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'copyRight': beianKeyWord.val(),
                'webInfoId' :   $('.meta').attr('id')
            },
            success: function (data) {
                if (data.code == 200) {
                    toastr.success('修改成功');
                }
                else if (data.code == 404) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                }
            }
        })
    }
})

$('#send').click(function () {
    var beianDescription = $('#beianDescription');
    if (beianDescription.val().length < 1) {
        toastr.error('备案信息不能为空');
        return false;
    } else {
        $.ajax({
            url: '/admin/site/updateMeta',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'icp': beianDescription.val(),
                'webInfoId' :   $('.meta').attr('id')
            },
            success: function (data) {
                if (data.code == 200) {
                    toastr.success('修改成功');
                }
                else if (data.code == 404) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                }
            }
        })
    }
});

$.ajax({
    url : '/admin/site/findAllMeta',
    type : 'GET',
    dataType : 'json',
    cache : false,
    success : function (data) {
        $('#beianDescription').val(data.data.icpInfo);
        $('#beianKeyWord').val(data.data.copyright);
        $('#metaDescription').val(data.data.description);
        $('#metaKeyWord').val(data.data.keywords);
        $('.meta').attr('id',data.data.webInfoId);
    }
});
