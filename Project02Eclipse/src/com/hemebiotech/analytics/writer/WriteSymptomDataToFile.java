package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class parses the given @param symptoms and writes into @param filepath every String : Integer pair in it.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    private static final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());

    /*
     * @param filepath a full or partial path to a file where to write into, file is created if it doesn't exists
     */
    public WriteSymptomDataToFile(String filepath) {
        if (filepath.isEmpty() || filepath.isBlank()) {
            throw new IllegalArgumentException("Le répertoire n'est pas valide");
        }
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (final Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (final IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

}
