<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
<!--    //require is not defined报错可以用-->
    <!--<script src="js/require.js"></script>
    加载这个文件，也可能造成网页失去响应。解决办法有两个，
    一个是把它放在网页底部加载，另一个是写成下面这样：-->
   <!-- //异步加载-->
    <script src="<%=request.getContextPath() %>/static/js/require.js" defer async="false" ></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
    <!--async属性表明这个文件需要异步加载，避免网页失去响应。
    IE不支持这个属性，只支持defer，所以把defer也写上。-->
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
    <div><button id="btn1" type="button">数据库品牌销量</button></div>
    <div><button id ="btn2" type="button">getlist</button> </div>
    <div><button id ="btn3" type="button">getmapobject</button> </div>
    <div><button id ="btn4" type="button">getlistmapobject</button> </div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
      require( 
                [ 'echarts',  
                	'echarts/chart/pie','echarts/chart/funnel'
                ], DrawEChart //异步加载的回调函数绘制图表 
            ); 
     
            //创建ECharts图表方法 
            function DrawEChart(ec) {                      
                myChart.setOption(options); //先把可选项注入myChart中 
                myChart.hideLoading();
              /*   timeId = setInterval("getChartData();",2000); */
                //getChartData();//aja后台交互  
            } 
        </script> 
     
     
      <script type="text/javascript"> 
            function getChartData() { 
                //获得图表的options对象 
                var options = myChart.getOption(); 
                //通过Ajax获取数据 
                $.ajax({ 
                    type : "post", 
                    async:"false", 
                    url : "getbrandsale",                 
                    datatype:"json" ,
                    contentType:"application/json;charset=utf-8",
                    success : function(result) { 
                    <%-- 	<%  System.out.println("4444");//调试？ %> --%>
           
                        if (result) {   
                        	 var kk=[];
                             var vv=[];             
                         var result=eval("("+result+")"); 
                        
                        //遍历操作
                        for( key in result){
                        	 
                     /*   	alert("key:"+key+"vaule:"+result[key]); */
                       	kk.push(key);
                     //失败例子貌似多此一举，无效表示
                       	/* vv.push("{"+"value:"+result[key]+","+"name:"+"'"+key+"'"+"}"); */
                       vv.push({
                    	   value:result[key],
                    	   name: key})                     }                                      
                      /*   vv=[{value:1, name:'直接访问'},
                        {value:2, name:'邮件营销'},
                        {value:3, name:'联盟广告'},
                        {value:4, name:'视频广告'},
                        {value:1, name:'搜索引擎'} ] */
                        options.legend.data=kk; 
                        options.series[0].data=vv; 
                             myChart.hideLoading();
                             myChart.setOption(options); 
                        } 
                    }, 
                    error : function(errorMsg) { 
                        alert("后台问题，图表请求数据失败啦!"); 
                        myChart.hideLoading(); 
                    } 
                }); 
            } 
    </script> 
    <script type="text/javascript">
    function getlist(){
    	$.get("getlist",function(data){
    		var	data=eval("("+data+")");
    		for (var k = 0, length = data.length; k < length; k++){
    			alert(data[k]);
    			/* alert(data); */
    		}
    	
    		})
    }
    </script>
      <script type="text/javascript">
    function getmapobject(){
    	$.get("getmapobject",function(data){
    	var	data=eval("("+data+")");
    	for(key in data){
    		alert(key+data[key].brand);
    	     }
    		})
    }
    </script>
     
        <script type="text/javascript">
    function getlistmapobject(){
    	$.get("getlistmapobject",function(data){
    		var data=eval("("+data+")");	
    		for (var k = 0, length = data.length; k < length; k++){
    			for(key in data[k]){
    	    		alert(key+data[k].dd.brand);
    	    	     }
    		
    			}    		
    		})
    }
    </script>    
     <script type="text/javascript">
    $(document).ready(function(){
    	//jquery格式})要注注意，可以在chrome后台查看错误
    	 $("#btn1").click(function(){
    		
    	 });
    	 $("#btn2").click(function(){
    		 
    	 });
    
        $("#btn3").click(function(){
        	
        });
        $("#btn4").click(function(){
        
        })
        
    })
    
    </script> 
    
</body>
	
</html>