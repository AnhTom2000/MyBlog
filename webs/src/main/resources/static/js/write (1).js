$(function () {

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

    var flag = false;

    // 初始化标签栏
    $('#tags').tagsInput({
        'height': '100px', //设置高度
        'width': '300px',  //设置宽度
        'interactive': true, //是否允许添加标签，false为阻止
        'defaultText': 'add a tag', //默认文字
        'removeWithBackspace': true, //是否允许使用退格键删除前面的标签，false为阻止
        'minChars': 0, //每个标签的小最字符
        'maxChars': 0 //每个标签的最大字符，如果不设置或者为0，就是无限大
    });
    $('#newtags').tagsInput({
        'height': '100px', //设置高度
        'width': '300px',  //设置宽度
        'interactive': true, //是否允许添加标签，false为阻止
        'defaultText': 'add a tag', //默认文字
        'removeWithBackspace': true, //是否允许使用退格键删除前面的标签，false为阻止
        'minChars': 0, //每个标签的小最字符
        'maxChars': 0 //每个标签的最大字符，如果不设置或者为0，就是无限大

    });
    $('#categorys').tagsInput({
        'height': '100px', //设置高度
        'width': '300px',  //设置宽度
        'interactive': true, //是否允许添加标签，false为阻止
        'defaultText': 'add a tag', //默认文字
        'removeWithBackspace': true, //是否允许使用退格键删除前面的标签，false为阻止
        'minChars': 0, //每个标签的小最字符
        'maxChars': 0 //每个标签的最大字符，如果不设置或者为0，就是无限大
    });


    var newTag_arr = new Array();
    var aa = 0;
    var categoryid = 1;

    // 根据点击的标签 添加进标签栏中
    $(".tag_list").children("li").click(function (e) {
        var chooseId = e.currentTarget.id;
        if (!$('#tags').tagExist($(this).text)) {
            $('#tags').addTag($(this).text());
        }
    });

    // 根据点击的类型，添加进类型栏中
    $('.category_list').children('li').click(function (e) {
        if (!$('#categorys').tagExist($(this).text)) {
            $('#categorys').addTag($(this).text());
            categoryid = e.currentTarget.id;
        }
    });


    // 有缺陷，有空优化
    //  发布文章
    $('#btn-submit').click(function () {
        var tags = $('#tags').val();
        var article_Title = $('#articleTitle').val();
        var content = $('#content').val();
        var htmlContent = $('#htmlContent').val();
        var newTag_arr = $('#newtags').val();

        if (categoryid == 0 || article_Title.length < 1) {
            toastr.warning('请选择必要的选项!')
            return;
        }


        if ((newTag_arr.length < 1) && (tags.length < 1)) {
            toastr.warning('新建标签或者选择一个旧标签!')
            return;
        }
        if (htmlContent.length < 1) {
            toastr.warning('文章内容不能为空')
            return;
        }
        var tag_arr = tags.split(",");
        newTag_arr = newTag_arr.split(",");

        $.ajax({
            url: '/article/submit',
            type: 'post',
            data: {
                'a_Title': article_Title,
                'a_text': content,
                'htmlcontent': htmlContent,
                'tag': tag_arr,
                'category_id': categoryid,
                'newTag': newTag_arr
            },
            // type:'application/json',
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.code == 200 || data.code == 300) {
                    toastr.success('发布成功！');

                    setTimeout(function () {
                        window.location.replace('/article_success');
                    }, 1000)
                } else if (data.code == 400) {
                    toastr.error(data.message);
                    setTimeout(function () {
                        $.get("/login", function (data, status, xhr) {
                            window.location.replace("/login");
                        });
                    }, 1000)

                } else {
                    toastr.error(data.message);
                }
            }
        })


    });


    //  修改文章
    $('#btn-update').click(function () {
        var tags = $('#tags').val();
        var article_Title = $('#articleTitle').val();
        var content = $('#content').val();
        var htmlContent = $('#htmlContent').val();
        var newTag_arr = $('#newtags').val();
        var id = $('#a_id').text();

        if (categoryid == 0 || article_Title.length < 1) {
            toastr.warning('请选择必要的选项!')
            return;
        }


        if ((newTag_arr.length) < 1 && (tags.length < 1)) {
            toastr.warning('新建标签或者选择一个旧标签!')
            return;
        }
        if (htmlContent.length < 1) {
            toastr.warning('文章内容不能为空')
            return;
        }
        var tag_arr = tags.split(",");
        newTag_arr = newTag_arr.split(",");
        $.ajax({
            url: '/article/edit_markdown',
            type: 'post',
            data: {
                'a_id': id,
                'a_Title': article_Title,
                'a_text': content,
                'htmlcontent': htmlContent,
                'tag': tag_arr,
                'category_id': categoryid,
                'newTag': newTag_arr
            },
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.code == 200 || data.code == 300) {
                    toastr.success('发布成功！');
                    flag = true;
                    setTimeout(function () {
                        window.location.replace('/article_success');
                    }, 1000)
                } else if (data.code == 400) {
                    {
                        toastr.error(data.message);
                        setTimeout(function () {
                            $.get("/login", function (data, status, xhr) {
                                window.location.replace("/login");
                            });
                        }, 1000)
                    }
                } else {
                    toastr.error(data.message);
                }
            }
        })
    })
    if ($(document).change(function () {
        flag = false;
        if (!flag) {
            window.onbeforeunload = function (event) {
                return confirm("确定离开此页面吗？(网站不会保存您的数据)");
            }
        }
    }));

});

