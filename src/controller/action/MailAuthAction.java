package controller.action;

import java.io.IOException;
import java.util.Spliterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;
import mail.GoogleMail;

public class MailAuthAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "member/Mail.jsp";		
		if( request.getParameter("mail") != null || request.getParameter("result") != null) {
			try {
				Member member = MemberDao.getInstance().getMemberByMail(request.getParameter("mail"));
								
				HttpSession session=request.getSession(false);
				if( member != null ) {
					String authNum = String.valueOf(authNum());
					session.setAttribute("authNum", authNum);
					session.setAttribute("memberTemp", member);
					session.setMaxInactiveInterval(3 * 60);
//					제일이 메일로만 테스트 할 것!
					GoogleMail.Send(request.getParameter("mail").split("@")[0], "qvbczrnnkomrthjx", "jihappypig@gmail.com", "메일인증", authNum);					
//					GoogleMail.Send(request.getParameter("mail").split("@")[0], "qvbczrnnkomrthjx", member.getEmail(), "메일인증", authNum);					
					session.setAttribute("mailtitle", "인증번호를 입력해 주세요(3분 제한!)");					
				}else {
					if(request.getParameter("result") != null) {						
						if(request.getParameter("result").equals((String)session.getAttribute("authNum"))) {
							session.setAttribute("loginUser", (Member)session.getAttribute("memberTemp"));
							session.removeAttribute("authNum");
							session.removeAttribute("memberTemp");
							url = "ShopController?command=index";
						}
					}
				}
			}catch(Exception e) {e.printStackTrace();}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
		
	public int authNum() {
		return ((int)(Math.random() * 10) + 1) * 2;
	}
}
