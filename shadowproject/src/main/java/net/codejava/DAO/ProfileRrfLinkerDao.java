package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.ProfileRrfLinker;
import net.codejava.model.Rrf;

public interface ProfileRrfLinkerDao  extends JpaRepository<ProfileRrfLinker, Long> {
	@Query("SELECT e FROM ProfileRrfLinker e WHERE e.prno = ?1")
	public ProfileRrfLinker findBySno(int Sno);
}
