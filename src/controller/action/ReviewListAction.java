package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.Member;
import dto.Review;

public class ReviewListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "review/ReviewList.jsp";
		HttpSession session = request.getSession();
		Review review = (Review) session.getAttribute("pseq");		
		try {
			ReviewDao reviewDao = ReviewDao.getInstance();
			ArrayList<Review> reviewList = reviewDao.listReview(review.getPseq() + "");
			request.setAttribute("reviewList", reviewList);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
