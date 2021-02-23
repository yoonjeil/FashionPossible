package controller;

import controller.action.Action;
import controller.action.AdminAction;
import controller.action.BestOfBestAction;
import controller.action.CartAction;
import controller.action.CartAddAction;
import controller.action.CartDeleteAction;
import controller.action.CategoryAction;
import controller.action.ContractAction;
import controller.action.DetailInfoAction;
import controller.action.FindZipNumAction;
import controller.action.IdCheckFormAction;
import controller.action.IndexAction;
import controller.action.JoinAction;
import controller.action.JoinFormAction;
import controller.action.LogOutAction;
import controller.action.LoginAction;
import controller.action.LoginFormAction;
import controller.action.MailAuthAction;
import controller.action.MyPageAction;
import controller.action.OrderAction;
import controller.action.OrderAddAction;
import controller.action.OrderAddedAction;
import controller.action.OrderAllAction;
import controller.action.OrderDetailAction;
import controller.action.ProductDetailInfoAction;
import controller.action.QnaAction;
import controller.action.QnaDeleteAction;
import controller.action.QnaListAction;
import controller.action.QnaViewAction;
import controller.action.QnaWriteAction;
import controller.action.RelatedProductAction;
import controller.action.ReviewAction;
import controller.action.ReviewListAction;
import controller.action.ReviewViewAction;
import controller.action.ReviewWriteAction;
import controller.action.WorldCupAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("index")) {
			action = new IndexAction();
		}
		 else if (command.equals("contract")) {
			  action = new ContractAction();
		  } else if (command.equals("join_form")) {
		      action = new JoinFormAction();
		  } else if (command.equals("join")) {
			  action = new JoinAction();
		  } else if (command.equals("id_check_form")) {
		      action = new IdCheckFormAction();
		  } else if (command.equals("find_zip_num")) {
		      action = new FindZipNumAction();
		  } else if (command.equals("login_form")) {
		      action = new LoginFormAction();
		  } else if (command.equals("login")) {
		      action = new LoginAction();
		  } else if (command.equals("logout")) {
		      action = new LogOutAction();
		  } else if (command.equals("gmail")) {
			  action = new MailAuthAction();
		  } else if(command.equals("product_detail_info")) {
			  action = new ProductDetailInfoAction();
		  } 		
		else if (command.equals("catagory")) {
			action = new CategoryAction();
		}else if (command.equals("product_detail")) {
//			action = new ProductdetailAction();
			action = new ProductDetailInfoAction();
		}else if (command.equals("cart_list")) {
			action = new CartAction();
		}else if (command.equals("cart_add")) {
			action = new CartAddAction();
		}else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}else if (command.equals("order_list")) {
			action = new OrderAction();
		}
		else if (command.equals("order_add")) {
			action = new OrderAddAction();
		}
		else if (command.equals("order_added")) {
			action = new OrderAddedAction();
		}
		else if (command.equals("mypage")) {
			action = new MyPageAction();
		}else if (command.equals("order_all")){
			action= new OrderAllAction();
		}else if (command.equals("order_detail")) {
			action = new OrderDetailAction();
		}  else if(command.equals("qna_write_form")){
			action = new QnaAction(); 
	    } else if(command.equals("qna_write")){
			action = new QnaWriteAction(); 
	    } else if(command.equals("qna_list")){
			action = new QnaListAction(); 
	    } else if(command.equals("qna_view")){
			action = new QnaViewAction(); 
	    }else if(command.equals("admin")) {
	    	action = new AdminAction();
	    }else if(command.equals("logout")) {
	    	action = new LogOutAction();
	    }else if(command.equals("review_list")) {
	    	action = new ReviewListAction();
	    }else if(command.equals("RelatedProduct")) {
	    	action = new RelatedProductAction();
	    }else if(command.equals("DetailInfo")) {
	    	action = new DetailInfoAction();
	    }else if(command.equals("review_write_form")) {
	    	action = new ReviewAction();
	    }else if(command.equals("review_write")) {
	    	action = new ReviewWriteAction();
	    }
	    else if(command.equals("review_view")) {
	    	action = new ReviewViewAction();
	    }else if(command.equals("worldcup")) {
	    	action = new WorldCupAction();
	    }else if (command.equals("qna_delete")) {
			action = new QnaDeleteAction();
		}
	    else if(command.equals("bestofbest")) {
	    	action = new BestOfBestAction();
	    }
		return action;
	}

}
