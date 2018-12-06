package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityBoardModifyViewService;
import vo.ActionForward;
import vo.CommunityBoard;

public class CommunityBoardModifyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		CommunityBoardModifyViewService communityBoardModifyViewService = new CommunityBoardModifyViewService();
		CommunityBoard communityBoard = communityBoardModifyViewService.communityBoardModifyView(boardNum);

		request.setAttribute("modifyView", communityBoard);
		forward = new ActionForward();
		forward.setPath("/community/communityBoardModifyView.jsp");

		return forward;
	}

}
