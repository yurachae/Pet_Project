package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityBoardDeleteService;
import vo.ActionForward;

public class CommunityBoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String password = request.getParameter("COMMUNITY_PASS");
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		System.out.println("CommunityBoardDeleteAction로 넘어온 값:"+boardNum+","+password+","+nowPage);
		
		CommunityBoardDeleteService communityBoardDeleteService = new CommunityBoardDeleteService();
		boolean passwordResult = communityBoardDeleteService.passwordResult(boardNum, password);
		
		boolean result = false;
		if(passwordResult) {//비밀번호가 일치하면
			result = communityBoardDeleteService.communityBoardDelete(boardNum);
			System.out.println("page 값:"+nowPage);
			if(result) {//삭제했으면
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("communityBoardListAction.bo");
			}else {
				response.setContentType("text;html/charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('비밀번호가 다릅니다. 실패.') location.href='communityBoardListAction.bo' <script>");
			}
		}
		return forward;
		
		
		
		
		
	}

}
