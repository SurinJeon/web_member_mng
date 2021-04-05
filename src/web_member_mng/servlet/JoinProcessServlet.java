package web_member_mng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_member_mng.dto.Member;
import web_member_mng.service.MemberService;

@WebServlet("/joinProcess")
public class JoinProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id=java&pass=11&name=전수린&age=22&gender=여&email=surin0901%40naver.com
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
	
		Member newMember = new Member(id, pass, name, age, gender, email);
		System.out.println("newMember > " + newMember);
		int res = service.addMember(newMember);
		
		System.out.println(request.getSession().getAttribute("id"));
		if(res == 1) {
			if(request.getSession().getAttribute("id").equals("admin")) {
				request.getRequestDispatcher("memberList").forward(request, response);
			} else {
				request.getRequestDispatcher("loginForm.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
