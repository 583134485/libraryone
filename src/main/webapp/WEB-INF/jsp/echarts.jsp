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
    <div><button id="btn1" type="button">从后台更行数据数据</button></div>
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
                  'echarts/chart/line',
                  'echarts/chart/bar'
                ], DrawEChart //异步加载的回调函数绘制图表 
            ); 
     
            //创建ECharts图表方法 
            function DrawEChart(ec) { 
                eCharts = ec; 
                myChart = eCharts.init(document.getElementById('main')); 
                myChart.showLoading({ 
                   text : "图表数据正在努力加载..." 
                }); 
                //定义图表options 
                var options = { 
                    title : { 
                        text : "未来一周气温变化", 
                        subtext : "纯属虚构", 
                        sublink : "http://www.baidu.com" 
                    }, 
                    tooltip : { 
                           show: true,
                        trigger : 'axis' 
                    }, 
                    legend : { 
                        data : [ "测试" ] 
                    }, 
                    toolbox : { 
                        show : true, 
                        feature : { 
                            mark : { show : true}, 
                            dataView : {show : true,  readOnly : false}, 
                            magicType : {show : true,  type : [ 'line', 'bar' ] }, 
                            restore : {show : true }, 
                            saveAsImage : {show : true } 
                        } 
                    }, 
                    calculable : true, 
                    xAxis : [ { 
                        type : 'category', 
                        boundaryGap : false, 
                        data : [ '1', '2', '3', '4', '5', '6', '7' ] 
                    } ], 
                    yAxis : [ { 
                        type : 'value', 
                        axisLabel : { 
                            formatter : '{value} °C' 
                        }, 
                        splitArea : { 
                            show : true 
                        } 
                    } ], 
                   grid : { 
                        width : '90%' 
                    }, 
                    series : [ { 
                        name : '最高气温', 
                        type : 'line', 
                        data : [ 1, 11, 18, 11, 15, 11, 8 ],//必须是Integer类型的,String计算平均值会出错 
                        markPoint : { 
                            data : [
                                     {type : 'max', name : '最大值'},
                                     {type : 'min',  name : '最小值'}
                                     ] 
                        }, 
                        markLine : { 
                            data : [
                                     {type : 'average', name : '平均值'}
                                     ] 
                        } 
                    } ] 
                }; 
               
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
                    url : "echarts", 
                    /*  data : {},    */
                    /* dataType : "JSON", */   //返回数据形式为json
                   /*  datatype : "json", *///改成datatype返回就不为空
                    datatype:"json" ,
                    contentType:"application/json;charset=utf-8",
                    success : function(result) { 
                    <%-- 	<%  System.out.println("4444");//调试？ %> --%>
           
                        if (result) {
                        	//测试是否真的为空
                       /*  alert(jQuery.isEmptyObject(result)); */ //为空 返回true
                        	/* alert(result); */
                        
                 /*  alert(JSON.parse(result)); */
                        	/* var dataObj=eval("("+result+")"); /*报错？？？？  */
                        	/* alert(dataObj);  */                       
                        	/* var result =JSON.stringify(r); */
                        	/* alert(JSON.stringify(result)); *///显示{} why? 
                        		/* 	alert(result); */
                        			var result=eval("("+result+")");//转话为json对象
                        			/* alert(JSON.stringify(result)); */
                        /* 	alert(dataObj.legend); */
                        	 options.legend.data = result.legend; 
                        	 /*  alert("options.legend.data"+options.legend.data);           
                        	  alert("result.legend"+result.legend); */
                             options.xAxis[0].data = result.category;
                        	/*  alert( options.xAxis[0].data); */
                        	/* alert("result.catagory"+result.catagory); *///undeined
                       /*  	alert("result.catagory[0]"+result.catagory[0]); */ //错误写法
                        	/* alert( "options.xAxis[0].data"+options.xAxis[0].data); *///这里却显示成功
                             options.series[0].data = result.series[0].data; 
                                 /*  alert(options.series[0].data); 
                                  alert(result.series[0].type);//这里却显示成功
                                  alert(result.series[0].name); */
                                                
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
    $(document).ready(function(){
    	//jquery格式})要注注意，可以在chrome后台查看错误
    	 $("#btn1").click(function(){
    		 getChartData();
    	 });
    })
    
    </script> 
    
</body>
	
</html>