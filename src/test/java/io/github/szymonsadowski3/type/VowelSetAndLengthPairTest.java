package io.github.szymonsadowski3.type;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class VowelSetAndLengthPairTest {
    @Test
    public void testSimpleToString1() {
        VowelSetAndLengthPair vowelSetAndLengthPair = new VowelSetAndLengthPair(
                new HashSet<>(Arrays.asList('a', 'o')),
                6
        );
        String expected = "({a, o}, 6)";
        assertEquals(expected, vowelSetAndLengthPair.toString());
    }

    @Test
    public void testSimpleToString2() {
        VowelSetAndLengthPair vowelSetAndLengthPair = new VowelSetAndLengthPair(
                new HashSet<>(Arrays.asList('a', 'e')),
                4
        );
        String expected = "({a, e}, 4)";
        assertEquals(expected, vowelSetAndLengthPair.toString());
    }
}