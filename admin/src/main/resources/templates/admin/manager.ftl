<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 响应式meta标签 -->
    <!--优先使用webkit内核渲染-->
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--不要被百度转码-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- Google fonts - Popppins for copy-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
    <!-- orion icons-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/css/orionicons.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admins/css/style.default.css"
          id="theme-stylesheet">
    <!-- Favicon-->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/img/favicon.png">

    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admins/css/admin.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/css/user.css">
</head>

<body>
<#setting number_format="#">
<!-- navbar-->
<header class="header">
    <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow">
        <a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead">
            <i class="fas fa-align-left"></i>
        </a>
        <a href="index.ftl" class="navbar-brand font-weight-bold text-uppercase text-base">Nobug后台管理系统</a>
        <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
            <li class="nav-item dropdown ml-auto">
                <a id="userInfo" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false" class="nav-link dropdown-toggle">
                    <img src="${superAdmin.avatarUrl}"
                         alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow">
                </a>
                <div aria-labelledby="userInfo" class="dropdown-menu">
                    <a href="javascript: void(0)" id="${superAdmin.adminId}"  onclick="exit(this)"  class="dropdown-item">退出登陆</a>
                </div>
            </li>
            <span href="javascript: void(0)"><strong
                    class="d-block text-uppercase headings-font-family"  >${superAdmin.adminName}</strong></span>
        </ul>
    </nav>
