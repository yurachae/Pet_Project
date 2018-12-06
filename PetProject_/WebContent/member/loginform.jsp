<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>loginForm.jsp 파일입니다.</h1>
	<br>
	<form action ="login" method="post">
		<!-- name 속성 : 서버로 넘겼을 때 서버에서 사용하도록 됨, id 속성 : 현재 페이지 용 -->
		<!-- name 속성 값은 서버로 넘겼을 때의 변수이다. -->
		아이디 : <input type="text" name="id" id="id" /><br>
		비밀번호 : <input	type="password" name="password" id="password" /><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>