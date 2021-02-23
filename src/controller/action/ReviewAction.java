package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

public class ReviewAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "review/ReviewWrite.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "ShopController?command=loginform";

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
