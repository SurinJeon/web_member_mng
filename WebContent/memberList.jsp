<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 관리자모드(회원 목록 보기)</title>
<link rel="stylesheet" href="css/loginForm_style.css">
</head>
<body>
	<h2>회원 관리 시스템 관리자모드(회원 목록 보기)</h2>
	<table>
			<c:forEach var="member" items="${list }">
		<tr>
			<td><a href="memberInfo?id=${member.id }"> ${member.id }</a></td>			
			<td><a href="memberDelete?id=${member.id }"><button>삭제</button></a></td>
		</tr>
			</c:forEach>
	</table>

	<a href="joinForm.jsp"><button>회원 추가하기</button></a>
	<a href="main.jsp"><button>메인으로</button></a>
</body>
</html>