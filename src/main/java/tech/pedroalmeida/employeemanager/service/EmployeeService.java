package tech.pedroalmeida.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pedroalmeida.employeemanager.exceptions.UserNotFoundException;
import tech.pedroalmeida.employeemanager.model.Employee;
import tech.pedroalmeida.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee getEmployee(Long id) {
        return employeeRepo.getEmployeeById(id).orElseThrow(() -> new UserNotFoundException(""));

    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCde(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void removeEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);


    }


}
