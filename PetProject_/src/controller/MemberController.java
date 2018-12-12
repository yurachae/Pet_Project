package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberLoginAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = RequestURI.substring(ContextPath.length()); // substring()메소드는 잘라낸 문자의 길이 값.
		System.out.println("command 값 :" + command);

		ActionForward forward = null;
		Action action = null; // Action은 인터페이스.

		// 로그인 결과 처리 하는 부분.
		if (command.equals("/member/memberLoginAction.me")) {
			System.out.println("memberLoginAction.me 실행");
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MemberController-memberLoginAction 예외 :" + e);
			}

			// 로그인 화면.jsp 로 보내는 부분.
		} else if (command.equals("/member/memberLoginForm.me")) {
			System.out.println("memberLoginForm.me 실행");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.jsp");

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
