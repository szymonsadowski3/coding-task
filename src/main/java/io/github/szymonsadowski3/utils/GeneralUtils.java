package io.github.szymonsadowski3.utils;

import java.util.List;
import java.util.OptionalDouble;

public class GeneralUtils {
    public static double listAvg(List<Integer> input) {
        OptionalDouble average = input
                .stream()
                .mapToDouble(a -> a)
                .average();

        return average.isPresent() ? average.getAsDouble() : 0;
    }
}
