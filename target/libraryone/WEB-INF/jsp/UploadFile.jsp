<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload One File</title>
      <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
</head>
<body>
 
    <h3>Upload One File:</h3>
 <!--最简单的表的表单处理,但页面会跳转，不是我要的  -->
    <!-- <form method="POST" action="doUpload" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br />       
        <input type="submit" value="Upload">
    </form> -->
    <!-- 采用ajax -->
  <form name="myForm"  enctype="multipart/form-data">
  <!--   <input type="text" name="userName"> -->
    <input type="file" name="file">
    <input type="button" id="btn" value="submit">
    结果：<label id="label"></label>
</form>
    <script type="text/javascript">
    //$.ajaxFileUpload失败
   /*  function upload(){
    	$.ajaxFileUpload({
    	        url: 'doUpload', //用于文件上传的服务器端请求地址
    	        secureuri: false, //一般设置为false
    	        fileElementId: 'file', //文件上传空间的id属性  
    	        dataType: 'json', //返回值类型 一般设置为json
    	        success: function (data, status)  //服务器成功响应处理函数
    	        {                
    	            $("#text").attr("value", data);
    	            //addI(data);
    	        },
    	        error: function (data, status, e)//服务器响应失败处理函数
    	        {
    	        	$("#text").attr("value", data);
    	           // alert(e);
    	        }
    	    }   
    	);
    	}   */	
    	function upload(){
    //	var userName = document.myForm.userName.value;
        var file = document.myForm.file.files[0];
        var fm = new FormData();
       // fm.append('userName', userName);
        fm.append('file', file);
    	$.ajax(
    	        {
    	            url: 'doUpload',
    	            type: 'POST',
    	            data: fm,
    	            contentType: false, //禁止设置请求类型
    	            processData: false, //禁止jquery对DAta数据的处理,默认会处理
    	            //禁止的原因是,FormData已经帮我们做了处理
    	            success: function (result) {
    	                //测试是否成功
    	                //但需要你后端有返回值
    	                $("#label").html(result);
    	               // alert(result);
    	            },
    	            error:function(result){
    	            	 $("#label").html("上传失败");
    	            }
    	        }
    	    );
    	}
   	
    </script>
     	<script type="application/javascript">
			$(document).ready(function(){
			$("#btn").click(function(){
				upload();
			})
		})
		
		</script>
</body>
</html>