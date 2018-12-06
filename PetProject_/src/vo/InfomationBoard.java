package vo;

import java.sql.Date;

public class InfomationBoard {
	//필드
	private String INFORMATION_SUBJECT ;
	private String INFORMATION_CONTENT ;
	@Override
	public String toString() {
		return "InfomationBoard [INFORMATION_SUBJECT=" + INFORMATION_SUBJECT + ", INFORMATION_CONTENT="
				+ INFORMATION_CONTENT + "]";
	}
	public String getINFORMATION_SUBJECT() {
		return INFORMATION_SUBJECT;
	}
	public void setINFORMATION_SUBJECT(String iNFORMATION_SUBJECT) {
		INFORMATION_SUBJECT = iNFORMATION_SUBJECT;
	}
	public String getINFORMATION_CONTENT() {
		return INFORMATION_CONTENT;
	}
	public void setINFORMATION_CONTENT(String iNFORMATION_CONTENT) {
		INFORMATION_CONTENT = iNFORMATION_CONTENT;
	}
	
}
