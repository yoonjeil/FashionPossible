package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBAction;
import dto.ProductVO;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	public ArrayList<ProductVO> listNewProduct() throws Exception {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from new_pro_view";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	public ArrayList<ProductVO> listBestProduct() {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from best_pro_view";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;

	}

	public ArrayList<ProductVO> listKindProduct(String kind) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from product where kind=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	public ArrayList<ProductVO> bestItemList(String bob) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from product_detail where image=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bob);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	public ProductVO pseqProduct(String pseq) throws Exception {
		ProductVO pseqProduct = new ProductVO();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product where pseq='" + pseq + "'");
			if (rs.next()) {
				pseqProduct.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setPrice2(rs.getInt("price2"))
						.setContent(rs.getString("content")).setImage(rs.getString("image"))
						.setIndate(rs.getTimestamp("indate"))
						.setKind(rs.getString("KIND"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pseqProduct;
	}
	public ProductVO getProduct(String bob_img) throws Exception {
		ProductVO pseqProduct = new ProductVO();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product where image='" + bob_img + "'");
			if (rs.next()) {
				pseqProduct.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setPrice2(rs.getInt("price2"))
				.setContent(rs.getString("content")).setImage(rs.getString("image"))
				.setIndate(rs.getTimestamp("indate"))
				.setKind(rs.getString("KIND"))				
				.setCoupon(bob_img); // issue
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pseqProduct;
	}
	public ArrayList<ProductVO> RelatedProductList(String kind) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from product where kind=? limit 4";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	
	public ProductVO DetailInfo(String pseq) throws Exception {
		ProductVO detailInfo = new ProductVO();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product inner join product_detail on product.pseq = product_detail.pseq");
			if (rs.next()) {
				detailInfo.setPseq(rs.getInt("pseq"))
							.setName(rs.getString("name"))
							.setPrice2(rs.getInt("price2"))
							.setContent(rs.getString("content"))
							.setImage(rs.getString("image"))
							.setIndate(rs.getTimestamp("indate"))
							.setImage2(rs.getString("image2"))
							.setImage3(rs.getString("image3"))
							.setImage4(rs.getString("image4"))
							.setImage5(rs.getString("image5"))
							.setContent2(rs.getString("content2"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return detailInfo;
	}
	public List<String> bestOfBest() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> bob_images = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select image from order_detail od, product p "
					+ " where od.result=2 and p.useyn = 'y' and od.pseq = p.pseq " 
					+ " group by od.pseq order by count(od.pseq) desc limit 20");
			bob_images = new ArrayList<>();
			while(rs.next()) {
				bob_images.add(rs.getString(1));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (stmt != null)stmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return bob_images;
	}
	public List<String> bestOfBestImages(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> bob_pseq_top10_images = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select pseq from order_detail od, product p "
					+ " where od.result=2 and p.useyn = 'y' and od.pseq = p.pseq " 
					+ " group by od.pseq order by count(od.pseq) desc limit 10");
			bob_pseq_top10_images = new ArrayList<>();
			while(rs.next()) {
				bob_pseq_top10_images.add(rs.getString(1));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (stmt != null)stmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return bob_pseq_top10_images;
	}	
}
