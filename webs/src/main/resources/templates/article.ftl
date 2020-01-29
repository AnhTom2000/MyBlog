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

    <link rel="stylesheet" href="http://ico.z01.com/zico.min.css">

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

<#setting number_format="#">
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
                                    <div class="article-info article-info-type badge badge-success">
                                    ${article_info.category.categoryname}
                                    </div>
                                    <div class="article-info article-info-publishDate">
                                        <i class="zi zi_calendar" zico="日历"><a class="articleCategoryColor"
                                                                       href="/archives?archive=' + data.publishDate + '">  ${article_info.a_year}
                                            -${article_info.a_month} </a></i>
                                    </div>
                                    <div class="article-info article-info-originalAuthor">
                                        <i class="zi zi_usergraduate" zico="用户学历"> Weleness</i>
                                    </div>
                                    <div class="article-info article-info-categories">
                                        <i class="zi zi_folders" zico="文件夹">
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
                            <i class="zi zi_tmGratipay">&nbsp;&nbsp;喜欢</i>
                        </div>
                        <div class="likesNum">
                            <span>  ${article_info.a_likeNums} </span>
                        </div>
                    </div>

                    <div class="comment">
                        <div class="comment-top">
                            <#if user??>
                            <div class="comment-top-input">
                                <textarea id="comment" placeholder="来说两句吧..."></textarea>
                            </div>
                                <div class="commentBtn" id="${article_info.a_id}" >
                                    <button id="commentBtn" type="button" class="btn btn-primary">发表评论</button>
                                </div>
                           <#else >
                            <div class="comment-top-input">
                                <div class="goToLogin">
                                        &nbsp;&nbsp;&nbsp;<a id="toLogin" href="javascript: void(0)" >登录</a>后才可以发表评论呦...
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
<footer class="row">
    <div class="others col-md-12 text-center">
        <div class="row">
            <div class="col-md-4">
                <h3>微信公众号</h3>
                <hr/>
                <div class="others-blcok friendLink others-block">
                    <a href="#" target="_blank">暂无</a>
                </div>
            </div>
            <div class="col-md-4 friendLink">
                <h3>友链</h3>
                <hr/>
                <a href="http://www.hxsail.com/" target="_blank">风华</a>
                <br/>
                <a href="https://blog.csdn.net/WXZCYQ" target="_blank">我的csdn博客</a>
            </div>
            <div class="col-md-4">
                <h3>反馈</h3>
                <hr/>
                <button class="btn btn-default">...</button>
            </div>
        </div>
    </div>
    <div class="company-info col-md-12 bg-dark">
        <p class="text-secondary text-center">Copy@Weleness 版权所有
            &nbsp;|&nbsp;粤ICP备19143953号-1&nbsp;|&nbsp;粤ICP备19143953号-1</p>
    </div>
</footer>


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