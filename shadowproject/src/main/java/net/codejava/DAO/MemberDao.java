package net.codejava.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Member;
import net.codejava.model.User;

public interface MemberDao extends JpaRepository<Member, String> {
	@Query("SELECT u FROM Member u WHERE u.email = ?1")
	public Member findByEmail(String email);
	

}
