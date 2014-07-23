<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"
	import="java.util.*,com.bit.java54th.softdrink.doore.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>물품등록!</title>
</head>
<body>
<form name="sharingForm" action="<c:url value='/action/sharing'/>"
		method="get">
		<input type='text' size='3' name='productid' />
		 <input type="submit"
			value="물품클릭">
	</form>
</body>
</html>