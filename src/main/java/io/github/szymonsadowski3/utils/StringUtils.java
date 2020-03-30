package io.github.szymonsadowski3.utils;

import java.util.*;

public class StringUtils {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

    private static ArrayList<String> arrayToList(String [] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static String removeNonLetterCharacters(String input) {
        return input.replaceAll("[^a-zA-Z ]", "");
    }

    public static ArrayList<String> splitToLines(String text) {
        return arrayToList(text.split("\\r?\\n"));
    }

    public static ArrayList<String> splitToWords(String line) {
        return arrayToList(line.split("[\\s]+"));
    }

    public static List<Character> findCharactersInString(String inputString) {
        List<Character> foundCharacters = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char checkedChar = inputString.charAt(i);

            if(VOWELS.contains(checkedChar)) {
                foundCharacters.add(checkedChar);
            }
        }

        return foundCharacters;
    }
}
