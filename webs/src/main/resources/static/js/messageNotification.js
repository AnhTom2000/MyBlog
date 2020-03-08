
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
/**************************所有消息****************************** */
var markRead = $('#markRead'); // 全部标记为已读a标签
var unmarkread = $('#unmarkread'); // 侧边栏未读消息数量
var icon = $('.icon-red-dot'); // 未读消息提示
var pump = $('#pump'); // 分割线（没啥用）
var unmarkreadCount = $('#unMarkReadCount'); // 未读消息数量
var $clear = $('#clear'); // 清空所有消息
var noMsg = $('#noMsg'); // 没有更多消息了
var msgUl = $('.msg-list>ul'); // 消息集合列表
var type = $(".type").attr('id'); // 消息类型
markRead.click(function () {
    markALLRead();
})

$clear.click(function () {
    if (confirm("确定要删除所有消息吗，(数据删除后不可恢复)")) {
        clear();
    }
})




// 标记所有点赞消息为已读
function markALLRead() {
    $.ajax({
        url: '/notice/' + type + '/markReadAll',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function (data) {
            if (data.code == 200) {
                toastr.success('标记成功');
                unmarkread.html('0');
                unmarkread.css("display", 'none');
                icon.css('display', 'none');
                markRead.css('display', 'none');
                pump.css('display', 'none');
                unmarkreadCount.html('0');
                setTimeout(function () {
                    window.location.reload();
                },500)
            } else if (!data.status) {
                toastr.warning('请先登录');
                $.get("/login", function (data, status, xhr) {
                    window.location.replace("/login");
                });
            } else {
                toastr.error('服务器异常，请重试');
            }
        }, error: function () {

        }
    })
}

// 清空所有点赞消息
function clear() {

    $.ajax({
        url: '/notice/' + type + '/clear',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function (data) {
            if (data.code == 200) {
                toastr.success('清空消息成功');
                unmarkread.html('0');
                unmarkread.css("display", 'none');
                $clear.css('display', 'none');
                unmarkreadCount.html('0');
                noMsg.css('display', 'block');
                msgUl.css('display', 'none');
                markRead.css('display', 'none');
                icon.css('display', 'none');
                pump.css('display', 'none');
                setTimeout(function () {
                    window.location.reload();
                },500)

            } else if (!data.status ) {
                toastr.warning('请先登录');
                $.get("/login", function (data, status, xhr) {
                    window.location.replace("/login");
                });
            } else {
                toastr.error('服务器异常，请重试');
            }
        }, error: function () {

        }
    })

}

// 删除单个点赞消息
function clearOne(btn) {
    if (confirm("确定要删除这条消息吗QWQ")) {
        var $NoticeId = $(btn).attr('id');
        if ($NoticeId != null && $NoticeId != '') {
            $.ajax({
                url: '/notice/' + type + '/clearOne',
                type: 'POST',
                data: { 'NoticeId': $NoticeId },
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (!data.status) {
                        toastr.warning('请先登录');
                        $.get("/login", function (data, status, xhr) {
                            window.location.replace("/login");
                        });
                    }
                    toastr.success('删除消息成功');
                    setTimeout(function () {
                        window.location.reload();
                    },500);
                    var count = parseInt(unmarkreadCount.html());
                    var countList = parseInt($('.msg-list').attr('id'));
                    $(btn).parent().parent().css('display', 'none');// 删除掉消息推送
                    if (count > 0 && (type == 'like')) {
                        unmarkreadCount.html((count - 1));
                        unmarkread.html((count - 1))
                        $(btn).parent().parent().prev().css('display', 'none');
                        $(btn).parent().parent().next().css('display', 'none');
                    } else if (type == 'comment' && count > 0) {
                        unmarkreadCount.html((count - 1));
                        unmarkread.html((count - 1))
                        $(btn).parent().parent().parent().css('display', 'none');
                        $(btn).parent().parent().parent().prev().css('display', 'none');
                        $(btn).parent().parent().parent().next().css('display', 'none');
                    } else if (type == 'system' && count > 0) {
                        unmarkreadCount.html((count - 1));
                        unmarkread.html((count - 1));
                        $(btn).parent().parent().parent().css('display', 'none');
                        $(btn).parent().parent().parent().prev().find("span").css('display', 'none');
                        $(btn).parent().parent().parent().next().css('display', 'none');
                    } if (count - 1 >= 0 || countList - 1 >= 0) {
                        console.log("为0");
                        count--;
                        if (count <= 0) {
                            unmarkread.html('0');
                            unmarkread.css("display", 'none');
                            $clear.css('display', 'none');
                            unmarkreadCount.html('0');
                            noMsg.css('display', 'block');
                            msgUl.css('display', 'none');
                            markRead.css('display', 'none');
                            icon.css('display', 'none');
                            pump.css('display', 'none');
                        } else if (countList <= 0) {
                            unmarkread.html('0');
                            unmarkread.css("display", 'none');
                            $clear.css('display', 'none');
                            unmarkreadCount.html('0');
                            noMsg.css('display', 'block');
                            msgUl.css('display', 'none');
                            markRead.css('display', 'none');
                            icon.css('display', 'none');
                            pump.css('display', 'none');
                        }
                    }

                }, error: function () {

                }
            })
        }
    }
}


/**************************点赞消息****************************** */

