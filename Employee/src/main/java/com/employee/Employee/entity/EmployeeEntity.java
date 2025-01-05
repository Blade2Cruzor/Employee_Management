package com.employee.Employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
public class EmployeeEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empID;
	
	@Column(name = "Name")
	private String empName;
	
	@Column(name = "Age")
	private Long empAge;
	
	@Column(name = "Salary")
	private Long empSalary;
	
	@Column(name = "Date_of_Birth")
	private LocalDate empDOB;
}
