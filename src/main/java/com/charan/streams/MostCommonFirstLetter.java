package com.charan.streams;

import com.charan.streams.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MostCommonFirstLetter {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "charan", 150000, "IT"),
                new Employee(2, "kumar", 50000, "HR"),
                new Employee(3, "ram", 70000, "IT"),
                new Employee(4, "gari", 40000, "FINANCE"),
                new Employee(5, "john", 120000, "IT"),
                new Employee(6, "Raman", 90000, "OPERATIONS")
        );

        Map<Character, Long> frequencyMap = employeeList.stream()
                .collect(Collectors.groupingBy(
                        emp -> Character.toLowerCase(emp.getName().charAt(0)),
                        Collectors.counting()
                ));

        frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println("Most common first letter: "
                                + entry.getKey() + " = " + entry.getValue()));
    }
}