</header>
<div class="d-flex align-items-stretch">
    <div id="sidebar" class="sidebar py-3">
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">MAIN
        </div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item">
                <a href="/admin/" class="sidebar-link text-muted ">
                    <i class="o-home-1 mr-3 text-gray"></i>
                    <span>主页</span>
                </a>
            </li>
            <li class="sidebar-list-item"><a href="javascript:void(0)" data-toggle="collapse" data-target="#users"
                                             aria-expanded="false"
                                             aria-controls="pages" class="sidebar-link text-muted">
                <i class="zi zi_userastronaut mr-3 text-gray"></i>
                <span>用户管理</span>
            </a>
                <div id="users" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item">
                            <a href="/admin/userAdmin" class="sidebar-link text-muted active pl-lg-5">
                      <span>
                          <i class="zi zi_usercog mr-3 text-gray"></i>
                          用户列表
                      </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item">
                <a href="javascript:void (0)" data-toggle="collapse" data-target="#managers" aria-expanded="false"
                   aria-controls="pages" class="sidebar-link text-muted">
                    <i class="zi zi_usersecret mr-3 text-gray"></i>
                    <span>后台管理</span>
                </a>
                <div id="managers" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item">
                            <a href="/admin/superAdmin" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_userscog mr-3 text-gray"></i>
                          管理员列表
                      </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item">
                <a href="javascript:void(0)" data-toggle="collapse" data-target="#items" aria-expanded="false"
                   aria-controls="pages" class="sidebar-link text-muted">
                    <i class="o-wireframe-1 mr-3 text-gray"></i>
                    <span>内容管理</span>
                </a>
                <div id="items" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item">
                            <a href="/admin/articleAdmin" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_textbook mr-3 text-gray"></i>
                          <span>内容管理</span>
                            </a>
                        </li>
                        <li class="sidebar-list-item">
                            <a href="/admin/checkArticle" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_clipboardcheck mr-3 text-gray"></i>
                          <span>文章审核</span>
                            </a>
                        </li>
                        <li class="sidebar-list-item">
                            <a href="/admin/questionAdmin" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_squareBook mr-3 text-gray"></i>
                          <span>反馈管理</span>
                            </a>
                        </li>
                        <li class="sidebar-list-item">
                            <a href="/admin/commentAdmin" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_commentalt mr-3 text-gray"></i>
                          <span>评论管理</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">EXTRAS
        </div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item">
                <a href="javascript:void (0)" data-toggle="collapse" data-target="#message" aria-expanded="false"
                   aria-controls="pages" class="sidebar-link text-muted">
                    <i class="o-database-1 mr-3 text-gray"></i>
                    <span>消息管理</span>
                </a>
                <div id="message" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item">
                            <a href="/admin/messageAdmin" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_fly mr-3 text-gray"></i>
                          <span>发送消息</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item">
                <a href="javascript:void (0)" data-toggle="collapse" data-target="#website" aria-expanded="false"
                   aria-controls="pages" class="sidebar-link text-muted">
                    <i class="zi zi_circleComponents mr-3 text-gray"></i>
                    <span>网站管理</span>
                </a>
                <div id="website" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item">
                            <a href="/admin/siteNotice" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_speaker mr-3 text-gray"></i>
                          <span>网站公告</span>
                            </a>
                        </li>
                        <li class="sidebar-list-item">
                            <a href="/admin/friendLink" class="sidebar-link text-muted pl-lg-5">
                      <span>
                          <i class="zi zi_link mr-3 text-gray"></i>
                          <span>友链管理</span>
                            </a>
                        </li>
                        <li class="sidebar-list-item"><a href="/admin/meta" class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_verFlag mr-4 text-gray"></i><span>元信息管理</span></a></li>

                    </ul>
                </div>
            </li>

        </ul>
    </div>
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
            <section>
                <div class="row  mt-5">
                    <div class="col-lg-12 text-center">
                        <p> 后台管理</p>
                    </div>
                    <div class="col-lg-12 ">
                        <div class="card mb-5 mb-lg-0 ">
                            <div class="card-body col-lg-12">
                                <div class="tab-content" id="tabContent">
                                    <div id="dateSearch" class="mb-5">
                                        <span><strong>ID: </strong></span>
                                        <input type="text" class="mr-5" id="serach-id" placeholder="请输入用户id">
                                        <span><strong>用户名: </strong></span>
                                        <input type="text" class="mr-5" id="serach-user" placeholder="用户名">
                                        <span><strong>邮箱: </strong></span>
                                        <input type="text" class="mr-5" id="serach-email" placeholder="请输入用户邮箱">
                                        <button type="button" class="btn btn btn-info search" id="serach"><i
                                                class="fa fa-search"></i>
                                            搜索
                                        </button>
                                    </div>
                                    <div id="toolbar" class="btn-group">
                                        <button id="btn_add" type="button" class="btn btn-info btn-sm "
                                                data-toggle="modal"
                                                data-target="#exampleModalCenter" role="">
                                            <i class="zi zi_plus" zico="加号黑"></i>新增
                                        </button>
                                        <button id="btn_delete" type="button" class="btn btn-info btn-sm ">
                                            <i class="zi zi_cuts" zico="剪刀"></i>删除
                                        </button>
                                    </div>
                                    <table id="table" data-toggle="table">
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">添加用户</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="admin-content pl-5 ">
                            <div class="userInfo my-3">
                                <div id="personalDate" class="my-3">
                                    <div class="personalupdate pl-5 pb-5 pt-5">
                                        <div class="personalDateHeadPortrait">


                                        </div>
                                        <div class="personalDateForm">
                                            <form id="personalDateForm">
                                                <div class="userNameTable">
                                                    <label for="username">用户名:</label>
                                                    <input class="formInput" type="text" id="username"
                                                           placeholder="用户名">
                                                    <hr/>
                                                </div>
                                                <div class="birthdayTable">
                                                    <label for="password">密码:</label>
                                                    <input class="formInput" type="password" id="password"
                                                           placeholder="密码"/>
                                                    <hr/>
                                                </div>
                                                <div class="birthdayTable">
                                                    <label for="checkPassword">确认密码:</label>
                                                    <input class="formInput" type="text" id="checkPassword"
                                                           placeholder="确认密码"/>
                                                    <hr/>
                                                </div>
                                                <div class="birthdayTable">
                                                    <label for="age">年龄:</label>
                                                    <input class="formInput" type="text" id="age"
                                                           placeholder="年龄"/>
                                                    <hr data-am-widget="divider" style=""
                                                        class="am-divider am-divider-default"/>
                                                </div>

                                                <div class="genderTable">
                                                    <label>性别:</label>
                                                    <label class="am-radio-inline" style="width: 60px">
                                                        <input class="formInput" type="radio" id="male"
                                                               name="gender" value="male" data-am-ucheck>
                                                        <span class="am-icon-male "><i class="zi zi_male"
                                                                                       zico="男性"></i></span>
                                                    </label>
                                                    <label class="am-radio-inline" style="width: 60px">
                                                        <input class="formInput" type="radio" id="female"
                                                               name="gender" value="female" data-am-ucheck>
                                                        <span class="am-icon-female "><i class="zi zi_female"
                                                                                         zico="女性"></i></span>
                                                    </label>
                                                    <hr data-am-widget="divider" style=""
                                                        class="am-divider am-divider-default"/>
                                                </div>
                                                <div class="emailTable">
                                                    <label for="email">邮箱:</label>
                                                    <input class="formInput" type="email" id="email"
                                                           placeholder="填写你的邮箱">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="yes">确定</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="update" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">修改用户</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="admin-content pl-5 ">
                            <div class="userInfo my-3">
                                <div id="personalDate" class="my-3">
                                    <div class="personalupdate pl-5 mb-5 pb-5 pt-5">
                                        <div class="personalDateForm">
                                            <div class="headPortrait">
                                                <img id="headPortrait"
                                                     src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%A4%B4%E5%83%8F%20.jpg"/>
                                            </div>
                                            <div class="headChange">
                                                <div class="headPortraitChange">
                                                    <form action="/admin/api/uploadUserImg" method="post" enctype="multipart/form-data" id="img">
                                                        <input id="imgTest" name="admin_avatar" type="file" onchange="imgChange(event)"
                                                               accept=".gif,.jpg,.jpeg,.png">
                                                        <a>更改头像</a>
                                                    </form>
                                                </div>
                                            </div>
                                            <form>
                                                <div class="userNameTable">
                                                    <label for="user">用户名:</label>
                                                    <input class="formInput" type="text" id="user" disabled="disabled"
                                                           placeholder="用户名">
                                                    <hr/>
                                                </div>
                                                <div class="emailTable">
                                                    <label for="emails">邮箱:</label>
                                                    <input class="formInput" type="email" id="emails"
                                                           placeholder="填写你的邮箱">
                                                </div>
                                                <hr/>
                                                <div class="phoneTable">
                                                    <label for="phone">手机:</label>
                                                    <input class="formInput" type="text" id="phone"
                                                           placeholder="填写你的邮箱">
                                                </div>
                                                <hr/>
                                                <div class="genderTables">
                                                    <label>性别:</label>
                                                    <label class="am-radio-inline" style="width: 60px">
                                                        <input class="formInput" type="radio" id="males"
                                                               name="gender" value="male" data-am-ucheck>
                                                        <span class="am-icon-male "><i class="zi zi_male"
                                                                                       zico="男性"></i></span>
                                                    </label>
                                                    <label class="am-radio-inline" style="width: 60px">
                                                        <input class="formInput" type="radio" id="females"
                                                               name="gender" value="female" data-am-ucheck>
                                                        <span class="am-icon-female "><i class="zi zi_female"
                                                                                         zico="女性"></i></span>
                                                    </label>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="confrim">确定</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript files-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admin/bootstrap-table-export.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admin/bootstrap-table-zh-CN.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admins/js/superAdmin.js"></script>
</body>

</html>