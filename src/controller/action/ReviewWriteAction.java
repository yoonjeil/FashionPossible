package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dao.ReviewDao;
import dto.Member;
import dto.QnaVO;
import dto.Review;

public class ReviewWriteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=review_list";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "ShopController?command=login_form";
		}else {
			Review review = new Review();
			review.setSubject(request.getParameter("subject"));
			review.setContent(request.getParameter("content"));
			review.setPseq(request.getParameter("pseq"));
			ReviewDao reviewDao = ReviewDao.getInstance();
			reviewDao.insertreview(review,loginUser.getId());
		}
		response.sendRedirect(url);
}
}
