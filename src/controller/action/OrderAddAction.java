package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.OrderDao;
import dao.ProductDAO;
import dto.Cart;
import dto.Member;

public class OrderAddAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=order_list";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		try {
		if (loginUser == null) {
			url = "ShopController?command=loginform";
		}else {
			CartDao cartDao = CartDao.getInstance();
			ArrayList<Cart> cartList = cartDao.listCart(loginUser.getId());
			OrderDao orderDao = OrderDao.getInstance();
			int maxOseq=orderDao.insertOrder(cartList, loginUser.getId());
			url = "ShopController?command=order_list&oseq=" + maxOseq;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
		
}
