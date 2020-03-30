package io.github.szymonsadowski3.reader;

import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Optional;

public class FileDataReader implements DataReader {
    private final static Logger logger = Logger.getLogger(FileDataReader.class);

    private String filePath;

    public FileDataReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Optional<String> readData() {
        try {
            String loadedContent = new String(Files.readAllBytes(Paths.get(filePath)));
            return Optional.of(loadedContent);
        } catch(Exception e){
            logger.error(MessageFormat.format("When reading file {0} such exception happened!", filePath), e);
            return Optional.empty();
        }
    }
}
