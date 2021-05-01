package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.EmployeeSkillLink;
import net.codejava.model.Exam;


public interface EmployeeSkillLinkDao extends JpaRepository<EmployeeSkillLink, Long> {
	@Query("SELECT e FROM EmployeeSkillLink e WHERE e.sno = ?1")
	public Exam findbysno(int sno);
	
}