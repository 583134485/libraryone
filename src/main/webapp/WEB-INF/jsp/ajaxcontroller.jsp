<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ajaxcontroller</title>
	<!-- script 导入问题 -->
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
</head>

<body>
<!-- 展示利用ajax进行跳转的方式 -->
<div><button id="btn" type="button">ajaxgetjson1</button></div>

<div><button id="btn2" type="button">href2getjson1</button></div>

<div><a href="javascript:void(0)" onclick="show2()">href调用js方法</a></div>

<script type="text/javascript">
 function show(){
	 $.ajax({
		  type:"post",
		  url:'/libraryone/test/ajaxcontroller',
		  async:false, //同步：意思是当有返回值以后才会进行后面的js程序。
		  //dataType:"json",
		   // data://请求需要发送的处理数据
		    success:function(msg){
		        if (msg) {//根据返回值进行跳转
		        	alert(msg);
		            window.location.href = '/libraryone/test/getjson';
		        } 
		        //alert("777");
		        
		    },
	     error:function(error){
			alert("后台问题请求失败");
			
		}
	 })
	 }
</script>
<script type="text/javascript">
 function show2(){
	 window.location.href='/libraryone/test/getjson';
	// 以下方式定时跳转
	// setTimeout("javascript:location.href=''", 5000); 
	 }
</script>
		<script type="text/javascript">
			$(document).ready(function(){
			$("#btn").click(function(){
				show();
			})
			$("#btn2").click(function(){
				show2();
			})
		
		})
		</script>
</body>
</html>