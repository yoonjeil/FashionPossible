package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.Address;
import db.DBAction;
public class AddressDAO {
  private AddressDAO() {
  }
  private static AddressDAO instance = new AddressDAO();
  public static AddressDAO getInstance() {
    return instance;
  }
  public ArrayList<Address> selectAddressByDong(String dong) 
  throws Exception{    
    ArrayList<Address> list = new ArrayList<Address>();    
    String sql = "select * from address where dong like '%" + dong + "%'";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = DBAction.getInstance().getConnection();
      pstmt = conn.prepareStatement(sql);      
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Address address = new Address();
        address.setzipNum(rs.getString("zip_num"));
        address.setSido(rs.getString("sido"));
        address.setGugun(rs.getString("gugun"));
        address.setDong(rs.getString("dong"));
        address.setzipCode(rs.getString("zip_code"));
        address.setBunji(rs.getString("bunji"));
        list.add(address);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
    	if(rs != null) rs.close();
    	if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
    }
    return list;
  }
}
