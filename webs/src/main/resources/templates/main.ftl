<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 跨域请求页面 -->
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 响应式meta标签 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.min.css ">
    <link rel="stylesheet"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/bootstrap/bootstrap.css">

    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/style.css">
    <!-- 站点图标 -->
    <link rel="shortcut icon"
          href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/20170730104929_y5Fi2.thumb.700_0.jpeg">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/index.css">
    <link rel="stylesheet" href="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/css/blogs/css/main.css">
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/jQuery/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/sticky-sidebar-master/dist/sticky-sidebar.js"></script>
    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/js/index.js"></script>

    <script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sidebar.js"></script>
    <title>Weleness的博客</title>
</head>

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
                    <a href="/markdown" style="text-decoration: none" target="_blank">
                        <span class="write-word fonts nav-link">写博客</span>

                    </a>
                </div>
                <#if user??>
                <div class=" navbar-nav justify-content-center ">
                    <div class=" navbar-nav justify-content-center ">
                        <div class="end" >
                            <button  id="exit" type="button"  class="btn btn-primary btn-sm active rounded btn-block ">退出登录</button>
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
    <div class="row ">
        <div class=" d-sm-block d-sm-none d-md-block  ml-3 shadow-lg p-2 mb-1 bg-white col-sm-9 col-lg-9 col-md-9">
            <div class="container">
                <div class="row align-items-center">
                    <div><svg t="1578299382807" class="icon" viewBox="0 0 1024 1024" version="1.1"
                              xmlns="http://www.w3.org/2000/svg" p-id="6233" width="20" height="20">
                        <path
                                d="M686.592 333.312c-19.968-19.968-51.712-19.968-71.68 0-19.968 19.968-19.968 51.712 0 71.68 59.392 59.392 59.392 155.136 0 214.528-19.968 19.968-19.968 51.712 0 71.68 19.968 19.968 51.712 19.968 71.68 0 98.816-99.328 98.816-259.584 0-357.888z m0 0M481.792 147.456L266.24 309.76H131.072c-37.376 0-67.584 29.696-67.584 67.072v270.848c0 36.352 30.208 67.072 67.584 67.072H266.24l216.064 161.792c30.208 22.528 53.76 10.24 53.76-27.136V175.104c0-36.864-24.576-49.664-54.272-27.648z m0 0"
                                fill="#f4ea2a" p-id="6234"></path>
                        <path
                                d="M829.44 189.952c-19.968-19.968-51.712-19.968-71.68 0-19.968 19.968-19.968 51.712 0 71.68 138.24 138.24 138.24 362.496 0 500.736-19.968 19.968-19.968 51.712 0 71.68 19.968 19.968 51.712 19.968 71.68 0 177.664-178.176 177.664-466.432 0-644.096z m0 0"
                                fill="#f4ea2a" p-id="6235"></path>
                    </svg></div>
                    <div id="carouselExampleControls " class="carousel slide col-sm-11 d-inline d-print-table-row"
                         data-ride="carousel" data-pause="hover" data-interval="3000" aria-hidden="true">
                        <div class="carousel-inner ">
                            <ul class="caption">
                                <li class="carousel-item active">
                                    愿你有前进一寸的勇气，亦有后退一尺的从容。
                                </li>
                                <li class="carousel-item">
                                    只有在梦想中，人才能真正自由。从来如此也将永远如此。
                                </li>
                                <li class="carousel-item">
                                    那些刻在椅子后的爱情，会不会像水泥上的花朵，开出没有风的，寂寞的森林。
                                </li>
                                <li class="carousel-item">
                                    告诉自己，明天会更好
                                </li>
                                <li class="carousel-item">
                                    天才在于勤奋，聪明在于积累
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content -->
    <main class="row " id="mains">
        <div class="col-md-3  d-none d-sm-none d-xd-none d-md-none d-md-none d-sm-none d-md-block  sidebar " id="sidebar">
            <div
                    class="base-info  content-blcok profile-block shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial sidebar__inner" >
                <div class="container mt-4 pt-1 " style="width: 330px; height: 590px">
                    <div class="row  mt-4  pt-2" width="273" height="136.5">
                        <div class="col-md-5 media erweima" width="140" height="140"
                             data-target="#exampleModalCenter" data-toggle="modal">
                            <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%A4%B4%E5%83%8F%20.jpg"
                                 alt="头像" title="头像" class=" align-self-start erweima" width="150.5" height="140.5">
                        </div>

                        <div class="col-md-7 mySelf mt-4 text-center text-md ">
                            <div>
                                <small style="width: 78px;height: 18px;">普通的大学生</small>
                            </div>
                            <div>
                                <small style="width: 78px;height: 18px;">不懈的学习者</small>
                            </div>
                            <div>
                                <small style="width: 78px;height: 18px;">狂热的技术宅</small>
                            </div>
                        </div>
                        <div class="col-md-12 col-sm-5 mt-4">
                            <h2 id="name" class="text-center">Welneess</h2>
                            <h3 id="title" class="text-center">Explorers&developers</h3>
                        </div>
                        <div class="col-md-12 mt-2 text-center " id="location">
                                <span><i class="fa fa-map-marker" aria-hidden="true">
                                        From : <svg t="1577985987188" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                                    xmlns="http://www.w3.org/2000/svg" p-id="6037" width="35" height="27">
                                            <path
                                                    d="M954.368 718.848c-4.096-7.168-11.264-11.264-21.504-11.264H672.768c-9.216 17.408-19.456 35.84-28.672 57.344-22.528 44.032-46.08 90.112-68.608 130.048l-2.048 2.048c-13.312 22.528-35.84 37.888-63.488 37.888s-51.2-15.36-63.488-37.888c-7.168-15.36-34.816-64.512-68.608-132.096l-28.672-57.344H210.944c-9.216 0-17.408 6.144-21.504 13.312L69.632 972.8c-4.096 7.168-4.096 15.36 2.048 22.528 4.096 8.192 11.264 12.288 20.48 12.288h721.92c9.216 0 17.408-6.144 21.504-13.312l120.832-251.904c1.024-8.192 1.024-15.36-2.048-23.552zM513.024 16.384C365.568 16.384 245.76 137.216 245.76 283.648c0 90.112 97.28 300.032 177.152 459.776C460.8 820.224 491.52 873.472 491.52 875.52c4.096 7.168 11.264 13.312 21.504 13.312 9.216 0 17.408-6.144 21.504-13.312 0 0 30.72-55.296 68.608-132.096C683.008 583.68 780.288 373.76 780.288 283.648c0-146.432-120.832-267.264-267.264-267.264z m0 430.08c-66.56 0-121.856-51.2-130.048-118.784v-13.312c0-72.704 59.392-130.048 130.048-130.048 66.56 0 123.904 51.2 130.048 116.736v13.312c0 72.704-57.344 132.096-130.048 132.096z"
                                                    fill="#BABABA" p-id="6038"></path>
                                        </svg>广东
                                    </i>
                                </span>
                        </div>
                        <!-- Button trigger modal -->
                        <div class="text-center col-md-12 mt-4 col-sm-5">
                            <button type="button" class="btn btn-primary rounded" data-toggle="modal"
                                    data-target="#exampleModalLong">
                                点击关注我吧
                            </button>
                            <div class="row mt-4"
                                 style="border-top: lightgray solid 1px; border-bottom: lightgray 1px solid ; border-left: solid 1px lightgray; ">
                                <div class="article-info-block col-md-6 text-center"
                                     style="border-right:  lightgray solid 1px; border-left:  lightgray solid 1px; height: 80px; ">
                                    <div class="mt-4 mb-4 " style="color: gray;font-size: 20px;">
                                      ${article_count}
                                    </div>
                                    <div class="mb-4 " style="color: gray;font-size: 20px;font-family: 微软雅黑;">
                                        <span>文章</span>
                                    </div>
                                </div>
                                <div class="article-info-block col-md-6 text-center "
                                     style="border-right:  gray solid 1px; border-left: lightgray solid 1px;">
                                    <div class="mt-4 mb-4 " style="color: gray;font-size: 20px;font-family: 微软雅黑;">
                                       ${tag_count}
                                    </div>
                                    <div class="mb-4 "  style="color: gray;font-size: 20px;">
                                        <span>标签</span>
                                    </div>
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-4 col-sm-1">
                                    <a href="#" target="_blank">
                                        <svg t="1577991899026" class="icon" viewBox="0 0 1252 1024" version="1.1"
                                             xmlns="http://www.w3.org/2000/svg" p-id="9183" width="30" height="30">
                                            <path
                                                    d="M846.769231 311.138462c15.753846 0 27.569231 0 43.323077 3.938461-39.384615-177.230769-228.430769-311.138462-445.046154-311.138461C200.861538 3.938462 3.938462 169.353846 3.938462 382.030769c0 122.092308 66.953846 220.553846 177.230769 299.323077l-43.323077 133.907692 153.6-78.76923c55.138462 11.815385 98.461538 23.630769 153.6 23.630769h43.323077c-7.876923-31.507692-11.815385-59.076923-11.815385-94.523077-7.876923-196.923077 161.476923-354.461538 370.215385-354.461538z m-236.307693-122.092308c31.507692 0 55.138462 23.630769 55.138462 55.138461 0 31.507692-23.630769 55.138462-55.138462 55.138462-31.507692 0-66.953846-23.630769-66.953846-55.138462 0-31.507692 31.507692-55.138462 66.953846-55.138461zM299.323077 299.323077c-31.507692 0-66.953846-23.630769-66.953846-55.138462 0-31.507692 31.507692-55.138462 66.953846-55.138461 31.507692 0 55.138462 23.630769 55.138461 55.138461 0 35.446154-23.630769 55.138462-55.138461 55.138462z m953.107692 358.4c0-177.230769-177.230769-322.953846-374.153846-322.953846-212.676923 0-378.092308 145.723077-378.092308 322.953846 0 177.230769 165.415385 322.953846 378.092308 322.953846 43.323077 0 86.646154-11.815385 133.907692-23.630769l122.092308 66.953846-31.507692-110.276923c82.707692-66.953846 149.661538-157.538462 149.661538-256z m-500.184615-59.076923c-23.630769 0-43.323077-23.630769-43.323077-43.323077 0-23.630769 23.630769-43.323077 43.323077-43.323077 35.446154 0 55.138462 23.630769 55.138461 43.323077 0 23.630769-19.692308 43.323077-55.138461 43.323077z m244.184615 0c-23.630769 0-43.323077-23.630769-43.323077-43.323077 0-23.630769 23.630769-43.323077 43.323077-43.323077 31.507692 0 55.138462 23.630769 55.138462 43.323077 0 23.630769-23.630769 43.323077-55.138462 43.323077z"
                                                    fill="#67C213" p-id="9184"></path>
                                        </svg>
                                    </a>
                                </div>
                                <div class="col-md-4 col-sm-1">
                                    <a href="https://github.com/AnhTom2000" target="_blank">
                                        <svg t="1577992015430" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                             xmlns="http://www.w3.org/2000/svg" p-id="9904" width="30" height="30">
                                            <path
                                                    d="M0 520.886c0-69.368 13.51-135.697 40.498-199.02 26.987-63.323 63.322-117.826 109.006-163.51 45.65-45.65 100.154-81.985 163.51-109.006A502.289 502.289 0 0 1 512 8.92c69.335 0 135.663 13.477 198.986 40.497 63.356 26.988 117.86 63.323 163.51 109.007 45.684 45.65 82.02 100.154 109.006 163.51A502.289 502.289 0 0 1 1024 520.852c0 111.318-32.504 211.472-97.511 300.494-64.975 88.989-148.48 150.825-250.484 185.476-5.351 0-9.348-0.99-11.99-2.973-2.676-1.982-4.196-3.997-4.526-6.012a59.458 59.458 0 0 1-0.495-8.984 7.663 7.663 0 0 1-0.991-3.006v-128.99c0-40.63-14.336-75.314-43.008-103.986 76.667-13.345 134.011-41.819 171.999-85.487 37.987-43.669 57.013-96.52 57.013-158.522 0-58.005-18.663-108.346-56.022-150.99 13.345-42.678 11-87.668-6.97-135.003-18.697-1.322-39.011 1.85-61.01 9.513-22 7.663-38.318 14.831-49.02 21.47-10.637 6.673-20.316 13.016-28.97 19.027-38.68-10.669-81.854-16.02-129.486-16.02-47.7 0-90.509 5.351-128.529 16.02-7.333-5.35-15.855-11.164-25.5-17.507-9.68-6.342-26.493-14.005-50.507-22.99-23.982-9.018-45.65-12.85-65.008-11.495-18.663 47.996-20.645 93.646-5.979 136.984-36.665 42.678-54.998 92.986-54.998 150.99 0 62.002 18.663 114.689 55.99 157.994 37.326 43.339 94.67 72.01 171.998 86.016a142.303 142.303 0 0 0-39.969 70.029c-56.683 13.972-96.355 3.963-119.015-30.06-42.017-61.308-79.674-83.307-113.003-65.965-4.69 4.657-3.997 9.48 1.982 14.501 6.012 4.988 14.996 11.66 27.02 19.985 11.99 8.357 20.976 17.507 26.987 27.515 0.661 1.322 2.51 6.177 5.517 14.502a831.917 831.917 0 0 0 8.985 23.981c2.973 7.663 8.654 16.186 17.011 25.5 8.324 9.349 18.003 17.178 29.003 23.52 11 6.309 26.161 11 45.485 14.006 19.324 2.972 41.323 3.138 65.998 0.495v100.484c0 0.991-0.165 2.643-0.495 5.021-0.33 2.312-0.991 3.964-1.982 4.955-0.991 1.024-2.345 2.015-4.03 3.039a12.52 12.52 0 0 1-6.474 1.486c-2.676 0-6.012-0.33-10.009-0.99-101.343-35.345-183.825-97.182-247.51-185.51C31.842 731.037 0 631.577 0 520.92z"
                                                    fill="#0085a1" p-id="9905"></path>
                                        </svg>
                                    </a>

                                </div>
                                <div class="col-md-4 col-sm-1">
                                    <a href="https://blog.csdn.net/WXZCYQ" target="_blank">
                                        <svg t="1577992035520" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                             xmlns="http://www.w3.org/2000/svg" p-id="10659" width="30" height="30">
                                            <path
                                                    d="M906.475693 943.728792c-49.491181 17.325597-152.164608 28.913517-295.537993 28.913517-412.545894 0-635.223462-193.912431-608.80579-450.249611C33.545364 216.96445 363.386627 45.025473 724.595296 45.025473c139.829675 0 222.1301 11.388375 299.383578 30.263258l-24.720008 205.822692c-51.434439-17.35118-171.688267-33.208333-269.12032-33.208333-212.388225 0-392.96493 63.425541-413.440264 263.878946-18.429745 179.328271 108.114346 265.024026 347.120812 265.024026 83.251076 0 205.89944-11.884678 262.580371-29.214369L906.475693 943.728792z"
                                                    fill="#d81e06" p-id="10660"></path>
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- Modal -->

                    </div>

                </div>

            </div>
            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <div class="container ">
                    <div class="row" style="width: 300px; height: 30px;">
                        <div class="mr-2 mt-2" style="border-right: 1px solid lightgrey; width: 30px;">
                            <svg t="1578000567375" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="1093" width="20" height="20">
                                <path
                                        d="M138.2 511.3c0-206 167-373.1 373.1-373.1 206 0 373.1 167 373.1 373.1 0 206-167 373.1-373.1 373.1-206 0-373.1-167.1-373.1-373.1zM511.3 63.6C264 63.6 63.6 264 63.6 511.3 63.6 758.6 264.1 959 511.3 959 758.6 959 959 758.6 959 511.3c0-247.2-200.4-447.7-447.7-447.7zM474 324.8c0-20.6 16.7-37.3 37.3-37.3s37.3 16.7 37.3 37.3c0 20.6-16.7 37.3-37.3 37.3S474 345.4 474 324.8z m37.3 410.4c20.6 0 37.3-16.7 37.3-37.3V474c0-20.6-16.7-37.3-37.3-37.3S474 453.4 474 474v223.9c0 20.6 16.7 37.3 37.3 37.3z"
                                        p-id="1094"></path>
                            </svg>
                        </div>
                        <strong style="font-size: 20px;"> 网站信息</strong>
                    </div>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>文章总数 :</span> <span>10篇</span>
                    </div>

                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>标签总数 :</span> <span>10个</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>留言总数 :</span> <span>13条</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>

                    </div>
                    <div class="col-5 mt-0 messgaes">
                        <span>评论总数 :</span> <span>2条</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>
                    </div>
                    <div class="col-9 mt-0 messgaes">
                        <span>网站最后更新 :</span> <span id="lastUpdate"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 ml-1 mb-2">
                        <i><svg t="1578001506720" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="1209" width="20" height="20">
                            <path
                                    d="M697.5 928.5H157.2c-64.6 0-117.1-52.5-117.1-117.1V206.2c0-64.6 52.5-117.1 117.1-117.1h540.2c64.6 0 117.1 52.5 117.1 117.1v6.3c0 11-9 20-20 20s-20-9-20-20v-6.3c0-42.5-34.6-77.1-77.1-77.1H157.2c-42.5 0-77.1 34.6-77.1 77.1v605.1c0 42.5 34.6 77.1 77.1 77.1h540.2c42.5 0 77.1-34.6 77.1-77.1v-27.2c0-11 9-20 20-20s20 9 20 20v27.2c0.1 64.6-52.5 117.2-117 117.2z"
                                    fill="#1C1C1C" p-id="1210"></path>
                            <path
                                    d="M189.5 582.7V729h-14.2V582.7h14.2zM323.7 580.8v146.9h-14.8l-74.2-118.1c0 39 0.2 78.3 0.2 117.3h-14.4V580.2h12.3l76.5 121.9c0-40.4 0.2-80.8 0.2-121.3h14.2zM435.2 595.6h-44.4c-13.5 0-22.7 9.8-22.5 27.1v24.2h68.1V661h-68.1v67.3h-14.2V622.7c-0.2-26.5 14.6-41.3 36.7-41.3h44.4v14.2zM560.1 608.6c4.6 12.3 7.1 29.4 7.1 46.9 0 16.7-2.3 33.5-7.5 46.7l0.2-0.2c-8.5 22.1-29.8 29.2-50 28.5-21-0.8-36.1-9.6-43.1-27.7-4.6-12.3-7.1-29.4-7.1-46.9 0-16.7 2.3-33.5 7.5-46.7l-0.2 0.2c8.6-22.1 30-29.2 50.2-28.5 20.8 0.8 35.8 9.5 42.9 27.7z m-79.8 6c-4.4 11-6.5 26-6.5 41.3 0 15.4 2.5 30.8 6.5 41.9 4.6 11.7 15.2 17.9 29.8 18.5 15 0.4 30.6-4.4 36.3-19.4 4.6-11.3 6.7-26.5 6.7-41.5 0-15.4-2.5-30.8-6.5-41.9-4.6-11.7-15.2-17.9-29.6-18.6-15.1-0.3-31.1 4.5-36.7 19.7zM727.6 526.8c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l242.3-281.1c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2L742.8 519.8c-4 4.6-9.5 7-15.2 7zM639.2 629.4c-4.6 0-9.3-1.6-13-4.9-8.4-7.2-9.3-19.8-2.1-28.2l48.9-56.7c7.2-8.4 19.8-9.3 28.2-2.1 8.4 7.2 9.3 19.8 2.1 28.2l-48.9 56.7c-4 4.6-9.6 7-15.2 7zM663.7 361H170.5c-11 0-20-9-20-20s9-20 20-20h493.2c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1211"></path>
                            <path
                                    d="M555.8 477.4H170.5c-11 0-20-9-20-20s9-20 20-20h385.3c11 0 20 9 20 20s-9 20-20 20z"
                                    fill="#1C1C1C" p-id="1212"></path>
                        </svg> </i>

                    </div>
                    <div class="col-9 mt-0 messgaes ">
                        <span>网站运行天数 :</span> <span id="RunTime"></span>
                    </div>
                </div>

            </div>
            <div class="modal fade " id="exampleModalLong" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">快快加入我吧</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="container">
                                <div class="mt-4 row">
                                    <div class="col-md-12">
                                        <blockquote class="blockquote">
                                            <p class="mb-0" style="color: gray;">
                                                在等待的日子里。刻苦读书，卑谦做人，养的深根，日后才能枝叶繁茂。</p>
                                        </blockquote>
                                    </div>
                                </div>
                                <div class="row mt-4 justify-content-md-center">
                                    <div class="mr-4"><svg t="1577987881589" class="icon" viewBox="0 0 1024 1024"
                                                           version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14333" width="20"
                                                           height="20">
                                        <path
                                                d="M819.2 279.04c-20.48-33.28-46.08-71.68-61.44-97.28 20.48-7.68 35.84-25.6 35.84-46.08V76.8c0-28.16-23.04-51.2-51.2-51.2H345.6c-28.16 0-51.2 23.04-51.2 51.2v58.88c0 20.48 12.8 35.84 28.16 46.08-46.08 46.08-130.56 135.68-135.68 181.76-2.56 23.04-15.36 197.12 5.12 225.28 2.56 2.56 5.12 5.12 5.12 10.24 17.92 25.6 51.2 76.8 112.64 61.44v243.2c0 66.56 28.16 99.84 87.04 99.84 56.32 0 87.04-51.2 87.04-99.84v-102.4c12.8 5.12 25.6 7.68 43.52 7.68 10.24 0 23.04-2.56 33.28-5.12 17.92-5.12 33.28-17.92 43.52-33.28 10.24 2.56 25.6 7.68 40.96 7.68 12.8 0 23.04-2.56 35.84-5.12 25.6-10.24 46.08-30.72 61.44-58.88h10.24c5.12 0 12.8 0 20.48-2.56 28.16-7.68 51.2-33.28 66.56-74.24 0-2.56 2.56-5.12 2.56-7.68 2.56-53.76 12.8-291.84-23.04-350.72z m-409.6-204.8c17.92 0 33.28 15.36 33.28 30.72 0 17.92-15.36 30.72-33.28 30.72-17.92 0-33.28-15.36-33.28-30.72 0-17.92 15.36-30.72 33.28-30.72z m381.44 542.72c-12.8 30.72-25.6 38.4-33.28 40.96-5.12 2.56-7.68 0-10.24 0v-128c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v158.72c-7.68 15.36-17.92 25.6-30.72 30.72-12.8 5.12-25.6 2.56-35.84 0v-145.92c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v135.68c-7.68 20.48-20.48 35.84-33.28 40.96-25.6 10.24-56.32-7.68-56.32-7.68H486.4v-153.6c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v312.32c0 12.8-7.68 48.64-35.84 48.64-23.04 0-35.84-2.56-35.84-48.64v-358.4c2.56-33.28 2.56-69.12 0-104.96 0-12.8-12.8-25.6-25.6-23.04-12.8 0-25.6 10.24-25.6 25.6v92.16c-2.56 38.4-7.68 69.12-15.36 76.8-20.48 5.12-33.28-7.68-56.32-40.96-2.56-2.56-2.56-5.12-5.12-7.68-7.68-23.04-5.12-145.92 0-192 5.12-30.72 89.6-122.88 145.92-179.2 2.56-2.56 2.56-5.12 5.12-5.12h309.76v2.56s46.08 69.12 76.8 117.76c23.04 33.28 23.04 199.68 17.92 312.32z"
                                                fill="#A0A0A0" p-id="14334"></path>
                                    </svg></div>
                                    <div class="mr-4"><svg t="1577987881589" class="icon" viewBox="0 0 1024 1024"
                                                           version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14333" width="20"
                                                           height="20">
                                        <path
                                                d="M819.2 279.04c-20.48-33.28-46.08-71.68-61.44-97.28 20.48-7.68 35.84-25.6 35.84-46.08V76.8c0-28.16-23.04-51.2-51.2-51.2H345.6c-28.16 0-51.2 23.04-51.2 51.2v58.88c0 20.48 12.8 35.84 28.16 46.08-46.08 46.08-130.56 135.68-135.68 181.76-2.56 23.04-15.36 197.12 5.12 225.28 2.56 2.56 5.12 5.12 5.12 10.24 17.92 25.6 51.2 76.8 112.64 61.44v243.2c0 66.56 28.16 99.84 87.04 99.84 56.32 0 87.04-51.2 87.04-99.84v-102.4c12.8 5.12 25.6 7.68 43.52 7.68 10.24 0 23.04-2.56 33.28-5.12 17.92-5.12 33.28-17.92 43.52-33.28 10.24 2.56 25.6 7.68 40.96 7.68 12.8 0 23.04-2.56 35.84-5.12 25.6-10.24 46.08-30.72 61.44-58.88h10.24c5.12 0 12.8 0 20.48-2.56 28.16-7.68 51.2-33.28 66.56-74.24 0-2.56 2.56-5.12 2.56-7.68 2.56-53.76 12.8-291.84-23.04-350.72z m-409.6-204.8c17.92 0 33.28 15.36 33.28 30.72 0 17.92-15.36 30.72-33.28 30.72-17.92 0-33.28-15.36-33.28-30.72 0-17.92 15.36-30.72 33.28-30.72z m381.44 542.72c-12.8 30.72-25.6 38.4-33.28 40.96-5.12 2.56-7.68 0-10.24 0v-128c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v158.72c-7.68 15.36-17.92 25.6-30.72 30.72-12.8 5.12-25.6 2.56-35.84 0v-145.92c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v135.68c-7.68 20.48-20.48 35.84-33.28 40.96-25.6 10.24-56.32-7.68-56.32-7.68H486.4v-153.6c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v312.32c0 12.8-7.68 48.64-35.84 48.64-23.04 0-35.84-2.56-35.84-48.64v-358.4c2.56-33.28 2.56-69.12 0-104.96 0-12.8-12.8-25.6-25.6-23.04-12.8 0-25.6 10.24-25.6 25.6v92.16c-2.56 38.4-7.68 69.12-15.36 76.8-20.48 5.12-33.28-7.68-56.32-40.96-2.56-2.56-2.56-5.12-5.12-7.68-7.68-23.04-5.12-145.92 0-192 5.12-30.72 89.6-122.88 145.92-179.2 2.56-2.56 2.56-5.12 5.12-5.12h309.76v2.56s46.08 69.12 76.8 117.76c23.04 33.28 23.04 199.68 17.92 312.32z"
                                                fill="#A0A0A0" p-id="14334"></path>
                                    </svg></div>
                                    <div class="mr-4"><svg t="1577987881589" class="icon" viewBox="0 0 1024 1024"
                                                           version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14333" width="20"
                                                           height="20">
                                        <path
                                                d="M819.2 279.04c-20.48-33.28-46.08-71.68-61.44-97.28 20.48-7.68 35.84-25.6 35.84-46.08V76.8c0-28.16-23.04-51.2-51.2-51.2H345.6c-28.16 0-51.2 23.04-51.2 51.2v58.88c0 20.48 12.8 35.84 28.16 46.08-46.08 46.08-130.56 135.68-135.68 181.76-2.56 23.04-15.36 197.12 5.12 225.28 2.56 2.56 5.12 5.12 5.12 10.24 17.92 25.6 51.2 76.8 112.64 61.44v243.2c0 66.56 28.16 99.84 87.04 99.84 56.32 0 87.04-51.2 87.04-99.84v-102.4c12.8 5.12 25.6 7.68 43.52 7.68 10.24 0 23.04-2.56 33.28-5.12 17.92-5.12 33.28-17.92 43.52-33.28 10.24 2.56 25.6 7.68 40.96 7.68 12.8 0 23.04-2.56 35.84-5.12 25.6-10.24 46.08-30.72 61.44-58.88h10.24c5.12 0 12.8 0 20.48-2.56 28.16-7.68 51.2-33.28 66.56-74.24 0-2.56 2.56-5.12 2.56-7.68 2.56-53.76 12.8-291.84-23.04-350.72z m-409.6-204.8c17.92 0 33.28 15.36 33.28 30.72 0 17.92-15.36 30.72-33.28 30.72-17.92 0-33.28-15.36-33.28-30.72 0-17.92 15.36-30.72 33.28-30.72z m381.44 542.72c-12.8 30.72-25.6 38.4-33.28 40.96-5.12 2.56-7.68 0-10.24 0v-128c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v158.72c-7.68 15.36-17.92 25.6-30.72 30.72-12.8 5.12-25.6 2.56-35.84 0v-145.92c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v135.68c-7.68 20.48-20.48 35.84-33.28 40.96-25.6 10.24-56.32-7.68-56.32-7.68H486.4v-153.6c0-12.8-10.24-25.6-25.6-25.6s-25.6 10.24-25.6 25.6v312.32c0 12.8-7.68 48.64-35.84 48.64-23.04 0-35.84-2.56-35.84-48.64v-358.4c2.56-33.28 2.56-69.12 0-104.96 0-12.8-12.8-25.6-25.6-23.04-12.8 0-25.6 10.24-25.6 25.6v92.16c-2.56 38.4-7.68 69.12-15.36 76.8-20.48 5.12-33.28-7.68-56.32-40.96-2.56-2.56-2.56-5.12-5.12-7.68-7.68-23.04-5.12-145.92 0-192 5.12-30.72 89.6-122.88 145.92-179.2 2.56-2.56 2.56-5.12 5.12-5.12h309.76v2.56s46.08 69.12 76.8 117.76c23.04 33.28 23.04 199.68 17.92 312.32z"
                                                fill="#A0A0A0" p-id="14334"></path>
                                    </svg></div>
                                </div>
                                <div class="row mt-4 justify-content-md-center">
                                    <div class="col-md-12 mr-3" style="border-bottom :dotted black;"
                                         style="width: 100px; ">
                                        <p style="font-family: 微软雅黑; color: goldenrod;">想交个朋友吗<br>
                                            那就快扫下面吧</p>
                                    </div>
                                </div>
                                <div class="justify-content-md-center text-center mr-2 mt-3">
                                    <p id="QQ">QQ</p>
                                </div>
                                <div class="row mt-4">
                                    <div class="col-md-12 justify-content-md-center img-thumbnail ">
                                        <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/b3eee5f3f8407e879140672b3138cf1.jpg"
                                             alt="" width="300px">
                                    </div>
                                </div>
                                <div class="justify-content-md-center mt-4">
                                    <p id="WeChat">WeChat</p>
                                </div>
                                <div class="justify-content-md-start mt-3">
                                    <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200102165354.jpg"
                                         alt="" width="450">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="justify-content-md-end">编写不易，不喜轻喷</div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div class="col-md-6 " id="show">
            <!-- each-blcok -->
            <#list article_List as article>
            <div class="content-blcok shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h1 class="mb-3 ml-4" ><a href="" target="_blank" class="articleTitle">${article.a_Title}</a></h1>
                <div class="second-div mb-4 text-center">
                        <span class="text-secondary"><svg t="1578578950975" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13365" width="18" height="18"><path d="M724.8 314.2c2.8 1.6 5.5 3.2 8.2 5.1l8.2 5.6 0.1 9.8c0.4 28.5-3 52.6-10.4 71.1-6.9 17-17.1 29.7-30.7 37.3-9.3 33.1-20.2 63.8-35.6 89.6-17.8 29.7-41.2 52.5-74.4 64.8-14.8 5.4-52.7 8-89.1 7.4-35.2-0.5-70.5-4-84.5-10.5-30.1-13.9-51.3-37.2-67.4-66.3-13.8-24.8-23.6-53.7-32.1-84.2-14.1-7.4-24.7-20-31.8-37.1-7.8-18.7-11.4-43.2-10.9-72.2l0.1-9.9 8.2-5.5c2.1-1.4 4.2-2.7 6.3-3.9-9.2-114.1-5.7-156.3 36.6-204.5 82.6-67.7 272-65.3 355.7-3.9 57 53.8 61 114.1 43.5 207.3zM551.3 644.1l1.2 26.1-15.5 25.6 21.6 141.8L647 647.5l134.7-4.6c69.6 65.8 114.2 220.8 103.2 321.9H134.2c1.9-88.8 18.2-240.4 106.6-317.6l121.7 1.1 114 188 21.4-140.6-15.5-25.5 1.2-26.1c29.5-1.6 38.2-1.6 67.7 0zM652 273.7c-53.5 10.5-133.2 19.6-196.2-15.8-24.2-13.6-59.7 14.3-88.7 11.4-9 17.8-15.7 37.3-19.6 58l-3.2 17.1-17.2-1.7c-3.2-0.3-6.5 0.1-10 1.3-1.6 0.5-3.1 1.1-4.7 1.9 0.5 19 3.1 34.7 8 46.5 4.3 10.4 10.4 17.1 18.2 19.6l10.1 3.1 2.8 10.1c8.4 31.3 17.9 60.8 31.2 84.8 12.3 22.3 28.1 40 50 50.1 9.2 4.2 38.4 6.6 69 7.1 32.5 0.5 64.9-1.3 75.6-5.2 24.1-8.9 41.4-26.1 54.9-48.6 14.5-24.2 24.8-54.9 33.8-88.6l2.6-9.6 9.6-3.3c7.6-2.7 13.5-9.6 17.6-20 4.7-11.7 7.3-27.2 7.7-45.8-1.4-0.7-2.8-1.3-4.2-1.7-3.4-1.1-6.6-1.7-9.7-1.5l-16.8 1.1-3.1-16.5c-3.8-19.2-9.7-37.2-17.7-53.8z m0 0" fill="#1890FF" p-id="13366"></path></svg>
                        </span><span
                        class="font-weight-bold text-info">Welneess</span> &nbsp;&nbsp; <span
                        class="text-secondary"><svg t="1578578791842" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6608" width="18" height="18"><path d="M829.44 95.232v66.56H712.704V95.232H311.296v66.56H194.56V95.232H61.44v183.296h901.12V95.232z" fill="#F44336" p-id="6609"></path><path d="M194.56 278.528H61.44v716.8h901.12v-716.8H311.296z" fill="#CFD8DC" p-id="6610"></path><path d="M194.56 28.672h116.736v133.12H194.56z m518.144 0H829.44v133.12H712.704z" fill="#E8E8E8" p-id="6611"></path><path d="M194.56 407.552h115.712V522.24H194.56V407.552z m173.056 0h115.712V522.24H367.616V407.552z m173.056 0h115.712V522.24H540.672V407.552z m173.056 0H829.44V522.24H713.728V407.552zM194.56 580.608h115.712V696.32H194.56V580.608z m173.056 0h115.712V696.32H367.616V580.608z m173.056 0h115.712V696.32H540.672V580.608z m173.056 0H829.44V696.32H713.728V580.608zM194.56 752.64h115.712v115.712H194.56V752.64z m173.056 0h115.712v115.712H367.616V752.64z m173.056 0h115.712v115.712H540.672V752.64z m173.056 0H829.44v115.712H713.728V752.64z" fill="#90A4AE" p-id="6612"></path></svg>
                           ${article.a_createTime}</span>&nbsp;&nbsp;<svg t="1578579077390" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14118" width="18" height="18 "><path d="M926.000524 338.592578 687.387008 107.195418c-43.826158-42.493813-114.802676-43.030026-159.351288-1.326205L71.441611 531.173688c-4.923126 4.585435-7.269567 10.885931-7.019881 17.117866-0.023536 0.416486-0.037862 0.835018-0.037862 1.257643l0 288.372803c0 61.457724 49.552579 111.124913 110.817921 111.124913l299.771411 0c5.968945 0 11.694343-2.407839 15.874549-6.67298L927.985738 495.519654C970.902176 451.640284 970.058972 381.306402 926.000524 338.592578zM303.350424 821.294298c-54.953589 0-99.510388-44.545542-99.510388-99.503225 0-54.956659 44.556798-99.503225 99.510388-99.503225 54.955636 0 99.511411 44.546565 99.511411 99.503225C402.860812 776.747733 358.305037 821.294298 303.350424 821.294298z" p-id="14119"></path></svg>
                    <#list article.tags as tag>
                        <span class="text-secondary  ">
                           <a href="/showTags?tag=${tag.tag_id}" class="showTags">${tag.tag_name?cap_first}</a></span>
                    <#sep >
                    ,
                </#list>
                </div>
                <p class="showSome lead text-sm-7 text-xd-7 mb-4">${article.a_text}
                </p>
                <span class="ml-2"><a><button class="btn btn-default red-button">阅读全文</button></a></span>
                <hr>
                <div class="text-right">
                    <span class="viewCount"><svg t="1578638337969" class="icon" viewBox="0 0 1152 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3948" width="20" height="20"><path d="M576 0C138.709333 0 0 512 0 512s132.693333 512 576 512C971.093333 1024 1152 512 1152 512S1043.413333 0 576 0z m0 877.269333A365.312 365.312 0 1 1 935.296 512a362.325333 362.325333 0 0 1-359.338667 365.269333zM775.04 512a199.082667 199.082667 0 1 1-199.082667-202.325333s38.4 132.565333 27.904 167.808a192.384 192.384 0 0 1 171.178667 34.517333z" p-id="3949" fill="#1296db"></path></svg> ${article.a_viewNums}
                    </span>&nbsp;
                    <span class="likeCount mr-4"><svg t="1578638384406" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4816" width="20" height="20"><path d="M512 1024C229.225412 1024 0 794.774588 0 512S229.225412 0 512 0s512 229.225412 512 512-229.225412 512-512 512z m138.059294-751.043765c-51.260235-8.764235-100.291765 14.215529-138.059294 45.266824-37.797647-31.051294-86.799059-54.031059-138.029176-45.296941-110.110118 18.853647-163.087059 134.264471-115.531295 239.796706 39.574588 87.792941 123.994353 166.068706 227.599059 225.370352L512 752.941176l25.961412-14.848c103.604706-59.331765 188.024471-137.577412 227.599059-225.370352 47.585882-105.532235-5.421176-220.943059-115.501177-239.766589z" fill="#FF5A5F" p-id="4817"></path></svg>
                        ${article.a_likeNums} </span>
                </div>
            </div>
            </#list>
        </div>
        <!-- content-right -->
        <div class="col-md-3 d-none d-sm-block d-sm-none d-md-block ">
            <div class="content-right shadow-lg p-2 mb-5  rounded animation-element slide-top testimonial backGround">
                <h4 style="font-weight: bold;">小黑板</h4>
                <hr>
                <p><i><svg t="1578641063134" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4288" width="35" height="35"><path d="M204.94336 788.48V524.93312c-1.13664-37.91872 4.42368-73.5232 16.67072-106.82368 12.2368-33.29024 29.40928-62.58688 51.61984-87.88992 22.14912-25.23136 48.64-46.19264 79.62624-62.8736 30.90432-16.61952 64.45056-27.26912 100.62848-31.82592v113.68448c-44.36992 14.92992-74.7008 37.00736-91.01312 66.31424-16.384 29.29664-24.50432 65.18784-24.50432 107.66336h115.5072V788.48h-248.5248z m365.73184 0V524.93312c-1.20832-37.91872 4.34176-73.5232 16.5888-106.82368 12.25728-33.28 29.4912-62.58688 51.63008-87.88992 22.13888-25.23136 48.71168-46.19264 79.616-62.8736 30.90432-16.61952 64.512-27.26912 100.68992-31.82592v113.68448c-44.35968 14.92992-74.7008 37.00736-91.00288 66.31424-16.384 29.29664-24.50432 65.18784-24.50432 107.66336H819.2V788.48H570.6752z" fill="#454553" p-id="4289"></path></svg></i></p>
                <div class="text-center ">
                    <p>初次写个人博客</p>

                    <p>我只想写点自己的所见所得 </p>

                    <p>对本网站有什么意见、建议。欢迎联系我</p>

                    <p>小弟，虚心听从各位大佬的指点</p>

                    <p>你不嫌弃就好</p>

                </div>
                <div class="text-right"><i><svg t="1578641646928" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4693" width="30" height="30"><path d="M932.619 90.125v362.083c1.539 52.097-5.973 101.018-22.532 146.762s-39.771 85.992-69.815 120.761c-29.947 34.665-65.771 63.46-107.664 86.382-41.797 22.823-87.151 37.461-136.072 43.718v-156.196c59.992-20.512 101.018-50.843 123.071-91.099 22.15-40.256 33.124-89.558 33.124-147.914h-156.19v-364.491h336.077zM428.499 90.125v362.083c1.638 52.097-5.875 101.018-22.435 146.761-16.566 45.743-39.867 85.992-69.815 120.761-29.947 34.665-65.868 63.46-107.664 86.382-41.797 22.823-87.248 37.461-136.168 43.718v-156.196c59.993-20.512 101.018-50.843 123.071-91.099 22.15-40.256 33.124-89.558 33.124-147.914h-156.196v-364.491h336.082z" p-id="4694"></path></svg></i></div>
                <div class="text-center mt-3" style="font-family: 仿宋; font-weight: bold;">
                    ------   Welcome to myBlog!   ------
                </div>
            </div>
            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h4 style="font-weight: bold;" >最新文章</h4>
                <hr>
                <#list article_new_List as article><a href="/showArticle?article_id=${article.a_id}">${article.a_Title}</a></#list>
            </div>
            <div class="content-right shadow-lg p-2 mb-5 bg-white rounded animation-element slide-top testimonial">
                <h4 style="font-weight: bold;" >留言区</h4>
                <hr>
                <button class="btn btn-default red-button">加载更多</button><br>
            </div>

            <h4>标签云</h4>
            <div class="content-left tagclound taglist">
                <div class="container " id="tags">
                    <#list tag_List as tags>
                    <a href="/getArticle?tag_id=${tags.tag_id}">${tags.tag_name?cap_first}</a>
                    </#list>
                </div>

            </div>
        </div>

        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">扫描二维码关注我吧</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12 media">
                            <img src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200102165354.jpg"
                                 alt="微信二维码" class=" align-self-start erweima">
                        </div>
                    </div>

                </div>
            </div>
        </div>


    </main>
    <button type="button" id="BackTop" class="toTop-arrow" style="z-index: 100;"><i class="fas fa-arrow-circle-up">aaaaaaaaaaaaaaa</i></button>
    <!-- foot -->
    <footer class="row">
        <div class="others col-md-12 text-center">
            <div class="row">
                <div class="col-md-4">
                    <h3>微信公众号</h3>
                    <hr />
                    <div class="others-blcok friendLink others-block">
                        <a href="#" target="_blank">暂无</a>
                    </div>
                </div>
                <div class="col-md-4 friendLink">
                    <h3>友链</h3>
                    <hr />
                    <a href="http://www.hxsail.com/" target="_blank">风华</a>
                    <br />
                    <a href="https://blog.csdn.net/WXZCYQ" target="_blank">我的csdn博客</a>
                </div>
                <div class="col-md-4">
                    <h3>反馈</h3>
                    <hr />
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

</body>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/blogs/js/sroll.js"></script>
<script src="https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/js/bootstrap/bootstrap.min.js"></script>


</html>