package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class ProductdetailAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
	      String pseq = request.getParameter("pseq");	      
	      try {	         
	         ProductVO product1 = ProductDAO.getInstance().pseqProduct(pseq);
	         request.setAttribute("product1", product1);	         
	         request.getRequestDispatcher("product/ProductDetail.jsp").forward(request, response);	        
	      }catch(Exception e) {
	         e.printStackTrace();   
	      }
	   }
}
