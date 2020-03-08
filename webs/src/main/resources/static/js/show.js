var articleId = "";
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

//填充文章
function putInArticle(data) {
    var wordsView;
    wordsView = editormd.markdownToHTML("wordsView", {
        htmlDecode: "style,script,iframe", // you can filter tags decode
        emoji: true,
        taskList: true,
        tex: true,
        flowChart: true,
        sequenceDiagram: true
    });

    if (data.isLiked == 1) {
        $('.likeBtn').css({
            "background-color": "#EA6F5A",
            "color": "white"
        });
        $('.likesNum').css({
            "border-left": "1px solid white"
        });
        $('.likeHeart').find('i').removeClass("am-icon-heart-o");
        $('.likeHeart').find('i').addClass("am-icon-heart");
    }
    $('.other').append($('<div class="social-share" data-initialized="true" data-url="https://www.zhyocean.cn/article/' + data.articleId + '"  data-title="' + data.articleTitle + '">' +
        '<a href="#" class="social-share-icon icon-qq" data-am-popover="{content: \'分享至QQ好友\', trigger: \'hover focus\'}"></a>' +
        '<a href="#" class="social-share-icon icon-qzone" data-am-popover="{content: \'分享至QQ空间\', trigger: \'hover focus\'}"></a>' +
        '<a href="#" class="social-share-icon icon-wechat"></a>' +
        '<a href="#" class="social-share-icon icon-weibo" data-am-popover="{content: \'分享至微博\', trigger: \'hover focus\'}"></a>' +
        '</div>'))

    //选中所有需放大的图片加上data-src属性
    $("#wordsView img").each(function (index) {
        if (!$(this).hasClass("emoji")) {
            var a = $(this).attr('src');
            $(this).attr("data-src", a);

            $(this).addClass("enlargePicture");
        }
    });
    //放大图片框架
    lightGallery(document.getElementById('wordsView'));
}

