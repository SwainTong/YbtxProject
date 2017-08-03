<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资计算页面</title>
<link rel="shortcut icon" href="images/timg.ico" type="image/X-icon"/>
<link rel="stylesheet" href="css/mainDD.css">
<link rel="stylesheet" href="css/bootstrap.minDD.css">
<link rel="stylesheet" href="css/demoDD.css">
<link rel="stylesheet" href="css/animateDD.css" type='text/css' />
<link rel="stylesheet" href="css/styleDD.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/bootstrapDD.css" type='text/css' />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Owl Stylesheets -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Studeon Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Oswald:400,700,300|Open+Sans:300italic,400italic,600italic,400,300,600,700' rel='stylesheet' type='text/css'>
<!--//webfont-->
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<!-- 先检查有没有登录 以及登录身份，登录后才可以进行成员管理 -->
<%-- <% 
	 String userPosition = (String)session.getAttribute("userPosition");
	System.out.println(userPosition+"--界面");
     if(userPosition==null)
     {
    	 request.setAttribute("msg", "您尚未登录，请先登录，来自成员管理");
%>
   <jsp:forward page="login.jsp"></jsp:forward>
<%	
	} 
     else{
		if(userPosition.equals("干事"))
		{
			 request.setAttribute("msg", "您无人员管理权限！");
%>
			 <jsp:forward page="login.jsp"></jsp:forward>
<%}}%> --%>

<!-- 从数据库查询每个员工的工资信息 -->
<%-- <c:if test="${empty requestScope.EmployeeWageList}">
	<jsp:forward page="Make_searchEmployeeWage"></jsp:forward>
</c:if> --%>

<body>
<!-- 标题头  -->
	<div class="header box css3-shadow" id="head">
		<div class="container">
			<div class="header-top">
				<div class="logo wow bounceInLeft" data-wow-delay="0.4s">
					<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
				 </div>
			     <div class="h_menu4"><!-- start h_menu4 -->
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li><a href="index.jsp">产品管理</a></li>
						<li><a href="register_search">纳新管理</a></li>
						<li><a href="memberManager.jsp">成员管理</a></li>
						<li><a href="memberSearch.jsp">成员查询</a></li>
						<li><a href="activityManager.jsp">活动管理</a></li>
						<li><a href="material_search">物资管理</a></li>
					</ul>
					<div style="position: absolute;top: 22px;right: 50px;">
						<c:if test="${sessionScope.username == null}">
							<a href="login.jsp">登录</a>
						</c:if>
						<a href="exit.jsp" style="align-self: auto;">${sessionScope.name}</a>
					</div>
					<script type="text/javascript" src="js/nav.js"></script>
				</div><!-- end h_menu4 -->
				
	
				<div class="clearfix"> </div>
				
			  </div><!-- end header_main4 -->
		</div>
	</div>
<!-- 表格部分 -->
 <tr><td id="info1"></td></tr>
<div class="header box css3-shadow" id="head">
	<div class="slider-bg">
		<div class="row">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">工资统计
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="MakeRecordAdd.jsp">添加记录</a></h3>
				</div>
				<div class="panel-body">
					<form action="Make_searchEmployeeWage" method="post" style="font-size: 17px;" class="container">
						开始时间&nbsp;&nbsp;<input type="Date" name="startDate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						截止时间&nbsp;&nbsp;<input type="Date" name="endDate">&nbsp;&nbsp;
						<input type="submit" value="查询"><br><br>
					</form>
					<table class="table table-striped">
						<tr>
							<th>员工姓名</th>
							<th>工资</th>
						</tr>
						<c:forEach items="${requestScope.EmployeeWageList}" var="employeeWage">
							<tr>
								<td>${employeeWage[0]}</td>
								<td>${employeeWage[1]}</td>
							</tr>
						</c:forEach>
						<tr style="font-size: 30px;">
							<td>总计</td>
							<td>${requestScope.totalWage}</td>
						</tr>
					</table>
					<%-- 每页${requestScope.makePage.pageSize}条记录 
					总共${requestScope.makePage.totalPage}页
					当前：第${requestScope.makePage.currentPage} / ${requestScope.makePage.totalPage}页
					请选择：第
					<c:forEach begin="1" end="${requestScope.makePage.totalPage}" step="1" var="i">
						<c:if test="${i==requestScope.makePage.currentPage}">
							【${i}】
						</c:if>
						<c:if test="${i!=requestScope.makePage.currentPage}">
							<a href="Make_findAll?currentPage=${i}">${i}</a>
						</c:if>
					</c:forEach>
					页 --%>
				</div>
			</div>
		</div>
	</div>
</div>

<!--尾注部分--><!--/start-copyright-section-->
	<div class="clearfix"></div>
		<div class="copyright">
			<div class="container">
				<div class="logo2  wow bounceInLeft" data-wow-delay="0.4s"><a href="index.html"><img src="images/logo2.png" alt=""/ title="logo" /></a></div>
				<p class="write  wow bounceInRight" data-wow-delay="0.4s">Copyright &copy; 2015<a href="http://nankai.edu.cn" target="_blank" title="南开大学">南开大学社团联合会</a></p>
			</div>
			<div class="clearfix"></div>
		</div>
</body>
</html>