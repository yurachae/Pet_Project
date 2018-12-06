package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	// 리턴 타입이 ActionForward 클래스인 execute 메소드 정의 : 추상메소드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
