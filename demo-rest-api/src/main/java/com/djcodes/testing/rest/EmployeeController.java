package com.djcodes.testing.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<Employee>();

	@PostConstruct
	public void initialiseEmployees() {
		employees.add(new Employee(1, "John", 30, "M", 111000));
		employees.add(new Employee(2, "Jane", 28, "F", 95000));
		employees.add(new Employee(3, "Sam", 38, "M", 150000));
		employees.add(new Employee(4, "Aloy", 27, "F", 88000));
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/welcome")
	public String welcome() {
		return "Welcome to employee controller";
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/getEmployeeList")
	public ResponseEntity<?> getEmployeeList() {
		return ResponseEntity.ok(employees);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
		Optional<Employee> employee = employees.stream().filter(emp -> emp.getId() == id).findFirst();
		if (employee.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(employee.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = "/searchBySalaryGreaterThan")
	public ResponseEntity<?> searchBySalaryGreaterThan(@RequestParam(value = "amt", required = true) double amt) {
		List<Employee> emps = employees.stream().filter(emp -> emp.getSalary() > amt).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(emps);

	}

}
