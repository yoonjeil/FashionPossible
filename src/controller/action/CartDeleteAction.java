package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.ProductDAO;

public class CartDeleteAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=cart_list";
		String[] cseqArr = request.getParameterValues("cseq");
		if(cseqArr != null) {
			for (String cseq: cseqArr) {
				CartDao productdao = CartDao.getInstance();
				productdao.deleteCart(Integer.parseInt(cseq));
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
