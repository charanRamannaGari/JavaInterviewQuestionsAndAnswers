package com.charan.streams;

import com.charan.streams.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWith3Departments {
    public static void main(String[] args) {

        List<Employee> employeeList = List.of(
                new Employee(10, "kumar", 10000, "Dev"),
                new Employee(30, "kumar", 50000, "Hr"),
                new Employee(20, "kumar", 80000, "Qa"),
                new Employee(40, "charan", 120000, "Hr"),
                new Employee(50, "charan", 150000, "Dev"),
                new Employee(51, "charan", 150000, "Qa")
        );

        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(
                Employee::getName
                ));

        List<String> list = collect.entrySet().stream().filter(
                entry -> entry.getValue().size() >= 3
        ).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("list:::"+list);
    }
}
