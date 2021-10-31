package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRespository;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRespository repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}
	
	public Iterable<Employee> getAllEmployee(){
		return repo.findAll();
	}
	
	public Employee getEmployeeId(int id) {
	    Optional<Employee> e = repo.findById(id);
	    if(e.isPresent()) {
	    	return e.get();
	    }
	    return null;
	}
//	public void updateEmp() {
//		
//	}
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}
}
