<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="communityBoardCommentWriteAction.bo" method="post">
		<input type="hidden" name="COMMENT_PARENT" value="${requestScope.COMMENT_PARENT }">
		<table align=center>
			<tr>
				<td><input type="text" name="COMMENT_ID" autocomplete="name"
					placeholder="작성자ID"></td>
			</tr>
			<tr>
				<td><textarea name="COMMENT_CONTENT" autofocus="autofocus"
						style="margin: 0px; height: 100px; width: 400px;">
					</textarea></td>

				<td><input type="submit" value="등록"
					style="height: 50px; width: 100px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>