<!DOCTYPE html>
<html lang="zh-EN">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- 响应式meta标签 -->
  <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link
    href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext"
    rel="stylesheet">

  <title>NO BUG后台管理系统| 登陆</title>
  <link rel="shortcut icon"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/img/favicon.png">

  <link rel="stylesheet"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/font-awesome.min.css">


  <link rel="stylesheet"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/animate.css">


  <link rel="stylesheet"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/bootstrap.min.css">


  <link rel="stylesheet"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/bootsnav.css">


  <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/style.css">


  <link rel="stylesheet"
    href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/assets/css/responsive.css">

  <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/css/toastr.css">

</head>

<body>

  <section class="signin popup-in">
    <div class="container">
      <div class="sign-content popup-in-content">
        <div class="popup-in-txt">
          <h2 class="text-center">欢迎登陆<em>NoBug</em>后台管理系统</h2>

          <div class="row">
            <div class="col-sm-12">
              <div class="signin-form">
                <form action="signin.html">
                  <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" placeholder="请输入用户名">

                    <div class="form-group">
                      <label for="password">密码</label>
                      <input type="password" class="form-control" id="password" placeholder="请输入密码">
                    </div>
                </form>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-12">
              <div class="signin-footer">
                <button type="button" id="login" class="btn signin_btn signin_btn_two" data-toggle="modal"
                  data-target=".signin_modal">
                  登陆
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Modal -->
  <div class="modal fade"  id="check" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
              <div class="modal-header" style="margin-bottom: 20px">
                  <div class="modal-title" style="margin-left: 30px" id="exampleModalLongTitle">输入邮箱验证码</div>
                  <button type="button" class="close" data-dismiss="modal" id="cancel"  aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
              </div>
              <div class="modal-body" style="margin-bottom: 30px">
                  <input type="text" style="width: 500px; margin-right: auto; margin-left: auto" class="form-control" id="checkCode" placeholder="请输入验证码">
                  <span id="error" style="display: none; color: red; font-family: 宋体;">验证码错误</span>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-primary" id="confirm">确定</button>
              </div>
          </div>
      </div>
  </div>


  <footer class="footer-copyright">
    <div id="scroll-Top">
      <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title=""
        data-original-title="Back to Top" aria-hidden="true"></i>
    </div>
  </footer>





  <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>

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

  <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/admin/js/admins/js/adminLogin.js"></script>
</body>

</html>