<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 가입 페이지</title>
</head>
<body>
	<form name="joinForm" action="joinProcess" method="get">
	<h2 class="td_title">회원 가입 페이지</h2>
		<table>
			<tr>
				<td><label for="id">아이디: </label> </td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			
			<tr>
				<td><label for="pass">비밀번호: </label> </td>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			
			<tr>
				<td><label for="name">이름: </label> </td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			
			<tr>
				<td><label for="age">나이: </label> </td>
				<td><input type="text" name="age" id="age"></td>
			</tr>
			
			<tr>
				<td><label for="gender1">성별: </label> </td>
				<td><input type="radio" name="gender" value="남자" checked id="gender1">남자
				<input type="radio" name="gender" value="여자" id="gender2">여자</td>
			</tr>
			
			<tr>
				<td><label for="email">이메일 주소: </label> </td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<a href="javascript: joinForm.submit()">회원가입</a> &nbsp;&nbsp;
					<a href="javascript: joinForm.reset()">다시작성</a>
				</td>
			</tr>
		</table>
	</form>		
</body>
</html>