//填充文章评论和回复
function putInComment(data) {
    $('#comment').val('');
    var comment = $('.comment');
    var commentBottom = $('.comment-bottom');
    commentBottom.html('');

    if (data.length == 0) {
        var comments = $('<div class="comments">' +
            '<span class="noComment" style="color: black">还没有评论，快来抢沙发吧！</span>' +
            '</div>');
        commentBottom.append(comments);
        comment.append(commentBottom);
    }
    else {
        var articleComment = $('<div class="article-comment"></div>');
        var articleCommentTop = $('<div class="article-comment-top">' +
            '<span class="article-comment-word">评论</span>' +
            '<div class="article-comment-line"></div>' +
            '</div>');
        var newComment = $('<div class="new-comment">' +
            '<i class="all-comment zi zi_list"></i>全部评论（<span class="commentNum">' + '' + '</span>）' +
            '</div>');
        articleComment.append(articleCommentTop);
        articleComment.append(newComment);
        var allComments = $('<div class="all-comments"></div>');
        $.each(data, function (index, obj) {
            var visitorReplies = $('<div class="visitorReplies"></div>');
            if (obj.replies != null) {
                $.each(obj.replies, function (index1, obj1) {
                    var visitorReply = $('<div id="p' + obj1.replyId + '" class="visitorReply"></div>');
                    var visitorReplyWords = $('<div class="visitorReplyWords">' +
                        '<a href="/user/showUser/' + obj1.user.userName + ' " class="answerer" >' + obj1.user.userName + '</a>： <a class="respondent">' + obj1.replyContent + ' </a>' +
                        '</div>');
                    var visitorReplyTime = $('<div class="visitorReplyTime">' +
                        '<span class="visitorReplyTimeTime">' + obj1.replyTime + '</span>' +
                        '<a>' +
                        '<i class="replyReply zi zi_msgchat">&nbsp;&nbsp;回复</i>' +
                        '</a>' +
                        '</div>');
                    visitorReply.append(visitorReplyWords);
                    visitorReply.append(visitorReplyTime);
                    visitorReply.append($('<hr data-am-widget="divider" style="" class="am-divider am-divider-dashed"/>'));
                    visitorReplies.append(visitorReply);
                });
            }
            var subCommentList = $('<div class="sub-comment-list" id = "' + obj.commentId + '"></div>');
            var moreComment = $('<div class="more-comment">' +
                '<a>' +
                '<i class="moreComment zi zi_msgchat"> 添加新评论</i>' +
                '</a>' +
                '</div>');
            subCommentList.append(visitorReplies);
            subCommentList.append(moreComment);
            var subComment = $('<div class="sub-comment" id = "' + obj.commentId + '"></div>');
            if (obj.replies != null) {
                subComment.append(subCommentList);
            }
            subComment.append($('<div class="reply-sub-comment-list am-animation-slide-bottom" id="' + obj.user.userId + '"> ' +
                '<div class="replyWord">' +
                '<div class="replyWordBtn">' +
                '<textarea class="replyWordTextarea" placeholder="写下你的评论..."></textarea>' +
                '<button type="button" class="sendReplyWordBtn btn btn-success">发送</button>' +
                '<button type="button" class="quitReplyWordBtn btn btn-secondary">取消</button>' +
                '</div>' +
                '</div>' +
                '</div>'));

            var amG = $('<div class="row"  id="' + obj.user.userId + '"></div>');
            amG.append($('<div class="visitorCommentImg col-sm-2 col-lg-1">' + '<a href="/user/showUser/' + obj.user.userName + ' ">' +
                '<img src="' + obj.user.avatarUrl + '"> ' +
                '</a>' +
                '</div>'));
            var amUSm10 = $('<div class="col-sm-10 col-lg-11"></div>');
            var visitorInfo = $('<div class="visitorInfo">' +
                '<span class="visitorFloor">#' + (index + 1) + '楼</span>' +
                '<span class="visitorName"> <a href="/user/showUser/' + obj.user.userName + ' ">' +
                obj.user.userName +
                '</a> ' +
                '</span>' +
                '<span class="visitorPublishDate">' +
                obj.commentTime +
                '</span>' +
                '</div>');
            var visitorSay = $('<div class="visitorSay">' +
                obj.commentContent +
                '</div>');
            var toolGroup1 = $('<div class="tool-group">' +
                '<a>' +
                '<i class="like zi zi_digg">&nbsp;&nbsp;<span>' + obj.comment_like_count + '</span>人赞</i>' +
                '</a>' +
                '<a>' +
                '<i class="reply zi zi_msgchat">&nbsp;&nbsp;回复</i>' +
                '</a>' +
                '</div>');
            var toolGroup2 = $('<div class="tool-group">' +
                '<a>' +
                '<i class="like zi zi_digg text-success">&nbsp;&nbsp;<span>' + obj.comment_like_count + '</span>人赞</i>' +
                '</a>' +
                '<a>' +
                '<i class="reply zi zi_msgchat">&nbsp;&nbsp;回复</i>' +
                '</a>' +
                '</div>');
            amUSm10.append(visitorInfo);
            amUSm10.append(visitorSay);
            if (obj.comment_like_count > 0) {
                amUSm10.append(toolGroup2);
            } else {
                amUSm10.append(toolGroup1);
            }
            amUSm10.append(subComment);
            amG.append(amUSm10);
            var visitorComment = $('<div class="visitorComment" id="' + obj.commentId + '"></div>');
            visitorComment.append(amG);
            visitorComment.append($('<hr>'));
            allComments.append(visitorComment);
        });
        articleComment.append(allComments);
        commentBottom.append(articleComment);
        comment.append(commentBottom);
        //添加评论数
        $('.commentNum').html(data.length);
    }

    var reply = $('.reply');
    var quitReplyWordBtn = $('.quitReplyWordBtn');
    var moreComment = $('.moreComment');
    var replyReply = $('.replyReply');

    var respondent;
    //点击回复显示评论框
    reply.click(function () {
        var $this = $(this);
        $this.parent().parent().parent().find($('.reply-sub-comment-list')).find($('.replyWordTextarea')).val('');
        $this.parent().parent().parent().find($('.reply-sub-comment-list')).css("display", "block");
        $this.parent().parent().parent().find($('.reply-sub-comment-list')).find($('.replyWordTextarea')).focus();
        respondent = $this.parent().parent().prev().prev().find('.answerer').html();
    });

    //添加新评论显示评论框
    moreComment.click(function () {
        var $this = $(this);
        $this.parent().parent().parent().next().find($('.replyWordTextarea')).val('');
        $this.parent().parent().parent().next().css("display", "block");
        $this.parent().parent().parent().next().find($('.replyWordTextarea')).focus();

        respondent = $this.parent().parent().parent().parent().parent().find('.visitorInfo').find('.visitorName').html();

    });

    //评论中的回复的回复按钮显示评论框
    replyReply.click(function () {
        var $this = $(this);
        {
            respondent = $this.parent().parent().prev().find($('.answerer')).html();
            $this.parent().parent().parent().parent().parent().next().css("display", "block");
            $this.parent().parent().parent().parent().parent().next().find($('.replyWordTextarea')).val('@' + respondent + ' ');
            $this.parent().parent().parent().parent().parent().next().find($('.replyWordTextarea')).focus();
        }

    });

    //点击取消隐藏评论框
    quitReplyWordBtn.click(function () {
        $(this).parent().parent().find($('.replyWordTextarea')).val('');
        $(this).parent().parent().parent().css("display", "none");
    });

    //发送评论中的回复
    $('.sendReplyWordBtn').click(function () {
        var $this = $(this);
        var replyContent = $this.parent().parent().find($('.replyWordTextarea')).val();
        var pId = $this.parent().parent().parent().parent().attr("id");

        var authId = $this.parent().parent().parent().attr('id');
        if (replyContent == "") {
            toastr.warning("留白我咋知道你想啥呢");
        } else {
            $.ajax({
                type: 'POST',
                url: '/article/comment/publishReply',
                dataType: 'json',
                data: {
                    'replyContent': replyContent,
                    'articleId': $(".likeBtn").attr('id'),
                    'parentId': pId,
                    'authId': authId,
                },
                success: function (data) {
                    if (!data.status) {
                        toastr.warning('请先登陆噢');
                        window.location.replace("/login");
                    } else {
                        toastr.success('发布评论回复成功,+1条回复');
                        var sub_comment = $this.parent().parent().parent().parent();
                        var visitorReply = $('<div id=p' + data.replyId + ' class="visitorReply"></div>');
                        var visitorReplyWords = $('<div class="visitorReplyWords">' +
                            '<a  href="/user/showUser/' + data.user.userName + '" class="answerer">' + data.user.userName + '</a>： <a class="respondent">' + data.replyContent + ' </a>' + '' +
                            '</div>');
                        var visitorReplyTime = $('<div class="visitorReplyTime">' +
                            '<span class="visitorReplyTimeTime">' + data.replyTime + '</span>' +
                            '<a>' +
                            '<i class="replyReply zi zi_msgchat">&nbsp;&nbsp;回复</i>' +
                            '</a>' +
                            '</div>');
                        visitorReply.append(visitorReplyWords);
                        visitorReply.append(visitorReplyTime);
                        visitorReply.append('<hr data-am-widget="divider" style="" class="am-divider am-divider-dashed" />');

                        if (sub_comment.find('.sub-comment-list').length > 0) {
                            sub_comment.find('.visitorReplies').append(visitorReply);
                        } else {
                            var visitorReplies = $('<div class="visitorReplies"></div>');
                            var sub_comment_list = $('<div class="sub-comment-list"></div>');
                            visitorReplies.append(visitorReply);
                            sub_comment_list.append(visitorReplies);
                            sub_comment_list.append($('<div class="more-comment">' +
                                ' <a>' +
                                '<i class="moreComment zi zi_msgchat"> 添加新评论</i>' +
                                '</a>' +
                                '</div>'));
                            sub_comment.prepend(sub_comment_list);
                        }

                        //给新加入的评论中的回复和下面的添加新评论添加点击事件
                        $this.parent().parent().parent().parent().find('.visitorReplies>div:last-child').find('.replyReply ').click(function () {
                            respondent = $(this).parent().parent().prev().find($('.answerer')).html();
                            $(this).parent().parent().parent().parent().parent().next().css("display", "block");
                            $(this).parent().parent().parent().parent().parent().next().find($('.replyWordTextarea')).val('@' + respondent + ' ');
                            $(this).parent().parent().parent().parent().parent().next().find($('.replyWordTextarea')).focus();
                        });
                        $this.parent().parent().parent().parent().find('.sub-comment-list').find('.more-comment').find('.moreComment').click(function () {
                            $(this).parent().parent().parent().next().find($('.replyWordTextarea')).val('');
                            $(this).parent().parent().parent().next().css("display", "block");

                            respondent = $(this).parent().parent().parent().parent().parent().find('.visitorInfo').find('.visitorName').html();
                        });
                        $this.parent().find($('.replyWordTextarea')).val('');
                        $this.parent().parent().parent().css("display", "none");
                    }
                },
                error: function () {
                    toastr.error("请先登陆噢！");
                }
            });
        }

    });

    //点击评论中的点赞
    $('.like').click(function () {
        var $this = $(this);
        var authId = $('.article-info-originalAuthor');
        var articleTitle = $('#articleTitle');
        var respondentId = $this.parent().parent().parent().parent().parent().attr("id");
        $.ajax({
            type: 'get',
            url: '/article/comment/addCommentLike',
            dataType: 'json',
            data: {
                'commentId': respondentId,
                'authId': authId.attr('id'),
                'articleTitle': articleTitle.html(),
                'articleId': $('.article-title').attr('id'),
                'commentContent': $this.parent().parent().prev().html()
            },
            success: function (data) {
                if (!data.status) {
                    toastr.warning('请先登陆噢');
                    setTimeout(function () {
                        window.location.replace("/login");
                    }, 1000);
                } else if (data.message ==="已经点赞过了，不能在点赞了") {
                    toastr.warning('已经给这条评论点过赞了嗷');
                } else {
                    var num = parseInt($this.find('span').html()) + 1;
                    $this.find('span').html(num);
                    toastr.success('评论点赞成功');
                    niceIn($this);
                    $this.removeClass("fa-thumbs-o-up");
                    $this.addClass("fa-thumbs-up");
                    $this.addClass("text-danger");
                }
            },
            error: function () {
                toastr.error('评论点赞失败');
            }
        });
    });
}


