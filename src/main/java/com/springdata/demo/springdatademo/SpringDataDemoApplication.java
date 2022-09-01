package com.springdata.demo.springdatademo;

import com.springdata.demo.springdatademo.model.Address;
import com.springdata.demo.springdatademo.model.Employee;
import com.springdata.demo.springdatademo.service.AddressService;
import com.springdata.demo.springdatademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setName("Sabina");
		employee.setSurname("Babayeva");
		employee.setAge(23);
		employee.setSalary(1300);
		employeeService.insert(employee);

		Address address=new Address();
		address.setCity("Baku");
		address.setEmployee(employee);
		addressService.insert(address);

		employeeService.getAllEmployees().forEach(System.out::println);


	}
}
