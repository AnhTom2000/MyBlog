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


    <div class="d-flex align-items-stretch">
        <div id="sidebar" class="sidebar py-3">
            <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">个人中心
            </div>
            <ul class="sidebar-menu list-unstyled">
                <li class="sidebar-list-item py-3 mr-3"><a href="userEdit.ftl" class="sidebar-link text-muted active"><i
                            class="zi zi_usercog" zico="用户设置"></i><span>个人设置</span></a></li>
                <li class="sidebar-list-item py-3"><a href="articles.ftl" class="sidebar-link text-muted"><i
                            class="o-sales-up-1 mr-3 text-gray"></i><span>文章列表</span></a></li>
                <li class="sidebar-list-item py-3"><a href="article_archive.ftl" class="sidebar-link text-muted"><i
                            class="o-table-content-1 mr-3 text-gray"></i><span>文章归档</span></a></li>
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
                                                            src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%A4%B4%E5%83%8F%20.jpg" />
                                                    </div>
                                                    <div class="headChange">
                                                        <div class="headPortraitChange">
                                                            <input id="imgTest" type="file" onchange="imgChange(event)"
                                                                accept=".gif,.jpg,.jpeg,.png">
                                                            <a>更改头像</a>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="personalDateForm">
                                                    <form id="personalDateForm">
                                                        <div class="userNameTable">
                                                            <label for="username">用户名:</label>
                                                            <input class="formInput" type="text" id="username"
                                                                placeholder="用户名">
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="birthdayTable">
                                                            <label for="age">年龄:</label>
                                                            <input class="formInput" type="text" id="age"
                                                                placeholder="年龄" />
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="phoneTable">
                                                            <label for="phone">手机:</label>
                                                            <input class="formInput" type="text" id="phone"
                                                                placeholder="填写你的手机">
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="genderTable">
                                                            <label>性别:</label>
                                                            <label class="am-radio-inline" style="width: 60px">
                                                                <input class="formInput" type="radio" id="male"
                                                                    name="gender" value="male" data-am-ucheck>
                                                                <span class="am-icon-male "><i class="zi zi_male"
                                                                        zico="男性"></i></span>
                                                            </label>
                                                            <label class="am-radio-inline" style="width: 60px">
                                                                <input class="formInput" type="radio" id="female"
                                                                    name="gender" value="female" data-am-ucheck>
                                                                <span class="am-icon-female "><i class="zi zi_female"
                                                                        zico="女性"></i></span>
                                                            </label>
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="emailTable">
                                                            <label for="email">邮箱:</label>
                                                            <input class="formInput" type="email" id="email"
                                                                placeholder="填写你的邮箱">
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="trueNameTable">
                                                            <label for="trueName">地区:</label>
                                                            <input class="formInput" type="text" id="area"
                                                                placeholder="地区">
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <div class="trueNameTable">
                                                            <label for="trueName">职业:</label>
                                                            <input class="formInput" type="text" id="profession"
                                                                placeholder="职业">
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>

                                                        <div class="personalBriefTable">
                                                            <label for="personalBrief">个人简介:</label><br>
                                                            <textarea class="formInput" id="personalBrief"
                                                                placeholder="填写你的个人简介"></textarea>
                                                            <hr data-am-widget="divider" style=""
                                                                class="am-divider am-divider-default" />
                                                        </div>
                                                        <button type="button" id="savePersonalDateBtn"
                                                            class="btn btn-success">保存操作</button>

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
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/user.js"></script>
</body>

</html>