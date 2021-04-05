package web_member_mng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_member_mng.dto.Member;
import web_member_mng.service.MemberService;

@WebServlet("/loginProcess")
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encodig 안 해줘도 됨(filter설정함)
		// url에 이렇게 올라감 >> id=aaa&pass=12324
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Member loginMember = new Member(id, pass);
		
		Member result = service.loginMember(loginMember);
		// 만약 result가 null이면 없는 아이디 혹은 비밀번호라는 뜻
		System.out.printf("loginMember > %s%nresult > %s", loginMember, result);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", result.getId());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else{
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
