
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
})

function deleteArticle(btn) {
    if (confirm('确认删除？删除之后数据不可以恢复噢')) {
     
        var authId = $(btn).parent().attr('id');
        var articleId = $(btn).attr('id');
        
        $.ajax({
            url: '/article/markdown_delete',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: { 'articleId': articleId, 'authId': authId },
            success: function (data) {
                if (data.code == 400) {
                    toastr.warning('请先登录');
                    $.get("/login", function (data, status, xhr) {
                        window.location.replace("/login");
                    });
                } else if (data.code == 404) {
                    toastr.error('文章不存在，请刷新页面重试');
                    return;
                } else {
                    toastr.success('删除成功！');
                    $(btn).parent().parent().parent().parent().css('display','none');
                }
            },
            error : function(){
                
            }
        })
    } else {
        return;
    }
}