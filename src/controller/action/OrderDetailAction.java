package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.ProductDAO;
import dto.OrderVO;
import dto.Member;

public class OrderDetailAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderDetail.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "ShopController?command=login_form";
		
		}else {
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			OrderDao orderDao = OrderDao.getInstance();
			ArrayList<OrderVO> orderList = orderDao.listOrder(loginUser.getId(),"%", oseq);
			int totalPrice=0;
			for(OrderVO ordering :orderList) {
				totalPrice+= ordering.getPrice2()*ordering.getQuantity();
				}
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
