<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts3.7.1.js "></script>
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts-gl.js "></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
     <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> 
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<body>
	<div class="jumbotron">
		<div id="main" style="width: 1500px;height:700px;"></div>		
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
			
 var xdata = ['12a', '1a', '2a', '3a', '4a', '5a', '6a',
        '7a', '8a', '9a','10a','11a',
        '12p', '1p', '2p', '3p', '4p', '5p',
        '6p', '7p', '8p', '9p', '10p', '11p'];
var ydata = ['Saturday', 'Friday', 'Thursday',
        'Wednesday', 'Tuesday', 'Monday', 'Sunday'];

var zdata = [[0,0,5],[0,1,1],[0,2,0],[0,3,0],[0,4,0],[0,5,0],[0,6,0],[0,7,0],[0,8,0],[0,9,0],[0,10,0],[0,11,2],[0,12,4],[0,13,1],[0,14,1],[0,15,3],[0,16,4],[0,17,6],[0,18,4],[0,19,4],[0,20,3],[0,21,3],[0,22,2],[0,23,5],[1,0,7],[1,1,0],[1,2,0],[1,3,0],[1,4,0],[1,5,0],[1,6,0],[1,7,0],[1,8,0],[1,9,0],[1,10,5],[1,11,2],[1,12,2],[1,13,6],[1,14,9],[1,15,11],[1,16,6],[1,17,7],[1,18,8],[1,19,12],[1,20,5],[1,21,5],[1,22,7],[1,23,2],[2,0,1],[2,1,1],[2,2,0],[2,3,0],[2,4,0],[2,5,0],[2,6,0],[2,7,0],[2,8,0],[2,9,0],[2,10,3],[2,11,2],[2,12,1],[2,13,9],[2,14,8],[2,15,10],[2,16,6],[2,17,5],[2,18,5],[2,19,5],[2,20,7],[2,21,4],[2,22,2],[2,23,4],[3,0,7],[3,1,3],[3,2,0],[3,3,0],[3,4,0],[3,5,0],[3,6,0],[3,7,0],[3,8,1],[3,9,0],[3,10,5],[3,11,4],[3,12,7],[3,13,14],[3,14,13],[3,15,12],[3,16,9],[3,17,5],[3,18,5],[3,19,10],[3,20,6],[3,21,4],[3,22,4],[3,23,1],[4,0,1],[4,1,3],[4,2,0],[4,3,0],[4,4,0],[4,5,1],[4,6,0],[4,7,0],[4,8,0],[4,9,2],[4,10,4],[4,11,4],[4,12,2],[4,13,4],[4,14,4],[4,15,14],[4,16,12],[4,17,1],[4,18,8],[4,19,5],[4,20,3],[4,21,7],[4,22,3],[4,23,0],[5,0,2],[5,1,1],[5,2,0],[5,3,3],[5,4,0],[5,5,0],[5,6,0],[5,7,0],[5,8,2],[5,9,0],[5,10,4],[5,11,1],[5,12,5],[5,13,10],[5,14,5],[5,15,7],[5,16,11],[5,17,6],[5,18,0],[5,19,5],[5,20,3],[5,21,4],[5,22,2],[5,23,0],[6,0,1],[6,1,0],[6,2,0],[6,3,0],[6,4,0],[6,5,0],[6,6,0],[6,7,0],[6,8,0],[6,9,0],[6,10,1],[6,11,0],[6,12,2],[6,13,1],[6,14,3],[6,15,4],[6,16,0],[6,17,0],[6,18,0],[6,19,0],[6,20,1],[6,21,2],[6,22,2],[6,23,6]];
 
			myChart.setOption(
				option = {
						  title: {
						        text: 'Wheater Statistics'
						    },
    tooltip: {
    	show:'true'
    },
    visualMap: {
        max: 20,
        inRange: {
            color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
        }
    },
    xAxis3D: {
        type: 'category',
        name:'款式',
        data: xdata
    },
    yAxis3D: {
       type: 'category',
       //type: 'time',
       //type: 'value',
        name:'日期',
        data: ydata
    },
    zAxis3D: {
    	name:'app流量',
        type: 'value'
    },
    grid3D: {
        boxWidth: 200,
        boxDepth: 80,
        viewControl: {
            // projection: 'orthographic'
        },
        light: {
            main: {
                intensity: 1.2,
                shadow: true
            },
            ambient: {
                intensity: 0.3
            }
        }
    },
    series: [{
        type: 'bar3D',
        data: zdata.map(function (item) {
            return {
                value: [item[1], item[0], item[2]],
            }
        }),
        shading: 'realistic',
        itemStyle: {
            opacity: 0.8
        },
        label: {
            textStyle: {
                fontSize: 16,
                borderWidth: 1
            }
        },

        emphasis: {
            label: {
                textStyle: {
                    fontSize: 20,
                    //color: '自适应'
                }
            },
            itemStyle: {
               // color: '自适应'
            }
        }
    }]
}
			)
			 
			
		</script>
		<script type="application/javascript">
			function show(){
				var option=myChart.getOption();
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
							var app=[];
							var typedata=result['typedata'];
							var type=[];
							var data=[];
							var appcdata=[];
							for(key in typedata){
								type.push(key)
								data.push([key,recordtime,typedata[key]['app']])
						
								
							}
							option.title[0].text=shop+recordtime;
							//非要设置成[0]才出现
							//xdata=type;
							option.xAxis3D[0].data=type;
							//console.log(xdata);
							//ydata=recordtime;
							option.yAxis3D[0].data=recordtime;
							console.log(option.yAxis3D[0].data);
							//zdata=data;
							option.series[0].data=data.map(function (item) {
					            return {
					                value: [item[0], item[1], item[2]],
					            }
					        });
							//console.log(option.series[0].data);
							//console.log(zdata);
							/* option.legend[0].data=type;
							option.series[0].data=appcdata;
							option.series[1].data=data;   */
							
							//console.log();
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
				$.ajax({
					type:"post",
					url:"http://localhost:8080/libraryone/shengejing/longdayshow3D",
					async:false,
					datatype:"json",
					data: {shop:$("input#shop").val(),
						begindate:$("input#begindate").val(),
						    enddate:$("input#enddate").val()},
					//contentType:"charset=utf-8",
					success:function(result){
						if(result){
							var result=eval("("+result+")");
							//最终的recordtime
							var listrecordtime=[];
							var shop=[];
							//最终的type
							var alltype=[];
							var alldata=[];
							for(var i=0;i<result.length;i++){
								var shops=result[i]['shop'];
								var recordtime=result[i]['recordtime'];
								var app=[];
								var typedata=result[i]['typedata'];
								var type=[];
								var data=[];
								var alldate=[];
								var appcdata=[];
								for(key in typedata){
									type.push(key);
									/* data.push([key,recordtime,typedata[key]['app']]); */
									alldata.push([key,recordtime,typedata[key]['app']]);
								}
								listrecordtime.push(recordtime);
								
								shop=shops;
								alltype=type;
								//alldata.push(data);	
								
								//console.log("data:"+data);
								console.log("alldata:"+alldata);
							}
							option.title[0].text=shop+"一段时间";
							//非要设置成[0]才出现
							//xdata=type;
							//console.log(alltype);
							option.xAxis3D[0].data=alltype;
							console.log(option.xAxis3D[0].data);
							//ydata=recordtime;
							//console.log(listrecordtime);
							option.yAxis3D[0].data=listrecordtime;
							console.log(option.yAxis3D[0].data);
							//zdata=data;
							option.series[0].data=alldata.map(function (item) {
					            return {
					                value: [item[0], item[1], item[2]],
					            }
					        });
							console.log(option.series[0].data);
							myChart.hideLoading();
						    myChart.setOption(option);

						};						
					},
					error:function(error){
						alert("后台请求数据失败");
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
