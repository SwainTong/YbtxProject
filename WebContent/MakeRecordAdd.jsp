<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加生产记录</title>
</head>

 <!-- 进入之前，先从数据库把员工和产品信息给找出来 -->
<c:if test="${empty requestScope.employeePage}">
	<jsp:forward page="Employee_findAll?usage=MakeRecordAdd"></jsp:forward>
</c:if>
<c:if test="${empty requestScope.productPage}">
	<jsp:forward page="Product_findAll"></jsp:forward>
</c:if>
 
<body>
	<form action="Make_add" method="post" style="align-content: center;">
		日期<input type="date" name="makeDate" ><br>
		员工姓名
		<select name="employeeId" style="font-size: 20px;width: 100px;">
			<c:forEach items="${requestScope.employeePage.dataList}" var="employee">
		    	<option value="${employee.employeeId}">${employee.employeeName}</option>
			</c:forEach>
    	</select><br>
		产品
		<select name="productId" style="font-size: 20px;width: 150px;">
			<c:forEach items="${requestScope.productPage.dataList}" var="product">
		    	<option value="${product.productId}">${product.productType}${product.productName}</option>
			</c:forEach>
    	</select><br>
		数量<input type="text" name="makeAmount" ><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>