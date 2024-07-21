package com.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {
   int id;
   String empName;
   int empAge;
   
   
   public static String upperCase(String str)
   {
	   return str.toUpperCase();
   }
   
   
	public static void main(String[] args) {
	
		Employee e = Employee.builder().id(1).empAge(20).empName("Anusha").build();

		Employee e1 = Employee.builder().id(2).empAge(19).empName("Karan").build();

		Employee e2 = Employee.builder().id(3).empAge(25).empName("Nihar").build();

		Employee e3 = Employee.builder().id(4).empAge(22).empName("Libin").build();
		
		List<Employee> list = new ArrayList<>();
           list.add(e3);
           list.add(e2);
           list.add(e1);
           list.add(e);
           
         List<String> data =  list.stream().map(Employee::getEmpName).map(Employee::upperCase).collect(Collectors.toList());
         System.out.println(data);
	}

}
