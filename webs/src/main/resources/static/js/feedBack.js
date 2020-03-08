$.ajax({
    url: '/api/feedBack/findAll',
    type: 'post',
    data: {
        'pageNo': 1,
        'pageSize': 5
    },
    dataType: 'json',
    cache: false,
    success : function (data) {
        init(data.data);
        console.log(data);
    }
});


function init(data) {
    var feedBackFather = $('<div></div>');
    var feedBackContent = $('<ul style="list-style: none"></ul>');
    var feedBackMain = '';
    $.each(data, function (index, obj) {
        feedBackMain = $('<li id="' + obj.questionId + '">' +
            '<div>' +
            '<a href="/user/showUser/'+obj.user.userName+'"  style="font-family: 微软雅黑;color: gray;font-weight: bold;font-size: 15px">' + obj.user.userName + ' : </a>' +
            ' <span >' + obj.questionTitle + '</span>' +
            '<span style="float: right">' + obj.createTime + '</span>' +
            '</div>' +
            '</li>'+'<hr>');
        feedBackContent.append(feedBackMain);
    });
    feedBackFather.append(feedBackContent);

    $('#feedBack').append(feedBackFather);
}

$('#send').click(function () {
    console.log("o");
    var content = $('#message-text');
    var title = $('#recipient-name');
    if (content == null || content.val().length < 1 || title == null || title.val().length < 1) {
        toastr.error('请填写正确的内容');
        return false;
    } else {
        $.ajax({
            url: 'user/question/submitFeedback',
            type: 'POST',
            data: {
                'feedBackTitle': title.val(),
                'feedBackContent': content.val()
            },
            cache: false,
            dataType: 'json',
            success: function (data) {
                if (data.status) {
                    toastr.success('提交反馈成功,等待管理员回复后显示');
                    $('#exampleModal').modal('hide');
                } else {
                    toastr.warning('请先登陆噢');
                    $('#exampleModal').modal('hide');
                }
            }
        })

    }
});