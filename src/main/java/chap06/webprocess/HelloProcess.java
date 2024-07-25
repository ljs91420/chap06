package chap06.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.web.WebProcess;

public class HelloProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("userName", "이재상");
		
		return "WEB-INF/views/hello.jsp";
	}
}
