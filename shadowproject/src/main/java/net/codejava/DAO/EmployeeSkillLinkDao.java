package net.codejava.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Employee;
import net.codejava.model.EmployeeSkillLink;
import net.codejava.model.Exam;


public interface EmployeeSkillLinkDao extends JpaRepository<EmployeeSkillLink, Long> {
	@Query("SELECT e FROM EmployeeSkillLink e WHERE e.sno = ?1")
	public Employee findbysno(int sno);
	@Query("SELECT empSno FROM EmployeeSkillLink")
	public List<Integer> getAllid();
	@Query("SELECT e.skillSno FROM EmployeeSkillLink e WHERE e.empSno = ?1")
	public List<String>retskillno(int empSo);
	
}