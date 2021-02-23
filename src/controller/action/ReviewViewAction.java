package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.Member;
import dto.Review;

public class ReviewViewAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String url = "review/ReviewView.jsp";
	      HttpSession session = request.getSession();
	      Member loginUser = (Member) session.getAttribute("loginUser");
	      if(loginUser == null) {
	         url = "ShopController?command=login_form";
	         
	      }else {
	         int rno = Integer.parseInt(request.getParameter("rno"));
	         ReviewDao reviewDao = ReviewDao.getInstance();
	         Review review = reviewDao.getReview(rno);
	         request.setAttribute("review", review);
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	   }      

}
  

