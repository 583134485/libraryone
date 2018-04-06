<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ajaxdemo</title>
	<!-- script 导入问题 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
</script>
</head>
<body>
<script type="text/javascript">
//请求json，输出是json
var cmd = {  
        "name" : "手机",  
        "price" : "999"  
};
/*json 传输对象其他乱七八糟的。。  */
/* $(document).ready(function(){
        	 
    $.ajax({
        type : "POST", 
        url:"json",
        async:"false",
        datatype:"json",
        contentType:"application/json;charset=utf-8",//指定为json类型
        //数据格式是json串，商品信息
        data : JSON.stringify(cmd),
        error:function(data){  
            alert("出错了！！:");  
        },
        success:function(data){//返回json结果
            alert(data.name);
          }      
    }); 
   
}); */
/*您也许已经注意到在我们的实例中的所有 jQuery 函数位于一个 document ready 函数中：
$(document).ready(function(){
});
这是为了防止文档在完全加载（就绪）之前运行 jQuery 代码。  */
$(document).ready(function(){
	  $("#btn1").click(function(){
		  $.ajax({
		        type : "POST", 
		        url:"json",
		        async:"false",
		        datatype:"json",
		        contentType:"application/json;charset=utf-8",//指定为json类型
		        //数据格式是json串，商品信息
		        data : JSON.stringify(cmd),
		        error:function(data){  
		            alert("出错了！！:");  
		        },
		        success:function(data){//返回json结果
		             /* alert(data.name);  *//* 显示undefined*/
		        	alert(data);
		          }      
		    });
	    
	  })
	   
	  
	  	  $("#btn2").click(function(){
		  $.ajax({
		        type : "GET", 
		        url:"getjson",
		        async:"false",
		         datatype:"json", //改成datatype 显示object
		       /*  dataType: 'json', */   //依旧格式错误
		        contentType:"application/json;charset=utf-8",//指定为json类型
		        //数据格式是json串，商品信息
		       /*  data : JSON.stringify(cmd), */
		        error:function(data){  
		            alert("出错了！！:");  
		        },
		        success:function(data){//返回json结果
		            alert(data);
		          }      
		    });
	    
	  })
	   $("#btn3").click(function(){
		  $.ajax({
		        type : "GET", 
		        url:"getjson1",
		        async:"false",
		        datatype:"json",
		        contentType:"application/json;charset=utf-8",//指定为json类型
		        //数据格式是json串，商品信息
		       /*  data : JSON.stringify(cmd), */
		        error:function(data){  
		            alert("出错了！！:");  
		        },
		        success:function(data){//返回json结果
		            alert(data);
		          }      
		    });
	    
	  })
	    
	     
	     $("#btn4").click(function(){
         	$.get("echarts");
         	});                       
                                 
	  
	})

</script>
<h3 id="test">传json到后台</h3>
<button id="btn1" type="button">前台到后台后台再到前台</button>
<button id="btn2" type="button">ajax从数据库调用所有数据</button>
<button id="btn3" type="button">$.ajax数据库一个数据</button>
<button id="btn4" type="button">到echarts页面动态调用</button>


</body>
</html>