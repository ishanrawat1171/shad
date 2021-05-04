package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileRrfLinker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
private int prno;
private int rrfno;
public int getPrno() {
	return prno;
}
public void setPrno(int prno) {
	this.prno = prno;
}
public int getRrfno() {
	return rrfno;
}
public void setRrfno(int rrfno) {
	this.rrfno = rrfno; 
}
public ProfileRrfLinker() {
	super();
	// TODO Auto-generated constructor stub
}
public ProfileRrfLinker(int prno, int rrfno) {
	super();
	this.prno = prno;
	this.rrfno = rrfno;
}
@Override
public String toString() {
	return "ProfileRrfLinker [prno=" + prno + ", rrfno=" + rrfno + "]";
}

}
