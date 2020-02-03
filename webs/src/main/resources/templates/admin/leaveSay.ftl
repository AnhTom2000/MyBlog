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
    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/style.css">
    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/articleList.css">
 

</head>

<body>
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


    <div class="d-flex align-items-stretch ">
        <div id="sidebar" class="sidebar py-3 ">
            <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">消息中心
            </div>
            <ul class="sidebar-menu list-unstyled">
                <li class="sidebar-list-item py-3 "><a href="Like.ftl" class="sidebar-link text-muted">
                        <i class="zi zi_digg mr-3" zico="用户设置"></i><span>点赞</span><span class="badge badge-danger" style="position: relative;bottom: 10px;left: 2px;">3</span></a></li>
                <li class="sidebar-list-item py-3"><a href="messageSystem.ftl" class="sidebar-link text-muted " >
                        <i class="zi zi_commentdots mr-3 text-gray"></i><span >评论 </span> <span class="badge badge-danger" style="position: relative;bottom: 10px;left: 2px;">3</span></a> </li>
                <li class="sidebar-list-item py-3"><a href="leaveSay.ftl" class="sidebar-link text-muted active">
                        <i class="zi zi_chat mr-3 text-gray"></i><span>留言</span><span class="badge badge-danger" style="position: relative;bottom: 10px;left: 2px;">3</span></a></li>
                <li class="sidebar-list-item py-3"><a href="systemMsg.ftl" class="sidebar-link text-muted">
                        <i class="zi zi_home mr-3 text-gray"></i><span>系统通知</span><span class="badge badge-danger" style="position: relative;bottom: 10px;left: 2px;">3</span></a></li>

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
                                                <div class="msg-list col-sm-12 col-xd-12  my-3">
                                                    <ul >
                                                        <li>
                                                          <div class="badge badge-info">博客</div><span class="msg-title col"><a href="#" class=" userName">Weleness</a>回复了你的评论<a href="javascript:void(0)" style="float: right;"><i class="zi zi_trashalt" zico="垃圾箱竖条"></i></a></span>
                                                          <p class="msg-text"><span><a href="#" class="articleName">轻松学，Java 中的代理模式及动态代理</a></span><em style="float: right;">2020-2-1</em></p>
                                                        </li>
                                                        <hr>
                                                        <li>
                                                            <div class="badge badge-info">博客</div><span class="msg-title col"><a href="#" class=" userName">Weleness</a>回复了你的评论<a href="javascript:void(0)" style="float: right;"><i class="zi zi_trashalt" zico="垃圾箱竖条"></i></a></span>
                                                            <p class="msg-text"><span><a href="#" class="articleName">轻松学，Java 中的代理模式及动态代理</a></span><em style="float: right;">2020-2-1</em></p>
                                                          </li>
                                                          <hr>
                                                          <li>
                                                            <div class="badge badge-info">博客</div><span class="msg-title col"><a href="#" class=" userName">Weleness</a>回复了你的评论<a href="javascript:void(0)" style="float: right;"><i class="zi zi_trashalt" zico="垃圾箱竖条"></i></a></span>
                                                            <p class="msg-text"><span><a href="#" class="articleName">轻松学，Java 中的代理模式及动态代理</a></span><em style="float: right;">2020-2-1</em></p>
                                                          </li>
                                                          <hr>
                                                    </ul>
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

</body>

</html>