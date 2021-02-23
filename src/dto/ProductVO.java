package dto;

import java.sql.Timestamp;

public class ProductVO {
	private Timestamp indate;
	private int pseq;
	private String kind;
	private String bestyn;
	private String useyn;
	private String name;
	private int price1;
	private int price2;
	private int price3;
	private String image;
	private String content;
	private String content2;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String coupon;
	public String getContent() {
		return content;
	}
	public ProductVO setContent(String content) {
		this.content = content;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public ProductVO setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public ProductVO setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public ProductVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getBestyn() {
		return bestyn;
	}
	public ProductVO setBestyn(String bestyn) {
		this.bestyn = bestyn;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public ProductVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public String getName() {
		return name;
	}
	public ProductVO setName(String name) {
		this.name = name;
		return this;
	}
	public int getPrice1() {
		return price1;
	}
	public ProductVO setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public ProductVO setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getPrice3() {
		return price3;
	}
	public ProductVO setPrice3(int price3) {
		this.price3 = price3;
		return this;
	}
	public String getImage() {
		return image;
	}
	public ProductVO setImage(String image) {
		this.image = image;
		return this;
	}
	public String getContent2() {
		return content2;
	}
	public ProductVO setContent2(String content2) {
		this.content2 = content2;
		return this;
	}
	public String getImage2() {
		return image2;
	}
	public ProductVO setImage2(String image2) {
		this.image2 = image2;
		return this;
	}
	public String getImage3() {
		return image3;
	}
	public ProductVO setImage3(String image3) {
		this.image3 = image3;
		return this;
	}
	public String getImage4() {
		return image4;
	}
	public ProductVO setImage4(String image4) {
		this.image4 = image4;
		return this;
	}
	public String getImage5() {
		return image5;
	}
	public ProductVO setImage5(String image5) {
		this.image5 = image5;
		return this;
	}
	public String getCoupon() {
		return coupon;
	}
	public ProductVO setCoupon(String coupon) {
		this.coupon = coupon;
		return this;
	}
}