//通过文章id和原作者请求评论信息
$.ajax({
    type: 'post',
    url: '/article/comment/getAllComment',
    dataType: 'json',
    cache: false,
    data: {
        articleId: $(".likeBtn").attr('id'),
    },
    success: function (data) {
        putInComment(data);
    },
    error: function () {
    }
});

// 文章点赞
(function ($) {
    $.extend({
        tipsBox: function (options) {
            options = $.extend({
                obj: null,  //jq对象，要在那个html标签上显示
                str: "+1",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
                startSize: "12px",  //动画开始的文字大小
                endSize: "30px",    //动画结束的文字大小
                interval: 600,  //动画时间间隔
                color: "red",    //文字颜色
                callback: function () {
                }    //回调函数
            }, options);
            $("body").append("<span class='num'>" + options.str + "</span>");
            var box = $(".num");
            var left = options.obj.offset().left + options.obj.width() / 2;
            var top = options.obj.offset().top - options.obj.height();
            box.css({
                "position": "absolute",
                "left": left + "px",
                "top": top + "px",
                "z-index": 9999,
                "font-size": options.startSize,
                "line-height": options.endSize,
                "color": options.color
            });
            box.animate({
                "font-size": options.endSize,
                "opacity": "0",
                "top": top - parseInt(options.endSize) + "px"
            }, options.interval, function () {
                box.remove();
                options.callback();
            });
        }
    });
})(jQuery);

