package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.domain.Employee;
import dev.fujioka.java.avancado.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements CrudInterface<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> save(Employee entity) {
        return Optional.of(employeeRepository.save(entity));
    }

    @Override
    public void delete(Employee entity) { employeeRepository.delete(entity);

    }

    @Override
    public void deleteById(long id) { employeeRepository.deleteById(id);

    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    public Employee findByFunction(String function) {
        return employeeRepository.findEmployeeByFunction(function);
    }

    public List<Employee> findFunctionBySubString(String function) {
        return employeeRepository.findEmployeesFunctionBySubstring(function);
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findEmployeesBysName(name);
    }

    public List<Employee> findNameBySubString(String name) {
        return employeeRepository.findEmployeesNameBYSubstring(name);
    }
    public void deleteByName(String name){
        employeeRepository.deleteByName(name);
    }
}
