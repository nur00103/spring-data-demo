package com.springdata.demo.springdatademo.service;

import com.springdata.demo.springdatademo.model.Employee;
import com.springdata.demo.springdatademo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //Avtomatik final fieldleri constructor injection edir.
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with given id " + id));
    }

    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional //Butun prosesler bir transactionda olur diger hissede xeta cixarsa evvel et. rollback edecek
    public void update(Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("id can not be null");
        }
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeeByNameAndSurname(String name,String surname){
        return employeeRepository.findByNameAndSurname(name,surname);
    }

    public List<Employee> getEmployeeByNameOrSurname(String name,String surname){
        return employeeRepository.findByNameOrSurname(name,surname);
    }

}
