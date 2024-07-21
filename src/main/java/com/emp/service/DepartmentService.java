package com.emp.service;

import java.util.List;

import com.emp.entity.Department;
import com.emp.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchAllDepartment();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
