package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Cart;
import dto.Member;

public class OrderAddedAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=order_list";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		try {
		if (loginUser == null) {
			url = "ShopController?command=login_form";
		}else {
			if(request.getParameter("pseq") != null && request.getParameter("quantity") != null ) {
				List<Cart> cartList = new ArrayList<>();
				cartList.add(new Cart(Integer.parseInt(request.getParameter("pseq")), Integer.parseInt(request.getParameter("quantity")), -1));
				OrderDao orderDao = OrderDao.getInstance();
				int maxOseq=orderDao.insertOrder(cartList, loginUser.getId());
				url = "ShopController?command=order_list&oseq=" + maxOseq;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
		
}
