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

public class OrderAllAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser == null) {
			url = "ShopController?command=login_form";
		
		}else {
			OrderDao orderDao = OrderDao.getInstance();
			ArrayList<Integer> oseqList = orderDao.selectSeqOrderIng(loginUser.getId());
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
			for(int oseq : oseqList) {
				
				ArrayList<OrderVO> orderListIng = orderDao.listOrder(loginUser.getId(),"%", oseq);
				OrderVO order = orderListIng.get(0);
				String str = (order.getPname()+"외"+(orderListIng.size()-1)+"건");
				order.setPname(str);
				int totalPrice = 0;
				for (OrderVO ordering: orderListIng) {
					totalPrice+= ordering.getPrice2()*ordering.getQuantity();
				}
				order.setPrice2(totalPrice);
				orderList.add(order);
			}
			request.setAttribute("title", "총 주문 내역");
			request.setAttribute("orderList", orderList);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
