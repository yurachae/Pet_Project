package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityBoardCommentWriteService;
import vo.ActionForward;
import vo.CommunityCommentBoard;

public class CommunityBoardCommentWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommunityBoardCommentWriteAction 실행");
		ActionForward forward = null;
		
		CommunityCommentBoard comment = new CommunityCommentBoard();
		System.out.println(Integer.parseInt(request.getParameter("COMMENT_PARENT")));
		
		
		comment.setCOMMENT_CONTENT(request.getParameter("COMMENT_CONTENT"));
		comment.setCOMMENT_ID(request.getParameter("COMMENT_ID"));
		comment.setCOMMENT_PARENT(Integer.parseInt(request.getParameter("COMMENT_PARENT")));
		
		CommunityBoardCommentWriteService communityBoardCommentService = new CommunityBoardCommentWriteService();
		boolean result = communityBoardCommentService.communityBoardCommentWrite(comment);
		
	 
		
		if(result) {//db에 저장됐으면 댓글 리스트 출력하도록 forwarding 하기
			forward = new ActionForward();
			forward.setPath("communityBoardDetailAction.bo?boardNum="+comment.getCOMMENT_PARENT());
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('댓글 등록 실패')");
			out.println("location.href='communityBoardWrite.jsp' </script>");
		}
		
		return forward;
		
	}

}
