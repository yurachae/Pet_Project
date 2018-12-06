package service;

import java.sql.Connection;

import dao.BoardDAO;
import vo.CommunityBoard;
import static db.jdbcUtil.*;

public class CommunityBoardModifyService {

	public boolean communityBoardModify(CommunityBoard communityBoard) {
		System.out.println("정보 수정 서비스 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		int DBresult = boardDAO.communityBoardModify(communityBoard);
		boolean result=false; 
		
		if(DBresult>0) {//등록 성공
			commit(conn);
			result = true;
		}else {
			rollback(conn);
			result = false;
		}
		return result;
		
		
	}

	public boolean passwordResult(int boardNum, String passwordCheck) {
		System.out.println("비밀번호 확인 서비스 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		
		String password = boardDAO.passwordResult(boardNum);
		boolean passwordResult=false;
		
		if(password.equals(passwordCheck)) {//입력한 패스워드와 DB에 저장된 패스워드가 같다면
			passwordResult=true;
		}else {
			passwordResult=false;
		}
		System.out.println("비밀번호 확인 서비스 리턴");
		return passwordResult;
	}

}
