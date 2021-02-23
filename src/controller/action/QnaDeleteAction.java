package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.QnaDao;

public class QnaDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=qna_list";
		String[] qseqArr = request.getParameterValues("qseq");
		if(qseqArr != null) {
			for (String qseq: qseqArr) {
				QnaDao qnadao = QnaDao.getInstance();
				qnadao.deleteQna(Integer.parseInt(qseq));
			}
	//		HttpSession session = request.getSession();
	//		ShopMemberVO member2 = (ShopMemberVO)session.getAttribute("member2");
	//		String id = member2.getId();
	//		String cseq = request.getParameter("cseq");
	//		String[] cseqs = new String[10];
	//		StringTokenizer st = new StringTokenizer(cseq,"/");
	//		for(int i=0;st.hasMoreElements();i++) {
	//			cseqs[i]=st.nextToken();
	//		}try {
	//			Cart deletecart = new ProductDAO().delete(id, cseqs);
	//			request.setAttribute("deletecart", deletecart);
	//			request.getRequestDispatcher("ShopController?command=cart_list").forward(request, response);
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//		}
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
