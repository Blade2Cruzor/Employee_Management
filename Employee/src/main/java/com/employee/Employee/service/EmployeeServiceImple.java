package com.employee.Employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.Employee.dto.EmployeeDTO;
import com.employee.Employee.entity.EmployeeEntity;
import com.employee.Employee.exception.EmployeeNotExist;
import com.employee.Employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImple implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	//CREATE
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO)
	{
		EmployeeEntity createdEmpEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
		//createdEmpEntity.setEmpDOB(java.sql.Date.valueOf(employeeDTO.getEmpDOB()));
		EmployeeEntity savedEmpEntity = employeeRepository.save(createdEmpEntity);
		
		
		return modelMapper.map(savedEmpEntity, EmployeeDTO.class);
	}

	//GET
	@Override
	public List<EmployeeDTO> getAllEmployees()
	{
		List<EmployeeEntity> employees = (List<EmployeeEntity>) employeeRepository.findAll();
		
		return employees.stream()
				.map(employee -> modelMapper.map(employee, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

	//UPDATE
	@Override
	public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO) throws EmployeeNotExist
	{
		//check if id exist or not
		if(!employeeRepository.existsById(employeeID))
			throw new EmployeeNotExist("Employee not exist with id: " + employeeID);
		
		EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
		employeeEntity.setEmpID(employeeID);
		EmployeeEntity updatedEmpEntity = employeeRepository.save(employeeEntity);
		
		return modelMapper.map(updatedEmpEntity, EmployeeDTO.class);
	}

	@Override
	public void deleteEmployee(Long employeeID) throws EmployeeNotExist
	{
		//check if id exist or not
		if(!employeeRepository.existsById(employeeID))
			throw new EmployeeNotExist("Employee not exist with id: " + employeeID);
		
		employeeRepository.deleteById(employeeID);
		
	}

	@Override
	public void deleteAllEmployees()
	{
		employeeRepository.deleteAll();
		
	}
	
}
