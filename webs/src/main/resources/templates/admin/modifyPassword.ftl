<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.css">
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
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/css/style.default.css"
          id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/css/custom.css">
    <!-- Favicon-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/user.css">
    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/style.css">
    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">


</head>

<body>
<#setting number_format="#">
<nav
        class="navbar navbar-default navbar-expand-sm navbar-expand-lg navbar-expand-xl navbar-light bg-light  navbar-static-top shadow-lg  mb-4 bg-white  ">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            1="Toggle navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <!-- 以折叠的方式触发-->
        <!--  .navbar-toggler-icon 汉堡式选单Icon -->
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- 屏幕宽度小于768px时，div.navbar-responsive-collapse容器里的内容都会隐藏，显示icon-bar图标，当点击icon-bar图标时，再展开。屏幕大于768px时，默认显示。 -->

    <div class="collapse navbar-collapse navbar-responsive-collapse " id="navbarSupportedContent">
        <!-- .navbar-nav提供完整的高和轻便的导航（包括下拉菜单的支持） -->

        <!-- 一定要用块级元素设置css属性，不然会失效-->
        <ul class="navbar-nav">
            <!-- 起隔离作用 -->

            <li class="nav-item fonts">
                <a class="nav-link" href="G:\bootstarp\main.html">首页</a>
            </li>

            <li class="nav-item fonts">
                <a class="nav-link  " id="archive" href="archives.html">归档</a>
            </li>

            <li class="nav-item fonts">
                <a class="nav-link " href="#">更新</a>
            </li>

            <li class="nav-item fonts">
                <a class="nav-link " href="#">友链</a>
            </li>

            <li class="nav-item fonts">
                <a class="nav-link " href="#">关于</a>
            </li>
        </ul>

        <!-- <div class="navbar-nav text-justify  text-nowrap text-monospace text-sm-left ">
            <a href="write.html" style="text-decoration: none" target="_blank">
                <span class="write-word fonts nav-link">写博客</span>
            </a>
        </div>
        <div class=" navbar-nav justify-content-center ">
            <div class="end">
                <a href="popupsignin.html" class="btn btn-primary btn-sm active rounded btn-block ">登陆</a>
            </div>

            <div class="
            ">
                <a href="popupsignup.html" class="btn btn-primary btn-sm active rounded btn-block ">注册</a>
            </div>
        </div> -->
    </div>


</nav>


<div class="d-flex align-items-stretch">
    <div id="sidebar" class="sidebar py-3">
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">个人中心
        </div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item py-3 mr-3"><a href="/user/PersonalSystem/info" class="sidebar-link text-muted"><i
                    class="zi zi_usercog" zico="用户设置"></i><span>个人设置</span></a></li>
            <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/articleList"
                                                  class="sidebar-link text-muted"><i
                    class="o-sales-up-1 mr-3 text-gray"></i><span>文章列表</span></a></li>
            <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/archives"
                                                  class="sidebar-link text-muted"><i
                    class="o-table-content-1 mr-3 text-gray"></i><span>文章归档</span></a></li>
            <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/modifyPassword"
                                                  class="sidebar-link text-muted active"><i
                    class="zi zi_at mr-3" zico="邮件标记"></i><span>修改密码</span></a></li>

            <li class="sidebar-list-item py-3"><a href="messageSystem.ftl" data-toggle="collapse" data-target="#pages"
                                                  aria-expanded="false" aria-controls="pages"
                                                  class="sidebar-link text-muted"><i
                    class="o-wireframe-1 mr-3 text-gray"></i><span>消息中心</span></a>
                <div id="pages" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="messageSystem.ftl"
                                                         class="sidebar-link text-muted pl-lg-5">个人消息</a>
                        </li>
                        <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted pl-lg-5">系统消息</a>
                        </li>

                    </ul>
                </div>
            </li>

        </ul>
    </div>
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid mx-5 ">
            <section>
                <div class="row mb-4">
                    <div class="col-lg-11 col-sm-11 mb-4 mb-lg-0">
                        <div class="admin-main bg-white shadow-lg" style="padding-top: 0">


                            <!--右侧-->
                            <div class="admin-content pl-5 ">
                                <div class="userInfo my-3">
                                    <div id="personalDate" class="my-3">
                                        <div class="personalupdate pl-5 pb-5 pt-5">
                                            <div class="personalDateHeadPortrait">
                                                <div class="headPortrait " style="margin-left: 60px;">
                                                    <img id="headPortrait"
                                                         src="${user.avatarUrl}"/>
                                                </div>
                                            </div>
                                            <div class="personalDateForm">
                                                <form id="personalDateForm">
                                                    <div class="emailTable ml-3">
                                                        <label for="email">邮箱:</label>
                                                        <input class="formInput" type="email" id="email"
                                                               placeholder="填写你的邮箱" value="${user.email}">
                                                        <hr/>
                                                    </div>
                                                    <div class="birthdayTable  ">
                                                        <label for="checkCode">验证码:</label>
                                                        <input class="formInput" type="text" id="checkCode"
                                                               placeholder="输入邮箱验证码"/>
                                                        <button class="btn  btn-info btn-sm ml-4" type="button"
                                                                id="getCode">点击获取验证码
                                                        </button>
                                                        <hr/>
                                                    </div>
                                                    <div class="birthdayTable ">
                                                        <label for="modifyPassword">新密码:</label>
                                                        <input class="formInput" type="password" id="modifyPassword"
                                                               placeholder="输入新密码"/>
                                                        <hr/>
                                                    </div>
                                                    <div class="birthdayTable">
                                                        <label for="checkPassword">确认密码:</label>
                                                        <input class="formInput" type="password" id="checkPassword"
                                                               placeholder="确认密码"/>
                                                        <hr/>
                                                    </div>
                                                    <button type="button" id="changePasswordBtn"
                                                            class="btn btn-success">保存操作
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>


    </section>


</div>

</div>
</div>
<!-- JavaScript files-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/all.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/plugs_paging.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/user.js"></script>
</body>

</html>