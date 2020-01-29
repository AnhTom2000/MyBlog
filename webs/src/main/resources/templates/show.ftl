<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title th:text="${articleTitle}"></title>
    <meta name="description" th:content="${articleTabloid}">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="keywords" content="博客,个人,学习,IT,生活,张海洋,程序猿,springboot,java,后端">

    <link rel="icon" type="image/x-icon" href="https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/static/img/favicon.ico">
    <link rel="stylesheet" href="css/editormd/editormd.preview.min.css"/>
    <link href="https://lib.baomitu.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/all.css">
    <link rel="stylesheet" href="css/editormd/editormd.min.css" />
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/show.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/comment.css">
    <link href="https://lib.baomitu.com/font-awesome/5.8.0/css/fontawesome.min.css" rel="stylesheet">
    <link href="https://lib.baomitu.com/lightgallery/1.6.12/css/lightgallery.min.css" rel="stylesheet">

    <script src="https://lib.baomitu.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://lib.baomitu.com/underscore.js/1.9.1/underscore-min.js"></script>
    <script src="https://lib.baomitu.com/modernizr/2010.07.06dev/modernizr.min.js"></script>
    <script src="https://lib.baomitu.com/amazeui/2.7.2/js/amazeui.ie8polyfill.min.js"></script>
    <script src="https://lib.baomitu.com/amazeui/2.7.2/js/amazeui.min.js"></script>
    <script src="js/editormd/editormd.js" charset="utf-8"></script>
    <script src="lib/marked.min.js"></script>
    <script src="https://lib.baomitu.com/prettify/r298/prettify.min.js"></script>
    <script src="https://lib.baomitu.com/raphael/2.2.7/raphael.min.js"></script>

    <script src="https://lib.baomitu.com/js-sequence-diagrams/1.0.6/sequence-diagram-min.js"></script>
    <script src="https://lib.baomitu.com/flowchart/1.11.3/flowchart.min.js"></script>
<#setting number_format="#">
</head>
<body>
<div id="app">
    <!--引入共有头部-->
    <div th:replace="header :: header"></div>
    <!--页面主体-->
    <div id="main">
        <div class="am-container">
            <div class="am-g">
                <div class="am-u-sm-12 am-u-lg-12">
                    <div class="content">
                        <div class="article">
                            <div class="zhy-article-top">
                                <div style="height: 500px">

                                </div>
                            </div>
                            <div class="article-content">
                                <div id="wordsView">
                                    <textarea style="display:none;" name="editormd-markdown-doc" id="mdText"></textarea>
                                </div>
                            </div>
                            <div class="zhy-article-footer">
                            </div>
                            <div class="other">

                            </div>
                        </div>

                        <div class="comment">
                            <div class="comment-top">
                                <div class="comment-top-input" th:if="${#httpServletRequest.remoteUser}">
                                    <textarea id="comment" placeholder="客官，来说两句吧..."></textarea>
                                </div>
                                <div class="comment-top-input" th:unless="${#httpServletRequest.remoteUser}">
                                    <div class="goToLogin">
                                        &nbsp;&nbsp;&nbsp;<a id="toLogin">登录</a>后才可以发表评论呦...
                                    </div>
                                </div>
                                <div class="commentBtn">
                                    <button id="commentBtn" type="button" class="am-btn am-btn-secondary">发表评论</button>
                                </div>
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
                        总访问量 <span id="totalVisitors"><strong></strong></span> 次  您是本文第 <span id="visitorVolume"><strong></strong></span> 位童鞋
                    </div>
                    <div class="webLogo" style="font-size: 15px;">
                        <a href="http://beian.miit.gov.cn" target="_blank">
                            蜀ICP备18000229号
                        </a>
                    </div>
                    <div class="webLogo" style="font-size: 15px;">
                        <img src="https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/static/img/webLog.png">
                        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51011402000164" target="_blank">
                            川公网安备 51011402000164号
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div id="sidebar_toggle" class="sidebar_toggle" data-am-offcanvas="{target: '#offCanvas'}">
            <div class="sidebar_toggle_line_wrap">
                <span class="sidebar-toggle-line sidebar-toggle-line-first" style="width: 100%; top: 0; transform: rotateZ(0deg); opacity: 1; left:0"></span>
                <span class="sidebar-toggle-line sidebar-toggle-line-middle" style="width: 100%; opacity: 1; left: 0; top: 0; transform: rotateZ(0deg);"></span>
                <span class="sidebar-toggle-line sidebar-toggle-line-last" style="width: 100%; top: 0; transform: rotateZ(0deg); opacity: 1; left: 0;"></span>
            </div>
        </div>
        <div id="offCanvas" class="am-offcanvas">
            <div class="am-offcanvas-bar am-offcanvas-bar-flip">
                <div class="am-offcanvas-content">
                    <div class="sidebar-inner">
                        <div class="site-overview">
                            <div class="img-author" style="text-align: center">
                                <p style="font-size: large;font-family: 仿宋">微信公众号</p>
                                <div id="weixin">
                                    <img class="weixinPublic" src="">
                                </div>
                                <div class="author-name">
                                    张海洋
                                </div>
                                <div class="author-words">
                                    <p>专注于Spring,SpringBoot等后端技术探索</p>
                                    <p>以及MySql,Oracle数据库开发和SSM,SSH等后端流行框架学习</p>
                                </div>

                            </div>
                            <div class="site-state" style="opacity: 1; display: block; transform: translateX(0px);">
                                <div class="site-state-item learn-posts">
                                    <a href="/archives">
                                        <span class="archivesNum site-state-item-count"></span>
                                        <span class="site-state-item-name">日志</span>
                                    </a>
                                </div>
                                <div class="site-state-item learn-categories">
                                    <a id="site-state-item-a" href="/categories">
                                        <span class="categoriesNum site-state-item-count"></span>
                                        <span class="site-state-item-name">分类</span>
                                    </a>
                                </div>
                                <div class="site-state-item learn-tags">
                                    <a href="/tags">
                                        <span class="tagsNum site-state-item-count"></span>
                                        <span class="site-state-item-name">标签</span>
                                    </a>
                                </div>
                            </div>
                            <div class="contact-way">
                                <span><i class="am-icon-qq">&nbsp;&nbsp;1125694337</i></span>
                                <span><i class="am-icon-wechat">&nbsp;&nbsp;zhy1125694337</i></span>
                            </div>
                            <div class="rss">
                                <div class="rss-site">
                                    <a class="rss-site-a" href="/rss">
                                        <i class="am-icon-rss"> RSS</i>
                                    </a>
                                </div>
                            </div>
                            <div class="author-words">
                                <p>本人目前本科生在读</p>
                                <p>由于水平有限，希望大家多多支持</p>
                                <p>有不足之处也希望各位前辈指出</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
            <a id="toTop"  href="#top">
            <span title="到顶部" style="color: white">
                <i class="am-icon-arrow-up"></i>
            </span>
            </a>
        </div>
    </div>
    <!--消息盒子+反馈-->
    <div th:replace="other :: other"></div>
</div>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/all.js"></script>
<script src="js/show.js"></script>
<script src="js/comment.js"></script>

</body>
</html>