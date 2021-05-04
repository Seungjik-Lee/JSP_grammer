<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spro.com.org.SPRO_SeatDBManager"%>
<%@ page import="spro.com.org.SPRO_SeatUse"%>
<%@ page import="java.util.ArrayList"%>
<%
	SPRO_SeatDBManager ssdm = new SPRO_SeatDBManager();
	ArrayList<SPRO_SeatUse> list = ssdm.select();
	out.print("list.size() =" + list.size());
	for (int i = 0; i < list.size(); i++) {
		SPRO_SeatUse ssu = list.get(i);
		out.println("ssu.getM_time() = " + ssu.getM_time() + "<br/>");
		out.println("ssu.getName() = " + ssu.getName() + "<br/>");
		out.println("ssu.getPhone() = " + ssu.getPhone() + "<br/>");
		out.println("ssu.getNum() = " + ssu.getNum() + "<br/>");
	}
%>
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
<link rel="stylesheet" href="/spro/css/mycss.css" />
<style type="text/css">
.mybgwh {
	background-color: #555;
	color: white;
}
</style>
</head>
<body>
	<div class="container mybgwh">
		판리자 화면입니다
		<table class="table table-dark table-hover text-center">
			<thead>
				<tr>
					<td>좌석</td>
					<td>이름</td>
					<td>연락처</td>
					<td>충전시간</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < list.size(); i++) {
						SPRO_SeatUse ssu = list.get(i);
				%>
				<tr>
					<td><%out.print(ssu.getNum());%></td>
					<td><%out.print(ssu.getName());%></td>
					<td><%out.print(ssu.getPhone());%></td>
					<td><%out.print(ssu.getM_time());%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		현재 좌석 내용들 입니다.
	</div>
</body>
</html>