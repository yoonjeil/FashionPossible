package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class RelatedProductAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/RelatedProduct.jsp";
		String kind = request.getParameter("kind").trim();
		ProductDAO productDao = ProductDAO.getInstance();
		ArrayList<ProductVO> relatedProduct = productDao.RelatedProductList(kind);
		request.setAttribute("relatedProduct", relatedProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
