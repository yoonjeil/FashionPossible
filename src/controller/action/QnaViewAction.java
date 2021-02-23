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

public class QnaViewAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/QnaView.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "ShopController?command=loginform";
		
		}else {
			int qseq = Integer.parseInt(request.getParameter("qseq"));
			QnaDao qnaDao = QnaDao.getInstance();
			QnaVO qna = qnaDao.getQna(qseq);
			request.setAttribute("qna", qna);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}		
}
