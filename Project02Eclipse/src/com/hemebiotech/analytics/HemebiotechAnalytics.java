package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.processor.ProcessSymptomOccurencesFromList;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.ISymptomWriter;
import com.hemebiotech.analytics.writer.WriteSymptomDataToFile;

public class HemebiotechAnalytics {

    public static void main(String[] args) {
        final ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
        final List<String> symptomsList = reader.getSymptoms();
        final ProcessSymptomOccurencesFromList processor = new ProcessSymptomOccurencesFromList(symptomsList);
        processor.sortSymptoms();
        final Map<String, Integer> symptomsMap = processor.countSymptoms();
        final ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse\\output.out");
        writer.writeSymptoms(symptomsMap);
    }
}
