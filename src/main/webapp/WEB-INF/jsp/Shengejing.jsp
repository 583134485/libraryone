<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts.js "></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
     <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> 
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<body>
		<div class="jumbotron">
		<div id="main" style="width: 1200px;height:600px;"></div>
		<div style="padding: 100px 100px 10px;">
	<form class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default" tabindex="-1">商铺名
						</button>
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
							<span class="caret"></span>
							<span class="sr-only">切换下拉菜单</span>
						</button>
						<ul  id="li1" class="dropdown-menu">
							<li><a href="#">拉夏贝尔官方旗舰</a></li>
							<li><a href="#">七格格旗舰店</a></li>
							<li><a href="#">7modifier官方旗舰店</a></li>
							<!--<li class="divider"></li>-->
							<li><a href="#">puella官方旗舰店</a></li>
							<li><a href="#">candies服饰旗舰店</a></li>
						</ul>
					</div><!-- /btn-group -->
					<input  id ="shop" type="text" value="七格格旗舰店" class="form-control">
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 --><br>
			<div class="col-lg-6">
				<div class="input-group">
					<input  id="begindate" type="text"  value="2017-8-26" class="form-control">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default" tabindex="-1">start日期
						</button>
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
							<span class="caret"></span>
							<span class="sr-only">切换下拉菜单</span>
						</button>
						<ul  id="li2" class="dropdown-menu pull-right">
							<li><a href="#">2017-8-26</a></li>
							<li><a href="#">2017-8-27</a></li>
							<li><a href="#">2017-8-28</a></li>
							<!--<li class="divider"></li>-->
							<li><a href="#">2017-8-29</a></li>
						</ul>
					</div><!-- /btn-group -->
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 -->
			<div class="col-lg-6">
				<div class="input-group">
					<input  id="enddate" type="text"  value="2017-8-29" class="form-control">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default" tabindex="-1">end日期
						</button>
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
							<span class="caret"></span>
							<span class="sr-only">切换下拉菜单</span>
						</button>
						<ul  id="li3" class="dropdown-menu pull-right">
							<li><a href="#">2017-8-26</a></li>
							<li><a href="#">2017-8-27</a></li>
							<li><a href="#">2017-8-28</a></li>
							<!--<li class="divider"></li>-->
							<li><a href="#">2017-8-29</a></li>
							<li><a href="#">2017-8-30</a></li>
							<li><a href="#">2017-9-01</a></li>
						</ul>
					</div><!-- /btn-group -->
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	</form>
	<!-- 标准的按钮 -->
<button  id="btn" type="button" class="btn btn-default">一天的数据</button>
<button  id="btn2" type="button" class="btn btn-default">一段时间数据</button>
</div>
</div>
		
		<script type="application/javascript">
			
			var myChart = echarts.init(document.getElementById('main'));
			/*myChart.showLoading({
				text:"在加载别急"
			});*/
		
/* 			var weatherIcons = {
    'Sunny': './data/asset/img/weather/sunny_128.png',
    'Cloudy': './data/asset/img/weather/cloudy_128.png',
    'Showers': './data/asset/img/weather/showers_128.png'
}; */

var seriesLabel = {
    normal: {
        show: true,
        textBorderColor: '#333',
        textBorderWidth: 2
    }
}
			myChart.setOption(
	option = {
    title: { 
    	top:'top',
        text: 'Wheater Statistics'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
    
        data: ['hotword', 'pc', 'app']
    },
    grid: {
        left: 100
    },
    toolbox: {
        show: true,
        feature: {
        	dataView : {show: true, readOnly: false},
        	magicType: {show: true, type: ['line', 'bar', 'stack']},
        	restore : {show: true},
            saveAsImage: {}
        }
    },
    xAxis: [
    	{
            type: 'value',
            name: 'hotword',
            axisLabel: {
                formatter: '{value}'
            }
        },
    	{
        type: 'value',
        name: 'liuliang',
        axisLabel: {
            formatter: '{value}'
        }
    }
    
    
    ],
    yAxis: {
        type: 'category',
        inverse: true,
        data: ['Sunny', 'Cloudy', 'Showers']
    },
      dataZoom: [
        
        {
            type: 'slider',
            show: true,
            yAxisIndex: [0],
             width: 30,
            // filterMode: 'empty',
           // fillerColor:colors[2],
            left: 'right',
            start: 1,
            end: 20
        },
        {
            type: 'slider',
            show: true,
            xAxisIndex: [0,1],
            start: 1,
            end: 100
        }
    ],
    series: [
        {
            name: 'hotword',
            type: 'bar',
            data: [165, 170, 30],
            label: seriesLabel,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
               markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
            
        },
        {
            name: 'app',
            type: 'bar',
            label: seriesLabel,
            data: [150, 105, 110],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
               markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
            
        },
        {
            name: 'pc',
            type: 'bar',
            label: seriesLabel,
            data: [220, 82, 63],
             markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
               markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }
    ]
}
				)
			
			 
			
		</script>
		<script type="application/javascript">
			function show(){
				var option=myChart.getOption();
				myChart.showLoading({
				text:"在加载别急"
			});
				$.ajax({
					type:"post",
					url:"onedayshow",
					async:false,
					datatype:"json",
					data: {shop:$("input#shop").val(),
						begindate:$("input#begindate").val()},
					
					//contentType:"application/json;charset=utf-8",
					success:function(result){
						if(result){
							 var result=eval("("+result+")"); 
							 var shop=result['shop'];
							 var recordtime=result['recordtime'];
                             var hotword=[];
                             var pc=[];
                             var app=[];
                             var type=[];
                             var data=result['typedata'];
							 for(key in data){
							 	type.push(key);
							 	pc.push(data[key]['pc']);
							 	app.push(data[key]['app']);
							 	hotword.push(data[key]['hotword']);
							 }
							 option.yAxis[0].data=type;
							 option.series[0].data=hotword;
							 option.series[1].data=app;
							 option.series[2].data=pc;
							 option.title[0].text=shop+recordtime;
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
			function show2(){
				var option=myChart.getOption();
				myChart.showLoading({
				text:"在加载别急"
			});
				$.ajax({
					type:"post",
					url:"longdayshow",
					async:false,
					datatype:"json",
					data: {shop:$("input#shop").val(),
						begindate:$("input#begindate").val(),
						    enddate:$("input#enddate").val()},
					//contentType:"application/json;charset=utf-8",
					success:function(result){
						if(result){
							 var result=eval("("+result+")"); 
							 var shop=result['shop'];
							 var recordtime=result['recordtime'];
                             var hotword=[];
                             var pc=[];
                             var app=[];
                             var type=[];
                             var data=result['typedata'];
							 for(key in data){
							 	type.push(key);
							 	pc.push(data[key]['pc']);
							 	app.push(data[key]['app']);
							 	hotword.push(data[key]['hotword']);
							 }
							 option.yAxis[0].data=type;
							 option.series[0].data=hotword;
							 option.series[1].data=app;
							 option.series[2].data=pc;
							 option.title[0].text=shop+recordtime;
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
			$("#btn2").click(function(){
				show2();
			})
			$('#li1 li a').click(function(){
			$("input#shop").val($(this).text());
		    })
			$('#li2 li a').click(function(){
				    $("input#begindate").val($(this).text());
			})
			$('#li3 li a').click(function(){
			   $("input#enddate").val($(this).text());
		})
		})
		</script>
		
	</body>
</html>
