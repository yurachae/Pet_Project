package vo;

import java.sql.Date;

public class CommunityBoard {
	//필드
	private int COMMUNITY_NUM;
	private String COMMUNITY_NAME ;
	private String COMMUNITY_PASS ;
	private String COMMUNITY_SUBJECT ;
	private String COMMUNITY_CONTENT ;
	private String COMMUNITY_FILE ;
	private int COMMUNITY_READCOUNT ;
	private Date COMMUNITY_DATE ;
	private String COMMUNITY_FAVORITE ;
	private int COMMUNITY_RE_REF ;
	private int  COMMUNITY_RE_LEV ;
	private int COMMUNITY_RE_SEQ ;
	@Override
	public String toString() {
		return "CommunityBoard [COMMUNITY_NUM=" + COMMUNITY_NUM + ", COMMUNITY_NAME=" + COMMUNITY_NAME
				+ ", COMMUNITY_PASS=" + COMMUNITY_PASS + ", COMMUNITY_SUBJECT=" + COMMUNITY_SUBJECT
				+ ", COMMUNITY_CONTENT=" + COMMUNITY_CONTENT + ", COMMUNITY_FILE=" + COMMUNITY_FILE
				+ ", COMMUNITY_READCOUNT=" + COMMUNITY_READCOUNT + ", COMMUNITY_DATE=" + COMMUNITY_DATE
				+ ", COMMUNITY_FAVORITE=" + COMMUNITY_FAVORITE + ", COMMUNITY_RE_REF=" + COMMUNITY_RE_REF
				+ ", COMMUNITY_RE_LEV=" + COMMUNITY_RE_LEV + ", COMMUNITY_RE_SEQ=" + COMMUNITY_RE_SEQ + "]";
	}
	
	public int getCOMMUNITY_NUM() {
		return COMMUNITY_NUM;
	}
	public void setCOMMUNITY_NUM(int cOMMUNITY_NUM) {
		COMMUNITY_NUM = cOMMUNITY_NUM;
	}
	public String getCOMMUNITY_NAME() {
		return COMMUNITY_NAME;
	}
	public void setCOMMUNITY_NAME(String cOMMUNITY_NAME) {
		COMMUNITY_NAME = cOMMUNITY_NAME;
	}
	public String getCOMMUNITY_PASS() {
		return COMMUNITY_PASS;
	}
	public void setCOMMUNITY_PASS(String cOMMUNITY_PASS) {
		COMMUNITY_PASS = cOMMUNITY_PASS;
	}
	public String getCOMMUNITY_SUBJECT() {
		return COMMUNITY_SUBJECT;
	}
	public void setCOMMUNITY_SUBJECT(String cOMMUNITY_SUBJECT) {
		COMMUNITY_SUBJECT = cOMMUNITY_SUBJECT;
	}
	public String getCOMMUNITY_CONTENT() {
		return COMMUNITY_CONTENT;
	}
	public void setCOMMUNITY_CONTENT(String cOMMUNITY_CONTENT) {
		COMMUNITY_CONTENT = cOMMUNITY_CONTENT;
	}
	public String getCOMMUNITY_FILE() {
		return COMMUNITY_FILE;
	}
	public void setCOMMUNITY_FILE(String cOMMUNITY_FILE) {
		COMMUNITY_FILE = cOMMUNITY_FILE;
	}
	public int getCOMMUNITY_READCOUNT() {
		return COMMUNITY_READCOUNT;
	}
	public void setCOMMUNITY_READCOUNT(int cOMMUNITY_READCOUNT) {
		COMMUNITY_READCOUNT = cOMMUNITY_READCOUNT;
	}
	public Date getCOMMUNITY_DATE() {
		return COMMUNITY_DATE;
	}
	public void setCOMMUNITY_DATE(Date cOMMUNITY_DATE) {
		COMMUNITY_DATE = cOMMUNITY_DATE;
	}
	public String getCOMMUNITY_FAVORITE() {
		return COMMUNITY_FAVORITE;
	}
	public void setCOMMUNITY_FAVORITE(String cOMMUNITY_FAVORITE) {
		COMMUNITY_FAVORITE = cOMMUNITY_FAVORITE;
	}
	public int getCOMMUNITY_RE_REF() {
		return COMMUNITY_RE_REF;
	}
	public void setCOMMUNITY_RE_REF(int cOMMUNITY_RE_REF) {
		COMMUNITY_RE_REF = cOMMUNITY_RE_REF;
	}
	public int getCOMMUNITY_RE_LEV() {
		return COMMUNITY_RE_LEV;
	}
	public void setCOMMUNITY_RE_LEV(int cOMMUNITY_RE_LEV) {
		COMMUNITY_RE_LEV = cOMMUNITY_RE_LEV;
	}
	public int getCOMMUNITY_RE_SEQ() {
		return COMMUNITY_RE_SEQ;
	}
	public void setCOMMUNITY_RE_SEQ(int cOMMUNITY_RE_SEQ) {
		COMMUNITY_RE_SEQ = cOMMUNITY_RE_SEQ;
	}
	
	
	
}
