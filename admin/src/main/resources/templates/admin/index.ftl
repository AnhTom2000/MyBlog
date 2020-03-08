<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">
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
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/img/favicon.png">

    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admins/css/admin.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">


</head>
<body>
<!-- navbar-->
<header class="header">
    <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow">
        <a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead">
            <i class="fas fa-align-left"></i>
        </a>
        <a href="javascript:void (0)" class="navbar-brand font-weight-bold text-uppercase text-base">Nobug后台管理系统</a>
        <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">

            <li class="nav-item dropdown ml-auto">
                <a id="userInfo" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false" class="nav-link dropdown-toggle"><img
                        src="${superAdmin.avatarUrl}"
                        alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow">
                </a>
                <div aria-labelledby="userInfo" class="dropdown-menu">
                    <a href="javascript: void(0)" id="${superAdmin.adminId}" class="dropdown-item exit">退出登陆</a>
                </div>
            </li>
            <span href="javascript: void(0)"><strong
                    class="d-block text-uppercase headings-font-family">${superAdmin.adminName}</strong></span>
        </ul>
    </nav>
</header>
<div class="d-flex align-items-stretch">
    <div id="sidebar" class="sidebar py-3">
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">MAIN
        </div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item"><a href="/admin/" class="sidebar-link text-muted active"><i
                    class="o-home-1 mr-3 text-gray"></i><span>主页</span></a></li>
            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#users" aria-expanded="false"
                                             aria-controls="pages" class="sidebar-link text-muted"><i
                    class="zi zi_userastronaut mr-3 text-gray"></i><span>用户管理</span></a>
                <div id="users" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/admin/userAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_usercog mr-3 text-gray"></i>用户列表</span></a></li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item"><a href="javascript: void(0)" data-toggle="collapse" data-target="#managers"
                                             aria-expanded="false" aria-controls="pages"
                                             class="sidebar-link text-muted"><i
                    class="zi zi_usersecret mr-3 text-gray"></i><span>后台管理</span></a>
                <div id="managers" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/admin/superAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_userscog mr-3 text-gray"></i>管理员列表</span></a></li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item"><a href="javascript: void(0)" data-toggle="collapse" data-target="#items"
                                             aria-expanded="false"
                                             aria-controls="pages" class="sidebar-link text-muted"><i
                    class="o-wireframe-1 mr-3 text-gray"></i><span>内容管理</span></a>
                <div id="items" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/admin/articleAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_textbook mr-3 text-gray"></i><span>内容管理</span></a></li>
                        <li class="sidebar-list-item"><a href="/admin/checkArticle"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_clipboardcheck mr-3 text-gray"></i><span>文章审核</span></a></li>
                        <li class="sidebar-list-item"><a href="/admin/questionAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_squareBook mr-3 text-gray"></i><span>反馈管理</span></a></li>
                        <li class="sidebar-list-item"><a href="/admin/commentAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_commentalt mr-3 text-gray"></i><span>评论管理</span></a></li>
                    </ul>
                </div>
            </li>
        </ul>
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">EXTRAS
        </div>
        <ul class="sidebar-menu list-unstyled">
            <li class="sidebar-list-item"><a href="javascript:void(0)" data-toggle="collapse" data-target="#message"
                                             aria-expanded="false" aria-controls="pages"
                                             class="sidebar-link text-muted"><i class="o-database-1 mr-3 text-gray"></i><span>消息管理</span></a>
                <div id="message" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/admin/messageAdmin"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_fly mr-3 text-gray"></i><span>发送消息</span></a></li>
                    </ul>
                </div>
            </li>
            <li class="sidebar-list-item"><a href="javascript:void(0)" data-toggle="collapse" data-target="#website"
                                             aria-expanded="false" aria-controls="pages"
                                             class="sidebar-link text-muted"><i
                    class="zi zi_circleComponents mr-3 text-gray"></i><span>网站管理</span></a>
                <div id="website" class="collapse">
                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                        <li class="sidebar-list-item"><a href="/admin/siteNotice"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_speaker mr-3 text-gray"></i><span>网站公告</span></a></li>
                        <li class="sidebar-list-item"><a href="/admin/friendLink"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_link mr-3 text-gray"></i><span>友链管理</span></a></li>
                        <li class="sidebar-list-item"><a href="/admin/meta"
                                                         class="sidebar-link text-muted pl-lg-5"><span><i
                                class="zi zi_verFlag mr-4 text-gray"></i><span>元信息管理</span></a></li>
                    </ul>
                </div>
            </li>

        </ul>
    </div>
    <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
            <section class="py-5">
                <div class="row">
                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                            <div class="flex-grow-1 d-flex align-items-center">
                                <div class="dot mr-3 bg-violet"></div>
                                <div class="text">
                                    <h6 class="mb-0">用户数量</h6><span class="text-gray">${userCount}</span>
                                </div>
                            </div>
                            <div class="icon text-white bg-violet"><i class="fas fa-server"></i></div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                            <div class="flex-grow-1 d-flex align-items-center">
                                <div class="dot mr-3 bg-green"></div>
                                <div class="text">
                                    <h6 class="mb-0">文章数量</h6><span class="text-gray">${articleCount}</span>
                                </div>
                            </div>
                            <div class="icon text-white bg-green"><i class="far fa-clipboard"></i></div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                            <div class="flex-grow-1 d-flex align-items-center">
                                <div class="dot mr-3 bg-blue"></div>
                                <div class="text">
                                    <h6 class="mb-0">标签总数</h6><span class="text-gray">${tagCount}</span>
                                </div>
                            </div>
                            <div class="icon text-white bg-blue"><i class="fa fa-dolly-flatbed"></i></div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                            <div class="flex-grow-1 d-flex align-items-center">
                                <div class="dot mr-3 bg-red"></div>
                                <div class="text">
                                    <h6 class="mb-0">友链数量</h6><span class="text-gray">${friendLinkCount}</span>
                                </div>
                            </div>
                            <div class="icon text-white bg-red"><i class="fas fa-receipt"></i></div>
                        </div>
                    </div>
                </div>
            </section>


            <section>
                <div class="row text-center">
                    <div class="col-lg-12 ">
                        <div class="card mb-5 mb-lg-0 ">
                            <div class="card-body col-lg-6 ml-auto mr-auto">
                                <div><span class="index">欢迎登陆</span></div>
                                <div><span class="index">NoBug社区</span></div>
                                <div><span class="index">后台管理系统</span></div>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
            <section class="py-5">
                <div class="row">
                    <div class="col-lg-12">
                        <#list superAdmins.data as admins>
                            <a href="#"
                               class="message card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                <div class="row">
                                    <div class="col-lg-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                        <strong class="h5 mb-0">${admins_index+1}<sup
                                                class="smaller text-gray font-weight-normal">Super</sup></strong><img
                                            src="${admins.avatarUrl}"
                                            alt="..." style="max-width: 3rem" class="rounded-circle mx-3 my-2 my-lg-0">
                                        <h6 class="mb-0">${admins.adminName}</h6>
                                    </div>
                                    <div class="col-lg-9 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                        <div class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode">
                                            <#if (admins.adminName=="Weleness")>
                                                超级管理员
                                            <#else >
                                                管理员
                                            </#if>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </#list></div>
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
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/js.cookie.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/front.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script>
    $('.exit').click(function () {
        exit(this);
    });

    function exit(btn) {
        $.ajax({
            url: '/admin/superAdmin/exit/adminExit',
            type: 'POST',
            data: {
                'adminId': $(btn).attr('id')
            }, cache: false,
            dataType: 'json',
            success: function (data) {
                $.get("/admin/login", function (data, status, xhr) {
                    window.location.replace("/admin/login");
                });
            }
        })
    }
</script>
</body>
</html>