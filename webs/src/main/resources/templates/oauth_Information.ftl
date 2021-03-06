<!DOCTYPE html>
<html  lang="zh-EN">

<head>
    <!-- meta data -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--font-family-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">
<#setting number_format="#">
    <!-- title of site -->
    <title>完善信息</title>

    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">

    <!--font-awesome.min.css-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/font-awesome.min.css">


    <!--animate.css-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/animate.css">

    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/bootstrap.min.css">

    <!-- bootsnav -->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/bootsnav.css" >

    <!--style.css-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/style.css">

    <!--responsive.css-->
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/responsive.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">
    <link rel="stylesheet" href="/static/css/NZ-Loading.min.css">

    <link rel="stylesheet" href="/static/css/shCoreRDark.css">
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/logo/%E4%B8%8B%E8%BD%BD.png">
</head>

<body>

<section class="signin signup popup-in pop-up">
    <div class="container">

        <div class="sign-content popup-in-content">
            <div class="popup-in-txt">
                <h2>完善信息</h2>

                <div class="signin-form">
                    <div class=" ">
                        <div class=" ">
                            <form action="/oauth/information/complete">
                                <div class="form-group">
                                    <label for="username">用户名</label>
                                    <input type="text" class="form-control" id="username" placeholder="请输入唯一的用户名">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="email">email</label>
                                    <input type="email" class="form-control" id="email" placeholder="请输入你的邮箱">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="checkCode">验证码</label>
                                    <input type="email" class="form-control" id="checkCode" placeholder="请输入验证码"><button class="btn btn-primary" type="button" id="getCode">点击获取验证码</button>
                                </div><!--/.form-group -->
                            </form><!--/form -->
                        </div><!--/.col -->
                    </div><!--/.row -->

                </div><!--/.signin-form -->
                <div class="signin-footer">
                    <button type="button" id="complete" class="btn signin_btn signin_btn_two">
                        完成注册
                    </button>
                </div><!--/.signin-footer -->
            </div><!-- .popup-in-txt -->
        </div><!--/.sign-content -->
    </div><!--/.container -->

</section><!--/.signin -->

<!-- signin end -->

<!--footer copyright start -->
<footer class="footer-copyright">
    <div id="scroll-Top">
        <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
    </div><!--/.scroll-Top-->

</footer><!--/.hm-footer-copyright-->
<!--footer copyright  end -->


<!-- Include all js compiled plugins (below), or include individual files as needed -->

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>

<!--modernizr.min.js-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/js/modernizr.min.js"></script>

<!--bootstrap.min.js-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/js/bootstrap.min.js"></script>

<!-- bootsnav js -->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/js/bootsnav.js"></script>

<!-- jquery.sticky.js -->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/js/jquery.sticky.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>


<!--Custom JS-->
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/js/custom.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>

<script src="/static/js/NZ-Loading.min.js"></script>
<script src="/static/js/shCore.js"></script>
<script src="/static/js/shBrushJScript.js"></script>

<script src="/static/js/userInfoComplete.js"></script>
</body>

</html>