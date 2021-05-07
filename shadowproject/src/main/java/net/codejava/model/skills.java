package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class skills {
public skills() {
		super();
		// TODO Auto-generated constructor stub
	}
private String skill;
@Id
private String sno;
@Override
public String toString() {
	return "skills [skill=" + skill + ", sno=" + sno + "]";
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public skills(String skill, String sno) {
	super();
	this.skill = skill;
	this.sno = sno;
}

}
