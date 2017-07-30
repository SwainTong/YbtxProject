<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加生产记录</title>
</head>
     
<body>
	<form action="Make_add" method="post">
		编号<input type="text" name="makeId" ><br>
		日期<input type="text" name="makeDate" ><br>
		员工姓名<input type="text" name="employeeId" ><br>
		产品<input type="text" name="productId" ><br>
		数量<input type="text" name="makeAmount" ><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>