package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.phone = ?1")
    public Customer findCustomerByPhone(String phone);

    @Query("SELECT c FROM Customer c WHERE c.phone like %:substring%")
    public List<Customer> findCustomersPhoneBySubstring(String substring);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    public List<Customer> findCustomersBysName(String name);

    @Query("SELECT c FROM Customer c WHERE c.name like %:substring%")
    public List<Customer> findCustomersNameBYSubstring(String substring);

    @Query("DELETE FROM Customer  WHERE name = :name")
    @Transactional
    @Modifying
    public void deleteByName(String name);
}
