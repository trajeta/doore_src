<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"
	import="java.util.*,com.bit.java54th.softdrink.doore.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>공유완료페이지</title>
</head>
<body>
	<P>${login.customerName}님공유신청이 완료되었습니다^^</P>
	<p>insert result: ${result}</p>
	<p>공유시작일: ${startday}</p>
	<p>공유완료일: ${endday}</p>

</body>
</html>