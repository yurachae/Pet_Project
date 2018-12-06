<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시판 글 등록하기(boardWrite.jsp)</h1>
	<form action="communityBoardWriteAction.bo" method="post"	name="communityBoardWriteForm" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>
					<table>
						<tr align="center">
							<td>제목</td>
							<td><input name="COMMUNITY_SUBJECT" size="50" maxlength="100"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">작성자</td>
							<td><input name="COMMUNITY_NAME"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">비밀번호</td>
							<td><input type="password" name="COMMUNITY_PASS" size="50" maxlength="50"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"><img src =""></td>
						</tr>
						<tr>
							<td align="center">관심 분야</td>
							<td><select name="COMMUNITY_FAVORITE">
									<option value="강아지" selected>강아지</option>
									<option value="푸들">푸들</option>
									<option value="말티즈">말티즈</option>
									<option value="치와와">치와와</option>
									<option value="고양이">고양이</option>
							</select></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">내용</td>
							<td><textarea name="COMMUNITY_CONTENT" cols="50" rows="13"></textarea></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">이미지 파일</td>
							<td><input type="file" name="COMMUNITY_FILE"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="2"></td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="제출" />&nbsp; &nbsp; 
								<input type="reset" value="다시 쓰기">
							<!-- <input type=button value="등록"	onClick="javascript:communityBoardWriteForm.submit()"> 
								<input	type=button value="취소" onClick="javascript:history.go(-1)"> -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>