<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
</head>
<body>
<div id="main" <!-- style="height:400px -->"></div>
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
                	'echarts/chart/treemap',               	
                ], DrawEChart //异步加载的回调函数绘制图表 
            );
      function DrawEChart(ec) { 
    	  eCharts = ec; 
          myChart = eCharts.init(document.getElementById('main')); 
          <%-- var uploadedDataURL = "<%=request.getContextPath() %>/static/echarts2.json"; --%>

          myChart.showLoading();

          $.post("treemap2", function (diskData) {
              myChart.hideLoading();

              function colorMappingChange(value) {
                  var levelOption = getLevelOption(value);
                  chart.setOption({
                      series: [{
                          levels: levelOption
                      }]
                  });
              }

              var formatUtil = echarts.format;

              function getLevelOption() {
                  return [
                      {
                          itemStyle: {
                              normal: {
                                  borderWidth: 0,
                                  gapWidth: 5
                              }
                          }
                      },
                      {
                          itemStyle: {
                              normal: {
                                  gapWidth: 1
                              }
                          }
                      },
                      {
                          colorSaturation: [0.35, 0.5],
                          itemStyle: {
                              normal: {
                                  gapWidth: 1,
                                  borderColorSaturation: 0.6
                              }
                          }
                      }
                  ];
              }

              myChart.setOption(option = {

                  title: {
                      text: 'Disk Usage',
                      left: 'center'
                  },

                  tooltip: {
                      formatter: function (info) {
                          var value = info.value;
                          var treePathInfo = info.treePathInfo;
                          var treePath = [];

                          for (var i = 1; i < treePathInfo.length; i++) {
                              treePath.push(treePathInfo[i].name);
                          }

                          return [
                              '<div class="tooltip-title">' + formatUtil.encodeHTML(treePath.join('/')) + '</div>',
                              'Disk Usage: ' + formatUtil.addCommas(value) + ' KB',
                          ].join('');
                      }
                  },

                  series: [
                      {
                          name:'Disk Usage',
                          type:'treemap',
                          visibleMin: 300,
                          label: {
                              show: true,
                              formatter: '{b}'
                          },
                          itemStyle: {
                              normal: {
                                  borderColor: '#fff'
                              }
                          },
                          levels: getLevelOption(),
                          data: diskData
                      }
                  ]
              });
          });
  
</body>


    
</html>