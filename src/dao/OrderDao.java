package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBAction;
import dto.Cart;
import dto.OrderVO;

public class OrderDao {
	private static OrderDao instance = new OrderDao();

	public static OrderDao getInstance() {
		return instance;
	}
	public ArrayList<OrderVO> listOrder(String id, String result, int oseq) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from order_view where id=? and result like '%" + result + "%' and oseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO order = new OrderVO();
				order.setOdseq(rs.getInt("odseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("id"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setMname(rs.getString("mname"));
				order.setZip_num(rs.getString("zip_num"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setPseq(rs.getInt("pseq"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPname(rs.getString("pname"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
				orderList.add(order);
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
		return orderList;
	}

	public int insertOrder(List<Cart> cartList, String id) {
		int maxOseq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			String insertOrder = "insert into orders(id)values(?)";
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			String selectMaxOseq = "select max(oseq) from orders";
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxOseq = rs.getInt(1);
			}
			for (Cart cart : cartList) {
				insertOrderDetail(cart, maxOseq);
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
		return maxOseq;

	}

	public void insertOrderDetail(Cart cart, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			String insertOrderDetail = "insert into order_detail(oseq,pseq,quantity) values (?,?,?)";
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
			pstmt.executeUpdate();
			pstmt.close();
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cart.getCseq());
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

	public ArrayList<Integer> selectSeqOrderIng(String id) {
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "select distinct oseq from order_view where id = ? and result = '1' order by oseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				oseqList.add(rs.getInt(1));
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
		return oseqList;
	}
}
