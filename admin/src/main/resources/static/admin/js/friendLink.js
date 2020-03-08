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
//默认加载时携带参数
function queryParams(params) {
    var params = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        pageNo: Math.ceil(params.offset / params.limit) + 1, //页码
        pageSize: params.limit, //页面大小
        "status": $("#status").val()
    };
    return params;
}


$('#table').bootstrapTable({
    url: '/admin/site/findAllLink',
    method: 'GET',
    contentType: 'application/x-www-form-urlencoded',
    toolbar: "#toolbar",  //工具按钮用哪个容器
    toolbarAlign: "left",//工具栏对齐方式
    striped: true,   //是否显示行间隔色
    cache: false,   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination: true,   //是否显示分页（*）
    //sortable: false,   //是否启用排序
    sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
    pageNumber: 1,   //初始化加载第一页，默认第一页
    pageSize: 5,   //每页的记录行数（*）
    pageList: [5, 10, 25, 50, 100], //可供选择的每页的行数（*）
    paginationPreText: "Previous",
    paginationNextText: "Next",
    paginationFirstText: "First",
    paginationLastText: "Last",
    sortOrder: "asc",   //排序方式
    showRefresh: true,                  //是否显示刷新按钮
    minimumCountColumns: 5,             //最少允许的列数
    buttonsAlign: "right",//按钮对齐方式
    //showColumns: true,//列选择按钮
    clickToSelect: true,  //是否启用点击选中行
    //height: 500,   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
    uniqueId: "id",   //每一行的唯一标识，一般为主键列
    cardView: false,   //是否显示详细视图
    detailView: false,   //是否显示父子表
    queryParamsType: 'limit',
    queryParams: queryParams,
    maintainSelected: true,
    responseHandler: function (res) {
        //  这里是后台接口返回的数据，需要把返回的数据分别对接rows和total 用于分页和展示
        return {
            "rows": res.data,
            "total": res.total
        }
    },
    columns: [
        {
            field: 'checked',
            title: 'index',
            checkbox: true,
        },
        {
            field: 'linkId',
            title: 'ID'
        }, {
            field: 'linkName',
            title: '友链名称',
            formatter: contentFormatter
        },
        {
            field: 'href',
            title: '友链地址',
            formatter: contentFormatter
        }
        , {
            field: 'operator',
            title: '操作',
            align: 'center',
            valign: 'middle',
            width: '10%',
            visible: true,
            formatter: function (value, row, index) {
                // var sid_code = base64encode(row.sid + '');   //  sid 加密处理
                // alert(sid_code);
                return '</a>' + '<a href="javascript:void(0)" data-target="#updateLink" class = "ml-3 mr-3" data-toggle="modal" title="编辑">' +
                    '<i class="zi zi_pencilalt" zico="笔黑"></i>' +
                    '</a>' +
                    '<a href="javascript:void(0)" class="ml-3 mr-3" id="' + row.linkId + '" onclick="deletes(this)"  title="删除">' +
                    '<i class="zi zi_trashalt" zico="垃圾箱竖条"></i> ' +
                    '</a>';
            }
        }]
});

var selects = [];

function deletes(btn) {
    if (confirm("确认要删除用户吗,(删除后数据不可恢复)")) {
        selects.splice(0, selects.length);
        selects.push($(btn).attr('id'));
        $.ajax({
            url: '/admin/site/deleteLink',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'linkId': selects
            },
            success: function (data) {
                if (data.code == 404) {
                    toastr.error("请先登陆");
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                } else if (data.code == 200) {
                    toastr.success("删除成功");
                    $('#table').bootstrapTable('refresh');
                }
            }, error: function () {

            }
        })
    }

}

// 选中用户时往数组添加元素
$('#table').on('check.bs.table', function (row, $element) {
    selects.push($element.linkId);
    console.log(selects);
});
// 不选中时移除元素
$('#table').on('uncheck.bs.table', function (row, $element) {
    selects.splice($.inArray($element.linkId, selects), 1);
    console.log(selects);
});
//全选时获得所有元素
$('#table').on('check-all.bs.table', function () {
    selects = $('#table').bootstrapTable('getSelections');
});
// 删除指定列
$('#btn_delete').click(function () {

    if (selects[0] == null) {
        toastr.error("你还未选择要删除的用户");
    } else if (confirm("确认要删除用户吗,(删除后数据不可恢复)")) {
        $.each(selects, function (index, obj) {
            selects[index] = obj.linkId;
        });
        console.log(selects);
        $.ajax({
            url: '/admin/site/deleteLink',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'linkId': selects
            },
            success: function (data) {
                if (data.code == 404) {
                    toastr.error("请先登陆");
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                } else if (data.code == 200) {
                    toastr.success("删除成功");
                    $('#table').bootstrapTable('refresh');
                }
            }, error: function () {

            }
        })
    }
});

// 格式化表格
/**
 * 表格中字段内容过长时采用缩略方式
 */
function contentFormatter(value, row, index) {
    var content = value;
    if (value && value.length > 10) {
        content = value.substr(0, 10) + "..."
    }
    return "<span data-toggle='tooltip' data-html='true'  data-placement=\"top\" title=\"" + value + "\">" + content + "</span>";
}

// 添加新友链
$('#comfrim').click(function () {
    var linkName = $('#linkName');
    var href = $('#href');
    if (linkName.val() == '' || linkName.val().length < 1) {
        toastr.error('友链名称不能为空');
        return false;
    } else if (href.val() == '' || href.val().length < 1) {
        toastr.error('友链网址不能为空');
        return false;
    } else {
        $.ajax({
            type: 'post',
            url: '/admin/site/addLink',
            dataType: 'json',
            cache: false,
            data: {
                'linkName': linkName.val(),
                'href': href.val()
            },
            success: function (data) {
                if (data.code == 404) {
                    toastr.error('请先登陆再操作噢');
                    $.get("/admin/login", function (data, status, xhr) {
                        window.location.replace("/admin/login");
                    });
                } else {
                    if (data.code == 200) {
                        toastr.success("添加成功");
                        $('#table').bootstrapTable('refresh');
                        $('#exampleModalCenter').modal('hide');
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
var linkId;
// 修改列
$('#table').on('click-row.bs.table', function (e, row, index, $tr) {
    $('#link').val(row.linkName);
    $('#linkHref').val(row.href);
    linkId = row.linkId;
});
// 修改
$('#yes').click(function () {
    var link = $('#link').val();
    var href = $('#linkHref').val();
    if (link == '' || link.length < 1 || href == '' || href.length < 1) {
        toastr.error('请填写信息');
        return false;
    }
    $.ajax({
        url: '/admin/site/updateLink',
        type: 'POST',
        cache: false,
        dataType: 'json',
        data: {
            'linkId': linkId,
            'linkName': link,
            'href': href
        },
        success: function (data) {
            if (data.code == 200) {
                toastr.success("修改成功");
                $('#table').bootstrapTable('refresh');
                $('#updateLink').modal('hide');

            } else if (data.code == 404) {
                toastr.error('请先登陆再操作噢');
                $.get("/admin/login", function (data, status, xhr) {
                    window.location.replace("/admin/login");
                });
            }
        }
    })
});
