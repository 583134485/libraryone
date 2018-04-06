<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>爆款成长周期2</title>
		
		 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts.js "></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>

	</head>
	<body>
		<div id="main" style="width: 1500px;height:600px;"></div>
		
		<div><button id="btn" type="button">爆款</button></div>
		<input type="text" name="name" id="name"/> 
		  读取数据结果  ：<label id="label2"></label>
	<form name="myForm"  enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="button" id="btn1" value="submit">
   上传 结果：<label id="label" ></label>
</form>
<div>
商品信息：<label id="shop"></label>
</div>
		<div><img  id="img" src="<%=request.getContextPath() %>/static/img/hot.png"  alt="图片不见了" ></div>
			<script type="application/javascript">
			
			var myChart = echarts.init(document.getElementById('main'));
			/*myChart.showLoading({
				text:"在加载别急"
			});*/
			var colors = ['#5793f3', '#d14a61', '#675bba' ,'#FE8463','#9BCA63','#FAD860'];
			myChart.setOption(
				option = {
    color: colors,
   // backgroundColor: '#21202D',
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    grid: {
        right: '20%'
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    legend: {
    	
        data:['流量','支付','加购','金额','转化','加购率','单价']
        
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
       /*  dataZoom: [
        {
            type: 'inside',
            start: 50,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 50,
            end: 100
        }
    ], */
    yAxis: [
        {
            type: 'value',
            name: '流量',
            min: 0,
            max: 10000,
            position: 'right',
            
            axisLine: {
                lineStyle: {
                    color: colors[0]
                }
            },
            axisLabel: {
                formatter: '{value} '
            }
        },
        {
            type: 'value',
            name: '支付',
            min: 0,
            max: 100,
            position: 'left',
            
            axisLine: {
                lineStyle: {
                    color: colors[2]
                }
            },
            axisLabel: {
                formatter: '{value} '
            }
        },
        {
            type: 'value',
            name: '加购',
            min: 0,
            max: 500,
            position: 'left',
             offset: 80,
            axisLine: {
                lineStyle: {
                    color: colors[5]
                }
            },
            axisLabel: {
                formatter: '{value}'
            }
        },
              {
            type: 'value',
            name: '单价',
            min: 0,
            max: 5000,
            position: 'left',
            offset: 25,
            axisLine: {
                lineStyle: {
                    color: colors[0]
                }
            },
            axisLabel: {
                formatter: '{value}%'
            }
        },
           {
            type: 'value',
            name: '金额',
            min: 0,
            max: 300000,
            position: 'right',
            offset: 30,
            axisLine: {
                lineStyle: {
                    color: colors[3]
                }
            },
            axisLabel: {
                formatter: '{value}元'
            }
        },
             {
            type: 'value',
            name: '加购率',
            min: 0,
            max: 25,
            position: 'right',
            offset: 60,
            axisLine: {
                lineStyle: {
                    color: colors[1]
                }
            },
            axisLabel: {
                formatter: '{value}%'
            }
        },
        
           {
            type: 'value',
            name: '转化',
            min: 0,
            max: 2,
            position: 'right',
            offset: 100,
            axisLine: {
                lineStyle: {
                    color: colors[1]
                }
            },
            axisLabel: {
                formatter: '{value} %'
            }
        }
    ],
  dataZoom: [
        
        {
            type: 'slider',
            show: true,
            yAxisIndex: [0,1,2],
             width: 30,
            // filterMode: 'empty',
           // fillerColor:colors[2],
            left: 'right',
            start: 1,
            end: 100
        },
        {
            type: 'slider',
            show: true,
            xAxisIndex: [0],
            start: 1,
            end: 35
        }
    ],
    series: [
        {
            name:'流量',
            type:'bar',
            markPoint:{
            	data: [
    {
        name: '最大值',
        type: 'max'
    } ,
      {
        name: '最小值',
        type: 'min'
    } 
   
]
            	
            },
            markLine:{
            	data:[
            	 {
        name: '平均线',
        // 支持 'average', 'min', 'max'
        type: 'average'
    },
      [
        {
            // 起点和终点的项会共用一个 name
            name: '最小值到最大值',
            type: 'min'
        },
        {
            type: 'max'
        }
    ]
            	]
            	
            },
            data:[2.9, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            
        },
        {
            name:'支付',
            type:'line',
            yAxisIndex: 1,
            markPoint:{
            	data: [
    {
        name: '最大值',
        type: 'max'
    } ,
      {
        name: '最小值',
        type: 'min'
    } 
   
]
            	
            },
            markLine:{
            	data:[
            	 {
        name: '平均线',
        // 支持 'average', 'min', 'max'
        type: 'average'
    },
      [
        {
            // 起点和终点的项会共用一个 name
            name: '最小值到最大值',
            type: 'min'
        },
        {
            type: 'max'
        }
    ]
            	]
            	
            },
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 17.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        },
        {
            name:'加购',
            type:'bar',
            yAxisIndex: 2,
            data:[3.0, 2.2, 3.3, 4.5, 6.3, 10.2, 210.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
         {
            name:'单价',
            type:'line',
            yAxisIndex: 3,
            data:[3.0, 2.2, 3.3, 4.5, 6.3, 10.2, 210.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
        {
            name:'金额',
            type:'line',
            yAxisIndex: 4,
            data:[2.0, 42.2, 3.3, 4.5, 6.3, 12.2, 220.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
          {
            name:'加购率',
            type:'line',
            yAxisIndex: 5,
            data:[2.0, 42.2, 3.3, 4.5, 6.3, 12.2, 220.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
        {
            name:'转化',
            type:'line',
            yAxisIndex: 6,
            data:[2.0, 2.2,6.3, 42.5, 6.3, 11.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        }
    ]
}


			)
			 
			
		</script>
		<script type="application/javascript">
			function show(){
				var option=myChart.getOption();
				$.ajax({
					type:"post",
					url:"shownewhotgoods",
					async:false,
					data:"name="+$("#name").val(), 
					datatype:"json",
					//contentType:"application/json;charset=utf-8",
					success:function(result){					
							//对象
							 var result=eval("("+result+")"); 
							 var kk=[];
							 var datetime=[];
							 var flow=[];
							 var pay=[];
							 var plus=[];
							 var money=[];
							 var conversion=[];
							 var purchaseRate=[];
							 var price=[];
							 var picurl=[];
							 //其实以下判断还是有些多余
							 for (key in result){
								 
							 /* 	if(result.key.)
							 	{
							 		//这是为了取真正展示的图表上的字段
							 	 kk.put(key);
							 	}  */
							 
							 	if(key=="datatime"){
							 		//alert(result.key);
							 		
							 		datetime=result[key];
							 	}
							 	else if(key=="flow"){
							 		flow=result[key];
							 	}
							 	else if(key=="payment"){
							 		pay=result[key];
							 	}
							 	
							 	else if(key=="plus"){
							 		plus=result[key];
							 	}
							 	else if(key=="money"){
							 		money=result[key];
							 	}
							 	
							 	else if(key=="price"){
							 		price=result[key];
							 	}
							 	
							 	else if(key=="purchaseRate"){
							 		purchaseRate=result[key];
							 	}
							 	else if(key=="conversion"){
							 		//alert(result(key));
							 		conversion=result[key];
							 	}
							 	else if(key=="pictureUrl"){
							 		picurl=result[key];
							 	}		 								 	
							 }
							// option.legend.data=kk;
							 option.xAxis[0].data=datetime;
							 option.series[0].data=flow;
							 option.series[1].data=pay;
							 option.series[2].data=plus;
							 option.series[3].data=price;
							 option.series[4].data=money;
							 option.series[5].data=purchaseRate;
							 option.series[6].data=conversion;
							 myChart.hideLoading();
						     myChart.setOption(option);		
						     $("#shop").html("id:"+"&nbsp;&nbsp;&nbsp;"+result["id"]+"&nbsp;&nbsp;&nbsp;"+"款号:"+result["styleNumber"]+"<br/>"+"吊牌价:"+result["tagPrice"]+"&nbsp;&nbsp;&nbsp;"+"上新价:"+result["Newquotation"]+"<br/>"+"折扣:"+result["discount"]+"&nbsp;&nbsp;&nbsp;"+"品类:"+result["category"]+"<br/>"+"面料:"+result["fabric"]+"&nbsp;&nbsp;&nbsp;"+"版型:"+result["typeVersion"]+"<br/>"+"年份:"+result["year"]+"&nbsp;&nbsp;&nbsp;"+"季节:"+result["season"]+"<br/>"+"平牌:"+result["brand"]+"&nbsp;&nbsp;&nbsp;"+"产品线:"+result["productLine"]);
						  //  console.log("id"+result["id"]);
							 $("#img").attr('src',"<%=request.getContextPath() %>"+picurl);
							 $("#label2").html("成功");
							 
					
						
					},
					error:function(error){
						//alert("后台问题请求失败")
						   console.log('请求失败');
						   $("#label2").html("请求失败");
						//myChart.hideLoading();
						//myChart.setOption();
					}
				});
			}
		</script>
		<!--异步加载图片  -->
<!-- <script type="application/javascript">
 function showpicture(picurl){
	 var url=picurl; 
	 $.ajax({
		 type:"get",
		 url:""
	 })
 }
</script> -->
    <script type="text/javascript">
    	function upload(){
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
				show();
			})
			$("#btn1").click(function(){
				upload();
			})
		})
		</script>
		
<!-- 懒加载待有错。。。 -->
<!-- <script type="text/javascript">
jQuery(function($) {
    console.log($, 'jquery works');
    console.log($("#img").length);
    $("#img").lazyload();
});
</script> -->
		
	</body>
</html>
