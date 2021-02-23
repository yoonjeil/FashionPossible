package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBAction;
import dto.Member;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	public Member getMember(String id) throws Exception {
		Member member = null;
		String sql = "select * from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_num(rs.getString("zip_num"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getString("useyn"));
				member.setIndate(rs.getTimestamp("indate"));
				member.setGrade(rs.getString("grade"));
				member.setPoint(rs.getInt("point"));
				member.setBalance(rs.getInt("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return member;
	}
	public Member getMemberByMail(String mail) throws Exception {
		Member member = null;
		String sql = "select * from member where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_num(rs.getString("zip_num"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getString("useyn"));
				member.setIndate(rs.getTimestamp("indate"));
				member.setGrade(rs.getString("grade"));
				member.setPoint(rs.getInt("point"));
				member.setBalance(rs.getInt("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return member;
	}
	public int insert(Member member) throws Exception{

		Connection conn = DBAction.getInstance().getConnection();
	    PreparedStatement stmt = null;

		try {
	         stmt = conn.prepareStatement
	      ("INSERT INTO member (ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE,INDATE,GRADE,POINT,BALANCE)" 
	         + " VALUES (?, ?, ?, ?, ?, ?, ?,now(),1,1,1)");
	         stmt.setString(1, member.getId());
	         stmt.setString(2, member.getPwd());
	         stmt.setString(3, member.getName());
	         stmt.setString(4, member.getEmail());
	         stmt.setString(5, member.getZip_num());
	         stmt.setString(6, member.getAddress());
	         stmt.setString(7, member.getPhone());
	         return stmt.executeUpdate();
	         
	      }catch(Exception e) {
	         throw e;
	      } finally {
	         try {
	            if(stmt != null) {stmt.close();}
	            if(conn != null) {conn.close();}
	         }catch (Exception e) {}
	      }

	}
	public int confirmID(String userid) throws Exception{
		int result = -1;
	    String sql = "select * from member where id=?";	       
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;	    
	    try {
	      conn = DBAction.getInstance().getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, userid);
	      rs = pstmt.executeQuery();
	      if (rs.next()) { 
	        result = 1;
	      } else { 
	        result = -1;
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }finally {
	    	if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	    return result;
	  }
	
	public ArrayList<Member> listMember(String member_name) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		String sql = "select * from member where name like '%" + member_name + "%' " +
				" order by indate desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member memberVO = new Member();
				memberVO.setId(rs.getString("id"));
		        memberVO.setPwd(rs.getString("pwd"));
		        memberVO.setName(rs.getString("name"));
		        memberVO.setEmail(rs.getString("email"));
		        memberVO.setZip_num(rs.getString("zip_num"));
		        memberVO.setAddress(rs.getString("address"));
		        memberVO.setPhone(rs.getString("phone"));
		        memberVO.setUseyn(rs.getString("useyn"));
		        memberVO.setIndate(rs.getTimestamp("indate"));
		        memberList.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}

}

