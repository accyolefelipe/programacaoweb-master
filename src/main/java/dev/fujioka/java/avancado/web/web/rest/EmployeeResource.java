package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Employee;
import dev.fujioka.java.avancado.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployeeList(){

        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employee = employeeService.save(employee).get();

        return ResponseEntity.ok().body(employee);
    }
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        employee = employeeService.save(employee).get();

        return ResponseEntity.ok().body(employee);
    }
    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        employeeService.delete(employee);

        return  ResponseEntity.ok().body("Empregado Excluido" + employee.getId());
    }

    @GetMapping("/employee/by-function/{function}")
    public ResponseEntity<?> findByFunction(@PathVariable String function){
        return new ResponseEntity<>(employeeService.findByFunction(function), HttpStatus.OK);
    }

    @GetMapping("/employee/substringfunction/{substring}")
    public ResponseEntity<?> findFunctionBySubstring(@PathVariable String substring){
        return new ResponseEntity<>(employeeService.findFunctionBySubString(substring), HttpStatus.OK);
    }

    @GetMapping("/employee/by-name/{name}")
    public ResponseEntity<?> findEmployeesByName(@PathVariable String name) {
        return new ResponseEntity<>(employeeService.findEmployeeByName(name), HttpStatus.OK);

    }

    @GetMapping("/employee/substringname/{substring}")
    public ResponseEntity<?> findNameBySubstring(@PathVariable String substring){
        return new ResponseEntity<>(employeeService.findNameBySubString(substring), HttpStatus.OK);
    }

    @DeleteMapping("/employee/deletebyname/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        employeeService.deleteByName(name);
        return new ResponseEntity<>("Empregado Excluido " + name, HttpStatus.OK);
    }
}
