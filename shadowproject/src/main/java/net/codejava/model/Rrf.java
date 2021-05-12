package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rrf {
	@Id
private int Sno;
private int experience;
private String skills;
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
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public Rrf(int sno, int experience, String skills) {
	super();
	Sno = sno;
	this.experience = experience;
	this.skills = skills;
}
public Rrf() {
	super();
	// TODO Auto-generated constructor stub
}



}
