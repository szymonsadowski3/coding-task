package io.github.szymonsadowski3.grouper;

import io.github.szymonsadowski3.tokenizer.Tokenizer;
import io.github.szymonsadowski3.tokenizer.WordTokenizer;
import io.github.szymonsadowski3.type.VowelSetAndLengthPair;
import io.github.szymonsadowski3.utils.GeneralUtils;
import io.github.szymonsadowski3.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Grouper {
    private Tokenizer tokenizer = new WordTokenizer();

    public Map<VowelSetAndLengthPair, Double> calculateResults(String inputText) {
        Map<VowelSetAndLengthPair, List<Integer>> aggregation = groupVowelsByVowelsAndWordLength(inputText);

        return calculateAverageNumberOfVowelsPerWord(aggregation);
    }

    private Map<VowelSetAndLengthPair, Double> calculateAverageNumberOfVowelsPerWord(
            Map<VowelSetAndLengthPair, List<Integer>> aggregation
    ) {
        return aggregation
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> GeneralUtils.listAvg(e.getValue())
                        )
                );
    }

    private Map<VowelSetAndLengthPair, List<Integer>> groupVowelsByVowelsAndWordLength(String content) {
        Map<VowelSetAndLengthPair, List<Integer>> vowelsAndWordLengthToListOfVowelsPerWord = new HashMap<>();

        List<String> words = tokenizer.tokenize(content);

        for(String word: words) {
            updateMapBySingleWord(vowelsAndWordLengthToListOfVowelsPerWord, word);
        }

        return vowelsAndWordLengthToListOfVowelsPerWord;
    }

    private void updateMapBySingleWord(
            Map<VowelSetAndLengthPair, List<Integer>> vowelsAndWordLengthToListOfVowelsPerWord,
            String word
    ) {
        int wordLength = word.length();
        List<Character> foundVowels = StringUtils.findCharactersInString(word);
        int howManyVowelsFound = foundVowels.size();
        Set<Character> distinctVowels = new HashSet<>(foundVowels);

        VowelSetAndLengthPair vowelsAndWordLength = new VowelSetAndLengthPair(distinctVowels, wordLength);

        if(vowelsAndWordLengthToListOfVowelsPerWord.containsKey(vowelsAndWordLength)) {
            updateMap(vowelsAndWordLengthToListOfVowelsPerWord, howManyVowelsFound, vowelsAndWordLength);
        } else {
            createNewEntryInMap(vowelsAndWordLengthToListOfVowelsPerWord, wordLength, howManyVowelsFound, distinctVowels);
        }
    }

    private void createNewEntryInMap(Map<VowelSetAndLengthPair, List<Integer>> vowelsAndWordLengthToListOfVowelsPerWord, int wordLength, int howManyVowelsFound, Set<Character> distinctVowels) {
        List<Integer> averageVowelsPerWord = new ArrayList<>();
        averageVowelsPerWord.add(howManyVowelsFound);
        vowelsAndWordLengthToListOfVowelsPerWord.put(
                new VowelSetAndLengthPair(distinctVowels, wordLength),
                averageVowelsPerWord
        );
    }

    private void updateMap(Map<VowelSetAndLengthPair, List<Integer>> vowelsAndWordLengthToListOfVowelsPerWord, int howManyVowelsFound, VowelSetAndLengthPair vowelsAndWordLength) {
        List<Integer> averageVowelsPerWord =
                vowelsAndWordLengthToListOfVowelsPerWord.get(vowelsAndWordLength);
        averageVowelsPerWord.add(howManyVowelsFound);
    }
}
