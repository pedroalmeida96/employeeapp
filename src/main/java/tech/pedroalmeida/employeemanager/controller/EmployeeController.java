package tech.pedroalmeida.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.pedroalmeida.employeemanager.model.Employee;
import tech.pedroalmeida.employeemanager.service.EmployeeService;
import tech.pedroalmeida.employeemanager.utils.Mappings;

import java.util.List;

@RestController
@RequestMapping(Mappings.EMPLOYEES)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(Mappings.ALL)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(Mappings.FIND_BY_ID)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping(Mappings.ADD_EMPLOYEE)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping(Mappings.UPDATE_EMPLOYEE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping(Mappings.DELETE_EMPLOYEE)
    @Transactional
    public ResponseEntity<?> removeEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
