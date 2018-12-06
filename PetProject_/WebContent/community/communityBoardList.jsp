<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.CommunityBoard"%>
<%@ page import="vo.PageInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<CommunityBoard> communityList = (ArrayList<CommunityBoard>) request.getAttribute("communityList");
%>
<%-- <%
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int nowPage = pageInfo.getPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();
	int listCount = pageInfo.getListCount();

	System.out.println(nowPage);
%> --%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>게시판 리스트(boardList.jsp)</h1>
	<h1>${sessionScope.memberId }님로그인했습니다.</h1>
	<input align="right" type=button value="글 작성"
		onClick="javacript:location.href='../community/communityBoardWrite.jsp'">
	<input align="right" type=button value="뒤로"
		onClick="javascript:history.go(-1)">
	<br>

	<table border=1 width="800px" align="center">
		<tr>
			<td width="100">번 호</td>
			<td width="500">제 목</td>
			<td width="100">작성자</td>			
			<td width="100">관심분야</td>
			<td width="100">날 짜</td>
			<td width="100">조회수</td>
		</tr>



	
		<c:forEach var="board" items="${communityList }">
			<tr>
				<td>${board.COMMUNITY_NUM }</td>
				<!-- 해당 글의 대한 글 번호에 링크를 걸어야 함. 글 번호는 primary key 이므로. -->
				<td><a href="communityBoardDetailAction.bo?boardNum=${board.COMMUNITY_NUM}&page=${pageInfo.page}">${board.COMMUNITY_SUBJECT }</a></td>
				<td>${board.COMMUNITY_NAME }</td>
				<td>${board.COMMUNITY_FAVORITE }</td>
				<td>${board.COMMUNITY_DATE }</td>
				<td>${board.COMMUNITY_READCOUNT }</td>
			</tr>
		</c:forEach>
	</table>


	<!-- 페이지 정보 및 페이지 링크 출력 -->

<%-- 	<%
		if (nowPage <= 1) {
	%>
	[◀◀]&nbsp;
	<%
		} else {
	%>
	<a href="communityBoardListAction.bo?page=<%=pageInfo.getPage() - 1%>">[◀◀]</a>&nbsp;
	<%
		}
	%>

	<%
		for (int a = pageInfo.getStartPage(); a <= pageInfo.getEndPage(); a++) {
			if (a == nowPage) {
	%>
	[<%=a%>]
	<%
		} else {
	%>

	<a href="communityBoardListAction.bo?page=<%=a%>">[<%=a%>]
	</a>&nbsp;
	<%
		}
	%>
	<%
		}
	%>

	<%
		if (nowPage >= maxPage) {
	%>
	[▶▶]
	<%
		} else {
	%>
	<a href="communityBoardListAction.bo?page=<%=nowPage + 1%>">[▶▶]</a>
	<%
		}
	%>
 --%>




</body>
</html>