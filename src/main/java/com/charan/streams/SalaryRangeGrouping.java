package com.charan.streams;

import com.charan.streams.model.Employee;
import com.charan.streams.model.EnumConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalaryRangeGrouping {
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "ramanna", 50000),
                new Employee(2, "gari", 40000),
                new Employee(3, "ram", 70000),
                new Employee(4, "charan", 120000),
                new Employee(5, "kumar", 50000)
        );

        Map<EnumConstants, List<Employee>> employeesBasedOnSalaryRange = employeeList.stream().collect(Collectors.groupingBy(
                e -> {
                    if (e.getSalary() < 50000) return EnumConstants.LOW;
                    if (e.getSalary() < 100000) return EnumConstants.MEDIUM;
                    else return EnumConstants.HIGH;
                }
        ));

        System.out.println("employeesBasedOnSalaryRange::"+employeesBasedOnSalaryRange);
    }
}
