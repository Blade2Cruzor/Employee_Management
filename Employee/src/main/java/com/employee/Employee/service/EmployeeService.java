package com.employee.Employee.service;

import java.util.List;

import com.employee.Employee.dto.EmployeeDTO;
import com.employee.Employee.exception.EmployeeNotExist;

public interface EmployeeService
{
	//create
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	//read/GET
	List<EmployeeDTO> getAllEmployees();
	
	//update
	EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO) throws EmployeeNotExist;
	
	//delete
	void deleteEmployee(Long employeeID) throws EmployeeNotExist;
	
	//deleteAll
	void deleteAllEmployees();
}
