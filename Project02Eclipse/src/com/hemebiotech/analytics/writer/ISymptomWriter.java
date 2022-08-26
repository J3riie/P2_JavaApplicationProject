package com.hemebiotech.analytics.writer;

import java.util.Map;

/**
 * Anything that will write symptom data to an output. The important part is the parameter type, which is a map of <String, Integer>, that should not contain
 * any duplication as it should have been processed first by @class CountSymptomOccurencesFromList
 */
public interface ISymptomWriter {

    /**
     * Doesn't return anything, the output is a file with the symptoms counted, sorted and listed
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
