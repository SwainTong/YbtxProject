<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加生产记录</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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

 <!-- 进入之前，先从数据库把员工和产品信息给找出来 -->
<c:if test="${empty requestScope.employeePage}">
	<jsp:forward page="Employee_findAll?usage=MakeRecordAdd"></jsp:forward>
</c:if>
<c:if test="${empty requestScope.productPage}">
	<jsp:forward page="Product_findAll"></jsp:forward>
</c:if>
<body>
	<div class="header box css3-shadow" id="head">
 	<div class="container">
	 <div class="header-top">
	        <div class="logo wow bounceInLeft" data-wow-delay="0.4s">
				<a href="index.html"><img src="images/logo.png" alt=""/></a>
			 </div>
		     <div class="h_menu4"><!-- start h_menu4 -->
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					
					<li><a href="index.jsp">首页</a></li>
					<li><a href="EmployeeManager.jsp">员工管理</a></li>
					<li><a href="ProductManager.jsp">产品管理</a></li>
					<li><a href="MakeRecordManager.jsp">记录管理</a></li>
					<li><a href="EmployeeWageCalculate.jsp">月账单</a></li>
					<li><a href="#">更多</a>
						<ul>
							<li><a href="#">Typography</a></li>
							<li><a href="#">Shortcodes</a></li>
							<li><a href="#">Columns</a></li>
							<li><a href="#">Pricing plans</a></li>
							<li><a href="#">Alerts</a></li>
							<li><a href="#">Services</a></li>
						</ul>
					</li>
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div><!-- end h_menu4 -->
			<div class="social_icons wow bounceInRight" data-wow-delay="0.4s">
					<ul>
						<li><a href="#"><i class="facebook"></i></a></li>
						<li><a href="#"><i class="twitter"></i></a></li>
						<li><a href="#"><i class="rss"></i></a></li>
						<li><a href="#"><i class="viemo"></i></a></li>
						<li><a href="#"><i class="youtube"></i></a></li>
						<li><a href="#"><i class="linkedin"></i></a></li>
					</ul>
				</div>

			<div class="clearfix"> </div>
			
		  </div><!-- end header_main4 -->
	</div>
</div>
<!--start-contact-->
		<div class ="contact-section">
			<div class="container">
				<div class="contact">
					<h3 class="wow bounceIn" data-wow-delay="0.4s">添加生产记录</h3>
					<p class="wow fadeInUpBig animated" data-wow-delay="0.4s"></p>
						<form class="wow bounceIn" data-wow-delay="0.4s" action="Make_add" method="post">
							日期&nbsp;<input type="date" name="makeDate" 
								style="border: 1px solid #DCDCDF; color:#000;height:50px;background:#fff;width: 25%;font-weight: 400;font-size: 10px; border-radius: 6px;"
							><br><br>
							姓名&nbsp;<select name="employeeId" 
								style="border: 1px solid #DCDCDF; color:#000;height:50px;background:#fff;width: 25%;font-weight: 400;font-size: 20px; border-radius: 6px;"
							>
								<c:forEach items="${requestScope.employeePage}" var="employee">
							    	<option value="${employee.employeeId}">${employee.employeeName}</option>
								</c:forEach>
					    	</select><br><br>
							产品&nbsp;<select name="productId" 
								style="border: 1px solid #DCDCDF; color:#000;height:50px;background:#fff;width: 25%;font-weight: 400;font-size: 20px; border-radius: 6px;"
							>
								<c:forEach items="${requestScope.productPage}" var="product">
							    	<option value="${product.productId}">${product.productType}${product.productName}</option>
								</c:forEach>
					    	</select><br>
							数量&nbsp;<input type="text" name="makeAmount" style="border: 1px solid #DCDCDF; color:#000;height:50px;background:#fff;width: 25%;font-weight: 400;font-size: 20px; border-radius: 6px;"><br><br>
							<input type="submit" value="提交">
						</form>
					</div>	
				</div>
			</div>
			
			
			<!--/start-footer-section-->
			<div class="footer-section">
				<div class="container">
					<div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
						<div class="col-md-3 footer-grid">
						<h4>About studeon</h4>
						<div class="border2"></div>
						  <p>素青纺织品加工, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
						  <p class="sub">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	
		<a href="#head" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>		
</body>
</html>