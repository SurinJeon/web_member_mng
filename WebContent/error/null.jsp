<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Null error 발생</title>
</head>
<body>
	<strong>요청한 페이지는 존재하지 않습니다.</strong>
 	<br>
 	<br>
 	주소를 올바르게 입력하였는지 확인하세요.
 	<br>
 	발생한 예외 종류: <%=exception.getClass().getName() %>
	<br>
	에러 메시지: <%=exception.getMessage() %>
</body>
</html>