package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ProductDAO;
import dto.Cart;
import dto.Member;

public class CartAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/Cart.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		try {
		if(loginUser == null) {
			url = "ShopController?command=login_form";
			
		}else {
			CartDao cartDao = CartDao.getInstance();
			ArrayList<Cart> cartList = cartDao.listCart(loginUser.getId());
			int totalPrice = 0;
			for (Cart cart :cartList) {
				totalPrice += cart.getPrice2()* cart.getQuantity();
				
			}
			request.setAttribute("cartList", cartList);
			request.setAttribute("totalPrice",totalPrice);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
