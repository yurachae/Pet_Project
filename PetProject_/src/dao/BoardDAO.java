package dao;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.CommunityBoard;
import vo.CommunityCommentBoard;

public class BoardDAO {

	private static BoardDAO BoardDAO;
	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// loginDAO가 없으면 생성. 있으면 바로 리턴. (싱글톤)
	public static BoardDAO getInstance() {
		if (BoardDAO == null) {
			BoardDAO = new BoardDAO();
		}
		return BoardDAO;
	}

	// DB와 Conncetion
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public boolean communityBoardWrite(CommunityBoard communityBoard) {
		String sql = "INSERT INTO COMMUNITY_BOARD VALUES(C_SEQ.NEXTVAL,?,?,?,?,?,?,SYSDATE,?,C_SEQ.NEXTVAL,?,?)";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, communityBoard.getCOMMUNITY_NAME());
			pstmt.setString(2, communityBoard.getCOMMUNITY_PASS());
			pstmt.setString(3, communityBoard.getCOMMUNITY_SUBJECT());
			pstmt.setString(4, communityBoard.getCOMMUNITY_CONTENT());
			pstmt.setString(5, communityBoard.getCOMMUNITY_FILE());
			pstmt.setInt(6, 0);
			pstmt.setString(7, communityBoard.getCOMMUNITY_FAVORITE());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);

			int boardResult = pstmt.executeUpdate();
			if (boardResult > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) {
			System.out.println("communityBoardWrite DAO에서 일어난 예외 :" + e);
		} finally {
			try {
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<CommunityBoard> communityBoardList() {
		String sql = "SELECT * FROM COMMUNITY_BOARD ORDER BY COMMUNITY_NUM DESC";
		ArrayList<CommunityBoard> communityBoardList = new ArrayList<>();
		CommunityBoard communityBoard = null;

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				communityBoard = new CommunityBoard();
				communityBoard.setCOMMUNITY_NUM(rs.getInt("COMMUNITY_NUM"));
				communityBoard.setCOMMUNITY_NAME(rs.getString("COMMUNITY_NAME"));
				communityBoard.setCOMMUNITY_PASS(rs.getString("COMMUNITY_PASS"));
				communityBoard.setCOMMUNITY_SUBJECT(rs.getString("COMMUNITY_SUBJECT"));
				communityBoard.setCOMMUNITY_CONTENT(rs.getString("COMMUNITY_CONTENT"));
				communityBoard.setCOMMUNITY_FILE(rs.getString("COMMUNITY_FILE"));
				communityBoard.setCOMMUNITY_READCOUNT(rs.getInt("COMMUNITY_READCOUNT"));
				communityBoard.setCOMMUNITY_DATE(rs.getDate("COMMUNITY_DATE"));
				communityBoard.setCOMMUNITY_FAVORITE(rs.getString("COMMUNITY_FAVORITE"));
				communityBoard.setCOMMUNITY_RE_REF(rs.getInt("COMMUNITY_RE_REF"));
				communityBoard.setCOMMUNITY_RE_LEV(rs.getInt("COMMUNITY_RE_LEV"));
				communityBoard.setCOMMUNITY_RE_SEQ(rs.getInt("COMMUNITY_RE_SEQ"));

				communityBoardList.add(communityBoard);
			}
		} catch (Exception e) {
			System.out.println("communityBoardList DAO에서 일어난 예외 :" + e);
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(communityBoardList.toString());
		return communityBoardList;
	}

	public int listCount() {
		String sql = "SELECT COUNT(*) FROM COMMUNITY_BOARD";
		int listCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("listCount DAO에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCount;
	}

	public CommunityBoard communityBoardDetail(int boardNum) {
		// 상세보기를 누르면 조회수가 올라가도록 sql문 업데이트 하기.
		String sql = "UPDATE COMMUNITY_BOARD SET COMMUNITY_READCOUNT = COMMUNITY_READCOUNT+1 WHERE COMMUNITY_NUM=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			System.out.println("communityBoardDetail DAO[조회수 증가]에서 생긴 예외 :" + e);
		}

		// boardNum에 해당하는 데이터 전부 가져오기
		sql = "SELECT * FROM COMMUNITY_BOARD WHERE COMMUNITY_NUM=?";
		CommunityBoard communityBoard = new CommunityBoard();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				communityBoard.setCOMMUNITY_NUM(rs.getInt("COMMUNITY_NUM"));
				communityBoard.setCOMMUNITY_NAME(rs.getString("COMMUNITY_NAME"));
				communityBoard.setCOMMUNITY_PASS(rs.getString("COMMUNITY_PASS"));
				communityBoard.setCOMMUNITY_SUBJECT(rs.getString("COMMUNITY_SUBJECT"));
				communityBoard.setCOMMUNITY_CONTENT(rs.getString("COMMUNITY_CONTENT"));
				communityBoard.setCOMMUNITY_FILE(rs.getString("COMMUNITY_FILE"));
				communityBoard.setCOMMUNITY_READCOUNT(rs.getInt("COMMUNITY_READCOUNT"));
				communityBoard.setCOMMUNITY_DATE(rs.getDate("COMMUNITY_DATE"));
				communityBoard.setCOMMUNITY_FAVORITE(rs.getString("COMMUNITY_FAVORITE"));
				communityBoard.setCOMMUNITY_RE_REF(rs.getInt("COMMUNITY_RE_REF"));
				communityBoard.setCOMMUNITY_RE_LEV(rs.getInt("COMMUNITY_RE_LEV"));
				communityBoard.setCOMMUNITY_RE_SEQ(rs.getInt("COMMUNITY_RE_SEQ"));

			}
			System.out.println(communityBoard.toString());
		} catch (Exception e) {
			System.out.println("communityBoardDetail DAO[값 가져오기]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return communityBoard;
	}

	public int communityBoardModify(CommunityBoard communityBoard) {// 관심분야,내용,첨부파일,
		String sql = "UPDATE COMMUNITY_BOARD SET COMMUNITY_FAVORITE =?, COMMUNITY_CONTENT=?, COMMUNITY_FILE=? WHERE COMMUNITY_NUM=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, communityBoard.getCOMMUNITY_FAVORITE());
			pstmt.setString(2, communityBoard.getCOMMUNITY_CONTENT());
			pstmt.setString(3, communityBoard.getCOMMUNITY_FILE());
			pstmt.setInt(4, communityBoard.getCOMMUNITY_NUM());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("communityBoardModify DAO[수정한 데이터 저장]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public String passwordResult(int boardNum) {
		String sql = "SELECT COMMUNITY_PASS FROM COMMUNITY_BOARD WHERE COMMUNITY_NUM=?";
		String password = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString("COMMUNITY_PASS");

			}
		} catch (Exception e) {
			System.out.println("passwordResult DAO[비밀번호 가져오기]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("db에서 가져온 비밀번호: " +password);
		return password;

	}

	public boolean communityBoardDelete(int boardNum) {
		String sql = "DELETE FROM COMMUNITY_BOARD WHERE COMMUNITY_NUM=?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int deleteResult = pstmt.executeUpdate();
			
			if(deleteResult>0) {
				result = true;
			}else {
				result = false;
			}
		
		}catch (Exception e) {
			System.out.println("communityBoardDelete DAO[데이터 삭제하기]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public boolean communityBoardCommentWrite(CommunityCommentBoard comment) {
		String sql ="INSERT INTO COMMUNITY_COMMENT_BOARD VALUES(CO_SEQ.NEXTVAL,?,SYSDATE,?,?)";
		boolean writeResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCOMMENT_ID());
			pstmt.setInt(2, comment.getCOMMENT_PARENT());
			pstmt.setString(3, comment.getCOMMENT_CONTENT());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				writeResult=true;
			}else {
				writeResult=false;
			}
			
			
		}catch (Exception e) {
			System.out.println("communityBoardCommentWrite DAO[댓글 DB 저장]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return writeResult;
	}

	public ArrayList<CommunityCommentBoard> communityBoardCommentList(int boardNum) {		
		String sql = "SELECT * FROM COMMUNITY_COMMENT_BOARD WHERE COMMENT_PARENT=? ORDER BY COMMENT_NUM ";
		ArrayList<CommunityCommentBoard> commentList= new ArrayList<>();
		CommunityCommentBoard communityComment = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				communityComment = new CommunityCommentBoard();
				communityComment.setCOMMENT_NUM(rs.getInt("COMMENT_NUM"));
				communityComment.setCOMMENT_ID(rs.getString("COMMENT_ID"));
				communityComment.setCOMMENT_DATE(rs.getDate("COMMENT_DATE"));
				communityComment.setCOMMENT_PARENT(rs.getInt("COMMENT_PARENT"));
				communityComment.setCOMMENT_CONTENT(rs.getString("COMMENT_CONTENT"));
				
				commentList.add(communityComment);
			}
		}catch (Exception e) {
			System.out.println("communityBoardCommentWrite DAO[댓글 DB 저장]에서 생긴 예외 :" + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return commentList;
	}

}
