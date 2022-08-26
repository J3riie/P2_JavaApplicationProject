package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
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
