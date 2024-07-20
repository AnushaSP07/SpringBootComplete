package com.emp;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class BeanLifeCycle {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
	
	Doctor doctor = context.getBean(Doctor.class);
//	doctor.assist();
//	doctor.setQualification();
	
}

@Component
@Scope(scopeName = "prototype")
class Doctor implements Staff, BeanNameAware{

	private String qualification;
	
	public void assist() {
		System.out.println("Doctor is assiting");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("set bean name method is called");
	}
}

interface Staff{
	public void assist();
}
