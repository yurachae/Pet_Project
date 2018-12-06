<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.CommunityBoard"%>
<%@ page import="vo.PageInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	CommunityBoard board = (CommunityBoard) request.getAttribute("communityBoardDetail");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시판 글 상세보기(boardDetail.jsp)</h1>

	<table align="center">
		<tr>
			<td>
				<table>
					<tr align="right">
						<td colspan=2>조회수 :
							${requestScope.communityBoardDetail.COMMUNITY_READCOUNT }</td>
					</tr>
					<tr align="center">
						<td>제목</td>
						<td>${requestScope.communityBoardDetail.COMMUNITY_SUBJECT }</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="2"></td>
					</tr>
					<tr align="center">
						<td align="center">작성자</td>
						<td>${requestScope.communityBoardDetail.COMMUNITY_NAME }</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="2"></td>
					</tr>
					<tr align="center">
						<td align="center">비밀번호</td>
						<td><input type="password" name="BOARD_PASS" size="50"
							maxlength="50" readonly="readonly"></td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="2"></td>
					</tr>
					<tr align="center">
						<td><img src="..\boardUpload\<%=board.getCOMMUNITY_FILE()%>"
							width="400" height="300"></td>
						<td><textarea name="BOARD_CONTENT" cols="50" rows="13"
								style="margin: 0px; height: 290px; width: 370px;"
								readonly="readonly">${requestScope.communityBoardDetail.COMMUNITY_CONTENT }</textarea></td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="2"></td>
					</tr>
					<tr>
						<td align="center">첨부 파일</td>
						<td><a
							href="communityBoardFileDownAction.bo?fileDown=${requestScope.communityBoardDetail.COMMUNITY_FILE }">
								${requestScope.communityBoardDetail.COMMUNITY_FILE }</a></td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="2"></td>
					</tr>

					<tr align="center">
						<td colspan="2">
							<a href="communityBoardListAction.bo">[목록]</a> 
							<a href="communityBoardModifyViewAction.bo?boardNum=${requestScope.communityBoardDetail.COMMUNITY_NUM }">[수정]</a>
							<a href="communityBoardDelete.bo?boardNum=${requestScope.communityBoardDetail.COMMUNITY_NUM }">[삭제]</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr height="1" bgcolor="#dddddd">
			<td colspan="2"></td>
		</tr>

		<tr height="1" bgcolor="#dddddd">
			<td colspan="2"></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF">
			<td colspan="2"></td>
		</tr>


	</table>

	<form action="communityBoardCommentWriteAction.bo" method="post" name="commentWrite">
		<input type="hidden" name="COMMENT_PARENT" value="${requestScope.communityBoardDetail.COMMUNITY_NUM }">
			<table align=center>
				<tr>
					<td>
						<table align=center>
							<tr align=center>
								<td align=center style="margin: 0px; height: 20px; width: 100px;">작성자</td>
								<td align=center style="margin: 0px; height: 20px; width: 400px;">내용</td>
								<td align=center style="margin: 0px; height: 20px; width: 100px;">작성일자</td>
							</tr>
							<tr height="1" bgcolor="#dddddd">
								<td colspan="3"></td>
							</tr>
							<c:forEach var="comment" items="${commentList }">
								<tr>
									<td style="margin: 0px; height: 30px; width: 50px;">${comment.COMMENT_ID }</td>
									<td style="margin: 0px; height: 30px; width: 400px;">${comment.COMMENT_CONTENT }</td>
									<td style="margin: 0px; height: 30px; width: 100px;">${comment.COMMENT_DATE}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			<tr>
				<td><input type="text" name="COMMENT_ID" autocomplete="name" placeholder="작성자ID"></td>
			</tr>
			<tr>
				<td><textarea name="COMMENT_CONTENT" autofocus="autofocus" style="margin: 0px; height: 100px; width: 400px;"></textarea></td>
				<td><a href="javascript:commentWrite.submit()">저장</a> </td>
			</tr>
		</table>
	</form>


</body>
</html>