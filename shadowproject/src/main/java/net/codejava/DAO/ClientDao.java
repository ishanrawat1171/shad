package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Checkout;
import net.codejava.model.Client;

public interface ClientDao extends JpaRepository<Client, Long> {
	@Query("SELECT c FROM Client c WHERE c.email = ?1")
	public Client findByEmail(String email);
	
}