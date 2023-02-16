package com.openclassrooms.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.webapp.model.Employee;
import com.openclassrooms.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeProxy employeeProxy;
	
	/**
	 * Select an employee by id
	 * @param id
	 * @return employee
	 */
	public Employee getEmployee(final int id) {
		return employeeProxy.getEmployee(id);
	}
	
	/**
	 * Select all employees
	 * @return list of employees
	 */
	public Iterable<Employee> getEmployees() {
		return employeeProxy.getEmployees();
	}
	
	/**
	 * Delete an employee
	 * @param id
	 */
	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}
	
	/**
	 * Update an employee
	 * @param employee
	 */
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;
		
		// Règle de gestion pour mettre le nom de famille en majuscule
		employee.setLastName(employee.getLastName().toUpperCase());
		
		if (employee.getId() == null) {
			// Si l'id est null, alors c'est un nouvel employé
			savedEmployee = employeeProxy.createEmployee(employee);
		} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}
		
		return savedEmployee;
	}
}
