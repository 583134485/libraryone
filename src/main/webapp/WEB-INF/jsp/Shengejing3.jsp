<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
 <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts3.7.1.js "></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
     <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> 
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<body>
	<div class="jumbotron">
		<div id="main" style="width: 1400px;height:700px;"></div>		
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
			myChart.setOption(
				option = {
					    title: {
					    	top:'auto',
					    	left:'center',
					        text: 'Wheater Statistics'
					    },
				
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    toolbox: {
        show: true,
        feature: {
        	dataView : {show: true, readOnly: true},
        	restore : {show: true},
            saveAsImage: {}
        }
    },
    legend: {
        type: 'scroll',
        left: 'left',
        orient: 'horizontal',
        bottom:'1%',
        show:true,
        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series: [
        {
            name:'总流量',
            type:'pie',
            selectedMode: 'single',
            radius: ['10%', '25%'],

            label: {
                normal: {
                	show: false,
                    position: 'center'
                    
                },
        emphasis: {
            show: true,
            
            fontSize: '20',
            fontWeight: 'bold'
            
        }
            },
/*             labelLine: {
                normal: {
                    show: true
                }
            }, */
            data:[
                {value:335, name:'直达', selected:true},
                {value:679, name:'营销广告'},
                {value:1548, name:'搜索引擎'}
            ]
        },
        {
            name:'app流量',
            type:'pie',
            radius: ['30%', '45%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
/*                     show: false,
                    position: 'center', */
                        formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                        backgroundColor: '#eee',
                        borderColor: '#aaa',
                        borderWidth: 1,
                        borderRadius: 4,
                         shadowBlur:3,
                         shadowOffsetX: 2,
                         shadowOffsetY: 2,
                         shadowColor: '#999',
                         padding: [0, 7],
                        rich: {
                            a: {
                                color: '#999',
                                lineHeight: 22,
                                align: 'center'
                            },
                            // abg: {
                            //     backgroundColor: '#333',
                            //     width: '100%',
                            //     align: 'right',
                            //     height: 22,
                            //     borderRadius: [4, 4, 0, 0]
                            // },
                            hr: {
                                borderColor: '#aaa',
                                width: '100%',
                                borderWidth: 0.5,
                                height: 0
                            },
                            b: {
                                fontSize: 16,
                                lineHeight: 33
                            },
                            per: {
                                color: '#eee',
                                backgroundColor: '#334455',
                                padding: [2, 4],
                                borderRadius: 2
                            }
                        }
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: true
                }
            },
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ]
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
								type.push(
									key+'all'
								);
								data.push({
									name:key+'app',
									value:typedata[key]['app']
								})
								data.push({
									name:key+'pc',
								    value:typedata[key]['pc']
								})
								appcdata.push({
									name:key+'all',
									value:Number(typedata[key]['pc'])+Number(typedata[key]['app'])
								})
								
						
								
							}
							option.title[0].text=shop+recordtime;
							//非要设置成[0]才出现
							option.legend[0].data=type;
							option.series[0].data=appcdata;
							option.series[1].data=data;  
							
							console.log(option.legend[0].data);
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
							var app=[];
							var typedata=result['typedata'];
							var type=[];
							var data=[];
							var appcdata=[];
							for(key in typedata){
								type.push(
									key+'all'
								);
								data.push({
									name:key+'app',
									value:typedata[key]['app']
								})
								data.push({
									name:key+'pc',
								    value:typedata[key]['pc']
								})
								appcdata.push({
									name:key+'all',
									value:Number(typedata[key]['pc'])+Number(typedata[key]['app'])
								})
								
						
								
							}
							option.title[0].text=shop+recordtime;
							//非要设置成[0]才出现
							option.legend[0].data=type;
							option.series[0].data=appcdata;
							option.series[1].data=data;  
							
							console.log(option.legend[0].data);
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
