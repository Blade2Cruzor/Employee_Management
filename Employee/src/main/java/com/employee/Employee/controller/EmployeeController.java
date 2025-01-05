package com.employee.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee.dto.EmployeeDTO;
import com.employee.Employee.exception.EmployeeNotExist;
import com.employee.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
	@Autowired
	EmployeeService employeeService;
	
	//CREATE
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO createdEmpDTO = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(createdEmpDTO, HttpStatus.CREATED);
	}
	
	//GET
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
	{
		List<EmployeeDTO> employees =  employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	//UPDATE
    @PutMapping("/update/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long employeeID,
            @RequestBody EmployeeDTO employeeDTO) throws EmployeeNotExist
    {
    	EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeID, employeeDTO);			
        
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    
    //DELETE
    @DeleteMapping("/delete/{employeeID}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeID) throws EmployeeNotExist
    {
    	employeeService.deleteEmployee(employeeID);
        String response = "Entity with id: " + employeeID + " has been removed";
        
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    //DELETE ALL
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee()
    {
    	employeeService.deleteAllEmployees();
        String response = "All records has been removed";
        
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
