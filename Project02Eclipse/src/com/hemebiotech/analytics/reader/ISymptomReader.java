package com.hemebiotech.analytics.reader;

import java.util.List;

/**
 * Anything that will read symptom data from a source The important part is, the return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
    /**
     * If no data is available, returns an empty list
     * 
     * @return a raw listing of all Symptoms obtained from a data source
     */
    List<String> getSymptoms();

}
