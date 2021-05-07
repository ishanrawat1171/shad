
package net.codejava.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Exam;
import net.codejava.model.skills;

public interface SkillsDao extends JpaRepository<skills, Long> {
	@Query("SELECT e FROM skills e WHERE e.sno = ?1")
	public skills findBySno(int sno);
	@Query("SELECT e.skill FROM skills e")
	public skills findall();
	@Query("SELECT e FROM skills e WHERE e.skill=?1")
	public List<skills> findbyskill(String skill);
}
