package io.github.szymonsadowski3.saver;

import io.github.szymonsadowski3.type.VowelSetAndLengthPair;

import java.util.Map;

public interface DataSaver {
    void saveData(Map<VowelSetAndLengthPair, Double> avgNumberOfVowelsResults);
}
