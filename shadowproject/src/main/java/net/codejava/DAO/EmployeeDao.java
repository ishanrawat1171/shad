package net.codejava.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	@Query("SELECT e FROM Employee e WHERE e.sno = ?1")
	public Employee findBySno(int sno);
}