package vo;


public class InformationAnimal {
	//필드
	private String ANIMAL_KIND ;
	private String ANIMAL_SUBJECT ;
	private String ANIMAL_IMAGE ;
	private String ANIMAL_CONTENT ;
	@Override
	public String toString() {
		return "Animal [ANIMAL_KIND=" + ANIMAL_KIND + ", ANIMAL_SUBJECT=" + ANIMAL_SUBJECT + ", ANIMAL_IMAGE="
				+ ANIMAL_IMAGE + ", ANIMAL_CONTENT=" + ANIMAL_CONTENT + "]";
	}
	public String getANIMAL_KIND() {
		return ANIMAL_KIND;
	}
	public void setANIMAL_KIND(String aNIMAL_KIND) {
		ANIMAL_KIND = aNIMAL_KIND;
	}
	public String getANIMAL_SUBJECT() {
		return ANIMAL_SUBJECT;
	}
	public void setANIMAL_SUBJECT(String aNIMAL_SUBJECT) {
		ANIMAL_SUBJECT = aNIMAL_SUBJECT;
	}
	public String getANIMAL_IMAGE() {
		return ANIMAL_IMAGE;
	}
	public void setANIMAL_IMAGE(String aNIMAL_IMAGE) {
		ANIMAL_IMAGE = aNIMAL_IMAGE;
	}
	public String getANIMAL_CONTENT() {
		return ANIMAL_CONTENT;
	}
	public void setANIMAL_CONTENT(String aNIMAL_CONTENT) {
		ANIMAL_CONTENT = aNIMAL_CONTENT;
	}
	
}
