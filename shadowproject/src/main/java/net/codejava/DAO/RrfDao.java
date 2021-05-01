package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Rrf;

public interface RrfDao extends JpaRepository<Rrf, Long> {
	@Query("SELECT e FROM Rrf e WHERE e.Sno = ?1")
	public Rrf findBySno(int Sno);
}

