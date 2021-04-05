<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
	<h2>회원 정보</h2>
	<form action="memberUpdate">
	<table>
		<tr>
			<td><label for="id">아이디: </label> </td>
			<td><input type="text" name="id" id="id" value="${member.id }"></td>
		</tr>
		<tr>
			<td><label for="name">이름: </label> </td>
			<td><input type="text" name="name" id="name" value="${member.name }"></td>
		</tr>
		<tr>
			<td><label for="age">나이: </label></td>
			<td><input type="text" name="age" id="age" value="${member.age }"></td>
		</tr>
		<tr>
			<td><label for="gender1">성별: </label></td>
			<c:choose>
				<c:when test="${member.gender eq '남자' }">
					<td><input type="radio" name="gender" value="남자" checked id="gender1" checked>남자 <input type="radio" name="gender" value="여자" id="gender2">여자</td>
				</c:when>
				<c:otherwise>
					<td><input type="radio" name="gender" value="남자" checked id="gender1">남자 <input type="radio" name="gender" value="여자" id="gender2" checked>여자</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td><label for="email">이메일 주소: </label> </td>
			<td><input type="text" name="email" id="email" value="${member.email }"></td>
		</tr>
	</table>
	
	
	<button>수정하기</button>
	<a href="memberList"><button>리스트로 돌아가기</button></a>
	<a href="main.jsp"><button>메인으로</button></a>
	</form>
	

</body>
</html>