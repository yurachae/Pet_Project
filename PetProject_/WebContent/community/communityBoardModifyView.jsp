<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.CommunityBoard"%>
<%@ page import="vo.PageInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%
	int nowPage = (int) request.getAttribute("pageInfo");
%> --%>
<%
	CommunityBoard board = (CommunityBoard) request.getAttribute("modifyView");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시판 글 수정 폼(communityBoardModifyView.jsp)</h1>
	<form name="modifyView" action="communityBoarModifyAction.bo" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardNum" value="${requestScope.modifyView.COMMUNITY_NUM }"> 
		<input	type="hidden" name="page" value="${requestScope.nowPage.page }">
		<table align="center">
			<tr>
				<td>
					<table>
						<tr align="center">
							<td>제목</td>
							<td>${requestScope.modifyView.COMMUNITY_SUBJECT }</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>

						<tr align="center">
							<td align="center">작성자</td>
							<td>${requestScope.modifyView.COMMUNITY_NAME }</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>

						<tr align="center">
							<td align="center">비밀번호</td>
							<td><input type="password" name="COMMUNITY_PASS" size="50"
								maxlength="50"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">관심 분야 <input type="text"
								value="${requestScope.modifyView.COMMUNITY_FAVORITE }"></td>
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
							<td align="center">이미지 파일</td>
							<td><input type="file" name="COMMUNITY_FILE">
								${requestScope.modifyView.COMMUNITY_FILE }</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
							
						<tr align="center">
							<td colspan=2><img
								src="..\boardUpload\<%=board.getCOMMUNITY_FILE()%>" width="400"
								height="350"></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>

						<tr align="center">
							<td align="center">내용</td>
							<td><textarea name="COMMUNITY_CONTENT" cols="50" rows="13">
							${requestScope.modifyView.COMMUNITY_CONTENT }</textarea></td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="2"></td>
						</tr>

						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="2"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<a href="javascript:modifyView.submit()">저장</a> <a
			href="javascript:modifyView.reset()">다시 작성</a> <a
			href="javascript:location.href='communityBoardDetailAction.bo?boardNum=${requestScope.modifyView.COMMUNITY_NUM }&'">취소</a>
	</form>
</body>
</html>