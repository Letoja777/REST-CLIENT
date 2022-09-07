package com.ledenov.spring.rest;

import com.ledenov.spring.rest.configuration.MyConfig;
import com.ledenov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List< Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);
        System.out.println("............................................");
        Employee empById = communication.getEmployee(1);
        System.out.println(empById);
        System.out.println("............................................");

        Employee emp = new Employee("Sveta", "Sokolova", "IT", 800);
        emp.setId(7); //id needs to update employee

        //save or update employee
        communication.saveEmployee(emp);
        System.out.println("............................................");

        //delete employee
        communication.deleteEmployee(7);
    }
}
