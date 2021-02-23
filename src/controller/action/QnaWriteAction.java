package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.QnaDao;
import dto.QnaVO;
import dto.Member;

public class QnaWriteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=qna_list";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "ShopController?command=login_form";
		}else {
			QnaVO qna = new QnaVO();
			qna.setSubject(request.getParameter("subject"));
			qna.setContent(request.getParameter("content"));
			QnaDao qnaDao = QnaDao.getInstance();
			qnaDao.insertqna(qna,loginUser.getId());
		}
		response.sendRedirect(url);
}
}
