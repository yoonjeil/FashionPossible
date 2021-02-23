package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBAction;
import dto.Cart;

public class CartDao {
	private static CartDao instance = new CartDao();

	public static CartDao getInstance() {
		return instance;
	}
	public ArrayList<Cart> listCart(String userId) throws Exception {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		String sql = "select * from cart_view where id = ? order by cseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCseq(rs.getInt(1));
				cart.setId(rs.getString(2));
				cart.setPseq(rs.getInt(3));
				cart.setMname(rs.getString(4));
				cart.setPname(rs.getString(5));
				cart.setQuantity(rs.getInt(6));
				cart.setIndate(rs.getTimestamp(7));
				cart.setPrice2(rs.getInt(8));
				cart.setImage(rs.getString(10));
				cart.setImage(rs.getString(9));
				cart.setResult(rs.getString(9));
				cart.setImage(rs.getString(10));
				cartList.add(cart);
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
		return cartList;
	}

	public void insertCart(Cart cart) {
		String sql = "insert into cart(id, pseq, quantity) values (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cart.getId());
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteCart(int cseq) {
		String sql = "delete from cart where cseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
