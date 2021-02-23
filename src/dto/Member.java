package dto;

import java.sql.Timestamp;

public class Member {
	private String address;
	private String id;
	private String email;
	private Timestamp indate;
	private String name;
	private String phone;
	private String pwd;
	private String useyn;
	private String grade;
	private int point;
	private int balance;
	public Member() {}
	public Member(String address, String id, String email, Timestamp indate,String name,String phone,String pwd,String useyn,String grade,int point, int balance){
		this.address = address;
		this.id = id;
		this.email = email;
		this.indate = indate;
		this.name = name;
		this.phone = phone;
		this.pwd= pwd;
		this.useyn = useyn;
		this.grade = grade;
		this.point = point;
		this.balance= balance;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
		
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
		
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
		
	}	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	private String zip_num;
}
