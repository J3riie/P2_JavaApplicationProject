package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class parses the given @param filepath and returns a String list containing each file's line
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    private static final Logger logger = Logger.getLogger(ReadSymptomDataFromFile.class.getName());

    /*
     * @param filepath : a full or partial path to file with symptom strings in it, one per line.
     * 
     * If the filepath is empty/blank, an exception is raised.
     */
    public ReadSymptomDataFromFile(String filepath) {
        if (filepath.isEmpty() || filepath.isBlank()) {
            throw new IllegalArgumentException("Le répertoire n'est pas valide");
        }
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        final List<String> symptomsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                symptomsList.add(line);
                line = reader.readLine();
            }
        } catch (final IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return symptomsList;
    }

}
