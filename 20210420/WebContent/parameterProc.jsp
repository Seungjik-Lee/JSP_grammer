<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String a = request.getParameter("a");
String b = request.getParameter("b");
out.print("a = " + a);
out.print("a = " + b);

String c = request.getParameter("c");
out.print("c = " + c);
%>
</body>
</html>