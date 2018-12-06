package vo;
//규격 정의하는 vo 패키지.

//dispatcher 또는 redirect의 포워딩 방식 선택을 위해 규격을 정의한 클래스
public class ActionForward {
	private String path=null;
	private boolean redirect = false;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	


}
