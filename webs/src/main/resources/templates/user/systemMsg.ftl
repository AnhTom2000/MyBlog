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
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
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
          href="/static/css/style.default.css"
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
    <link rel="stylesheet" href="https://ico.z01.com/zico.min.css">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/articleList.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">
    <title>系统通知</title>
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
    <div class="d-flex align-items-stretch ">
        <div id="sidebar" class="sidebar py-3 ">
            <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">消息中心
            </div>
            <ul class="sidebar-menu list-unstyled">
                <li class="sidebar-list-item py-3 "><a href="/user/MessageSystem/LikeNotification"
                                                       class="sidebar-link text-muted">
                    <i class="zi zi_digg mr-3" zico="用户设置"></i><span>点赞</span><#if (unMarkRead_Like > 0)><span
                        class="badge badge-danger"
                        style="position: relative;bottom: 10px;left: 2px;">${unMarkRead_Like}</span>
                </#if>
                </a>
                </li>
                <li class="sidebar-list-item py-3"><a href="/user/MessageSystem/Comment_ReplyNotification"
                                                      class="sidebar-link text-muted ">
                    <i class="zi zi_commentdots mr-3 text-gray"></i><span>评论 </span>  <#if (unMarkRead_Comment > 0)>
                    <span
                            class="badge badge-danger"
                            style="position: relative;bottom: 10px;left: 2px;">${unMarkRead_Comment}</span>
                </#if>
                </a>
                </li>
                <li class="sidebar-list-item py-3"><a href="javascript: void (0)"
                                                      class="sidebar-link text-muted active">
                    <i class="zi zi_home mr-3 text-gray"></i><span class="type"
                                                                   id="system">系统通知</span><#if (unMarkRead_System > 0)>
    <span
            class="badge badge-danger" id="unmarkread"
            style="position: relative;bottom: 10px;left: 2px;">${unMarkRead_System}</span>
                </#if>
                </a>
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
                                <div class="admin-content  ">
                                    <div class="userInfo my-3">
                                        <div id="personalDate" class="my-3">
                                            <div class="personalupdate  pb-5 pt-5">
                                                <div class="msg-info col-sm-12 col-xd-12">
                                                    未读消息 : <span id="unMarkReadCount"> ${unMarkRead_System}</span>
                                                <#if (unMarkRead_System > 0 && systemNotice?size > 0) >
                                                <div style="float: right;"><a href="javascript: void(0)"
                                                                              id="markRead">全部标记为已读</a>
                                                    <i id="pump">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;</i>
                                                    <a href="javascript: void(0)" id="clear">清空所有消息</a>
                                                </div>
                                                <#elseif (systemNotice?size>0&&unMarkRead_System==0)>
                                                     <div style="float: right;">
                                                         <a href="javascript: void(0)" id="clear">清空所有消息</a>
                                                     </div>
                                                </#if>
                                                </div>
                                                <div class="msg-list col-sm-12 col-xd-12  my-3"
                                                     id="${systemNotice?size}">
                                                <ul>
                                                     <#if (systemNotice?size > 0)>
                                                        <#list systemNotice as notice>
                                                            <#if (notice.markRead==false)>
                                                       <span class="icon-red-dot" style="
                                                        position: absolute;
                                                        width: 8px;
                                                        height: 8px;
                                                        background: red;
                                                        left: 4px;
                                                        border-radius: 50%;"></span>
                                                            </#if>
                                                            <li>
                                                                <div class="badge badge-info"
                                                                     style="font-size: 15px;">${notice.type}</div>
                                                                <span class="msg-title col">${notice.messageTitle}</span>
                                                                <span>
                                                                    <#if (notice.type=="文章")>
                                                                      <a href="/article/${notice.sourceId}"
                                                                         class="articleName">${notice.messageContent}</a>
                                                                    <#else >
                                                                        <span class="articleName">${notice.messageContent}</span>
                                                                    </#if>
                                                                    <a id="${notice.systemNotificationId}"
                                                                       href="javascript:void(0)"
                                                                       style="float: right;" onclick="clearOne(this)">
                                                                        <i class="zi zi_trashalt" zico="垃圾箱竖条"></i>
                                                                    </a>
                                                                </span>
                                                                <div class="msg-text col">
                                                                    <em style="float: right;">${notice.createTime}</em>
                                                                </div>
                                                            </li>
                                                            <#sep >
                                                            <hr>
                                                        </#list>
                                                </ul>
                                                     <#else >
                                                      <div class="col-sm-12 col-xd-12 text-center my-5"
                                                           style="background-color: lightgray;">
                                                        <span class="noComment"
                                                              style="color: black">没有更多了</span>
                                                      </div>
                                                     </#if>
                                                    <div class="col-sm-12 col-xd-12 text-center my-5"
                                                         style="background-color: lightgray;display: none;  "
                                                         id="noMsg">
                                                        <span class="noComment"
                                                              style="color: black">没有更多了</span>
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
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script src="/static/js/messageNotification.js"></script>
<script src="/static/js/search.js"></script>
</body>

</html>