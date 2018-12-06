package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.CommunityBoard;
import static db.jdbcUtil.*;


public class CommunityBoardWriteService {

	public boolean communityBoardWrite(CommunityBoard communityBoard) {
		BoardDAO boardDAO = new BoardDAO();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		boolean communityBoardResult = boardDAO.communityBoardWrite(communityBoard);
		boolean result = false;
		
		if(communityBoardResult) {//true이면 성공
			System.out.println("db 입력 성공(service-commit)");
			commit(conn); 
			result =true;
		}else {
			System.out.println("db 입력 실패 (service-rollback)");
			rollback(conn);
			result = false;
		}
		
		return result;
	}

}
