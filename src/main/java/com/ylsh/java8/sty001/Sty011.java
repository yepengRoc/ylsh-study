package com.ylsh.java8.sty001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Sty011 {
    /**
     * Optional
     * @param args
     */
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("zs");

        Employee employee1 = new Employee();
        employee1.setName("ls");

        Company company = new Company();
        company.setName("cmpony1");
        List<Employee> employeeList = Arrays.asList(employee,employee1);
//        company.setEmployees(employeeList);

        List<Employee> list = company.getEmployees();

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(cy -> cy.getEmployees()).orElse(Collections.emptyList()));




    }
}
