package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.CommunityBoard;
import vo.CommunityCommentBoard;

public class CommunityBoardDetailService {

	public CommunityBoard communityBoardDetail(int boardNum) {
		System.out.println("CommunityBoardDetailService실행");
		// DB와 연결
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		// BoardDAO에서 sql문으로 boardNum에 해당하는 데이터를 가져와서 CommunityBoard클래스의 변수에 저장.
		CommunityBoard communityBoard = boardDAO.communityBoardDetail(boardNum);
		System.out.println("CommunityBoardDetailService리턴");
		return communityBoard;
	}

	public ArrayList<CommunityCommentBoard> communityBoardCommentList(int boardNum) {
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);
		ArrayList<CommunityCommentBoard> commentList = boardDAO.communityBoardCommentList(boardNum);

		return commentList;

	}

}
