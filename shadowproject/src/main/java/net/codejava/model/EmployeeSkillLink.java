package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeSkillLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
public EmployeeSkillLink() {
		super();
		// TODO Auto-generated constructor stub
	}
private int empSno;
private int skillSno;
public EmployeeSkillLink(int empSno, int skillSno) {
	super();
	this.empSno = empSno;
	this.skillSno = skillSno;
}
@Override
public String toString() {
	return "EmployeeSkillLink [empSno=" + empSno + ", skillSno=" + skillSno + "]";
}
public int getEmpSno() {
	return empSno;
}
public void setEmpSno(int empSno) {
	this.empSno = empSno;
}
public int getSkillSno() {
	return skillSno;
}
public void setSkillSno(int skillSno) {
	this.skillSno = skillSno;
}
}
