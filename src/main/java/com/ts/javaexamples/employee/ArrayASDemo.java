package com.ts.javaexamples.employee;

import java.util.ArrayList;

public class ArrayASDemo {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setDepartment("department");
        employee.setSalary(5000);
        employee.setAddress("test address");
        employee.setContactNo(123456);
        employee.setEmailId("test@test.com");
        employee.setPosition("position1");
        employee.setExperience(5);
        for (int i=1; i <= 30; i++){
            employee.setId(i);
            employeeList.add(employee);
        }
        System.out.println("Employee List Size : "+employeeList.size());
        System.out.println("First Employee : "+employeeList.get(0));
        System.out.println("Last Employee : "+employeeList.get(employeeList.size()-1));
        employeeList.remove(employeeList.size()-1);
        employeeList.remove(0);
        employeeList.remove(2);
        employee.setId(31);
        employeeList.add(employeeList.size()-1, employee);
        employee.setId(32);
        employeeList.add(0, employee);
        employee.setId(33);
        employeeList.add(1, employee);
    }
}
