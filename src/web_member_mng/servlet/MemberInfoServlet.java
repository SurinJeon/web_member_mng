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

@WebServlet("/memberInfo")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
	
    public MemberInfoServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(((String)session.getAttribute("id")).equals("") ||
				!(((String)session.getAttribute("id")).equals("admin"))) {
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
			
		}
		
		String id = request.getParameter("id");
		Member searchMember = service.memberInfo(new Member(id));
		
		request.setAttribute("member", searchMember);
		request.getRequestDispatcher("memberInfo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
