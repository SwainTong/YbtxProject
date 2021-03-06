<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>工资详情</title>
  <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
  <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/exporting.js"></script>
 <%--  <!-- 先把要用到的数据拿出来,即工人每天的工资表 -->
  <c:if test="${empty requestScope.employeeWageByDay}">
	<jsp:forward page="Make_employeeWageByDay"></jsp:forward>
  </c:if> --%>

  <script>
  	
	
	
    $(function () {
    $('#container').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '工资统计'
        },
        subtitle: {
            text: '数据来源: 素青纺织品来料加工'
        },
        xAxis: {
        	
            categories:  ['1','2']//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'] 
        },
        yAxis: {
            title: {
                text: '工资 (￥)'
            }
        },
        tooltip: {
            enabled: false,
            formatter: function() {
                return '<b>'+ this.series.name +'</b>'+this.x +': '+ this.y +'°C';
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
        	name:'张三',
            data: wage
        }]
    });
  });
  </script>
</head>
<body>
  <div id="container" style="min-width:700px;height:400px"></div>
  <table style="margin-left: 630px;">
  <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
  <tr><td style="width: 140px;font-size: 20px;background-color: #fff;">工资表</td></tr>
  <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
  </table>
  <script>
		//获取json传来的每日工资
  		var WageByDay = '<%=request.getAttribute("employeeWageByDay")%>'
  		obj = JSON.parse(WageByDay);
  		var wage = new Array();
  		for(var i = 0;i<= 31;i++){
			wage.push(0);
		}
  		for(var i = 0; i < obj.length; i++)
		{
			wage[obj[i].date] = obj[i].wage;
		}
			
		//表格
		var htmlstr = "<table border='0px' style=\"margin-left: 300px;\">";
		var k = 0;
		for(var i = 0; i < wage.length-1; i++,k++) {
			if(k % 6 == 0)
			{
				htmlstr += "<tr style=\"background-color: #c0c0c0;\">";
				k++;
			}
			
			htmlstr += "<td style=\"width: 60px;font-size: 20px;\">" + (i+1)+"号"+ "</td>";
			htmlstr += "<td style=\"width: 80px;font-size: 20px\">" + wage[i] + "</td>";
			if((k+1) % 6 == 0)
			{
				htmlstr += "</tr><tr><td>&nbsp</td></tr>";
			}
		}
		htmlstr += "</table>";
		document.write(htmlstr); 
	
  		
  		
  		
  </script>	
</body>
</html>