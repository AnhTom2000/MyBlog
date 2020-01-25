<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <#setting number_format="#">
    <title th:text="${article_info.a_Title}">${article_info.a_Title}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/editormd.min.css"/>
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/all.css">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/editormd.min.css"/>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/show.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/comment.css">

    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">

    <link href="https://lib.baomitu.com/lightgallery/1.6.12/css/lightgallery.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/style.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/underscore.min.js"></script>

    <script src="https://lib.baomitu.com/modernizr/2010.07.06dev/modernizr.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/flowchart.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/marked.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/prettify.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/raphael.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/sequence-diagram.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/lib/jquery.flowchart.min.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/editormd.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/style.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">

</head>
<style>
    .${isLike}{
    background-color: #EA6F5A;
    color: white;
    }
</style>
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
                                <form class=" from-inline" style="display: inline-flex;" role="search">
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
    </nav>
</div>

<!--页面主体-->
<div id="main">
    <div class="container">
        <div class="row">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="content">
                    <div class="article">
                        <div class="article-top">
                            <div style="height: 200px">
                                <div class="article-title">

                                    <h1> ${article_info.a_Title} </h1>
                                </div>
                                <div class="article-info row">
                                    <div class="article-info article-info-type am-badge am-badge-success">
                                    ${article_info.category.categoryname}
                                    </div>
                                    <div class="article-info article-info-publishDate">
                                        <i class="am-icon-calendar"><a class="articleCategoryColor"
                                                                       href="/archives?archive=' + data.publishDate + '">  ${article_info.a_year}
                                            -${article_info.a_month} </a></i>
                                    </div>
                                    <div class="article-info article-info-originalAuthor">
                                        <i class="am-icon-user"> Weleness</i>
                                    </div>
                                    <div class="article-info article-info-categories">
                                        <i class="am-icon-folder">
                                                <#list article_info.tags as tag>
                                                    <a class="articleCategoryColor"
                                                       href="/categories?category=' + data.articleCategories ">${tag.tag_name}</a>
                                                </#list></i>
                                    </div>
                                </div>
                                <div class="article-i-say">
                                    多年以后，愿你的城市，有清风，有烈酒，也有人是你的归途。<span class="article-i-say-me"></span>
                                </div>
                            </div>
                        </div>
                        <div class="article-content">
                            <div id="wordsView">
                                    <textarea style="display:none;" name="editormd-markdown-doc" id="mdText">
                                    ${article_info.a_text}
                                    </textarea>
                            </div>
                        </div>
                        <div class="article-footer">
                        </div>
                        <div class="other">
                            <div class="end-logo">
                                <i ><svg t="1579956846249" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7338" width="60" height="60"><path d="M550.4 102.4c-249.6 0-448 198.4-448 448 0 249.6 198.4 448 448 448 249.6 0 448-198.4 448-448C998.4 300.8 800 102.4 550.4 102.4zM307.2 358.4l224 0C524.8 345.6 512 332.8 499.2 313.6 512 307.2 524.8 294.4 544 288 563.2 313.6 576 332.8 588.8 358.4l211.2 0c0 19.2-6.4 38.4-6.4 57.6 0 19.2 0 32 6.4 51.2l-51.2 0L748.8 396.8 358.4 396.8l0 70.4L307.2 467.2c0-19.2 0-38.4 0-57.6S307.2 371.2 307.2 358.4zM697.6 454.4l0 44.8c-25.6 0-51.2 0-83.2 0L480 499.2c-25.6 0-57.6 0-83.2 0L396.8 454.4c25.6 0 57.6 0 83.2 0l140.8 0C646.4 454.4 672 454.4 697.6 454.4zM780.8 780.8c-12.8 12.8-25.6 19.2-38.4 19.2L633.6 800c-32 0-44.8-12.8-44.8-44.8L588.8 595.2 505.6 595.2c0 38.4-6.4 70.4-19.2 96-12.8 32-32 57.6-64 76.8-32 25.6-57.6 38.4-89.6 51.2-12.8-12.8-25.6-25.6-38.4-38.4C332.8 768 364.8 755.2 384 742.4s38.4-32 51.2-51.2C441.6 665.6 448 640 454.4 595.2L384 595.2c-32 0-64 0-83.2 0L300.8 556.8c25.6 0 51.2 0 83.2 0l345.6 0c25.6 0 57.6 0 83.2 0l0 44.8c-25.6 0-51.2 0-83.2 0L633.6 601.6l0 140.8c0 12.8 6.4 19.2 19.2 19.2 12.8 0 25.6 0 44.8 0 19.2 0 38.4 0 44.8-6.4 6.4-6.4 12.8-19.2 19.2-51.2 19.2 12.8 38.4 19.2 57.6 19.2C800 748.8 793.6 768 780.8 780.8z" p-id="7339" fill="#6fc00b"></path></svg></i>
                            </div>
                            <div>
                                <ul class="post-copyright">
                                    <li><strong>本文作者：</strong><span id="authorFooter">  Weleness</span></li>
                                    <li><strong>版权声明：</strong> 本博客所有文章除特别声明外，均采用<span id="copyRightFooter"><a
                                            href="https://creativecommons.org/licenses/by/3.0/cn/" target="_blank"> CC BY 3.0 CN协议</a></span>进行许可。转载请署名作者且注明文章出处。
                                    </li>
                                </ul>
                            </div>
                            <hr>
                        </div>
                    </div>
                    <div class="likeBtn am-btn am-btn-danger ${isLike}" id="${article_info.a_id}">
                        <div class="likeHeart ${heart}" id="heart">
                            <i class="am-icon-heart-o"><svg t="1579955277984" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6592" width="30" height="30"><path d="M523.733 841.024l33.174-32.576 99.69-97.813c70.976-69.632 120.32-117.974 138.71-135.894 59.008-57.514 93.248-121.28 99.626-184.234 6.251-61.44-15.488-119.744-61.589-164.672-44.992-43.84-98.88-61.91-157.035-52.907-49.365 7.616-101.034 34.624-150.016 78.848a21.333 21.333 0 0 1-28.586 0c-48.982-44.224-100.651-71.232-150.016-78.87-58.155-8.96-112.043 9.089-157.035 52.929-46.101 44.928-67.84 103.21-61.61 164.693 6.4 62.933 40.64 126.72 99.647 184.213a100207.573 100207.573 0 0 1 145.92 142.827l24.256 23.765L512 852.523l11.733-11.499zM512 852.544l-1.493 1.43a2.133 2.133 0 0 1 1.493-0.64c0.512 0 1.045 0.213 1.493 0.64L512 852.522z m157.781-721.792c71.638-11.093 138.902 11.477 193.344 64.533 55.318 53.931 81.835 124.992 74.283 199.531-7.467 73.643-46.55 146.368-112.32 210.475-18.347 17.898-67.67 66.218-138.453 135.637-31.83 31.232-65.707 64.448-99.84 97.984L553.6 871.467l-13.184 12.949a40.555 40.555 0 0 1-56.832 0l-114.603-112.64-24.213-23.723a677626.347 677626.347 0 0 0-145.856-142.762C133.142 541.184 94.08 468.48 86.613 394.816c-7.552-74.539 18.944-145.6 74.283-199.53 54.443-53.057 121.707-75.606 193.344-64.534 53.163 8.213 107.093 34.688 157.781 76.95 50.71-42.24 104.619-68.737 157.782-76.95z" p-id="6593"></path></svg>&nbsp;&nbsp;喜欢</i>
                        </div>
                        <div class="likesNum">
                            <span>  ${article_info.a_likeNums} </span>
                        </div>
                    </div>

                    <div class="comment">
                        <div class="comment-top">
                            <#if user??>
                            <div class="comment-top-input">
                                <textarea id="comment" placeholder="客官，来说两句吧..."></textarea>
                            </div>
                                <div class="commentBtn" id="${article_info.a_id}" >
                                    <button id="commentBtn" type="button" class="btn btn-primary">发表评论</button>
                                </div>
                           <#else >
                            <div class="comment-top-input">
                                <div class="goToLogin">
                                    &nbsp;&nbsp;&nbsp;<a id="toLogin" >登录</a>后才可以发表评论呦...
                                </div>
                            </div>
                            </#if>
                        </div>
                        <div class="comment-bottom">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部中含有该页面的单独访客量，不应使用共有底部-->
<div class="footer">
    <div class="footer am-u-sm-centered">
        <div class="am-vertical-align" style="text-align: center">
            <hr>
            <div class="am-vertical-align-bottom">
                <div style="color: #009688;font-size: 15px;">
                    &copy; 2018-2019 程序猿张先森 - <i class="am-icon-coffee" style="margin: 0 5px"></i>张海洋 版权所有
                </div>
                <div id="footer" style="color: #009688;font-size: 15px;">
                    总访问量 <span id="totalVisitors"><strong></strong></span> 次 您是本文第 <span
                        id="visitorVolume"><strong></strong></span> 位童鞋
                </div>
                <div class="webLogo" style="font-size: 15px;">
                    <a href="http://beian.miit.gov.cn" target="_blank">
                        蜀ICP备18000229号
                    </a>
                </div>
                <div class="webLogo" style="font-size: 15px;">
                    <img src="https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/static/img/webLog.png">
                    <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51011402000164"
                       target="_blank">
                        川公网安备 51011402000164号
                    </a>
                </div>
            </div>
        </div>
    </div>


</div>


<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/show.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/comment.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var wordsView;
        wordsView = editormd.markdownToHTML("wordsView", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });

    })
</script>
</body>
</html>