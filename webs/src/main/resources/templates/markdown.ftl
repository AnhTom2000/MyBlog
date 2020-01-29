<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 响应式meta标签 -->
    <!--优先使用webkit内核渲染-->
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--不要被百度转码-->
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">
    <title>创作</title>
<#setting number_format="#">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js "></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/editormd.js "></script>
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/amazeUI/amazeui.min.css">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/amazeUI/amazeui.min.js "></script>
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/editormd.preview.css">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/editormd.min.css">


    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/mark.css">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/markdown.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/write.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/jquery.tagsinput.js "></script>

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/jquery.tagsinput.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>
</head>

<body>
<div class="am-container am-text-truncate">

    <div class="am-navbar am-navbar-default am-show-sm-only" data-am-widget="navbar">
        <ul class="am-navbar-nav">
            <li>
                <a href="/">
                    <span class="am-icon-home"></span>
                    <span class="am-navbar-label">首页</span>
                </a>
            </li>
            <li>
                <a href="/archives">
                    <span class="am-icon-server"></span>
                    <span class="am-navbar-label">归档</span>
                </a>
            </li>
            <li>
                <a href="/rich">
                    <span class="am-icon-modx"></span>
                    <span class="am-navbar-label">富文本编辑器</span>
                </a>
            </li>
            <li data-am-navbar-share>
                <a href="/">
                    <span class="am-icon-angellist"></span>
                    <span class="am-navbar-label">返回</span>
                </a>
            </li>
        </ul>
    </div>


    <!-- z-index是越大的在上面 -->
    <div class="am-input-group   am-u-md-7  am-u-sm-7 am-u-lg-7 am-u-sm-offset-1 am-u-md-offset-1">
        <input type="text" class="am-form-field" id="articleTitle" placeholder="请输入文章标题">
        <span class="counts"><span id="count">0/100</span></span>
    </div>
    <div class="am-u-md-1  am-u-sm-3 am-u-lg-1 " style="margin-top: 20px; "> <button type="button"
                                                                                     class="am-btn am-btn-default am-round am-btn am-btn-success"
                                                                                     data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400, height: 600}">发布文章</button>
    </div>
    <div class="am-u-md-3 am-u-sm-3 am-u-lg-3 am-u-sm-offset-1 am-u-md-offset-1" style="margin-top: 20px">
        <div class="am-btn-group am-hide-sm-only">
            <button class="am-btn am-btn-secondary "> <i class="am-icon-cog"></i> &nbsp;离开</button>
            <div class="am-dropdown" data-am-dropdown>
                <button class="am-btn am-btn-secondary am-dropdown-toggle" data-am-dropdown-toggle> <span
                        class="am-icon-caret-down"></span></button>
                <ul class="am-dropdown-content">
                    <li class="am-dropdown-header">选择方式</li>
                    <li class="am-divider"></li>
                    <li class="am-active"><a href="/">首页</a></li>
                    <li class="am-divider"></li>
                    <li class="am-divider"></li>
                    <li><a href="/archives">归档</a></li>
                    <li class="am-divider"></li>
                    <li><a href="/rich">富文本编辑</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div>
        <div class="editormd" id="test-editormd">
            <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc" id="content"></textarea>
            <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
            <textarea class="editormd-html-textarea" name="text" id="htmlContent"></textarea>
        </div>
    </div>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">发布文章
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <form action="#" class="am-form" id="doc-vld-msg">
                <div class="am-modal-bd">
                    <div class="am-form-group">
                        <div>
                            <label for="doc-vld-name-2" id="new"
                                   style="display: inline; font-size: 15px;">新建标签：</label><span
                                style="margin-left: 20px;"></span>
                            <span><i><svg t="1578712024362" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                          xmlns="http://www.w3.org/2000/svg" p-id="4513" width="15" height="15">
                                            <path
                                                    d="M855.45984 544.1024H572.416v283.01312a49.94048 49.94048 0 0 1-99.88096 0V544.1024H189.55264a49.95072 49.95072 0 1 1 0-99.8912h283.01312V161.19808a49.94048 49.94048 0 1 1 99.88096 0V444.2112h283.01312a49.95072 49.95072 0 1 1 0 99.8912z"
                                                    fill="" p-id="4514"></path>
                                        </svg></i></span><input name="tags" id="newtags"
                                                                style="display: inline-block;height: 50px; width:50px;" placeholder="新建标签">
                        </div>
                        <div class="form-content">
                            <label for="doc-vld-name-2"
                                   style="display: inline; font-size: 15px;margin-right: 20px;">历史标签：</label>
                            <div class="am-dropdown" data-am-dropdown="{justify: '#doc-dropdown-justify'}">

                                <button class="am-btn am-btn-success am-dropdown-toggle" style="width: 113px;"
                                        data-am-dropdown-toggle>
                                    请选择
                                    <span class="am-icon-caret-down"></span></button> <br>
                                <ul class="am-dropdown-content tag_list" id="tag_List">
                                    <li class="am-dropdown-header">历史标签</li>
                                    <#list tag_List as tag>
                                    <li  id="${tag.tag_id}"><a href="javascript: void(0)">${tag.tag_name}</a></li>
                                    </#list>
                                </ul>

                            </div>
                            <input name="tags" readonly="readonly" id="tags"
                                   style="display: inline-block;height: 50px; width:50px;" />
                        </div>
                        <div class="form-content">
                            <label for="doc-vld-name-2"
                                   style="display: inline; font-size: 15px;margin-right: 20px;">文章类型：</label>
                            <div class="am-dropdown" data-am-dropdown="{justify: '#doc-dropdown-justify'}">
                                <button class="am-btn am-btn-success am-dropdown-toggle" style="width: 113px;"
                                        data-am-dropdown-toggle>请选择
                                    <span class="am-icon-caret-down"></span></button>
                                <ul class="am-dropdown-content category_list" id="cates">
                                    <li class="am-dropdown-header">全部类型</li>
                                    <li id="1"><a href="javascript: void(0)" >原创</a></li>
                                    <li id="2"><a href="javascript: void(0)" >转载</a></li>
                                    <li id="3"><a href="javascript: void(0)" >翻译</a></li>
                                </ul>

                            </div>

                        </div>
                        <input name="tags" readonly="readonly" id="categorys"
                               style="display: inline-block;height: 50px; width:50px;" />
                    </div>
                </div>
                <div class="am-modal-bd  foot" style="margin-top: 30px;">
                    <button class="am-btn am-btn-default am-round " data-am-modal-close type="button"
                            role="button">取消</button> <button class="am-btn am-btn-primary am-round" type="button"
                                                              id="btn-submit" role="button">发布</button>
                </div>
            </form>

        </div>
    </div>

</div>
</body>

</html>