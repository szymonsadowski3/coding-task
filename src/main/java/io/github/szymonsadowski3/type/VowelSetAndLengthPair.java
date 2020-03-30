package io.github.szymonsadowski3.type;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class VowelSetAndLengthPair {
    private Set<Character> vowels;
    private int length;

    public VowelSetAndLengthPair(Set<Character> vowels, int length) {
        this.vowels = vowels;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VowelSetAndLengthPair that = (VowelSetAndLengthPair) o;
        return length == that.length &&
                vowels.equals(that.vowels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vowels, length);
    }

    @Override
    public String toString() {
        String joinedVowels = vowels.stream().map(Object::toString).collect(Collectors.joining(", "));
        String setRepresentation = MessageFormat.format("'{'{0}'}'", joinedVowels);
        return MessageFormat.format("({0}, {1})", setRepresentation, length);
    }
}
