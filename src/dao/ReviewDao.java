package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBAction;
import dto.QnaVO;
import dto.Review;

public class ReviewDao {
	private static ReviewDao instance = new ReviewDao();

	public static ReviewDao getInstance() {
		return instance;
	}

	public ArrayList<Review> listReview(String pseq) throws Exception {
		ArrayList<Review> qnaList = new ArrayList<Review>();		
		String sql = "select * from review where pseq=? order by rno desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setRno(rs.getInt("rno"));
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setId(rs.getString("id"));
				review.setPseq(rs.getString("pseq"));
				review.setStar(rs.getInt("star"));
				review.setIndate(rs.getTimestamp("indate"));
				review.setImage(rs.getString("image"));
				qnaList.add(review);
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
		return qnaList;
	}
	
	public void insertreview(Review review, String session_id) {
		String sql = "insert into review(subject,content,id,pseq)values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getSubject());
			pstmt.setString(2, review.getContent());
			pstmt.setString(3, session_id);
			pstmt.setString(4, review.getPseq());
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
	
	public Review getReview(int rno) {
		Review review = null;
		String sql = "select * from review where rno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				review = new Review();
				review.setRno(rno);
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setId(rs.getString("id"));
				review.setPseq(rs.getString("pseq"));
				review.setIndate(rs.getTimestamp("indate"));
				review.setImage(rs.getString("image"));
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
		}return review;
	}
}
