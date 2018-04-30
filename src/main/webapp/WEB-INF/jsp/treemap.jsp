<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
  
    <script  type="text/javascript" src="<%=request.getContextPath() %>/static/js/echarts.js "></script>
	   <script src="http://cdn.staticfile.org/jquery/3.2.1/jquery.js">
</script>
</head>
<body>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1000px;height:800px;"></div>
 
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
          var myChart = echarts.init(document.getElementById('main')); 
myChart.showLoading();

var household_america_2012 = 113616229;
$.get("showtreemap", function (obama_budget_2012) {
	obama_budget_2012= eval("("+obama_budget_2012+")")
    myChart.hideLoading();

    var visualMin = -100;
    var visualMax = 100;
    var visualMinBound = -40;
    var visualMaxBound = 40;

    convertData(obama_budget_2012);

    function convertData(originList) {
    	
        var min = Infinity;
        var max = -Infinity;

        for (var i = 0; i < originList.length; i++) {
            var node = originList[i];
            if (node) {
                var value = node.value;
                value[2] != null && value[2] < min && (min = value[2]);
                value[2] != null && value[2] > max && (max = value[2]);
            }
        }

        for (var i = 0; i < originList.length; i++) {
            var node = originList[i];
            if (node) {
                var value = node.value;

                // Scale value for visual effect
                if (value[2] != null && value[2] > 0) {
                    value[3] = echarts.number.linearMap(
                        value[2], [0, max], [visualMaxBound, visualMax], true
                    );
                }
                else if (value[2] != null && value[2] < 0) {
                    value[3] = echarts.number.linearMap(
                        value[2], [min, 0], [visualMin, visualMinBound], true
                    );
                }
                else {
                    value[3] = 0;
                }

                if (!isFinite(value[3])) {
                    value[3] = 0;
                }

                if (node.children) {
                    convertData(node.children);
                }
            }
        }
    }


    function isValidNumber(num) {
        return num != null && isFinite(num);
    }

    myChart.setOption(option = {
        title: {
            left: 'center',
            text: 'zengliu旗舰店',
            subtext: 'Growth > 0: green; Growth < 0: red; Growth = 0: grey'
        },
        tooltip: {
            formatter: function (info) {
                var value = info.value;

                var amount = value[0];
                amount = isValidNumber(amount)
                    ? echarts.format.addCommas(amount ) + '件'
                    : '-';

                var amount2011 = value[1];
                amount2011 = isValidNumber(amount2011)
                    ? echarts.format.addCommas(amount2011 ) + '元'
                    : '-';

                var change = value[2];
                change = isValidNumber(change)
                    ? change + '库存'
                    : '-';

                return [
                    '<div class="tooltip-title">' + echarts.format.encodeHTML(info.name) + '</div>',
                    'totalSale: &nbsp;&nbsp;' + amount + '<br>',
                    'tprice: &nbsp;&nbsp;' + amount2011 + '<br>',
                    'stock: &nbsp;&nbsp;' + change
                ].join('');
            }
        },
        series: [{
            name: 'ALL',
            top: 80,
            type: 'treemap',
            label: {
                show: true,
                formatter: "{b}",
                normal: {
                    textStyle: {
                        ellipsis: true
                    }
                }
            },
            itemStyle: {
                normal: {
                    borderColor: 'black'
                }
            },
            visualMin: visualMin,
            visualMax: visualMax,
            visualDimension: 3,
            levels: [
                {
                    itemStyle: {
                        normal: {
                            borderWidth: 3,
                            borderColor: '#333',
                            gapWidth: 3
                        }
                    }
                },
                {
                    color: ['#942e38', '#aaa', '#269f3c'],
                    colorMappingBy: 'value',
                    itemStyle: {
                        normal: {
                            gapWidth: 1
                        }
                    }
                }
            ],
            data: obama_budget_2012
        }]
    });


});

    </script>
</body>
</html>