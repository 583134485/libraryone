<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

        <!--    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet"> -->
        <link href="<c:url value='/static/css/bootstrap.min.css?v=3.4.0' />" rel="stylesheet"></link>

        <!--  <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet"> -->
        <link href="<c:url value='/static/font-awesome/css/font-awesome.css?v=4.3.0' />" rel="stylesheet"></link>

        <!--     <link href="css/animate.css" rel="stylesheet"> -->
        <link href="<c:url value='/static/css/animate.css' />" rel="stylesheet"></link>

        <!-- <link href="css/style.css?v=2.2.0" rel="stylesheet"> -->
        <link href="<c:url value='/static/css/style.css?v=2.2.0' />" rel="stylesheet"></link>

        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <!-- Mainly scripts -->
        <!--    <script src="js/jquery-2.1.1.min.js"></script> -->
        <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-2.1.1.min.js"></script>

        <!--     <script src="js/bootstrap.min.js?v=3.4.0"></script> -->
        <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js?v=3.4.0"></script>


        </head>

        <body class="gray-bg">

        <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
        <div>

        <h1 class="logo-name">666</h1>

        </div>
        <h3>登陆</h3>

        <form class="m-t"  action="" method=post>
        <div class=" form-group">
        <!--required 必填 html5 -->
        <input type="text" class="form-control" name="username" placeholder="用户名" required="required">
        </div>
        <div class="form-group">
        <input type="password" class="form-control" name="password" placeholder="密码" required="required">
        </div>
        <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


        <p class="text-muted text-center"> <a href="#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
        </p>

        </form>
        </div>
        </div>

  

        </body>
 
        </html>