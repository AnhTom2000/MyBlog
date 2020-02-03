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
    <title>文章归档</title>
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

        </div>



    </nav>


    <div class="d-flex align-items-stretch bg-gray-100">
        <div id="sidebar" class="sidebar py-3">
            <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">个人中心
            </div>
            <ul class="sidebar-menu list-unstyled">
                <li class="sidebar-list-item py-3 mr-3"><a href="userEdit.ftl" class="sidebar-link text-muted "><i
                            class="zi zi_usercog" zico="用户设置"></i><span>个人设置</span></a></li>
                <li class="sidebar-list-item py-3"><a href="articles.ftl" class="sidebar-link text-muted"><i
                            class="o-sales-up-1 mr-3 text-gray"></i><span>文章列表</span></a></li>
                <li class="sidebar-list-item py-3"><a href="article_archive.ftl" class="sidebar-link text-muted active"><i
                            class="o-table-content-1 mr-3 text-gray "></i><span>文章归档</span></a></li>
                <li class="sidebar-list-item py-3"><a href="modifyPassword.ftl" class="sidebar-link text-muted"><i class="zi zi_at mr-3" zico="邮件标记"></i><span>修改密码</span></a></li>
                
                <li class="sidebar-list-item py-3"><a href="messageSystem.ftl" data-toggle="collapse" data-target="#pages"
                                                      aria-expanded="false" aria-controls="pages" class="sidebar-link text-muted"><i
                            class="o-wireframe-1 mr-3 text-gray"></i><span>消息中心</span></a>
                    <div id="pages" class="collapse">
                        <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                            <li class="sidebar-list-item"><a href="messageSystem.ftl" class="sidebar-link text-muted pl-lg-5">个人消息</a>
                            </li>
                            <li class="sidebar-list-item"><a href="messageSystem.ftl" class="sidebar-link text-muted pl-lg-5">系统消息</a>
                            </li>

                        </ul>
                    </div>
                </li>

            </ul>
        </div>
        <div class="page-holder w-100 d-flex flex-wrap bg-gray">
            <div class="container-fluid mx-5 ">
                <section>
                    <div class="row mb-4">
                        <div class="col-lg-11 col-sm-11 mb-4 mb-lg-0">
                            <div class="admin-main bg-gray-100 shadow-lg" style="padding-top: 0">
                                <!--右侧-->
                                <div class="admin-content pl-4 pr-4 ">
                                    <div class="userInfo my-5">
                                        <div id="personalDate" class="my-5">
                                            <div class="personalupdate">
                                                <section class="py-5">
                                                    <div class="row">
                                                        <div class="col-lg-12 mt-3 mb-5 articleList">
                                                            <div href="#"
                                                                class="message mb-5 mt-2 card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                                                <div class="row">
                                                                    <div
                                                                        class="col-lg-7 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <strong class="h5 mb-0">4<sup
                                                                                class="smaller text-gray font-weight-normal">Sep</sup></strong>
                                                                        <h6 class="mb-0"><a href="../archives.html" class="articleTitle">测试</a></h6>
                                                                    </div>
                                                                    <div class="col-lg-5 pl-5 pt-5 d-flex align-items-center flex-column flex-lg-row text-center text-md-left ">
                                                                        <button type="button" class="btn btn-warning" style="margin-right: auto;margin-left: auto;">编辑</button>
                                                                        <button type="button" class="btn btn-danger"  style="margin-right: auto;margin-left: auto;">删除</button>
                                                                    </div>
                                                                    <div
                                                                        class="col-lg-7 pt-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <div
                                                                            class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode">
                                                                            2020-1-31 20:26</div>
                                                                       
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12 mb-5 mt-3 articleList">
                                                            <div href="#"
                                                                class="message mb-5 mt-2 card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                                                <div class="row">
                                                                    <div
                                                                        class="col-lg-7 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <strong class="h5 mb-0">4<sup
                                                                                class="smaller text-gray font-weight-normal">Sep</sup></strong>
                                                                        <h6 class="mb-0"><a href="#" class="articleTitle">测试</a></h6>
                                                                    </div>
                                                                    <div class="col-lg-5 pl-5 pt-5 d-flex align-items-center flex-column flex-lg-row text-center text-md-left ">
                                                                        <button type="button" class="btn btn-warning" style="margin-right: auto;margin-left: auto;">编辑</button>
                                                                        <button type="button" class="btn btn-danger"  style="margin-right: auto;margin-left: auto;">删除</button>
                                                                    </div>
                                                                    <div
                                                                        class="col-lg-7 pt-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <div
                                                                            class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode">
                                                                            2020-1-31 20:26</div>
                                                                       
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12 mt-3 mb-5 articleList">
                                                            <div href="#"
                                                                class="message mb-5  mt-2 card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                                                <div class="row">
                                                                    <div
                                                                        class="col-lg-7 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <strong class="h5 mb-0">4<sup
                                                                                class="smaller text-gray font-weight-normal">Sep</sup></strong>
                                                                        <h6 class="mb-0"><a href="#" class="articleTitle">测试</a></h6>
                                                                    </div>
                                                                    <div class="col-lg-5 pl-5 pt-5 d-flex align-items-center flex-column flex-lg-row text-center text-md-left ">
                                                                        <button type="button" class="btn btn-warning" style="margin-right: auto;margin-left: auto;">编辑</button>
                                                                        <button type="button" class="btn btn-danger"  style="margin-right: auto;margin-left: auto;">删除</button>
                                                                    </div>
                                                                    <div
                                                                        class="col-lg-7 pt-1 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <div
                                                                            class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode">
                                                                            2020-1-31 20:26</div>
                                                                       
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12 mt-3 articleList">
                                                            <div href="#"
                                                                class="message mb-5 mt-2 card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                                                <div class="row">
                                                                    <div
                                                                        class="col-lg-7 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <strong class="h5 mb-0">4<sup
                                                                                class="smaller text-gray font-weight-normal">Sep</sup></strong>
                                                                        <h6 class="mb-0"><a href="#" class="articleTitle">测试</a></h6>
                                                                    </div>
                                                                    <div class="col-lg-5 pl-5 pt-5 d-flex align-items-center flex-column flex-lg-row text-center text-md-left ">
                                                                        <button type="button" class="btn btn-warning" style="margin-right: auto;margin-left: auto;">编辑</button>
                                                                        <button type="button" class="btn btn-danger"  style="margin-right: auto;margin-left: auto;">删除</button>
                                                                    </div>
                                                                    <div
                                                                        class="col-lg-7 pt-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                                                        <div
                                                                            class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode">
                                                                            2020-1-31 20:26</div>
                                                                       
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                   <div class="col-lg-12 mt-5 my-4"> <button type="button" class="btn btn-info">加载更多</button></div>
                                                </section>
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