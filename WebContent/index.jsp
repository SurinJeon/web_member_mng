<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="web_member_mng.ds.JndiDS" %>

<c:set var="con" value="${JndiDS.getConnection() }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테스트</title>
<link rel="stylesheet" href="css/index_style.css">
</head>
<body>
 	<c:out value="con > ${con }"/> <!-- 이게 뜨면 연결 성공한 것 -->
</body>
</html>