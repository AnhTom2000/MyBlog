$(function () {
    var editor = editormd("test-editormd", {
        width: "100%",
        height: 800,
        syncScrolling: "single",
        // path: "lib/",
        saveHTMLToTextarea: true, //注意3：这个配置，方便post提交表单
        
        emoji: true,//emoji表情，默认关闭
        taskList: true,
        tocm: true, // Using [TOCM]
        tex: true,// 开启科学公式TeX语言支持，默认关闭
        editorTheme : "pastel-on-dark",
        flowChart: true,//开启流程图支持，默认关闭
        sequenceDiagram: true,//开启时序/序列图支持，默认关闭,
        previewCodeHighlight : true,
        dialogLockScreen: false,//设置弹出层对话框不锁屏，全局通用，默认为true
        dialogShowMask: false,//设置弹出层对话框显示透明遮罩层，全局通用，默认为true
        dialogDraggable: false,//设置弹出层对话框不可拖动，全局通用，默认为true
        dialogMaskOpacity: 0.4, //设置透明遮罩层的透明度，全局通用，默认值为0.1
        dialogMaskBgColor: "#000",//设置透明遮罩层的背景颜色，全局通用，默认为#fff

        codeFold: true,

        path: "https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/",
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/api/uploadArticleImg",   //注意你后端的上传图片服务地址


    });
    // 限制标题长度
    var count = $("#count");
    var articleTitle = $("#articleTitle");

    articleTitle.on('keydown', function () {
        countInput(articleTitle, count)
    });
    
   

    var $count = 0;
    // 动态添加新标签
    $('#addTab').on('click', function () {
        if ($count < 1) {
            var input = '<span><input type="text" minlength="1" maxlength = 30  class="am-form-field tagsName" style="width: 50px; height: 10px; display: inline-block; margin-right: 10px;" required/></span>'
            $(this).before(input);
            $count++;
            $('.tagsName').blur(function () {
                addTabs($(this).val());
                $count--;
                setTimeout(() => {
                    $('.tagsName').popover('close');
                }, 3000);
            })
        }
    })

    // 删除新建标签
    $('.am-form-group').on('click', '.close', function () {
        $(this).parent().remove();
    })

});

// 限制标题长度
function countInput(articleTitle, count) {
    if (articleTitle.val().length > 100) {
        var lenText = articleTitle.val().substring(0, 100);
        articleTitle.val(lenText);
    }
    count.html(articleTitle.val().length + '/100');

}

// 添加标签的函数
function addTabs(value) {
    if (value.length < 1 || value.length > 30) {
        console.log($('.tagsName'));
        $('.tagsName').popover({
            content: '标签长度在1到30之间',
            theme: 'danger sm'
        })
        $('.tagsName').popover('open');
        setTimeout(() => {
            $('.tagsName').popover('close');
        }, 3000);
    } else {
        var tabs = "<span><span class='token_label'>"
            + value + "</span><a href='javascript:void(0)' class='close'>x</a><span>";
        $('#addTab').before(tabs);
        $('.tagsName').remove();
    }
}
