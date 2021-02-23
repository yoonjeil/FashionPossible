package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBAction;
import dto.QnaVO;

public class QnaDao {
	private static QnaDao instance = new QnaDao();

	public static QnaDao getInstance() {
		return instance;
	}
	public void insertqna(QnaVO qna, String session_id) {
		String sql = "insert into qna(subject,content,id)values (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, session_id);
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

	public QnaVO getQna(int seq) {
		QnaVO qna = null;
		String sql = "select * from qna where qseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qna = new QnaVO();
				qna.setQseq(seq);
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setId(rs.getString("id"));
				qna.setIndate(rs.getTimestamp("indate"));
				qna.setReply(rs.getString("reply"));
				qna.setRep(rs.getString("rep"));
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
		}return qna;
	}
	public ArrayList<QnaVO> listQna(String userId) throws Exception {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		String sql = "select * from qna where id=? order by qseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO qna = new QnaVO();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				qna.setId(rs.getString("id"));
				qna.setRep(rs.getString("rep"));
				qna.setIndate(rs.getTimestamp("indate"));
				qnaList.add(qna);
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
	
	public void deleteQna(int qseq) {
		String sql = "delete from qna where qseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
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
