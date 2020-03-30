package io.github.szymonsadowski3.application;

import io.github.szymonsadowski3.grouper.Grouper;
import io.github.szymonsadowski3.reader.DataReader;
import io.github.szymonsadowski3.reader.FileDataReader;
import io.github.szymonsadowski3.saver.DataSaver;
import io.github.szymonsadowski3.saver.FileDataSaver;
import io.github.szymonsadowski3.type.VowelSetAndLengthPair;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Optional;

public class Task {
    private final static Logger logger = Logger.getLogger(Task.class);

    private DataReader dataReader = new FileDataReader("INPUT.txt");
    private DataSaver dataSaver = new FileDataSaver("OUTPUT.txt");
    private Grouper grouper = new Grouper();

    public void runTask() {
        Optional<String> inputText = dataReader.readData();
        if(inputText.isPresent()) {
            Map<VowelSetAndLengthPair, Double> results = grouper.calculateResults(inputText.get());
            dataSaver.saveData(results);
        } else {
            logger.warn("Couldn't perform task as file reading failed!");
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        task.runTask();
    }
}
