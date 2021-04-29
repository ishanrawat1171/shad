package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Coin;

public interface CoinRepository extends JpaRepository<Coin, Integer> {
	@Query("SELECT u FROM Coin u WHERE u.coinid = ?1")
	public Coin findByCoinId(int coinid);

	
}