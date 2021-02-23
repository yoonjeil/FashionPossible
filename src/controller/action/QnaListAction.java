package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dto.Member;
import dto.QnaVO;

public class QnaListAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/QnaList.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		try {
		if(loginUser == null) {
			url = "ShopController?command=login_form";
			
		}else {
			QnaDao qnaDao = QnaDao.getInstance();
			ArrayList<QnaVO> qnaList = qnaDao.listQna(loginUser.getId());
			
			request.setAttribute("qnaList", qnaList);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
