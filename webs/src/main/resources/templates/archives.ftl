<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="https://www.baidu.com">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">

<#--css-->
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/amazeUI/amazeui.min.css ">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/amazeUI/app.css">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/archives.css">

<#--js-->
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sroll.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/index.js"></script>
    <title>Weleness|归档</title>
</head>

<body>

<div class="am-container .am-scrollable-vertical">
<#list archive_List as archive>
    <div class="am-g am-g-fixed blog-content">
        <!-- 响应式，适应中小屏幕  和bootstrap一个道理 -->
        <div class="am-u-sm-12 am-u-md-9">
            <div class="timeline-year">
                <h1>${archive}年</h1>
                <hr>
                <ul>
                    <#list article_List as article>
                        <#if article.a_year == archive>
                        <li>
                            <div class="am-u-md-12 am-u-sm-12 timeline-row-marjor">
                                <!-- each-blcok  am-comment-main-->
                                <div class="content  am-animation-slide-top animation-element slide-top testimonial">
                                    <header class="am-comment-hd" style="background: #fff;">
                                        <div class="contentTittle am-comment-meta">
                                            <a href="#">${article.a_Title}</a>
                                        </div>
                                    </header>

                                    <div class="am-comment-bd">
                                        <i class="am-icon-calendar">
                                            <a href="#">${article.a_createTime}</a>
                                        </i>
                                        <i class="am-icon-folder">
                                            <a href="#">${article.category.categoryname}</a>
                                        </i>

                                        <i class="am-comment-bd-tags am-icon-tag">
                                            <#list article.tags as tag>
                                                <a href="showArtilceByTag?tag=${tag.tag_id}">${tag.tag_name?cap_first}</a>
                                        <#sep >
                                        ,
                                            </#list>
                                        </i>
                                    </div>
                                </div>
                        </li>
                        </#if>
                    </#list>
                </ul>
            </div>
        </div>

    </div>
</#list>
</div>


</body>
</html>