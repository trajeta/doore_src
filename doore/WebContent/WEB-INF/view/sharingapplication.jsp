<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"
	import="java.util.*,com.bit.java54th.softdrink.doore.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>공유신청!</title>

</head>
<body>

	<form name="sharingForm" action="<c:url value='/action/sharing'/>"
		method="get">

		<p>
			<strong>공유신청페이지^^</strong>
		</p>

		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>상세정보</th>
			</tr>
			<tr>
				<td>소유자: ${product.customer_id}</td>
				<td>사진: ${product.product_picture}</td>
				<td>카테고리: ${product.category_id}</td>
				<td>물품명: ${product.product_name}</td>
				<td>detail key: ${product.detail_key}</td>
				<td>detail value: ${product.detail_value}</td>
			</tr>
		</table>
		<br /> <strong>예약현황</strong>
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<c:forEach var="item" items="${sharings}">
					<td>시작일: ${item.startDay}</td>
					<td>종료일: ${item.endDay}</td>
					<td>신청자id:${item.applicationID}</td>
			</tr>
			</c:forEach>
		</table>
		<br />
	</form>

	<form name="checkoutForm" action="<c:url value='/action/checkout'/>"
		method="get">
		<input type='hidden' name='productid' value='${product.product_id}' />
		
		<p>startDay</p>
		<input type='text' name='startDay' />
		<p>endDay</p>
		<input type='text' name='endDay' /><br /> <br />
		<input type="submit" value="공유신청">
	</form>

</body>
</html>