<!DOCTYPE html>
<html lang="zh-CN">

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
    <meta name="description" content="${webInfo.description}">
    <meta name="keywords" content="${webInfo.keywords}">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/style.css">
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/main.css">

    <link rel="stylesheet" href="https://ico.z01.com/zico.min.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/returnTop.css">
    <script src="/static/js/twenMax.js"></script>
    <script src="/static/js/scollToPlugin.js"></script>
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>


    <title>${author.userName}的博客</title>
</head>
<style>
    .fonts {
        color: gray;
        font-weight: bold;
        font-size: 20px;
    }
</style>
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
                                <form class=" from-inline " action="/search" style="display: inline-flex;" role="search"
                                      method="get">
                                    <input id="search" type="search" placeholder="Search" class="form-control mr-sm-2 "
                                           name="key">
                                    <a id="search-btn" role="button" type="submit">
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
                         <span class="write-word nav-link" style="font-family: 微软雅黑;font-size: 15px;font-weight: bold"> <svg
                                 t="1582099712264" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1106" width="16" height="16"><path
                                 d="M62.877 32.936z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0z m29.942 0z m29.941 0z m29.942 0z m29.942 0z m29.941 0zM32.936 62.877z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m0 29.942z m0 29.941z m0 29.942z m0 29.942z m0 29.941z m359.298-379.261s190.824-114.488 298.261-69.264c22.271-33.935 44.209-70.49 65.686-107.81-105.1-25.749-244.18-2.575-244.18-2.575s177.976-106.781 286.939-73.357c21.847-39.399 43.091-78.262 63.585-114.437-86.808-5.865-170.874 8.144-170.874 8.144s111.484-66.89 212.002-78.22c31.624-51.331 60.978-91.583 87.413-111.409-524.912 0-838.362 598.83-958.129 958.129H92.82l179.649-299.415s59.883 59.883 239.532 0c42.548-14.183 85.098-53.569 126.851-106.605-105.371-26.717-246.617-3.181-246.617-3.181z"
                                 p-id="1107" fill="#d81e06"></path></svg>写博客</span>
                     </a>
                 </div>
                 <div class="navbar-barand  dropdown">
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
    <div class="row ">
        <div class=" d-sm-block d-sm-none d-md-block ml-3 shadow-lg p-2 mb-1 bg-white col-sm-9 col-lg-9 col-md-9">
            <div class="container">
                <div class="row   align-items-center">
                    <div class="">
                        <svg t="1578299382807" class="icon" viewBox="0 0 1024 1024" version="1.1"
                             xmlns="http://www.w3.org/2000/svg" p-id="6233" width="20" height="20">
                            <path
                                    d="M686.592 333.312c-19.968-19.968-51.712-19.968-71.68 0-19.968 19.968-19.968 51.712 0 71.68 59.392 59.392 59.392 155.136 0 214.528-19.968 19.968-19.968 51.712 0 71.68 19.968 19.968 51.712 19.968 71.68 0 98.816-99.328 98.816-259.584 0-357.888z m0 0M481.792 147.456L266.24 309.76H131.072c-37.376 0-67.584 29.696-67.584 67.072v270.848c0 36.352 30.208 67.072 67.584 67.072H266.24l216.064 161.792c30.208 22.528 53.76 10.24 53.76-27.136V175.104c0-36.864-24.576-49.664-54.272-27.648z m0 0"
                                    fill="#f4ea2a" p-id="6234"></path>
                            <path
                                    d="M829.44 189.952c-19.968-19.968-51.712-19.968-71.68 0-19.968 19.968-19.968 51.712 0 71.68 138.24 138.24 138.24 362.496 0 500.736-19.968 19.968-19.968 51.712 0 71.68 19.968 19.968 51.712 19.968 71.68 0 177.664-178.176 177.664-466.432 0-644.096z m0 0"
                                    fill="#f4ea2a" p-id="6235"></path>
                        </svg>
                    </div>
                    <div id="carouselExampleControls " class="carousel slide col-sm-11 d-inline d-print-table-row"
                         data-ride="carousel" data-pause="hover" data-interval="3000" aria-hidden="true">
                        <div class="carousel-inner ">
                            <ul class="caption">
                                <#list siteNotice as notice>
                                    <#if (notice.siteNoticeContent == "这里是公告，以后网站更新内容会在这里显示")>
                                           <li class="carousel-item active">
                                               ${notice.siteNoticeContent}
                                           </li>
                                    <#else >
                                     <li class="carousel-item">
                                         ${notice.siteNoticeContent}
                                     </li>
                                    </#if>

                                </#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content -->
    <main class="row " id="mains">
        <div class="col-md-3 col-sm-3 col-lg-3  d-none d-sm-none d-xd-none d-md-none d-md-none d-sm-none d-md-block  sidebar "
             id="sidebar">
            <div
                    class="base-info  content-blcok profile-block shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial sidebar__inner">
                <div class="container mt-4 pt-1 col-sm-7">
                    <div class="row  mt-4  pt-2" width="273" height="136.5">
                        <div class="col-md-12  media erweima" width="140" height="140"
                             data-target="#exampleModalCenter" data-toggle="modal">
                            <img src="${author.avatarUrl}"
                                 alt="头像" title="头像" class=" align-self-start ml-auto mr-auto " width="150.5"
                                 height="140.5">
                        </div>


                        <div class="col-md-12 col-sm-5 mt-4">
                            <h2 id="name" class="text-center">${author.userName}</h2>
                            <h3 id="title" class="text-center">Explorers&developers</h3>
                        </div>
                        <div class="col-md-12 mt-2 text-center " id="location">
                                <span><i class="fa fa-map-marker" aria-hidden="true">
                                        From : <svg t="1577985987188" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                                    xmlns="http://www.w3.org/2000/svg" p-id="6037" width="35"
                                                    height="27">
                                            <path
                                                    d="M954.368 718.848c-4.096-7.168-11.264-11.264-21.504-11.264H672.768c-9.216 17.408-19.456 35.84-28.672 57.344-22.528 44.032-46.08 90.112-68.608 130.048l-2.048 2.048c-13.312 22.528-35.84 37.888-63.488 37.888s-51.2-15.36-63.488-37.888c-7.168-15.36-34.816-64.512-68.608-132.096l-28.672-57.344H210.944c-9.216 0-17.408 6.144-21.504 13.312L69.632 972.8c-4.096 7.168-4.096 15.36 2.048 22.528 4.096 8.192 11.264 12.288 20.48 12.288h721.92c9.216 0 17.408-6.144 21.504-13.312l120.832-251.904c1.024-8.192 1.024-15.36-2.048-23.552zM513.024 16.384C365.568 16.384 245.76 137.216 245.76 283.648c0 90.112 97.28 300.032 177.152 459.776C460.8 820.224 491.52 873.472 491.52 875.52c4.096 7.168 11.264 13.312 21.504 13.312 9.216 0 17.408-6.144 21.504-13.312 0 0 30.72-55.296 68.608-132.096C683.008 583.68 780.288 373.76 780.288 283.648c0-146.432-120.832-267.264-267.264-267.264z m0 430.08c-66.56 0-121.856-51.2-130.048-118.784v-13.312c0-72.704 59.392-130.048 130.048-130.048 66.56 0 123.904 51.2 130.048 116.736v13.312c0 72.704-57.344 132.096-130.048 132.096z"
                                                    fill="#BABABA" p-id="6038"></path>
                                        </svg>${author.area}
                                    </i>
                                </span>
                        </div>
                        <!-- Button trigger modal -->
                        <div class="text-center col-md-12 mt-4 col-sm-7 col-xd-7 text-center">
                            <div style="color: darkgrey;font-size: 15px;">
                                <label for="description" >博主简介：</label><br>
                                <p id="description"> <#if (author.description == "无" || author.description == "")>博主很懒，什么也没有留下<#else >${author.description}</#if></p>
                            </div>
                            <div class="row mt-4"
                                 style="border-top: lightgray solid 1px; border-bottom: lightgray 1px solid ; border-left: solid 1px lightgray; ">
                                <div class="article-info-block col-md-6 .col-sm-6 .col-6 text-center"
                                     style="border-right:  lightgray solid 1px; border-left:  lightgray solid 1px; height: 80px; ">
                                    <div class="mt-2  " style="color: gray;font-size: 20px;">
                                    ${author.articleCount}
                                    </div>
                                    <div class="" style="color: gray;font-size: 20px;font-family: 微软雅黑;">
                                        <span>文章</span>
                                    </div>
                                </div>
                                <div class="article-info-block col-md-6 .col-sm-6 .col-6 text-center "
                                     style="border-right:  gray solid 1px; border-left: lightgray solid 1px;">
                                    <div class="mt-2  " style="color: gray;font-size: 20px;font-family: 微软雅黑;">
                                    ${author.tagCount}
                                    </div>
                                    <div class="" style="color: gray;font-size: 20px;">
                                        <span>标签</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Modal -->

                    </div>

                </div>

            </div>

            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h4 style="font-weight: bold;">最新评论</h4>
                <hr>
                <ul style="list-style: none">
                    <#list newComments as comment>
                        <li>
                            <div>
                                <a class="newComment_ArticleTitle"
                                   href="/article/${comment.article.a_id}">${comment.article.a_Title}</a>
                            </div>
                            <p class="newCommentContent">
                                <span>${comment.user.userName} : </span><span
                                    style="float: right">${(comment.commentTime?string)?replace("T"," ")?datetime("yyyy-MM-dd HH:mm:ss")}</span>
                                <span>${comment.commentContent}</span>
                            </p>
                        </li>
  <#sep >
                        <hr>
                    </#list>
                </ul>

                <br>
            </div>


        </div>
        <div class="col-md-6 " id="show">
            <!-- each-blcok -->
            <#list pageHelper.data as article>
            <div class="content-blcok shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h1 class="mb-3 ml-4"><a href="/article/${article.a_id}" class="articleTitle">${article.a_Title}</a>
                </h1>
                <div class="second-div mb-4 text-center">
                        <span class="text-secondary"><svg t="1578578950975" class="icon" viewBox="0 0 1024 1024"
                                                          version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13365"
                                                          width="18" height="18"><path
                                d="M724.8 314.2c2.8 1.6 5.5 3.2 8.2 5.1l8.2 5.6 0.1 9.8c0.4 28.5-3 52.6-10.4 71.1-6.9 17-17.1 29.7-30.7 37.3-9.3 33.1-20.2 63.8-35.6 89.6-17.8 29.7-41.2 52.5-74.4 64.8-14.8 5.4-52.7 8-89.1 7.4-35.2-0.5-70.5-4-84.5-10.5-30.1-13.9-51.3-37.2-67.4-66.3-13.8-24.8-23.6-53.7-32.1-84.2-14.1-7.4-24.7-20-31.8-37.1-7.8-18.7-11.4-43.2-10.9-72.2l0.1-9.9 8.2-5.5c2.1-1.4 4.2-2.7 6.3-3.9-9.2-114.1-5.7-156.3 36.6-204.5 82.6-67.7 272-65.3 355.7-3.9 57 53.8 61 114.1 43.5 207.3zM551.3 644.1l1.2 26.1-15.5 25.6 21.6 141.8L647 647.5l134.7-4.6c69.6 65.8 114.2 220.8 103.2 321.9H134.2c1.9-88.8 18.2-240.4 106.6-317.6l121.7 1.1 114 188 21.4-140.6-15.5-25.5 1.2-26.1c29.5-1.6 38.2-1.6 67.7 0zM652 273.7c-53.5 10.5-133.2 19.6-196.2-15.8-24.2-13.6-59.7 14.3-88.7 11.4-9 17.8-15.7 37.3-19.6 58l-3.2 17.1-17.2-1.7c-3.2-0.3-6.5 0.1-10 1.3-1.6 0.5-3.1 1.1-4.7 1.9 0.5 19 3.1 34.7 8 46.5 4.3 10.4 10.4 17.1 18.2 19.6l10.1 3.1 2.8 10.1c8.4 31.3 17.9 60.8 31.2 84.8 12.3 22.3 28.1 40 50 50.1 9.2 4.2 38.4 6.6 69 7.1 32.5 0.5 64.9-1.3 75.6-5.2 24.1-8.9 41.4-26.1 54.9-48.6 14.5-24.2 24.8-54.9 33.8-88.6l2.6-9.6 9.6-3.3c7.6-2.7 13.5-9.6 17.6-20 4.7-11.7 7.3-27.2 7.7-45.8-1.4-0.7-2.8-1.3-4.2-1.7-3.4-1.1-6.6-1.7-9.7-1.5l-16.8 1.1-3.1-16.5c-3.8-19.2-9.7-37.2-17.7-53.8z m0 0"
                                fill="#1890FF" p-id="13366"></path></svg>
                        </span><a href="/user/showUser/${article.user.userName}"
                                  class="font-weight-bold text-info">${article.user.userName}</a> &nbsp;&nbsp; <a
                        href="/archives"
                        class="text-secondary">
                    <svg t="1578578791842" class="icon" viewBox="0 0 1024 1024" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" p-id="6608" width="18"
                         height="18">
                        <path
                                d="M829.44 95.232v66.56H712.704V95.232H311.296v66.56H194.56V95.232H61.44v183.296h901.12V95.232z"
                                fill="#F44336" p-id="6609"></path>
                        <path d="M194.56 278.528H61.44v716.8h901.12v-716.8H311.296z"
                              fill="#CFD8DC" p-id="6610"></path>
                        <path
                                d="M194.56 28.672h116.736v133.12H194.56z m518.144 0H829.44v133.12H712.704z"
                                fill="#E8E8E8"
                                p-id="6611"></path>
                        <path
                                d="M194.56 407.552h115.712V522.24H194.56V407.552z m173.056 0h115.712V522.24H367.616V407.552z m173.056 0h115.712V522.24H540.672V407.552z m173.056 0H829.44V522.24H713.728V407.552zM194.56 580.608h115.712V696.32H194.56V580.608z m173.056 0h115.712V696.32H367.616V580.608z m173.056 0h115.712V696.32H540.672V580.608z m173.056 0H829.44V696.32H713.728V580.608zM194.56 752.64h115.712v115.712H194.56V752.64z m173.056 0h115.712v115.712H367.616V752.64z m173.056 0h115.712v115.712H540.672V752.64z m173.056 0H829.44v115.712H713.728V752.64z"
                                fill="#90A4AE" p-id="6612"></path>
                    </svg>
                    ${(article.a_createTime?string)?replace("T"," ")?datetime("yyyy-MM-dd HH:mm:ss")}</a>&nbsp;&nbsp;<svg
                        t="1578579077390" class="icon"
                        viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="14118"
                        width="18" height="18 ">
                    <path d="M926.000524 338.592578 687.387008 107.195418c-43.826158-42.493813-114.802676-43.030026-159.351288-1.326205L71.441611 531.173688c-4.923126 4.585435-7.269567 10.885931-7.019881 17.117866-0.023536 0.416486-0.037862 0.835018-0.037862 1.257643l0 288.372803c0 61.457724 49.552579 111.124913 110.817921 111.124913l299.771411 0c5.968945 0 11.694343-2.407839 15.874549-6.67298L927.985738 495.519654C970.902176 451.640284 970.058972 381.306402 926.000524 338.592578zM303.350424 821.294298c-54.953589 0-99.510388-44.545542-99.510388-99.503225 0-54.956659 44.556798-99.503225 99.510388-99.503225 54.955636 0 99.511411 44.546565 99.511411 99.503225C402.860812 776.747733 358.305037 821.294298 303.350424 821.294298z"
                          p-id="14119"></path>
                </svg>
                    <span class="text-secondary  ">
                    <#list article.tags as tag>
                            <a href="/search?key=${tag.tag_name}" class="showTags">${tag.tag_name?cap_first}</a>
                        <#sep >
                    ,
                    </#list>
                    </span>
                </div>
                <div class="mr-auto ml-auto col-sm-12 col-xd-12 col-lg-12">
                    <p class="showSome lead text-sm-7 text-xd-7 mb-4">
                        ${article.a_text}
                    </p>
                </div>
                <span class="ml-2"><a href="/article/${article.a_id}"><button
                        class="btn btn-default red-button">阅读全文</button></a></span>
                <hr>
                <div class="text-right">
                      <span class="article-info article-info-type badge badge-success " style="float: left">
                          ${article.category.categoryname}
                      </span>
                    <span class="viewCount"><svg t="1578638337969" class="icon" viewBox="0 0 1152 1024" version="1.1"
                                                 xmlns="http://www.w3.org/2000/svg" p-id="3948" width="20" height="20"><path
                            d="M576 0C138.709333 0 0 512 0 512s132.693333 512 576 512C971.093333 1024 1152 512 1152 512S1043.413333 0 576 0z m0 877.269333A365.312 365.312 0 1 1 935.296 512a362.325333 362.325333 0 0 1-359.338667 365.269333zM775.04 512a199.082667 199.082667 0 1 1-199.082667-202.325333s38.4 132.565333 27.904 167.808a192.384 192.384 0 0 1 171.178667 34.517333z"
                            p-id="3949" fill="#1296db"></path></svg> ${article.a_viewNums}
                    </span>&nbsp;
                    <span class="likeCount mr-4"><svg t="1578638384406" class="icon" viewBox="0 0 1024 1024"
                                                      version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4816"
                                                      width="20" height="20"><path
                            d="M512 1024C229.225412 1024 0 794.774588 0 512S229.225412 0 512 0s512 229.225412 512 512-229.225412 512-512 512z m138.059294-751.043765c-51.260235-8.764235-100.291765 14.215529-138.059294 45.266824-37.797647-31.051294-86.799059-54.031059-138.029176-45.296941-110.110118 18.853647-163.087059 134.264471-115.531295 239.796706 39.574588 87.792941 123.994353 166.068706 227.599059 225.370352L512 752.941176l25.961412-14.848c103.604706-59.331765 188.024471-137.577412 227.599059-225.370352 47.585882-105.532235-5.421176-220.943059-115.501177-239.766589z"
                            fill="#FF5A5F" p-id="4817"></path></svg>
                        ${article.a_likeNums} </span>
                </div>
            </div>
            </#list>
        </div>
        <!-- content-right -->
        <div class="col-md-3 d-none d-sm-block d-sm-none d-md-block ">

            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h4 style="font-weight: bold;">最新文章</h4>
                <hr>
                <ul style="list-style: none">
                <#list article_new_List as article>
                    <li>
                        <p>
                            <i class="zi zi_archive zi_2x" zico="文献典籍"> <a class="newArticle"
                                                                           href="/article/${article.a_id}">${article.a_Title}</a>&nbsp;&nbsp;
                            </i><a
                                href="/archives">${(article.a_createTime?string)?replace("T"," ")?datetime("yyyy-MM-dd HH:mm:ss")}</a>
                        </p>

                    </li>

                </#list>
                </ul>
            </div>


            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <div class="container ">
                    <div class="row" style="width: 300px; height: 30px;">
                        <div class="mr-2 mt-2" style="border-right: 1px solid lightgrey; width: 30px;">
                            <svg t="1578000567375" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1093" width="20" height="20">
                                <path
                                        d="M138.2 511.3c0-206 167-373.1 373.1-373.1 206 0 373.1 167 373.1 373.1 0 206-167 373.1-373.1 373.1-206 0-373.1-167.1-373.1-373.1zM511.3 63.6C264 63.6 63.6 264 63.6 511.3 63.6 758.6 264.1 959 511.3 959 758.6 959 959 758.6 959 511.3c0-247.2-200.4-447.7-447.7-447.7zM474 324.8c0-20.6 16.7-37.3 37.3-37.3s37.3 16.7 37.3 37.3c0 20.6-16.7 37.3-37.3 37.3S474 345.4 474 324.8z m37.3 410.4c20.6 0 37.3-16.7 37.3-37.3V474c0-20.6-16.7-37.3-37.3-37.3S474 453.4 474 474v223.9c0 20.6 16.7 37.3 37.3 37.3z"
                                        p-id="1094"></path>
                            </svg>
                        </div>
                        <strong style="font-size: 20px;"> 个人信息</strong>
                    </div>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i>
                            <svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                                <path
                                        d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                        fill="#1C1C1C" p-id="1210"></path>
                                <path
                                        d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1211"></path>
                                <path
                                        d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1212"></path>
                            </svg>
                        </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>文章总数 :</span> <span>${author.articleCount}条</span>
                    </div>

                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i>
                            <svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                                <path
                                        d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                        fill="#1C1C1C" p-id="1210"></path>
                                <path
                                        d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1211"></path>
                                <path
                                        d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1212"></path>
                            </svg>
                        </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>标签总数 :</span> <span>${author.tagCount}条</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i>
                            <svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                                <path
                                        d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                        fill="#1C1C1C" p-id="1210"></path>
                                <path
                                        d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1211"></path>
                                <path
                                        d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1212"></path>
                            </svg>
                        </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>评论总数 :</span> <span>${allCounts.comment_Count}条</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i>
                            <svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                                <path
                                        d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                        fill="#1C1C1C" p-id="1210"></path>
                                <path
                                        d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1211"></path>
                                <path
                                        d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1212"></path>
                            </svg>
                        </i>
                    </div>
                    <div class="col-9 mt-0 messgaes">
                        <span>最后一次登陆时间 :</span> <span
                            id="lastLogin">${(author.lastLogin?string)?replace("T"," ")?datetime("yyyy-MM-dd HH:mm:ss")}</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i>
                            <svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                                <path
                                        d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                        fill="#1C1C1C" p-id="1210"></path>
                                <path
                                        d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1211"></path>
                                <path
                                        d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                        fill="#1C1C1C" p-id="1212"></path>
                            </svg>
                        </i>

                    </div>
                    <div class="col-9 mt-0 messgaes ">
                        <span>最后一次发布文章时间 :</span>
                        <span>${(author.lastUpdate?string)?replace("T"," ")?datetime("yyyy-MM-dd HH:mm:ss")}</span>
                    </div>
                </div>

            </div>
        </div>

        <div class="ml-auto mr-auto">
            <nav aria-label="...">
                <ul class="pagination pagination-lg">
                <#if (pageHelper.pageNo == 1)>
                <li class="page-item disabled" style="cursor: not-allowed">
                    <a class="page-link" href="javascript:void(0)" tabindex="-1">上一页</a>
                </li>
                <#else >
                 <li class="page-item ">
                     <a class="page-link"
                        href="/user/showUser/${user.userName}?pageNo=${pageHelper.pageNo-1}&pageSize=${pageHelper.pageSize}"
                        tabindex="-1">上一页</a>
                 </li>
                </#if>
               <#list 1..(pageHelper.totalPage?number)!0 as data>
                <li class="page-item <#if (pageHelper.pageNo == (data_index+1)) > active</#if>"><a class="page-link"
                                                                                                   href="/user/showUser/${user.userName}?pageNo=${data_index+1}&pageSize=${pageHelper.pageSize}">${data_index+1}</a>
                </li>
               </#list>
                <#if (pageHelper.totalPage==pageHelper.pageNo)>
                <li class="page-item disabled" style="cursor: not-allowed">
                    <a class="page-link" href="javascript:void(0)">下一页</a>
                </li>
                <#else >
                 <li class="page-item " style="cursor: not-allowed">
                     <a class="page-link"
                        href="/user/showUser/${author.userName}?pageNo=${pageHelper.pageNo+1}&pageSize=${pageHelper.pageSize}">下一页</a>
                 </li>
                </#if>
                </ul>
            </nav>

        </div>
        <div id="shangxia2">
				<span id="gotop1">
					<img src="/static/css/huojian.svg" alt="返回顶部小火箭">
				</span>
        </div>
    </main>

    <!-- foot -->
    <footer class="row">
        <div class="others col-md-12 text-center">
            <div class="row">
                <div class="col-md-4">
                    <h3>站长微信</h3>
                    <hr/>
                    <div class="others-blcok friendLink others-block mb-5">
                        <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200102165354.jpg"
                             width="150" height="150">
                    </div>
                </div>
                <div class="col-md-4 friendLink">
                    <h3>友链</h3>
                    <hr/>
                <#list webInfo.links as link>
                     <a href="${link.href}" target="_blank" class="mb-3">${link.linkName}</a>
                    <#sep >
                <br/>
                </#list>
                </div>
                <div class="col-md-4">
                    <h3>站长邮箱</h3>
                    <hr/>
                    <div class="others-blcok friendLink others-block mb-5">
                        <p>939850185@qq.com</p>
                    </div>
                </div>
            </div>
            <div class="company-info col-md-12 bg-dark">
                <p class="text-secondary text-center">©Copyright&nbsp;${webInfo.copyright}&nbsp;至今 Weleness
                    <br>
                    |&nbsp;&nbsp;<a
                            href="http://beian.miit.gov.cn/state/outPortal/loginPortal.action;jsessionid=dTJd4GyV8SCkxeXgsVC8XTDs3CoaHxb_LXpXqFYLPFsbiJ1WtHBY!1122133304"
                            target="_blank" style="text-decoration: none;color:darkgrey">${webInfo.icpInfo}</a>&nbsp;&nbsp;|
                </p>
            </div>
    </footer>


</div>

</body>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sroll.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
<script src="/static/js/index%20(1).js"></script>
<script src="/static/js/search.js"></script>
</html>