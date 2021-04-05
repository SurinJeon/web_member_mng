<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.id eq null }">
	<c:redirect url="loginForm.jsp" />
</c:if> 
<c:set var="id" value="${sessionScope.id}" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 메인 페이지</title>
<!-- <link rel="stylesheet" href="css/loginForm_style.css"> --> <!-- 여기 css 나중에 손보기 -->
</head>
<body>
	<h3>${id }로 로그인하셨습니다.</h3>
	
	<a href="logoutProcess">로그아웃</a>
	<!-- id이름이 admin(관리자)일 경우에만 밑의 a태그 나옴 -->
	<c:if test="${id eq 'admin'}">
		<a href="memberList">관리자모드 접속(회원 목록 보기)</a>
	</c:if>
	
	<script type="text/javascript">
		window.history.forward();
		function noBack(){
			window.history.forward();
		}
	</script>
</body>
</html>