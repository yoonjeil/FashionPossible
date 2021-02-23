package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class CategoryAction implements Action {
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		String kind = request.getParameter("kind");
//		try {
//			response.setContentType("text/html; charset=UTF-8");
//			ArrayList<ProductVO> kindProduct = ProductDAO.getInstance().exist(kind);
//			request.setAttribute("kindProduct", kindProduct);
//			request.getRequestDispatcher("jspEx/Heels.jsp").forward(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
		
		String url = "product/ProductKindList.jsp";
				String kind = request.getParameter("kind").trim();
		ProductDAO productDao=ProductDAO.getInstance();
		ArrayList<ProductVO>productKindList = productDao.listKindProduct(kind);
		request.setAttribute("productKindList", productKindList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}
}
