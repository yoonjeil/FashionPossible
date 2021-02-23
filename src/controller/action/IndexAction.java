package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class IndexAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			List<ProductVO> best = ProductDAO.getInstance().listBestProduct();
			List<ProductVO> news = ProductDAO.getInstance().listNewProduct();
			request.setAttribute("news", news);
			request.setAttribute("best", best);
			List<String> bob_images = ProductDAO.getInstance().bestOfBest();
			request.setAttribute("bob_images", bob_images);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
