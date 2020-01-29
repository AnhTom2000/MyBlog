<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <#setting number_format="#">
    <title th:text="个人中心">个人中心</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/editormd.min.css"/>
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/all.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/style.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">

    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>


    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/style.css">

<#setting number_format="#">

<body>

<div class="container-fluid">

    <nav
            class="navbar navbar-default navbar-expand-sm navbar-expand-lg navbar-expand-xl navbar-light bg-light  navbar-static-top shadow-lg  mb-4 bg-white  ">
        <#if user??>
        <div class="navbar-barand mr-auto " width="100">
            <a href="/">
                <img src="${user.avatarUrl}"
                     class="img-thumbnail navbar-brand img-responsive rounded-circle" width="50" height="60"
                ><span>${user.userName}</span>
            </a>
        </div>
        <#else >
         <div class="navbar-barand mr-auto " width="100">

         </div>
        </#if>
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
                            <a class="nav-link " href="#">更新</a>
                        </li>

                        <li class="nav-item fonts">
                            <a class="nav-link " href="#">友链</a>
                        </li>

                        <li class="nav-item fonts">
                            <a class="nav-link " href="#">关于</a>
                        </li>

                        <li class="nav-item">
                            <div class="navbar navbar-start">
                                <form class=" from-inline " style="display: inline-flex;" role="search">
                                    <input type="search" placeholder="Search" class="form-control mr-sm-2">
                                    <svg t="1577948224406"
                                         class="icon img-thumbnail navbar-brand img-responsive icon-serach "
                                         role="button" viewBox="0 0 1024 1024" version="1.1"
                                         xmlns="http://www.w3.org/2000/svg" p-id="2586" width="35" height="31">
                                        <path
                                                d="M192 448c0-141.152 114.848-256 256-256s256 114.848 256 256-114.848 256-256 256-256-114.848-256-256z m710.624 409.376l-206.88-206.88A318.784 318.784 0 0 0 768 448c0-176.736-143.264-320-320-320S128 271.264 128 448s143.264 320 320 320a318.784 318.784 0 0 0 202.496-72.256l206.88 206.88 45.248-45.248z"
                                                fill="#1afa29" p-id="2587"></path>
                                    </svg>
                                </form>
                            </div>
                        </li>
                        <li class="divier"></li>
                    </ul>
                </div>

                <div class="navbar-nav text-justify  text-nowrap text-monospace text-sm-left mr-auto">
                    <a href="/markdown" style="text-decoration: none">
                        <span class="write-word fonts nav-link">写博客</span>

                    </a>
                </div>
                <#if user??>
                <div class=" navbar-nav justify-content-center ">
                    <div class=" navbar-nav justify-content-center ">
                        <div class="end">
                            <button id="exit" type="button" class="btn btn-primary btn-sm active rounded btn-block ">
                                退出登录
                            </button>
                        </div>
                    </div>
                </div>
                <#else >
                  <div class="end">
                      <a href="/login" class="btn btn-primary btn-sm active rounded btn-block ">登陆</a>
                  </div>

                    <div class="end">
                        <a href="/register" class="btn btn-primary btn-sm active rounded btn-block ">注册</a>
                    </div>

                </#if>

            </div>
        </div>
    </nav>
</div>


</body>
</html>