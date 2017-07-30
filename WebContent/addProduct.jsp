<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
</head>
<body>
	<form action="Product_add" method="post">
		产品编号<input type="text" name="productId" placeholder="产品编号" value="619"><br>
		产品名称<input type="text" name="productName" placeholder="产品名称" value="619"><br>
		产品类别<input type="text" name="productType" placeholder="产品类别" value="内衬"><br>
		产品数量<input type="text" name="productAmount" placeholder="产品数量" value = "0"><br>
		产品工钱<input type="text" name="productWage" placeholder="产品工钱" value="6"><br>
		产品总价<input type="text" name="productMargin" placeholder="产品总价" value="9"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>