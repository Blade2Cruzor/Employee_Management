package com.employee.Employee.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDTO
{
	private Long empID;
	private String empName;
	private Long empAge;
	private Long empSalary;
	private LocalDate empDOB;
}
