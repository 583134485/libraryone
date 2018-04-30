<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>uploadfile</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   	<link href="<c:url value='/static/font-awesome/css/font-awesome.css?v=4.3.0' />" rel="stylesheet"></link>
<!--     <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet"> -->
    <link href="<c:url value='/static/css/animate.css' />" rel="stylesheet"></link>
  <!--   <link href="css/animate.css" rel="stylesheet"> -->
    <link href="<c:url value='/static/css/plugins/dropzone/basic.css' />" rel="stylesheet"></link>
  <!--   <link href="css/plugins/dropzone/basic.css" rel="stylesheet"> -->
    <link href="<c:url value='/static/css/plugins/dropzone/dropzone.css' />" rel="stylesheet"></link>
<!--     <link href="css/plugins/dropzone/dropzone.css" rel="stylesheet"> -->
    <link href="<c:url value='/static/css/style.css?v=2.2.0' />" rel="stylesheet"></link>
<!--     <link href="css/style.css?v=2.2.0" rel="stylesheet"> -->

</head>

<body>
    <div id="wrapper">
      <nav class="navbar-default navbar-static-side" role="navigation">
			<!--折叠收缩-->
			<div class="sidebar-collapse">
				<!-- ul 无序列表-->
               <ul class="nav" id="side-menu">
                    <li class="nav-header">

                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/a1.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Beaut-zihan</strong>
                             </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="">修改头像</a>
                                </li>
                                <li><a href="">个人资料</a>
                                </li>
                            <li><a href="">联系我们</a>
                                </li>
                                <li><a href="">信箱</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            H+
                        </div>

                    </li>
                    <li class="">
                        <a href=""><i class="fa fa-th-large"></i> <span class="nav-label">主页</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="">主页示例一</a>
                            </li>
                            <li><a href="">主页示例二</a>
                            </li>
                            <li><a href="">主页示例三</a>
                            </li>
                            <li><a href="">主页示例四</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <di
                    </li>

                    <li>
                        <a href="index.html"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="">百度ECharts</a>
                            </li>
                            <li><a href="">HCharts</a>
                            </li>

                        </ul>
                    </li>

                    <li>
                        <a href=""><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="">基本表单</a>
                            </li>
                            <li><a href="">表单验证</a>
                            </li>
                            <li><a href="">高级插件</a>
                            </li>
                            <li><a href="">步骤条</a>
                            </li>
                            <li><a href="">百度WebUploader</a>
                            </li>
                            <li><a href="http://127.0.0.1:8020/persionUI/person/uploadfile.html">文件上传</a>
                            </li>
                            <li><a href="">富文本编辑器</a>
                            </li>
                            <li><a href="">simditor</a>
                            </li>
                            <li><a href="">头像裁剪上传</a>
                            </li>
                            <li><a href="">日期选择器layerDate</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-table"></i> <span class="nav-label">表格</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="">基本表格</a>
                            </li>
                            <li><a href="http://127.0.0.1:8020/persionUI/person/datatables.html">数据表格(DataTables)</a>
                            </li>
                            <li><a href="">jqGrid</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-table"></i> <span class="nav-label">文件</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="http://127.0.0.1:8020/persionUI/person/uploadfile.html">文件上传</a>
                            </li>
                            <li><a href="http://127.0.0.1:8020/persionUI/person/filedown.html">数据到出</a>
                            </li>
                          
                        </ul>
                    </li>
     
                </ul>
			</div>
		</nav>
        
<div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="form_file_upload.html#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <span class="m-r-sm text-muted welcome-message"><a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用H+后台主题</span>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                                <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                                <li>
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="img/a7.jpg">
                                        </a>
                                        <div class="media-body">
                                            <small class="pull-right">46小时前</small>
                                            <strong>小四</strong> 项目已处理完结
                                            <br>
                                            <small class="text-muted">3天前 2014.11.8</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="img/a4.jpg">
                                        </a>
                                        <div class="media-body ">
                                            <small class="pull-right text-navy">25小时前</small>
                                            <strong>国民岳父</strong> 这是一条测试信息
                                            <br>
                                            <small class="text-muted">昨天</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a href="mailbox.html">
                                            <i class="fa fa-envelope"></i>  <strong> 查看所有消息</strong>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                                <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li>
                                    <a href="mailbox.html">
                                        <div>
                                            <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                            <span class="pull-right text-muted small">4分钟前</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="profile.html">
                                        <div>
                                            <i class="fa fa-qq fa-fw"></i> 3条新回复
                                            <span class="pull-right text-muted small">12分钟钱</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a href="notifications.html">
                                            <strong>查看所有 </strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>


                        <li>
                            <a href="login.html">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>文件上传</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">主页</a>
                        </li>
                        <li>
                            <a>表单</a>
                        </li>
                        <li>
                            <strong>文件上传</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
            <div class="wrapper wrapper-content animated fadeIn">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>文件上传</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="form_file_upload.html#">选项1</a>
                                        </li>
                                        <li><a href="form_file_upload.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <form id="my-awesome-dropzone" class="dropzone" action="form_file_upload.html#">
                                    <div class="dropzone-previews"></div>
                                    <button type="submit" class="btn btn-primary pull-right">提交</button>
                                    <button type="button" id ="clear" class="btn btn-primary pull-right">清空</button>
                                </form>
                                
                                <div>
                                    <div class="m"><small>DropzoneJS是一个开源库，提供拖放文件上传与图片预览：<a href="https://github.com/enyo/dropzone" target="_blank">https://github.com/enyo/dropzone</a></small>，百度前端团队提供的<a href="http://fex.baidu.com/webuploader/" target="_blank">Web Uploader</a>也是一个非常不错的选择，值得一试！</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            
            <div class="footer">
                <div class="pull-right">
                    By：<a href="http://www.zi-han.net" target="_blank">zihan's blog</a>
                </div>
                <div>
                    <strong>Copyright</strong> H+ &copy; 2014
                </div>
            </div>

        </div>
    
    </div>


    </div>
<!-- 为了迎合jsp -->
    <!-- Mainly scripts -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!--<script src="js/jquery-2.1.1.min.js"></script>-->
 <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/metisMenu/jquery.metisMenu.js "></script>
   
  <!--   <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script> -->
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/slimscroll/jquery.slimscroll.min.js "></script>
   <!--  <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> -->
    <!-- Custom and plugin javascript -->
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/hplus.js?v=2.2.0"></script>
 <!--    <script src="js/hplus.js?v=2.2.0"></script> -->
  <!-- <script src="js/plugins/pace/pace.min.js"></script>-->
  
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/dropzone/dropzone.js"></script>
    <!-- DROPZONE -->
   <!--  <script src="js/plugins/dropzone/dropzone.js"></script> -->
    


    <script>
        $(document).ready(function () {
         
            $("#clear").click(function(){
            	//之后实现清空clear 上传文件API
                   window.location.href=window.location.href;
            });
            
            Dropzone.options.myAwesomeDropzone = {
               // url:"http://127.0.0.1:8080/libraryone/HotGoods/doUpload",
                 url:"http://127.0.0.1:8080/libraryone/shengecanmou/doupload",
                autoProcessQueue: false,
                uploadMultiple: false,
                parallelUploads: 100,
                maxFiles: 100,

                // Dropzone settings
                init: function () {
                    var myDropzone = this;

                    this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                        e.preventDefault();
                        e.stopPropagation();
                        myDropzone.processQueue();
                    });
                    this.on("sendingmultiple", function () {});
                    this.on("successmultiple", function (files, response) {});
                    this.on("errormultiple", function (files, response) {});
                }

            }

        });
    </script>


</body>

</html>
