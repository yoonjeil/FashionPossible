package dto;

import java.sql.Timestamp;

public class Review {
	private int rno; 
	private String subject; 
	private String content; 
	private String id; 
	private String pseq;
	private int star; 
	private Timestamp indate;
	private String image;
	public int getRno() {
		return rno;
	}
	public Review setRno(int rno) {
		this.rno = rno;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public Review setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Review setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public Review setId(String id) {
		this.id = id;
		return this;
	}
	public String getPseq() {
		return pseq;
	}
	public Review setPseq(String pseq) {
		this.pseq = pseq;
		return this;
	}
	public int getStar() {
		return star;
	}
	public Review setStar(int star) {
		this.star = star;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Review setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Review setImage(String image) {
		this.image = image;
		return this;
	}
	
	
}
