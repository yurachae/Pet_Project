package service;

import java.sql.Connection;

import dao.BoardDAO;
import vo.CommunityBoard;
import static db.jdbcUtil.*;

public class CommunityBoardModifyViewService {

	public CommunityBoard communityBoardModifyView(int boardNum) {
		CommunityBoard communityBoard = null;
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		communityBoard = boardDAO.communityBoardDetail(boardNum);
		
		return communityBoard;
	}

}
