package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RrfSkillLinker {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sno;
private int skillsno;
private int rrfno;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getSkillsno() {
	return skillsno;
}
public void setSkillsno(int skillsno) {
	this.skillsno = skillsno;
}
public int getRrfno() {
	return rrfno;
}
public RrfSkillLinker(int sno, int skillsno, int rrfno) {
	super();
	this.sno = sno;
	this.skillsno = skillsno;
	this.rrfno = rrfno;
}
public RrfSkillLinker() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "RrfSkillLinker [sno=" + sno + ", skillsno=" + skillsno + ", rrfno=" + rrfno + "]";
}
public void setRrfno(int rrfno) {
	this.rrfno = rrfno;
}


}
