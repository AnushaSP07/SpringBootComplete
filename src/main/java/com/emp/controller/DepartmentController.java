package com.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Department;
import com.emp.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		LOGGER.info("Inside save department of controller");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/department")
	public List<Department> fetchAllDepartment(){
		return departmentService.fetchAllDepartment();
	}
	
	@GetMapping("/department/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId){
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/department/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
