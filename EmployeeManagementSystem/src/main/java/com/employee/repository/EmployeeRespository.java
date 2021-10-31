package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRespository extends CrudRepository<Employee, Integer>{
	
}

//public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
//	
//}
