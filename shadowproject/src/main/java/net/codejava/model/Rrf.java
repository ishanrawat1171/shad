package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rrf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Sno;
private int experience;
public int getSno() {
	return Sno;
}
public void setSno(int sno) {
	Sno = sno;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
@Override
public String toString() {
	return "Rrf [Sno=" + Sno + ", experience=" + experience + "]";
}
public Rrf(int sno, int experience) {
	super();
	Sno = sno;
	this.experience = experience;
}
public Rrf() {
	super();
	// TODO Auto-generated constructor stub
}

}
