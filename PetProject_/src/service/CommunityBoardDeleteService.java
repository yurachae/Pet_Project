package service;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import static db.jdbcUtil.*;

public class CommunityBoardDeleteService {

	public boolean passwordResult(int boardNum, String passwordCheck) {
		System.out.println("비밀번호 확인 서비스 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		String password = boardDAO.passwordResult(boardNum);
		boolean passwordResult = false;

		if (password.equals(passwordCheck)) {// 입력한 패스워드와 DB에 저장된 패스워드가 같다면
			passwordResult = true;
		} else {
			passwordResult = false;
		}
		System.out.println("비밀번호 확인 서비스 리턴");
		return passwordResult;
	}

	public boolean communityBoardDelete(int boardNum) {
		System.out.println("데이터 삭제 서비스 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection conn = getConnection();
		boardDAO.setConnection(conn);

		boolean deleteResult = boardDAO.communityBoardDelete(boardNum);
		boolean result = false;

		if (deleteResult) {
			commit(conn);
			result = true;
		} else {
			rollback(conn);
			result = false;
		}
		return result;
	}

}
