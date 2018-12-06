package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.CommunityBoard;
import static db.jdbcUtil.*;

public class CommunityBoardListService {

	// DB에 저장된 글의 갯수를 가져오는 메소드. BoardListAction에서 호출함.
	public int listCount() {
		System.out.println("CommunityBoardListService-communityListCount 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		int communityListCount = 0;
		communityListCount = boardDAO.listCount();

		return communityListCount;
	}

	public ArrayList<CommunityBoard> communityBoardList() {
		System.out.println("CommunityBoardListService 실행");

		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		ArrayList<CommunityBoard> communityBoardList = boardDAO.communityBoardList();

		
		return communityBoardList;
	}

}
