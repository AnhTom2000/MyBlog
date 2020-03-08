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
    url: '/admin/user/findAll',
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
            checkbox: true
        },
        {
            field: 'userId',
            title: 'ID'
        }, {
            field: 'userName',
            title: '用戶名',
                formatter: contentFormatter
        }, {
            field: 'avatarUrl',
            title: '頭像地址',
            formatter: contentFormatter
        },
        {
            field: 'phone',
            title: '手機'
        },
        {
            field: 'email',
            title: '郵箱'
        },
        {
            field: 'gender',
            title: '性別'
        },
        {
            field: 'age',
            title: '年齡'
        },
        {
            field: 'area',
            title: '地區'
        },
        {
            field: 'description',
            title: '個人簡介',
            formatter: contentFormatter
        },
        {
            field: 'profession',
            title: '工作',
            formatter: contentFormatter
        },
        {
            field: 'articleCount',
            title: '文章數量'
        },
        {
            field: 'tagCount',
            title: '標簽數量'
        },
        {
            field: 'loginCount',
            title: '登錄次數'
        },
        {
            field: 'lastLogin',
            title: '最後登錄時間'
        },
        {
            field: 'lastUpdate',
            title: '最後一次更新'
        },
        {
            field: 'createTime',
            title: '創建時間'
        },
        {
            field: 'locked',
            title: '是否被鎖定'
        },
        {
            field: 'messageCount',
            title: '消息數量'
        }, {
            field: 'operator',
            title: '操作',
            align: 'center',
            valign: 'middle',
            width: '10%',
            visible: true,
            formatter: function (value, row, index) {
                // var sid_code = base64encode(row.sid + '');   //  sid 加密处理
                // alert(sid_code);
                return '<a href="#editProject" data-toggle="modal"  ' +
                    'data-target="#update" role="button" title="修改">' +
                    '<i class="zi zi_pencilalt"  zico="笔黑"></i>' +
                    '</a>' +
                    '<a href="javascript:void(0)" title="删除" id="'+row.userId+'" onclick="deletes(this)">' +
                    '<i class="zi zi_trashalt" zico="垃圾箱竖条"></i> ' +
                    '</a>' +
                    '<a href="javascript:void(0)" onclick="locked(this)"  id="' + row.userId + '" class="' + row.locked + '"  title="锁定">' +
                    '<i class="zi zi_lock" ></i> ' +
                    '</a>';
            }
        }]
});
var selectId;
var selects = [];


