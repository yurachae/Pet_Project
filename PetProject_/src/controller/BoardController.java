package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CommunityBoardModifyAction;
import action.CommunityBoardCommentWriteAction;
import action.CommunityBoardDeleteAction;
import action.CommunityBoardListAction;
import action.CommunityBoardModifyViewAction;
import action.CommunityBoardWriteAction;
import action.CommunityBoardDetailAction;
import action.CommunityBoardFileDownAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length());
		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		// 글 등록
		if (command.equals("/community/communityBoardWriteAction.bo")) {
			action = new CommunityBoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardWriteAction 컨트롤러에서 생긴 예외 :" + e);
			}

			// 글 목록
		} else if (command.equals("/community/communityBoardListAction.bo")) {
			action = new CommunityBoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardListAction 컨트롤러에서 생긴 예외 :" + e);
			}

			// 글 상세보기
		} else if (command.equals("/community/communityBoardDetailAction.bo")) {
			action = new CommunityBoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardDetailAction 컨트롤러에서 생긴 예외 :" + e);
			}

			// 파일 다운로드
		} else if (command.equals("/community/communityBoardFileDownAction.bo")) {
			action = new CommunityBoardFileDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardFileDownAction 컨트롤러에서 생긴 예외 :" + e);
			}

			// 수정하기 전에 수정할 폼 가져오기(BoardNum)에 해당하는.
		} else if (command.equals("/community/communityBoardModifyViewAction.bo")) {
			action = new CommunityBoardModifyViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardModifyViewAction 컨트롤러에서 생긴 예외 :" + e);
			}

			// 글 수정하기
		} else if (command.equals("/community/communityBoarModifyAction.bo")) {
			action = new CommunityBoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoarModifyAction 컨트롤러에서 생긴 예외 :" + e);
			}

		} else if (command.equals("/community/communityBoardDeleteAction.bo")) {
			action = new CommunityBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardDeleteAction 컨트롤러에서 생긴 예외 :" + e);
			}

		} else if (command.equals("/community/communityBoardDelete.bo")) {
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			request.setAttribute("boardNum", boardNum);
			forward = new ActionForward();
			forward.setPath("/community/communityBoardDelete.jsp");

		} else if (command.equals("/community/communityBoardCommentWriteAction.bo")) {
			action = new CommunityBoardCommentWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("communityBoardCommentWriteAction 컨트롤러에서 생긴 예외 :" + e);
			}

		}
		// 각 Action 클래스 호출 결과인 forward 객체 처리
		if (forward != null) {
			if (forward.isRedirect()) {
				System.out.println("Redirect 방식");
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println("dispatcher 방식");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
