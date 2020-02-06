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



    <nav
            class="navbar navbar-default navbar-expand-sm navbar-expand-lg navbar-expand-xl navbar-light bg-light  navbar-static-top shadow-lg  mb-4 bg-white  d-flex">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse  navbar-responsive-collapse col-sm-7 col-xd-5 col-lg-7 ml-auto"
             id="navbarSupportedContent">
            <ul class="navbar-nav ">

                <!-- 起隔离作用 -->

                <li class="nav-item fonts">
                    <a class="nav-link" href="/">首页</a>
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
        </div>
        <div class="d-flex">
            <div class="navbar-nav text-justify  text-nowrap text-monospace text-sm-left ">
                <a href="/markdown" style="text-decoration: none" target="_blank">
                    <span class="write-word fonts nav-link">写博客</span>
                </a>
            </div>
            <div class=" navbar-nav justify-content-center ">
                <div style="width: 70px;
            text-decoration: none;
            margin-top: 10px;
            margin-right: 30px;
            color: white;">
                    <a href="/login"
                       class="btn btn-primary btn-sm active rounded btn-block ">登陆</a>
                </div>

                <div style="width: 70px;
            text-decoration: none;
            margin-top: 10px;
            margin-right: 30px;
            color: white;">
                    <a href="/register"
                       class="btn btn-primary btn-sm active rounded btn-block ">注册</a>
                </div>
            </div>
        </div>
        <div class="nav-item ml-auto navbar-brand  dropdown dropdown-toggle   d-flex" style="margin-right: 100px;"
             data-toggle="dropdown" aria-haspopup="true" role="button">
            <#--<img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/photo.jpg" role="button"-->
                 <#--class="img-fluid rounded mx-auto d-block" alt="Responsive image" width="50" height="10">-->

            <div class="dropdown-menu " aria-labelledby="dropdownMenuReference">
                <a class="dropdown-item" href="/userSystem">个人中心</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/user/userMain/${user.userName}">个人主页</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">退出登陆</a>
            </div>
        </div>


    </nav>



</body>
</html>