//点赞喜欢效果
function niceIn(prop) {
    prop.find('i').addClass('niceIn');
    setTimeout(function () {
        prop.find('i').removeClass('niceIn');
    }, 1000);
}

//  退出登陆方法
$('#exit').click(function () {
    $.ajax({
        url: '/api/exit/userExit',
        type: 'GET',
        dataType: 'json',
        success: function () {
            window.location.reload();
        }
    })
});

//文章点赞按钮
$(".likeBtn").click(function () {
    var $this = $(this);
    var authId = $('.article-info-originalAuthor');
    var articleTitle = $('#articleTitle');
    $.ajax({
        type: 'get',
        url: '/article/addArticleLike',
        dataType: 'json',
        data: {
            'articleId': $this.attr('id'),
            'authId': authId.attr('id'),
            'articleTitle': articleTitle.html()
        },
        success: function (data) {
            if (!data.status) {
                toastr.warning('还未登陆，请先登陆噢');
                setTimeout(function () {
                    window.location.replace("/login");
                }, 1000)
            } else if (data.message === "已经点赞过这篇文章了") {
                toastr.warning('你已经点赞过了噢，不可以重复点赞')
                //文章已经点过赞了，啥都不干
            } else {
                $('.likesNum').find('span').html(parseInt($('.likesNum').find('span').html()) + 1);
                $('.likeBtn').css({'background-color': '#EA6F5A', "color": 'white'});
                $('.likeHeart').find('i').removeClass("am-icon-heart-o");
                $('#heart').addClass("heart");
                toastr.success('点赞成功！+1个喜欢');
                niceIn($this);
            }
        },
        error: function () {
            toastr.error('点赞失败！也不知道为啥');
        }
    });
});

// 加载过度动画
var loading_all_id = null;
loading_all_id = $(document.body).NZ_Loading("show", {
    content: "正在加载模块...",
    autohide: true
});

// 游客访问量+1
$.ajax({
    url: '/api/article/visitorComing',
    type: 'POST',
    data: {'articleId': $(".likeBtn").attr('id')},
    dataType: 'json',
    cache: false,
    success: function (data) {
        //  什么也不干
    }, error: function () {

    }
})
$("#gotop1,#gotop2").click(function(e) {
    TweenMax.to(window, 1.5, {scrollTo:0, ease: Expo.easeInOut});
    var huojian = new TimelineLite();
    huojian.to("#gotop1", 1, {rotationY:720, scale:0.6, y:"+=40", ease:  Power4.easeOut})
        .to("#gotop1", 1, {y:-1000, opacity:0, ease:  Power4.easeOut}, 0.6)
        .to("#gotop1", 1, {y:0, rotationY:0, opacity:1, scale:1, ease: Expo.easeOut, clearProps: "all"}, "1.4");
});
