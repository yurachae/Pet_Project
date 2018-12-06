package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.CommunityCommentBoard;
import static db.jdbcUtil.*;

public class CommunityBoardCommentWriteService {

	public boolean communityBoardCommentWrite(CommunityCommentBoard comment) {
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		
		
		
		//댓글을 db에 저장하기
		boolean writeResult = boardDAO.communityBoardCommentWrite(comment);
		if(writeResult) {//true이면 저장 된 것.
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return writeResult;
	}

}
