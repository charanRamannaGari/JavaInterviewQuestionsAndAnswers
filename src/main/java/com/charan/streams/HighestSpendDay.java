package com.charan.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HighestSpendDay {
    public static void main(String[] args) {

        List<Transactions> txsList = Arrays.asList(
                new Transactions("T1", LocalDate.of(2025, 11, 7), 300d),
                new Transactions("T2", LocalDate.of(2025, 11, 12), 100d),
                new Transactions("T3", LocalDate.of(2025, 11, 12), 800d),
                new Transactions("T4", LocalDate.of(2025, 11, 9), 200d),
                new Transactions("T5", LocalDate.of(2025, 11, 8), 700d)
        );

        Map<LocalDate, Double> collect = txsList.stream().collect(
                Collectors.groupingBy(Transactions::getDate, Collectors.summingDouble(Transactions::getAmount))
        );

        Map.Entry<LocalDate, Double> maxValuePerDay = collect.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("maxValuePerDay::"+maxValuePerDay);

    }
}
