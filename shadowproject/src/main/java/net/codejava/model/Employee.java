package net.codejava.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;

	 private String name;
	
	private int experience;
private String skills;
	public String getSkills() {
	return skills;
}

public void setSkills(String skills) {
	this.skills = skills;
}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [sno=" + sno + ", name=" + name + ", experience=" + experience + ", skills=" + skills + "]";
	}

	public Employee(int sno, String name, int experience, String skills) {
		super();
		this.sno = sno;
		this.name = name;
		this.experience = experience;
		this.skills = skills;
	}


	 
		

		

	 
	
		
		
	}
