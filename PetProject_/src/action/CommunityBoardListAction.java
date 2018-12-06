package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityBoardListService;
import vo.ActionForward;
import vo.CommunityBoard;
import vo.PageInfo;

public class CommunityBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommunityBoardListAction 실행");

		ActionForward forward = null;

		CommunityBoardListService communityBoardListService = new CommunityBoardListService();
		ArrayList<CommunityBoard> communityList = communityBoardListService.communityBoardList();
		request.setAttribute("communityList", communityList);

		System.out.println(request.getAttribute("communityList"));

		forward = new ActionForward();
		forward.setPath("/community/communityBoardList.jsp"); // 나중에 .bo로 처리할 것.


		System.out.println("BoardListAction 리턴");
		return forward;
	}

}
