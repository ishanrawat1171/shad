package net.codejava.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Buyer implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int buyerId;
@Column(name = "buyerName", nullable = false, length = 20)
private String buyerName;
@Column(name = "buyeremail", nullable = false, length = 40)
private String buyeremail;
@Column(columnDefinition = "int" ,name="Buyerpincode")
private int Buyerpincode;
@Column(name = "flatno", nullable = false, length = 20)
private String flatno;
@Column(name = "area", nullable = false, length = 20)
private String area;
@Column(name = "landmark", nullable = false, length = 20)
private String landmark;
@Column(name = "town", nullable = false, length = 20)
private String town;


public int getBuyerId() {
	return buyerId;
}
public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
public String getBuyerName() {
	return buyerName;
}
public void setBuyerName(String buyerName) {
	this.buyerName = buyerName;
}
public String getBuyeremail() {
	return buyeremail;
}
public void setBuyeremail(String buyeremail) {
	this.buyeremail = buyeremail;
}
public int getBuyerpincode() {
	return Buyerpincode;
}
public void setBuyerpincode(int buyerpincode) {
	Buyerpincode = buyerpincode;
}
public String getFlatno() {
	return flatno;
}
public void setFlatno(String flatno) {
	this.flatno = flatno;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}



public Buyer(int buyerId, String buyerName, String buyeremail, int buyerpincode, String flatno, String area,
		String landmark, String town, String buy) {
	super();
	this.buyerId = buyerId;
	this.buyerName = buyerName;
	this.buyeremail = buyeremail;
	Buyerpincode = buyerpincode;
	this.flatno = flatno;
	this.area = area;
	this.landmark = landmark;
	this.town = town;
	
}
public Buyer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", buyeremail=" + buyeremail + ", Buyerpincode="
			+ Buyerpincode + ", flatno=" + flatno + ", area=" + area + ", landmark=" + landmark + ", town=" + town
			+ "]";
}

}