package com.hemebiotech.analytics.processor;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class parses every @param symptoms of a list and returns the number of times each one occures in a Map
 */
public class ProcessSymptomOccurencesFromList {

    private final List<String> symptoms;

    public ProcessSymptomOccurencesFromList(List<String> symptoms) {
        if (symptoms.isEmpty()) {
            throw new IllegalArgumentException("Le fichier texte donné est vide");
        }
        this.symptoms = symptoms;
    }

    public Map<String, Integer> countSymptoms() {
        final Map<String, Integer> symptomsMap = new TreeMap<>();
        for (final String symptom : symptoms) {
            if (symptomsMap.containsKey(symptom)) {
                symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);
            } else {
                symptomsMap.put(symptom, 1);
            }
        }
        return symptomsMap;
    }
}
