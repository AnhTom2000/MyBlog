<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">

    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">
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
          href="/static/css/style.default.css">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/css/custom.css">
    <!-- Favicon-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/user.css">
    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/style.css">
    <link rel="stylesheet" href="https://ico.z01.com/zico.min.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">

    <title>个人中心</title>
</head>

<body>
<#setting number_format="#">

<div class="container-fluid">

    <nav
            class="navbar navbar-default navbar-expand-sm navbar-expand-lg navbar-expand-xl navbar-light bg-light  navbar-static-top shadow-lg  mb-4 bg-white  ">
        <div class="navbar-barand ml-auto" width="100">
            <a href="/">
                <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png"
                     width="150" height="80"
                     class=" navbar-brand img-responsive"
                >
            </a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                1="Toggle navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            <div class="collapse navbar-collapse navbar-responsive-collapse " id="navbarSupportedContent">
                <div class="  d-flex justify-content-center mr-auto">
                    <ul class="navbar-nav">
                        <li class="divider"></li>
                        <li class="nav-item fonts">
                            <a class="nav-link" href="/">首页</a>
                        </li>

                        <li class="nav-item fonts">
                            <a class="nav-link  " id="archive" href="/archives">归档</a>
                        </li>

                        <li class="nav-item fonts">
                            <a class="nav-link " href="/update">更新</a>
                        </li>

                        <li class="nav-item fonts">
                            <a class="nav-link fonts" href="javascript:void (0)" onclick="toastr.warning('敬请期待')">其他</a>
                        </li>

                        <li class="nav-item">
                            <div class="navbar navbar-start">
                                <form class=" from-inline " action="/search" style="display: inline-flex;" role="search" method="get" >
                                    <input id="search" type="search" placeholder="Search"  class="form-control mr-sm-2 " name="key">
                                    <a id="search-btn" role="button" type="submit" >
                                        <svg t="1577948224406"
                                             class="icon img-thumbnail navbar-brand img-responsive icon-serach "
                                             role="button" viewBox="0 0 1024 1024" version="1.1"
                                             xmlns="http://www.w3.org/2000/svg" p-id="2586" width="35" height="31">
                                            <path
                                                    d="M192 448c0-141.152 114.848-256 256-256s256 114.848 256 256-114.848 256-256 256-256-114.848-256-256z m710.624 409.376l-206.88-206.88A318.784 318.784 0 0 0 768 448c0-176.736-143.264-320-320-320S128 271.264 128 448s143.264 320 320 320a318.784 318.784 0 0 0 202.496-72.256l206.88 206.88 45.248-45.248z"
                                                    fill="#1afa29" p-id="2587"></path>
                                        </svg>
                                    </a>
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>

                <#if user??>
                 <div class="navbar-nav text-justify  text-nowrap text-monospace text-sm-left mr-3">
                     <a href="/markdown" style="text-decoration: none" target="_self">
                         <span class="write-word nav-link" style="font-family: 微软雅黑;font-size: 15px;font-weight: bold"> <svg t="1582099712264" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1106" width="16" height="16"><path d="M62.877 32.936z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0zM32.936 62.877z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m359.298-379.261s190.824-114.488 298.261-69.264c22.271-33.935 44.209-70.49 65.686-107.81-105.1-25.749-244.18-2.575-244.18-2.575s177.976-106.781 286.939-73.357c21.847-39.399 43.091-78.262 63.585-114.437-86.808-5.865-170.874 8.144-170.874 8.144s111.484-66.89 212.002-78.22c31.624-51.331 60.978-91.583 87.413-111.409-524.912 0-838.362 598.83-958.129 958.129H92.82l179.649-299.415s59.883 59.883 239.532 0c42.548-14.183 85.098-53.569 126.851-106.605-105.371-26.717-246.617-3.181-246.617-3.181z" p-id="1107" fill="#d81e06"></path></svg>写博客</span>
                     </a>
                 </div>
                 <div class="navbar-barand  dropdown" >
                     <a href="#" class="dropdown-toggle" role="button" id="dropdownMenuLink" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                         <img src="${user.avatarUrl}"
                              class="img-thumbnail navbar-brand img-responsive rounded-circle " width="50"
                              height="80">
                         <span style="font-size: 15px;">${user.userName}</span>
                     </a>
                     <div class="dropdown-menu " aria-labelledby="dropdownMenuLink">
                         <a class="dropdown-item" href="/user/showUser/${user.userName}">博客主页</a>
                         <a class="dropdown-item" href="/user/PersonalSystem/info">个人中心</a>
                         <a id="exit" class="dropdown-item" href="javascript:void(0)"> 退出登录</a>
                     </div>
                 </div>
                <#else >
                  <div class="end mr-5">
                      <a href="/login" class="btn btn-primary btn-sm active rounded btn-block ">
                          登陆
                      </a>
                  </div>
                    <div class="end">
                        <a href="/register" class="btn btn-primary btn-sm active rounded btn-block ">
                            注册
                        </a>
                    </div>
                </#if>
            </div>
    </nav>
</div>

