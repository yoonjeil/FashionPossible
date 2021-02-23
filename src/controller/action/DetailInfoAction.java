package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class DetailInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String pseq = request.getParameter("pseq");	      
	      try {	         
	         ProductVO detail = ProductDAO.getInstance().DetailInfo(pseq);
	         request.setAttribute("detail", detail);	         
	         request.getRequestDispatcher("product/detail_info.jsp").forward(request, response);	        
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
		}
}
