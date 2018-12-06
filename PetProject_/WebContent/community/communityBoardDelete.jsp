<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int boardNum = (Integer)request.getAttribute("boardNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<form action="communityBoardDeleteAction.bo?boardNum=<%=boardNum %>" method="POST">
		<h3>비밀번호를 입력하세요.<h3>
		<input type="password" name="COMMUNITY_PASS" autofocus="autofocus" required="required"><br><br>
		<input type="submit" value="삭제하기">
		<input type="button" value="취소" onClick ="javascript:history.go(-1)">
		
		<a href="commentBoard.jsp?boardNum=<%=boardNum %>%>">댓글 달기</a>
	</form>
</body>
</html>