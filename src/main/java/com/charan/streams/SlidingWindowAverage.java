package com.charan.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 8, 15, 16, 23, 42);

        int window = 4;
        List<Double> collect = IntStream.range(0, input.size() - (window - 1))
                .mapToObj(i -> input.subList(i, i + window))
                .map(w -> w.stream().mapToInt(Integer::intValue)
                        .average().orElse(0.0)).collect(Collectors.toList());

        System.out.println(collect);

        // TimeComplexcity O(n)
        List<Integer> input1 = Arrays.asList(4, 8, 15, 16, 23, 42);
        int window1 = 4;

        List<Double> result = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < input1.size(); i++) {
            sum += input1.get(i);

            if (i >= window) {
                sum -= input1.get(i - window1);
            }

            if (i >= window1 - 1) {
                result.add(sum / (double) window1);
            }
        }

        System.out.println(result);
    }
}
