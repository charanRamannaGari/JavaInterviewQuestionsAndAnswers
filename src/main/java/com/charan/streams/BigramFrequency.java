package com.charan.streams;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigramFrequency {
    public static void main(String[] args) {

        String paragraph = "Java is power ful. Java is great. java is boom";
        String[] words = paragraph.toLowerCase()
        .replaceAll("[^a-z\\s]", "").split(" ");

        Map<String, Long> bigramFrequency = IntStream.range(0, words.length - 1)
                .mapToObj(i -> words[i] + " " + words[i + 1])
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("bigramFrequency::"+bigramFrequency);
    }
}
