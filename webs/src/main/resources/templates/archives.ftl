<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="${webInfo.description}">
    <meta name="keywords" content="${webInfo.keywords}">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/style.css">
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">

    <link rel="stylesheet" href="/static/css/NZ-Loading.min.css">

    <link rel="stylesheet" href="/static/css/shCoreRDark.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <link rel="stylesheet" href="/static/css/about.css">

<#--js-->
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
    <title>归档</title>
</head>
    <#setting number_format="#">
<body>
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
    <main class="row " id="mains">
        <div class="box">
            <ul class="event_year">
                <#list archives as archive>
                    <li <#if (archive.archiveYear == .now?string("yyyy"))> class="current"</#if>>
                        <label for="${archive.archiveYear}">${archive.archiveYear}</label></li>
                </#list>
            </ul>
            <ul class="event_list">
            <#list archives as archive>
                     <div>
                         <h3 id="${archive.archiveYear}">${archive.archiveYear}</h3>
                         <#list archive.articles as article>
                         <li>
                             <span>${archive.archiveName}</span>
                             <p>
                                 <span >
                                     <a class=" badge badge-success mr-5"
                                           style="float: left;width: 40px;height :20px;color: snow;background-color: mediumseagreen">
                                         ${article.category.categoryname}
                                     </a>
                                     <a style="font-size: 20px; color: darkgrey;font-size: 楷体" href="/article/${article.a_id}">${article.a_Title}</a>
                             </span>
                                 <span><svg t="1582355971794" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                            xmlns="http://www.w3.org/2000/svg" p-id="2035" width="16" height="16"><path
                                         d="M175.36 960C125.696 960 64 894.016 64 840.64V320h896v513.024C961.152 887.616 894.848 960 843.84 960H175.36zM768 0v128h-128l-0.256-128H384v128H256V0H169.92C75.904 0 0 90.496 0 202.24v619.52C0 933.568 75.904 1024 169.92 1024h684.096C948.096 1024 1024 933.632 1024 821.76V202.24C1024 91.904 948.032 0 854.016 0H768zM192 832h128v-128H192v128z m0-256h128v-128H192v128z m256 0h128v-128h-128v128z m256 0h128v-128h-128v128z m0 256h128v-128h-128v128z m-256 0h128v-128h-128v128z"
                                         fill="#757575" p-id="2036"></path></svg> ${article.a_createTime} &nbsp;&nbsp;&nbsp;<svg
                                         t="1582356053005" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                         xmlns="http://www.w3.org/2000/svg" p-id="2762" width="16" height="16"><path
                                         d="M895.898 821.453c-12.186-21.095-29.901-39.22-52.634-54.067-27.443-17.92-62.464-30.925-103.936-38.605-0.307 0-0.512-0.103-0.82-0.103-0.306 0-31.64-4.3-63.794-12.8-55.91-14.745-60.826-27.75-60.826-27.852-0.307-1.332-0.82-2.56-1.434-3.687-0.41-2.457-1.536-11.571 0.615-36.045 5.53-62.156 37.888-98.918 63.897-128.512 8.192-9.318 15.975-18.124 21.914-26.726 25.805-37.171 28.16-79.565 28.262-81.306v-0.819c0-5.325-0.614-9.728-1.843-13.721-2.56-8.09-7.27-13.108-10.752-16.794-0.921-0.922-1.74-1.843-2.355-2.662-0.307-0.308-0.922-1.127-0.307-5.325 2.253-15.463 3.686-28.365 4.3-40.653 1.127-21.914 2.049-54.682-3.379-86.63-0.716-5.428-1.843-11.162-3.686-18.023-5.837-22.016-15.155-40.755-27.75-55.808-0.103-0.102-0.205-0.307-0.41-0.41-2.253-2.457-56.32-61.235-213.504-73.318-21.709-1.638-43.213-0.819-63.386 0.307l-1.024 0.103c-5.12 0.307-12.083 0.614-18.636 2.355-16.18 4.3-20.583 14.95-21.71 20.89-1.842 9.83 1.434 17.408 3.585 22.528 0.307 0.716 0.717 1.638 1.024 2.355-0.205 0.41-0.512 0.921-0.922 1.638-3.686 5.837-9.42 11.06-15.053 15.872l-0.204 0.205c-1.741 1.434-41.063 36.454-43.316 82.227-5.836 34.714-5.427 88.883 1.024 124.007 0.103 0.819 0.308 1.536 0.41 2.355 0.41 2.048 1.024 5.12 0.922 6.349-0.103 0.102-0.205 0.307-0.512 0.512l-0.41 0.41c-7.475 6.86-15.872 14.642-15.872 31.538v0.82c0.102 1.74 2.458 44.134 28.262 81.305 5.94 8.602 13.722 17.408 21.914 26.727 26.01 29.49 58.47 66.252 63.898 128.512 2.15 24.473 1.024 33.587 0.614 36.044-0.614 1.127-1.126 2.356-1.434 3.687 0 0.102-4.915 13.107-60.62 27.75-32.154 8.5-63.693 12.8-64.103 12.8-0.205 0-0.41 0.103-0.614 0.103-41.063 7.168-75.879 19.763-103.22 37.683-22.63 14.745-40.345 32.973-52.735 54.17-19.764 33.894-19.15 64.819-18.842 70.45v20.173c0 9.319 7.578 16.794 16.794 16.794h401.1l188.11-0.102v0.102h184.729c9.318 0 16.793-7.578 16.793-16.794v-20.07c0.41-6.349 1.23-36.557-18.124-69.94z"
                                         p-id="2763"></path></svg> <a
                                         href="/user/showUser/${article.user.userName}">${article.user.userName}</a>&nbsp;&nbsp;&nbsp;<svg
                                         t="1582356093508" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                         xmlns="http://www.w3.org/2000/svg" p-id="3557" width="16" height="16"><path
                                         d="M154.432 521.216l-25.92-199.424a59.584 59.584 0 0 1 68.288-66.624l193.92 30.208c12.544 1.92 24.064 7.808 33.024 16.768l323.456 323.456a59.584 59.584 0 0 1 0 84.352l-168.576 168.576a59.584 59.584 0 0 1-84.352 0L171.392 555.648a59.584 59.584 0 0 1-16.96-34.432z m146.56-88.96a59.584 59.584 0 1 0-84.288-84.288 59.584 59.584 0 0 0 84.288 84.352z m-43.328-216.32l-2.688-20.608a59.584 59.584 0 0 1 68.288-66.56l193.92 30.208c12.544 1.92 24.064 7.808 33.024 16.704L873.664 499.2a59.584 59.584 0 0 1 0 84.352l-84.288 84.288a59.584 59.584 0 0 0 0-84.288L465.92 259.968a59.584 59.584 0 0 0-32.96-16.704l-175.36-27.328z"
                                         p-id="3558"></path></svg><#list article.tags as tag>
                                     <a href="/search?type=tag&key=${tag.tag_name}" >${tag.tag_name}</a> <#sep > ,
                                 </#list></span>
                             </p>
                         </li>
                         </#list>
                     </div>


            </#list>
            </ul>
            <div class="clearfix">
            </div>
        </div>
    </main>
    <div class="under" style="margin-top: 30%">
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
            </div>
        </footer>
    </div>
</div>

</body>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sidebar.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sroll.js"></script>
<script src="/static/js/NZ-Loading.min.js"></script>
<script src="/static/js/shCore.js"></script>
<script src="/static/js/shBrushJScript.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
<script src="/static/js/archives.js"></script>
<script src="/static/js/search.js"></script>
</html>