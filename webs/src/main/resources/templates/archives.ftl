<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Access-Control-Allow-Origin" content="https://www.baidu.com">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/amazeUI/amazeui.min.css    ">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/amazeUI/app.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">

    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/archives.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/index.js"></script>
    <title>Weleness|归档</title>
</head>

<body>
<div class="am-container .am-scrollable-vertical">
    <div class="am-g am-g-fixed blog-content">

    <div class="am-u-sm-12 am-u-md-9">
            <#list article_List as artilce>

                <div class="timeline-year">
                    <h1>${artilce.a_year}</h1>
                    <hr>
                    <ul>
                        <h3>${artilce.a_month}月</h3>
                        <hr>
                        <div class="am-u-md-12 am-u-sm-12 timeline-row-marjor">
                            <!-- each-blcok  am-comment-main-->
                            <div class="content  am-animation-slide-top animation-element slide-top testimonial">
                                <header class="am-comment-hd" style="background: #fff;">
                                    <div class="contentTittle am-comment-meta">
                                        <a href="#">${artilce.a_name}</a>
                                    </div>
                                </header>

                                <div class="am-comment-bd">
                                    <i class="am-icon-calendar">
                                        <a href="#">${artilce.a_createTime}</a>
                                    </i>
                                    <i class="am-comment-bd-tags am-icon-tag">
                                   <#list artilce.tag as tag><a
                                           href="/showArticle?tag_id=${tag.tag_id}">${tag.tag_name}</a></#list>
                                        ,
                                        <a href="#">原创</a>
                                    </i>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
            </#list>
        <div class="am-u-md-12 am-u-sm-12  am-center" style="margin: 0 auto;">
            <ul class="am-pagination">
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">下一页&raquo;</a></li>
            </ul>

        </div>
    </div>


</div>

</div>


</body>

<script src="js/sroll.js"></script>

</html>