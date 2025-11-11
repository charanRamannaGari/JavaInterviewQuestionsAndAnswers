package com.charan.streams;

import com.charan.streams.model.EnumConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupCharacters {
    public static void main(String[] args) {

        List<Character> charsList = Arrays.asList('A', 'b', '3', 'Z', 'x', '#', '7', 'm', '@');

        Map<EnumConstants, List<Character>> charsGroup = charsList.stream().collect(Collectors.groupingBy(
                ch -> {
                    if (Character.isLowerCase(ch)) return EnumConstants.LOWER_CASE;
                    if (Character.isUpperCase(ch)) return EnumConstants.UPPER_CASE;
                    if (Character.isDigit(ch)) return EnumConstants.DIGIT;
                    else return EnumConstants.OTHERS;
                }
        ));

        System.out.println("charsGroup::"+charsGroup);


    }
}
