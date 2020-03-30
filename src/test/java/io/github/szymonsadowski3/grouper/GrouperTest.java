package io.github.szymonsadowski3.grouper;

import io.github.szymonsadowski3.type.VowelSetAndLengthPair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GrouperTest {
    private static Grouper grouper = new Grouper();

    @Test
    public void testSimpleCalculateResults() {
        Map<VowelSetAndLengthPair, Double> expected = new HashMap<>();
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('o')),4), 1.0);

        Map<VowelSetAndLengthPair, Double> actual = grouper.calculateResults("word");

        assertThat( actual.entrySet(), everyItem(isIn(expected.entrySet())));
        assertThat( expected.entrySet(), everyItem(isIn(actual.entrySet())));
    }

    @Test
    public void testCalculateResults() {
        Map<VowelSetAndLengthPair, Double> expected = new HashMap<>();
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('a', 'o')),5), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('a', 'o')),6), 2.5);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('a', 'e')),4), 2.0);

        Map<VowelSetAndLengthPair, Double> actual = grouper.calculateResults("Platon made bamboo boats.");

        assertThat( actual.entrySet(), everyItem(isIn(expected.entrySet())));
        assertThat( expected.entrySet(), everyItem(isIn(actual.entrySet())));
    }

    @Test
    public void testCalculateResultsWithNewlines() {
        Map<VowelSetAndLengthPair, Double> expected = new HashMap<>();
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('e')),4), 1.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('e', 'o')),5), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('i', 'y')),6), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('a')),8), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('u', 'y')),5), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('u', 'i')),5), 2.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('i')),2), 1.0);
        expected.put(new VowelSetAndLengthPair(new HashSet<>(Arrays.asList('e')),3), 1.0);

        Map<VowelSetAndLengthPair, Double> actual = grouper.calculateResults(
                "Lorem Ipsum is simply dummy text.\n " +
                        "Lorem Ipsum is the standard"
        );

//        System.out.println(actual);
        assertThat( actual.entrySet(), everyItem(isIn(expected.entrySet())));
        assertThat( expected.entrySet(), everyItem(isIn(actual.entrySet())));
    }
}