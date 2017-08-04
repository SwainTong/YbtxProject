<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加产品</title>
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
					<h3 class="wow bounceIn" data-wow-delay="0.4s">添加产品</h3>
					<p class="wow fadeInUpBig animated" data-wow-delay="0.4s"></p>
						<form class="wow bounceIn" data-wow-delay="0.4s" action="Product_add" method="post">
							编号&nbsp;<input type="text" placeholder="产品编号" required=" " name="productId"><br>
							名称&nbsp;<input type="text" name="productName" placeholder="产品名称" ><br>
							类别&nbsp;<input type="text" name="productType" placeholder="产品类别" ><br>
							<input type="hidden" name="productAmount" placeholder="产品数量" value="0">
							工钱&nbsp;<input type="text" name="productWage" placeholder="产品工钱" ><br>
							总价&nbsp;<input type="text" name="productMargin" placeholder="产品总价" ><br><br><br>
							<input type="submit" value="添加">
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
						  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
						  <p class="sub">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	
		<a href="#head" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>		
</body>
</html>