function deletes(btn) {
        if (confirm("确认要删除用户吗,(删除后数据不可恢复)")) {
            selects.splice(0,selects.length);
            selects.push($(btn).attr('id'));
            $.ajax({
                url: '/admin/user/deleteUsers',
                type: 'POST',
                cache: false,
                dataType: 'json',
                data: {
                    'select': selects
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

$('#serach').click(function () {
    var id = $('#serach-id');
    var name = $('#serach-user');
    var email = $('#serach-email');
    if (id.val() == null && name.val() == null && email.val() == null) {
        toastr.error('请输入搜索条件');
    } else {
        $.ajax({
            url: '/admin/user/search',
            type: 'POST',
            dataType: 'json',
            cache: false,
            data: {
                'userId': id.val(),
                'name': name.val(),
                'email': email.val()
            }, success: function (data) {
                if (data.code == 200) {
                    toastr.success('查询成功');
                    $('#table').bootstrapTable('removeAll');
                    $('#table').bootstrapTable('load', data.data);
                } else {
                    toastr.error('查询失败，未找到该用户');
                }
            }
        })
    }
});
// 选中用户时往数组添加元素
$('#table').on('check.bs.table', function (row, $element) {
    selects.push($element.userId);
});
// 不选中时移除元素
$('#table').on('uncheck.bs.table', function (row, $element) {
    selects.splice($.inArray($element.userId, selects), 1);
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
        $.ajax({
            url: '/admin/user/deleteUsers',
            type: 'POST',
            cache: false,
            dataType: 'json',
            data: {
                'select': selects
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
var userId;
var $index;
// 修改列
$('#table').on('click-row.bs.table', function (e, row, index, $tr) {
    deleteId = row.userId;
    $('#user').val(row.userName);
    $('#emails').val(row.email);
    $('#phone').val(row.phone);
    $index = index;
    userId = row.userId;
    if (row.gender == true || row.gender == 'true') {
        $('.genderTables input[value="male"]').attr("checked", 'checked');
    } else {
        $('.genderTables input[value="female"]').attr("checked", 'checked');
    }

});

// 修改
$('#confrim').click(function () {
    var email = $('#emails');
    var phone = $('#phone');
    var gender = $('.genderTables input');
    var genderValue = "male";
    if (gender[0].checked) {
        genderValue = true;
    } else {
        genderValue = false;
    }
    $.ajax({
        url: '/admin/user/updateUser',
        type: 'POST',
        cache: false,
        dataType: 'json',
        data: {
            'email': email.val(),
            'phone': phone.val(),
            'gender': genderValue,
            'userId': userId
        },
        success: function (data) {
            if (data.code == 200) {
                toastr.success("修改成功");
                $('table').bootstrapTable('updateRow', {
                    index: $index,
                    replace: true,
                    row: {
                        email: data.email,
                        phone: data.phone,
                        gender: data.gender
                    }
                });
                $('#table').bootstrapTable('refresh');
                $('#update').modal('hide');

            } else if (data.code == 404) {
                toastr.error('请先登陆再操作噢');
                $.get("/admin/login", function (data, status, xhr) {
                    window.location.replace("/admin/login");
                });
            }
        }
    })
})
$('#btn_add').click(function () {
    $(userName).val('');
    $(password).val('');
})
// 添加新用户
var userName = $('#username');
var password = $('#password');
var checkPassword = $('#checkPassword');
var age = $('#age');
var gender = $('.genderTable input');
var email = $('#email');
$('#yes').click(function () {
    var genderValue = "male";
    if (userName.val() == '' || userName.val().length < 1) {
        toastr.error('用户名不能为空');
        return false;
    }
    else if (password.val() !== checkPassword.val()) {
        toastr.error('两次密码不一致');
        return false;
    }
    else if (password.val() == '' || password.val().length < 1 || checkPassword.val() == '' || checkPassword.val().length < 1) {
        toastr.error('密码不能为空');
        return false;
    }
    else if (!gender[0].checked && !gender[1].checked) {
        toastr.error("性别不能为空");
        return false;
    } else {
        if (gender[0].checked) {
            genderValue = true;
        } else {
            genderValue = false;
        }
        $.ajax({
            type: 'post',
            url: '/admin/user/addUser',
            dataType: 'json',
            cache: false,
            data: {
                'userName': userName.val(),
                'password': password.val(),
                'age': age.val(),
                'gender': genderValue,
                'email': email.val(),
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
                        $('#table').bootstrapTable("append", data.data);
                        $('#table').bootstrapTable('refresh');
                        $('#exampleModalCenter').modal('hide');
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




// 管理员锁定用户
function locked(btn) {
    var type ;
     {
         console.log($(btn).attr('class'));
        if ($(btn).attr('class') == 'false' || $(btn).attr('class')==false) {
            if (confirm('确定要锁定此用户吗')) {
                 type = '锁定';
                $.ajax({
                    url: '/admin/user/locked',
                    type: 'POST',
                    data: {
                        'userId': $(btn).attr('id'),
                        'type': type
                    },
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                        if (data.code == 200) {
                                toastr.success("锁定用户成功");
                                $('#table').bootstrapTable('refresh');
                            $(btn).next().toggleClass('zi zi_lockopen');
                        } else if (data.code == 404) {
                            toastr.error('请先登陆');
                            $.get("/admin/login", function (data, status, xhr) {
                                window.location.replace("/admin/login");
                            });
                        } else if (data.code == 400) {
                            toastr.error('锁定失败')
                        }
                    }
                })
            }
        }else {
            if (confirm('确定要解锁此用户吗')) {
                type = '解锁';
                $.ajax({
                    url: '/admin/user/locked',
                    type: 'POST',
                    data: {
                        'userId': $(btn).attr('id'),
                        'type': type
                    },
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                        if (data.code == 200) {
                                toastr.success("解锁用户成功");
                            $('#table').bootstrapTable('refresh');
                            $(btn).next().toggleClass('zi zi_lock');
                        } else if (data.code == 404) {
                            toastr.error('请先登陆');
                            $.get("/admin/login", function (data, status, xhr) {
                                window.location.replace("/admin/login");
                            });
                        } else if (data.code == 400) {
                            toastr.error('解锁失败')
                        }
                    }
                })
            }
        }
    }
}

