package com.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import java.util.List;
@Controller
public class EmpController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		Iterable<Employee> employee = service.getAllEmployee();
		m.addAttribute("emp",employee);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session){
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id , Model m) {
		
		Employee employee = service.getEmployeeId(id);
		m.addAttribute("emp", employee);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e , HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg" , "Employee Data Added Successfully");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id , HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg" , "Employee Data Delete Successfully");
		return "redirect:/";
	}
	
}
