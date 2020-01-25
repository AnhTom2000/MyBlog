<!DOCTYPE html>
<html  lang="zh-EN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">

    <title>Weleness | 登陆</title>

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

</head>

<body>

<section class="signin popup-in">
    <div class="container">
        <div class="sign-content popup-in-content">
            <div class="popup-in-txt">
                <h2>登陆</h2>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">
                            <form action="signin.html">
                                <div class="form-group">
                                    <label for="username">用户名</label>
                                    <input type="text" class="form-control" id="username" placeholder="请输入用户名">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                                </div><!--/.form-group -->
                            </form><!--/form -->
                        </div><!--/.signin-form -->
                    </div><!--/.col -->
                </div><!--/.row -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-password">
                            <div class="password-circle">
                                <div class="single-password-circle">
                                    <input type="radio" id="radio01" name="radio">
                                    <label for="radio01">
													<span class="round-boarder">
														<span class="round-boarder1"></span>
													</span>记住密码(请在私人计算机上使用此功能)
                                    </label>
                                </div><!--/.single-password-circle-->
                                <div class="single-forgot-password-circle text-right
										">
                                    <a href="signin.html">忘记密码？</a>
                                </div><!--/.single-password-circle-->
                            </div><!--/.password-circle-->
                        </div><!--/.signin-password -->
                    </div><!--/.col -->
                </div><!--/.row -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-footer">
                            <button type="button" id="login" class="btn signin_btn signin_btn_two" data-toggle="modal" data-target=".signin_modal">
                                登陆
                            </button>
                            <div class="c3-2 clearfix">
                                <div class="text-center">
                                    <hr style="display: inline-flex; border: 0.48px solid gray;width: 120px;"> <span style="color: gray;">更多登陆方式</span> <hr style="display: inline-flex; border: 0.48px solid gray;width: 120px;">
                                </div>
                                <div class="c3-2-1 col-md-12   text-center" style="margin-top: 20px;">
											<span style="margin-right: 20px;display: inline-block">
											<a href="" title="使用腾讯QQ登录" ><span
                                                    class="s1"><svg t="1578110514715" class="icon" viewBox="0 0 1024 1024"
                                                                    version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3965" width="30"
                                                                    height="30">
														<path
                                                                d="M798.523 684.701c8.215-10.903 10.822-35.444 9.961-52.295-4.651-64.079-47.657-117.761-72.514-145.534 3.455-8.076 11.852-54.84-20.573-86.752 0.057-0.76 0.057-1.518 0.057-2.26 0-125.865-89.587-216.458-202.005-216.876-112.426 0.418-202.006 91.011-202.006 216.876 0 0.742-0.013 1.5 0.039 2.26-32.419 31.906-24.01 78.672-20.574 86.752-24.838 27.773-67.849 81.455-72.506 145.534-0.842 16.851 1.759 41.392 9.992 52.295 10.029 13.295 37.55-2.67 57.238-45.157 5.479 19.68 18.116 49.732 46.714 87.878-47.859 10.922-61.516 58.124-45.418 83.937 11.359 18.18 37.368 33.14 82.171 33.14 79.728 0 114.937-21.421 130.651-36.349 3.201-3.253 7.821-4.821 13.705-4.834 5.879 0.013 10.506 1.581 13.696 4.834 15.712 14.928 50.928 36.349 130.636 36.349 44.828 0 70.811-14.961 82.164-33.14 16.111-25.813 2.463-73.021-45.392-83.937 28.604-38.152 41.24-68.198 46.714-87.878 19.694 42.487 47.208 58.452 57.25 45.157zM956.81 195.359l2.69 633.278c0 70.646-57.693 130.863-130.864 130.863H195.359C124.717 959.5 64.5 901.808 64.5 828.637V195.359c0-70.641 57.526-130.858 130.859-130.858h630.587c70.647 0 130.864 57.692 130.864 130.858z"
                                                                fill="#68A5E1" p-id="3966"></path>
													</svg></spa></a>
												</span>

                                    <span style="display: inline-block;margin-left: 10px;margin-right: 20px;">
											<a href="javascript: void(0)" id="github" title="使用GItHub登录" ><span
                                                    class="s3"><svg t="1578110593530" class="icon" viewBox="0 0 1024 1024"
                                                                    version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7220" width="30"
                                                                    height="30">
														<path
                                                                d="M0 520.886c0-69.368 13.51-135.697 40.498-199.02 26.987-63.323 63.322-117.826 109.006-163.51 45.65-45.65 100.154-81.985 163.51-109.006A502.289 502.289 0 0 1 512 8.92c69.335 0 135.663 13.477 198.986 40.497 63.356 26.988 117.86 63.323 163.51 109.007 45.684 45.65 82.02 100.154 109.006 163.51A502.289 502.289 0 0 1 1024 520.852c0 111.318-32.504 211.472-97.511 300.494-64.975 88.989-148.48 150.825-250.484 185.476-5.351 0-9.348-0.99-11.99-2.973-2.676-1.982-4.196-3.997-4.526-6.012a59.458 59.458 0 0 1-0.495-8.984 7.663 7.663 0 0 1-0.991-3.006v-128.99c0-40.63-14.336-75.314-43.008-103.986 76.667-13.345 134.011-41.819 171.999-85.487 37.987-43.669 57.013-96.52 57.013-158.522 0-58.005-18.663-108.346-56.022-150.99 13.345-42.678 11-87.668-6.97-135.003-18.697-1.322-39.011 1.85-61.01 9.513-22 7.663-38.318 14.831-49.02 21.47-10.637 6.673-20.316 13.016-28.97 19.027-38.68-10.669-81.854-16.02-129.486-16.02-47.7 0-90.509 5.351-128.529 16.02-7.333-5.35-15.855-11.164-25.5-17.507-9.68-6.342-26.493-14.005-50.507-22.99-23.982-9.018-45.65-12.85-65.008-11.495-18.663 47.996-20.645 93.646-5.979 136.984-36.665 42.678-54.998 92.986-54.998 150.99 0 62.002 18.663 114.689 55.99 157.994 37.326 43.339 94.67 72.01 171.998 86.016a142.303 142.303 0 0 0-39.969 70.029c-56.683 13.972-96.355 3.963-119.015-30.06-42.017-61.308-79.674-83.307-113.003-65.965-4.69 4.657-3.997 9.48 1.982 14.501 6.012 4.988 14.996 11.66 27.02 19.985 11.99 8.357 20.976 17.507 26.987 27.515 0.661 1.322 2.51 6.177 5.517 14.502a831.917 831.917 0 0 0 8.985 23.981c2.973 7.663 8.654 16.186 17.011 25.5 8.324 9.349 18.003 17.178 29.003 23.52 11 6.309 26.161 11 45.485 14.006 19.324 2.972 41.323 3.138 65.998 0.495v100.484c0 0.991-0.165 2.643-0.495 5.021-0.33 2.312-0.991 3.964-1.982 4.955-0.991 1.024-2.345 2.015-4.03 3.039a12.52 12.52 0 0 1-6.474 1.486c-2.676 0-6.012-0.33-10.009-0.99-101.343-35.345-183.825-97.182-247.51-185.51C31.842 731.037 0 631.577 0 520.92z"
                                                                fill="#0085a1" p-id="7221"></path>
													</svg></span></a>
												</span>

                                </div>
                            </div>
                            <p>
                                还没有账号？
                                <a href="/register">点击注册</a>
                            </p>
                        </div><!--/.signin-footer -->
                    </div><!--/.col -->
                </div><!--/.row -->
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

<script type="text/javascript" src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/login.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/toastr.min.js"></script>

<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/login.js"></script>
</body>

</html>