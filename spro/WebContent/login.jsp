<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="spro.com.org.SPRO_DBManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
		<h1>My StudyCafe</h1>
		<p>공부하자</p>
	</div>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	out.println("id = "+id);
	out.println("pw = "+pw);
	out.println("안녕하세요 ");
	
	SPRO_DBManager sdbm = new SPRO_DBManager();
	int ret = sdbm.ckLogin(id, pw);
	if(ret == 0){
		out.println("로그인 성공");
	}
	else {
		out.println("로그인 실패");
	}
%>
</body>
</html>