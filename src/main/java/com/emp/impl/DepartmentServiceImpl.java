package com.emp.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Department;
import com.emp.exception.DepartmentNotFoundException;
import com.emp.repo.DepartmentRepository;
import com.emp.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchAllDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department with given ID not found");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		var departmentDB = departmentRepository.findById(departmentId).get();
		 if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			 departmentDB.setDepartmentName(department.getDepartmentName());
		 }
		 if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			 departmentDB.setDepartmentAddress(department.getDepartmentAddress());
		 }
		 if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			 departmentDB.setDepartmentCode(department.getDepartmentCode());
		 }
		return departmentRepository.save(departmentDB);
		
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
