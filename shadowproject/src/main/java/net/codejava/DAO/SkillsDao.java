
package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Exam;
import net.codejava.model.skills;

public interface SkillsDao extends JpaRepository<skills, Long> {
	@Query("SELECT e FROM skills e WHERE e.sno = ?1")
	public skills findBySno(int sno);
	
}
