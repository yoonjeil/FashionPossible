package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;


public class LoginAction implements Action {
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url="member/login_fail.jsp";
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		MemberDao memberDao = MemberDao.getInstance();
		Member member = null;;
		try {
			member = memberDao.getMember(id);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(member != null) {
			if (member.getPwd().equals(pwd)){
				session.removeAttribute("id");
				session.setAttribute("loginUser", member);
				url = "ShopController?command=index";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
