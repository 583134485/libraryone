<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>爆款成长周期</title>
		 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts.js "></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
	</head>
	<body>
		<div id="main" style="width: 920px;height:400px;"></div>
		
		<div><button id="btn" type="button">展示</button></div>
		<div><img src="<%=request.getContextPath() %>/static/img/hot.png"  alt="图片不见了" ></div>
		<script type="application/javascript">
			
			var myChart = echarts.init(document.getElementById('main'));
			/*myChart.showLoading({
				text:"在加载别急"
			});*/
			var colors = ['#5793f3', '#d14a61', '#675bba'];
			myChart.setOption(
				option = {
    color: colors,

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
        data:['流量','支付','加购','金额','转化']
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
    dataZoom: [
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
    ],
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
            offset: 50,
            axisLine: {
                lineStyle: {
                    color: colors[1]
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
            max: 400,
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
            name: '金额',
            min: 0,
            max: 250000,
            position: 'right',
            offset: 40,
            axisLine: {
                lineStyle: {
                    color: colors[1]
                }
            },
            axisLabel: {
                formatter: '{value} 元'
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
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 17.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        },
        {
            name:'加购',
            type:'line',
            yAxisIndex: 2,
            data:[3.0, 2.2, 3.3, 4.5, 6.3, 10.2, 210.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
        {
            name:'金额',
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
            yAxisIndex: 3,
            data:[2.0, 42.2, 3.3, 4.5, 6.3, 12.2, 220.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        },
        {
            name:'转化',
            type:'line',
            yAxisIndex: 4,
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
					url:"showhotgoods",
					async:true,
					datatype:"json",
					contentType:"application/json;charset=utf-8",
					success:function(result){
						if(result){
							//对象
							 var result=eval("("+result+")"); 
							 var kk=[];
							 var datetime=[];
							 var flow=[];
							 var pay=[];
							 var plus=[];
							 var money=[];
							 var conversion=[];
							 for (key in result){
							 	kk.push(key);
							 	if(key=="日期"){
							 		datatime=result[key];
							 	}
							 	else if(key=="流量"){
							 		flow=result[key];
							 	}
							 	else if(key=="支付"){
							 		pay=result[key];
							 	}
							 	else if(key=="加购"){
							 		plus=result[key];
							 	}
							 	else if(key=="金额"){
							 		money=result[key];
							 	}
							 	else if(key=="转化"){
							 		conversion=result[key];
							 	}
							 	
							 	
							 }
							 option.legend.data=kk;
							 option.xAxis[0].data=datatime;
							 option.series[0].data=flow;
							 option.series[1].data=pay;
							 option.series[2].data=plus;
							 option.series[3].data=money;
							 option.series[4].data=conversion;
							 myChart.hideLoading();
						     myChart.setOption(option);
							 
							 
						};
						
					},
					error:function(error){
						alert("后台问题请求失败")
						myChart.hideLoading();
						myChart.setOption();
					}
				});
			}
		</script>
		<script type="application/javascript">
			$(document).ready(function(){
			$("#btn").click(function(){
				show();
			})
		})
		</script>
		
	</body>
</html>
