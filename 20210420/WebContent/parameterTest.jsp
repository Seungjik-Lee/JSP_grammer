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
		/* 
		-파라메타 전송방법
		1. form 태그로 감싸서 보내는 방식
		2. 주소에 parameterProc.jsp?a=10&b=20
		   ㄴ (특징) 다음 페이지에서 변수로 작동
		   
		-세션으로 전송방법
		1.session 객체를 사용
		2.setAtrribute("이름", "값") // 설정 사용함수
		3.getAttribute("이름") // 가져올 때 사용하는 함수
		4.session.invalidate() // 
		    ㄴ (특징) 브라우저가 닫기기 전까지 변수로 작동 
		          
		*/
	%>
	<!-- form 태그로 감싸서 파라메터 보내기 -->
	<form action="parameterProc.jsp">
		a = <input type="text" name="a" />
		b = <input type="text" name="b" />
		<input type="submit" value="확인" />
	</form>

	<!-- 주소로 파라메터 보내기 -->
	<a href="parameterProc.jsp?a=10">a값 보내기</a>

	<%
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		out.print("a = " + a);
		out.print("a = " + b);

		String c = request.getParameter("c");
		out.print("c = " + c);
		
		Integer se_a = (Integer)session.getAttribute("a");
		String se_id = (String)session.getAttribute("id");
		String se_b = (String)session.getAttribute("b");
	
		out.println("se_a = "+se_a);
		out.println("se_id = "+se_id);
		out.println("se_b = "+se_b);
	%>
</body>
</html>