package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Rrf;

public interface RrfDao extends JpaRepository<Rrf, Integer> {
	public Rrf findById(int Sno);
	
 
}