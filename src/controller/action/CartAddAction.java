package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ProductDAO;
import dto.Cart;
import dto.Member;

public class CartAddAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopController?command=cart_list";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser ==null) {
			url = "ShopController?command=login_form";
		}else {
			Cart cart = new Cart();
			cart.setId(loginUser.getId());
			cart.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			CartDao cartDao = CartDao.getInstance();
			cartDao.insertCart(cart);
		}
		response.sendRedirect(url);
//		String url = "jspEx/ShopCart.jsp";
//		HttpSession session = request.getSession();
//		ShopMemberVO loginUser = (ShopMemberVO) session.getAttribute("loginUser");
//		try {
//		if(loginUser == null) {
//			url = "ShopController?command=loginform";
//			
//		}else {
//			ProductDAO cartDao = ProductDAO.getInstance();
//			ArrayList<Cart> cartList = cartDao.listCart(loginUser.getId());
//			
//				
//			}
//			
//		
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher(url).forward(request, response);
	}

	

}
