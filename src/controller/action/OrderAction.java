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

public class OrderAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderList.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if (loginUser == null) {
	         url = "ShopController?command=login_form";
	      } else {
	    	  OrderDao orderDao = OrderDao.getInstance();
//	    	  ArrayList<OrderVO> orderList = orderDao.listOrder(loginUser.getId());
	         int oseq = Integer.parseInt(request.getParameter("oseq"));
	         ArrayList<OrderVO> orderList = orderDao.listOrder(loginUser.getId(), "1", oseq);
	         int totalPrice = 0;
	         for (OrderVO order : orderList) {
	            totalPrice += order.getPrice2() * order.getQuantity();
	         }
	         request.setAttribute("orderList", orderList);
	         request.setAttribute("totalPrice", totalPrice);
	      }

//		try {
//		if(loginUser == null) {
//			url = "ShopController?command=loginform";
//			
//		}else {
//			ProductDAO orderDao = ProductDAO.getInstance();
//			int oseq=Integer.parseInt(request.getParameter("oseq"));
//			ArrayList<OrderVO> orderList = orderDao.listOrder(loginUser.getId(),"1",oseq);
//			
////			ArrayList<OrderVO> orderList = orderDao.listOrder(loginUser.getId());
//			int totalPrice = 0;
//			for (OrderVO order :orderList) {
//				totalPrice += order.getPrice2()* order.getQuantity();
//				
//			
//			}
//			request.setAttribute("orderList", orderList);
//			request.setAttribute("totalPrice",totalPrice);
//		}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
