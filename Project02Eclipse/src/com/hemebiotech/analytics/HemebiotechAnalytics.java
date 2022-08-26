package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class HemebiotechAnalytics {

    public static void main(String[] args) {
        final ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
        final List<String> symptomsList = reader.getSymptoms();
        final CountSymptomOccurencesFromList counter = new CountSymptomOccurencesFromList(symptomsList);
        final Map<String, Integer> symptomsMap = counter.countSymptoms();
        final ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse\\output.out");
        writer.writeSymptoms(symptomsMap);
    }
}
