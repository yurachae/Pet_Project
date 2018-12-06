package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityBoardDetailService;
import vo.ActionForward;
import vo.CommunityBoard;
import vo.CommunityCommentBoard;

public class CommunityBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));// communityBoardList.jsp에서 boardNum 값이 request로 넘어옴.

		CommunityBoardDetailService communityBoardDetailService = new CommunityBoardDetailService();// CommunityBoardDetailService의 communityBoardDetail() 메소드 호출.
		
		//게시판 가져오기
		CommunityBoard communityBoard = communityBoardDetailService.communityBoardDetail(boardNum);		// 리턴 값은 boardNum에 해당하는 게시판 데이터 하나를 가져오기 때문에 CommunityBoard 클래스의 변수에 저장.
		
		//댓글가져오기
		ArrayList<CommunityCommentBoard> commentList = (ArrayList<CommunityCommentBoard>)communityBoardDetailService.communityBoardCommentList(boardNum);
		
		System.out.println(communityBoard.toString());
		// communityBoard에 값이 있으면 DAO에서 해당하는 데이터를 가져온 것.
		// 가져온 데이터를 jsp로 보내기 위해서 request에 저장해서 forward(dispatcher방식)함.
		request.setAttribute("communityBoardDetail", communityBoard);
		request.setAttribute("commentList", commentList);
		
		forward = new ActionForward();
		forward.setPath("/community/communityBoardDetail.jsp");
		System.out.println("CommunityBoardDetailAction 리턴");
		return forward;
	}

}