<div class="container-fluid">
    <div class="d-flex align-items-stretch">
        <div id="sidebar" class="sidebar py-3">
            <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">个人中心
            </div>
            <ul class="sidebar-menu list-unstyled">
                <li class="sidebar-list-item py-3 mr-3"><a href="/user/PersonalSystem/info"
                                                           class="sidebar-link text-muted active"><i
                        class="zi zi_usercog" zico="用户设置"></i><span>个人设置</span></a></li>
                <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/articleList"
                                                      class="sidebar-link text-muted"><i
                        class="o-sales-up-1 mr-3 text-gray"></i><span>文章列表</span></a></li>
                <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/archives"
                                                      class="sidebar-link text-muted"><i
                        class="o-table-content-1 mr-3 text-gray"></i><span>文章归档</span></a></li>
                <li class="sidebar-list-item py-3"><a href="/user/PersonalSystem/modifyPassword"
                                                      class="sidebar-link text-muted"><i class="zi zi_at mr-3"
                                                                                         zico="邮件标记"></i><span>修改密码</span></a>
                </li>

                <li class="sidebar-list-item py-3"><a href="javascript:void(0)" data-toggle="collapse"
                                                      data-target="#pages"
                                                      aria-expanded="false" aria-controls="pages"
                                                      class="sidebar-link text-muted"><i
                        class="o-wireframe-1 mr-3 text-gray"></i><span>消息中心</span></a>
                    <div id="pages" class="collapse">
                        <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                            <li class="sidebar-list-item"><a href="/user/MessageSystem/LikeNotification"
                                                             class="sidebar-link text-muted pl-lg-5">个人消息</a>
                            </li>
                            <li class="sidebar-list-item"><a href="/user/MessageSystem/systemNotification"
                                                             class="sidebar-link text-muted pl-lg-5">系统消息</a>
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
                                                    <div class="headPortrait">
                                                        <img id="headPortrait"
                                                             src="${user.avatarUrl}"/>
                                                    </div>
                                                    <div class="headChange">
                                                        <div class="headPortraitChange">
                                                            <form action="/api/uploadUserImg" method="post"
                                                                  enctype="multipart/form-data" id="img">
                                                                <input id="imgTest" name="user_avatar" type="file"
                                                                       onchange="imgChange(event)"
                                                                       accept=".gif,.jpg,.jpeg,.png">
                                                                <a>更改头像</a>
                                                            </form>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="personalDateForm">
                                                    <form id="personalDateForm">
                                                        <div class="userNameTable">
                                                            <label for="username">用户名:</label>
                                                            <input class="formInput" type="text" id="username"
                                                                   readonly="readonly"
                                                                   style=" background-color:lightgray;cursor: not-allowed"
                                                                   placeholder="用户名" value="${user.userName}">
                                                            <hr/>
                                                        </div>
                                                        <div class="birthdayTable">
                                                            <label for="age">年龄:</label>
                                                            <input class="formInput" type="text" id="age"
                                                                   placeholder="年龄" value="${user.age}"/>
                                                            <hr/>
                                                        </div>
                                                        <div class="phoneTable">
                                                            <label for="phone">手机:</label>
                                                            <input class="formInput" type="text" id="phone"
                                                                   placeholder="填写你的手机" value="${user.phone}">
                                                            <hr/>
                                                        </div>
                                                        <div class="genderTable">
                                                            <label>性别:</label>
                                                            <#if user.gender>
                                                            <label class="am-radio-inline" style="width: 60px">
                                                                <input class="formInput" type="radio" id="male"
                                                                       name="gender" value="true" checked>
                                                                <span class="am-icon-male "><i class="zi zi_male"
                                                                                               zico="男性"></i></span>
                                                            </label>
                                                            <label style="width: 60px">
                                                                <input class="formInput" type="radio" id="female"
                                                                       name="gender" value="false">
                                                                <span class="am-icon-female "><i class="zi zi_female"
                                                                                                 zico="女性"></i></span>
                                                            </label>
                                                            <hr/>
                                                            <#else >
                                                            <label class="am-radio-inline" style="width: 60px">
                                                                <input class="formInput" type="radio" id="male"
                                                                       name="gender" value="true">
                                                                <span><i class="zi zi_male"
                                                                         zico="男性"></i></span>
                                                            </label>
                                                            <label style="width: 60px">
                                                                <input class="formInput" type="radio" id="female"
                                                                       name="gender" value="false" checked>
                                                                <span><i class="zi zi_female"
                                                                         zico="女性"></i></span>
                                                            </label>
                                                            </#if>
                                                        </div>
                                                        <div class="emailTable">
                                                            <label for="email">邮箱:</label>
                                                            <input class="formInput" type="email" id="email"
                                                                   placeholder="填写你的邮箱" value="${user.email}">
                                                            <hr/>
                                                        </div>
                                                        <div class="trueNameTable">
                                                            <label for="trueName">地区:</label>
                                                            <input class="formInput" type="text" id="area"
                                                                   placeholder="地区" value="${user.area}">
                                                            <hr/>
                                                        </div>
                                                        <div class="trueNameTable">
                                                            <label for="profession">职业:</label>
                                                            <input class="formInput" type="text" id="profession"
                                                                   placeholder="职业" value="${user.profession}">
                                                            <hr/>
                                                        </div>

                                                        <div class="personalBriefTable">
                                                            <label for="description">个人简介:</label><br>
                                                            <textarea class="formInput" id="description"
                                                                      placeholder="填写你的个人简介">${user.description}</textarea>
                                                            <hr/>
                                                        </div>
                                                        <button type="button" id="savePersonalDateBtn"
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
</div>
<!-- JavaScript files-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/all.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script src="/static/js/user.js"></script>
<script src="/static/js/search.js"></script>
</body>

</html>