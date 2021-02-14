package tech.pedroalmeida.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedroalmeida.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> getEmployeeById(Long id);
}
