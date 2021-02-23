package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.QnaDao;
import dao.ReviewDao;
import dto.Member;
import dto.ProductVO;
import dto.QnaVO;
import dto.Review;

public class ProductDetailInfoAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
	      String pseq = request.getParameter("pseq");	      
	      String info = request.getParameter("info") != null ? request.getParameter("info") : "default";	      
	      try {		    	  
	    	  HttpSession session = request.getSession();
	    	  Member loginUser = (Member) session.getAttribute("loginUser");	
	    	  switch(info) {
//	    	  case "qna" :
//				if (loginUser == null) {
//					// url = "ShopController?command=login_form";
//					// qnaList // null이면 로그인해야 볼 수 있다.
//				} else {
//					request.setAttribute("isResult", QnaDao.getInstance().listQna(loginUser.getId()));
//					request.setAttribute("actionPath", "/qna/QnaList.jsp");	
//				}
//				break;
	    	  case "review_list" : 
					request.setAttribute("isResult", ReviewDao.getInstance().listReview(pseq));
					request.setAttribute("actionPath", "/review/ReviewList.jsp");						 
	    		    break;
	    	  case "detail_info" :
	    		  	request.setAttribute("isResult", ProductDAO.getInstance().DetailInfo(pseq));
					request.setAttribute("actionPath", "/product/detail_info.jsp");	
	    		  break;
	    	  case "kind_list" :
	    			if(request.getParameter("kind") != null ) {
		    		  	request.setAttribute("isResult", ProductDAO.getInstance().RelatedProductList(request.getParameter("kind")));
						request.setAttribute("actionPath", "/product/RelatedProduct.jsp");
	    			}
	    		  break;
	    	  default :  // detail_info 	  
	    		  request.setAttribute("isResult", ProductDAO.getInstance().DetailInfo(pseq));
				  request.setAttribute("actionPath", "/product/detail_info.jsp");	
	    	  }
	    	  ProductVO product1 = null;
	    	 if(request.getParameter("bob") != null ) product1 = ProductDAO.getInstance()
	    			 .getProduct(request.getParameter("bob"));
	    	 else product1 = ProductDAO.getInstance().pseqProduct(pseq);
	         request.setAttribute("product1", product1);	         
	         request.getRequestDispatcher("product/ProductDetail.jsp").forward(request, response);	        
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
}
