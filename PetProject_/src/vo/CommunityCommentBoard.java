package vo;

import java.sql.Date;

public class CommunityCommentBoard {
	int COMMENT_NUM; //댓글 글 번호
	int COMMENT_BOARD; //게시글 번호
	String COMMENT_ID; //댓글 작성자
	Date COMMENT_DATE;	//댓글 작성일
	int COMMENT_PARENT; //부모 글 번호
	String COMMENT_CONTENT;//댓글 내용
	
	@Override
	public String toString() {
		return "CommentBoard [COMMENT_NUM=" + COMMENT_NUM + ", COMMENT_BOARD=" + COMMENT_BOARD + ", COMENT_ID="
				+ COMMENT_ID + ", COMMENT_DATE=" + COMMENT_DATE + ", COMMENT_PARENT=" + COMMENT_PARENT
				+ ", COMMENT_CONTENT=" + COMMENT_CONTENT + "]";
	}
	
	public int getCOMMENT_NUM() {
		return COMMENT_NUM;
	}
	public void setCOMMENT_NUM(int cOMMENT_NUM) {
		COMMENT_NUM = cOMMENT_NUM;
	}
	public int getCOMMENT_BOARD() {
		return COMMENT_BOARD;
	}
	public void setCOMMENT_BOARD(int cOMMENT_BOARD) {
		COMMENT_BOARD = cOMMENT_BOARD;
	}
	public String getCOMMENT_ID() {
		return COMMENT_ID;
	}
	public void setCOMMENT_ID(String cOMMENT_ID) {
		COMMENT_ID = cOMMENT_ID;
	}
	public Date getCOMMENT_DATE() {
		return COMMENT_DATE;
	}
	public void setCOMMENT_DATE(Date cOMMENT_DATE) {
		COMMENT_DATE = cOMMENT_DATE;
	}
	public int getCOMMENT_PARENT() {
		return COMMENT_PARENT;
	}
	public void setCOMMENT_PARENT(int cOMMENT_PARENT) {
		COMMENT_PARENT = cOMMENT_PARENT;
	}
	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}
	public void setCOMMENT_CONTENT(String cOMMENT_CONTENT) {
		COMMENT_CONTENT = cOMMENT_CONTENT;
	}
	

}
