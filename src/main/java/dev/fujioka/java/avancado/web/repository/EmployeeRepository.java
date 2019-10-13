package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.function = ?1")
    public Employee findEmployeeByFunction(String function);

    @Query("SELECT e FROM Employee e WHERE e.function like %:substring%")
    public List<Employee> findEmployeesFunctionBySubstring(String substring);


   @Query("SELECT e FROM Employee e WHERE e.name = :name")
   public List<Employee> findEmployeesBysName(String name);

   @Query("SELECT e FROM Employee e WHERE e.name like %:substring%")
   public List<Employee> findEmployeesNameBYSubstring(String substring);

   @Query("DELETE FROM Employee  WHERE name = :name")
   @Transactional
   @Modifying
   public void deleteByName(String name);



}
