package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.CommunityBoardModifyService;
import vo.ActionForward;
import vo.CommunityBoard;

public class CommunityBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		CommunityBoardModifyService communityBoardModifyService = new CommunityBoardModifyService();

		// 비밀번호가 맞으면 수정하기

		CommunityBoard communityBoard = new CommunityBoard();
		// 파일업로드 추가.
		String realPath = "";
		String savePath = "/boardUpload"; // 파일을 업로드하기 위한 경로값. WEB_CONTENT 안에다 폴더 만들기
		int size = 100 * 1024 * 1024; // 파일 업로드 사이즈(최대 사이즈100MB)
		ServletContext context = request.getServletContext();
		realPath = context.getRealPath(savePath);

		// cos.jar에서 제공하는 클래스 및 메소드.
		MultipartRequest multi = new MultipartRequest(request, realPath, size, "UTF-8", new DefaultFileRenamePolicy());

		String passwordCheck = multi.getParameter("COMMUNITY_PASS");
		int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
		communityBoard.setCOMMUNITY_CONTENT(multi.getParameter("COMMUNITY_CONTENT"));
		communityBoard.setCOMMUNITY_FILE(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		communityBoard.setCOMMUNITY_FAVORITE(multi.getParameter("COMMUNITY_FAVORITE"));
		communityBoard.setCOMMUNITY_NUM(boardNum);
		communityBoard.setCOMMUNITY_PASS(passwordCheck);

		boolean passwordResult = communityBoardModifyService.passwordResult(boardNum, passwordCheck);
		System.out.println("비밀번호 확인 서비스에서 리턴 된 결과 :" + passwordResult);

		if (passwordResult) {// 입력한 패스워드와 저장된 패스워드가 같으면
			System.out.println("비밀번호 일치");
			boolean result = communityBoardModifyService.communityBoardModify(communityBoard);
			if (result) {// 참이면 DB에 저장 성공
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("communityBoardListAction.bo");
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('비밀번호가 틀렸습니다.') location.href=communityBoardModifyViewAction.bo </script>");
		}
		return forward;
	}

}
