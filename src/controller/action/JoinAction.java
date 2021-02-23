package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;



public class JoinAction implements Action {
	 public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  String url = "member/login.jsp"; 
		  HttpSession session = request.getSession();
		  Member memberVO = new Member();
		  memberVO.setId(request.getParameter("id"));
		  memberVO.setPwd(request.getParameter("pwd"));
		  memberVO.setName(request.getParameter("name"));
		  memberVO.setEmail(request.getParameter("email"));
		  memberVO.setZip_num(request.getParameter("zipNum"));
		  memberVO.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		  memberVO.setPhone(request.getParameter("phone"));  
//		  session.setAttribute("id", request.getParameter("id")); 		  		  
		  MemberDao memberDAO = MemberDao.getInstance();
		  try {
			  memberDAO.insert(memberVO);
			  session.setAttribute("loginUser", memberVO);
			  url = "ShopController?command=index"; 
		  }catch(Exception e) {
			  e.printStackTrace();   
		  }    
		  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		  dispatcher.forward(request, response);
	 }
}
