package io.github.szymonsadowski3.saver;


import io.github.szymonsadowski3.type.VowelSetAndLengthPair;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.Map;

public class FileDataSaver implements DataSaver {
    private final static Logger logger = Logger.getLogger(FileDataSaver.class);

    private String filePath;

    public FileDataSaver(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveData(Map<VowelSetAndLengthPair, Double> avgNumberOfVowelsResults) {
        try {
            FileWriter fstream = new FileWriter(filePath);
            BufferedWriter out = new BufferedWriter(fstream);

            for (Map.Entry<VowelSetAndLengthPair, Double> entry : avgNumberOfVowelsResults.entrySet()) {
                out.write(MessageFormat.format("{0} -> {1}\n", entry.getKey().toString(), entry.getValue()));
            }

            out.close();
        } catch (Exception e) {
            logger.error(MessageFormat.format("Couldn't save results to file {0}!", filePath));
        }
    }
}
