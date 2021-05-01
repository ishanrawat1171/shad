package net.codejava.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.RrfSkillLinker;

public interface RrfSkillLinkerDao extends JpaRepository<RrfSkillLinker, Long> {
	@Query("SELECT e FROM RrfSkillLinker e WHERE e.sno = ?1")
	public RrfSkillLinker findbysno(int sno);
	@Query("SELECT e.skillsno FROM RrfSkillLinker e WHERE e.rrfno = ?1")
	public List<String> retskillno(int empsno);
}
