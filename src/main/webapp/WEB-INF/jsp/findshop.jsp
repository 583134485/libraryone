<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>findshop</title>
	<!-- script 导入问题 -->
   <script src="<%=request.getContextPath() %>/static/js/require.js" defer async="false" ></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
</head>

<body>

 <div>
inputname<input type="text" id="name"/>
 <button id="btn1" type="button">传输{"name":"ll"}的json对象到后台</button></div>
 <div>
<!-- <form action="form" method="post">    
     参数inputStr:<input type="text" name="inputStr">    
     参数intputInt:<input type="text" name="inputInt">  
     <input type="submit" value="原始的form提交url地址会变">  
</form> -->

<form id="form">
First name: <input type="text" name="FirstName" value="Bill" /><br />
Last name: <input type="text" name="LastName" value="Gates" /><br />
<input type="button" id="btn3" value="serialize化非json">
</form>

<div>
<input type="text" id="name4">
<input type="button" id="btn4" value="最简单的传输非json">
</div>
 
 </div>
</body>
<script type="text/javascript">
function name2(){
	
}
</script>
<script type="text/javascript">
function name3(){
/* 	alert($("#form").serialize());
	alert($("#form").serializeArray()); */

	$.ajax({
	    type: "post",
	    url: "findshop3",
	      data: $("#form").serializeArray(),
 	   // data: $("#form").serialize(), 
	    success: function(data) {
	        // your code
	    }
	});
	
/* 	
	$.post('your url', $("form").serialize(), function(data) {
        // your code
    }
});

$.get('your url', $("form").serialize(), function(data) {
        // your code
    }
});

$.getJSON('your url', $("form").serialize(), function(data) {
        // your code
    }
}); */
}
</script>

<script type="text/javascript">
function name4(){
	$.post("findshop4", {"name4":$("#name4").val()}, function(data) {})
}
</script>


<script type="text/javascript">
function findshop(){
/* 	var name = {name : $("#name").val()}; */
	/* alert(name); */
	/* alert($("#name").val()); */
	var name = $("#name").val();
	var data={"name":name}
		$.ajax({  
			         type:"post",      
			        url:"findshop",  
			    data: JSON.stringify(data), 
			        /* data: data, */
			         dataType:"json", 
			         //注释掉以后就能传输数据了
			       contentType:"application/json",    
			         success:function(data){  
			        	alert(data);
			         }  
			     });  
	
	/* else{
		$.ajax({ 
	        type : "post", 
	        async:"false", 
	        url : "findshop", 
	        data:  {"name":$("#name").val()},
	        datatype:"json",
	        contentType:"application/json;charset=utf-8",
	        success : function(result) {
	        	alert(result);
	        },
		 error : function(errorMsg) { 
	         alert("失败!"); 
	         
	     } 
		  }); 
	} */

	
}
</script>
 <script type="text/javascript">
    $(document).ready(function(){
    	//jquery格式})要注注意，可以在chrome后台查看错误
    	 $("#btn1").click(function(){
    		 findshop();
    	 });
    	 $("#btn2").click(function(){
    		 name2();
    	 });
    
        $("#btn3").click(function(){
        	name3();
        });
        $("#btn4").click(function(){
            name4();
        });
      
        
    })
    
    </script> 
</html>