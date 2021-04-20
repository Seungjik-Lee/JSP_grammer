<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer se_a = (Integer)session.getAttribute("a");
		String se_id = (String)session.getAttribute("id");
		String se_b = (String)session.getAttribute("b");
	
		out.println("se_a = "+se_a);
		out.println("se_id = "+se_id);
		out.println("se_b = "+se_b);
	%>
</body>
</html>