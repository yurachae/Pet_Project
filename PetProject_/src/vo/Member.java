package vo; 
//value object : 일관적으로 필드랑 get, setter를 묶어 놓은 패키지. 
//DTO : data Transfer Object
//bin, 셋다 같은 의미. 

public class Member {
	private String ID;
	private String PASSWORD;
	private String NAME;
	private String GENDER;
	private String ADDRESS;
	private String PHONE;
	private String IMAGE;
	private String EMAIL;
	private String FAVORITE;
	private String FIELD;
	
	@Override
	public String toString() {
		return "Member [ID=" + ID + ", PASSWORD=" + PASSWORD + ", NAME=" + NAME + ", GENDER=" + GENDER + ", ADDRESS="
				+ ADDRESS + ", PHONE=" + PHONE + ", IMAGE=" + IMAGE + ", EMAIL=" + EMAIL + ", FAVORITE=" + FAVORITE
				+ ", FIELD=" + FIELD + "]";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getFAVORITE() {
		return FAVORITE;
	}
	public void setFAVORITE(String fAVORITE) {
		FAVORITE = fAVORITE;
	}
	public String getFIELD() {
		return FIELD;
	}
	public void setFIELD(String fIELD) {
		FIELD = fIELD;
	}

	
	
}
