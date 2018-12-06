package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.CommunityBoardWriteService;
import vo.ActionForward;
import vo.CommunityBoard;

public class CommunityBoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityBoard communityBoard = new CommunityBoard();
		System.out.println("CommunityBoardWriteAction실행");
		//파일업로드 추가. 
		String realPath = "";
		String savePath="/boardUpload";	//파일을 업로드하기 위한 경로값. WEB_CONTENT 안에다 폴더 만들기
		int size =100*1024*1024;	//파일 업로드 사이즈(최대 사이즈 5MB)
		ServletContext context = request.getServletContext();
		realPath = context.getRealPath(savePath);
		
		//cos.jar에서 제공하는 클래스 및 메소드.
		MultipartRequest multi = new MultipartRequest(request, realPath, size, "UTF-8",new DefaultFileRenamePolicy());
	
		communityBoard.setCOMMUNITY_NAME(multi.getParameter("COMMUNITY_NAME"));
		communityBoard.setCOMMUNITY_PASS(multi.getParameter("COMMUNITY_PASS"));
		communityBoard.setCOMMUNITY_SUBJECT(multi.getParameter("COMMUNITY_SUBJECT"));
		communityBoard.setCOMMUNITY_CONTENT(multi.getParameter("COMMUNITY_CONTENT"));
		communityBoard.setCOMMUNITY_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		communityBoard.setCOMMUNITY_FAVORITE(multi.getParameter("COMMUNITY_FAVORITE"));
		
		System.out.println(communityBoard.toString());
		
		ActionForward forward = null;
		CommunityBoardWriteService communityBoardWriteService = new CommunityBoardWriteService();
		boolean result = communityBoardWriteService.communityBoardWrite(communityBoard);
		
		if(result) {//db에 등록 성공했다면 
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("communityBoardListAction.bo");
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('글 등록 실패')");
			out.println("location.href='communityBoardWrite.jsp' </script>");
		}
		System.out.println("CommunityBoardWriteAction리턴");
		return forward;
	}

}
