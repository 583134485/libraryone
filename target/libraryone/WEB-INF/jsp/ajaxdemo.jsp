<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ajaxdemo</title>
	<!-- script 导入问题 -->
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
</head>

<body>
<!-- //location 导入问题 -->
<div><button id="btn" type="button">getjson1</button></div>


<script type="text/javascript">
 function show(){
	 $.ajax({
		  type:"POST",
		    url: "/library/test/ajaxdemo",
		    async:false,//同步：意思是当有返回值以后才会进行后面的js程序。
		   // data://请求需要发送的处理数据
		    success:function(msg){
		        if (msg) {//根据返回值进行跳转
		            window.location.href = '/library/test/getjson1';}
		        }
	 })
 }


</script>

		<script type="application/javascript">
			$(document).ready(function(){
			$("#btn").click(function(){
				show();
			})
		
		})
		</script>

<script type="text/javascript">
var cmd =  [{"storeId":"0a1", 
	"address":"西斗门路2号", 
	"goods":[{"goodsId":"1"}, {"goodsId":"2"}, {"goodsId":"3"}]},{"storeId":"0a1", "address":"西斗门路2号", "goods":[{"goodsId":"4"}, {"goodsId":"4"}, {"goodsId":"5"}]}] 

$(document).ready(function(){
	  $.ajax({  
          url : "ajaxdemo",//  url : "/ajaxdemo" 这种形式会没有跳转，具体原因不知
          type : "POST",  
          async:"false",
          datatype:"json",  
          contentType: "application/json; charset=utf-8",  
        /*   data : $toJSON(cmd),   *//* 两种方式转化成json字符传 */
          data : JSON.stringify(cmd),
          success : function(data, stats) {  
              if (stats == "success") {  
            	  alert("请求成功");   
              }  
          },  
          error : function(data) {  
              alert("请求失败");  
          }  
      });  

});

</script>
	
</body>
</html>