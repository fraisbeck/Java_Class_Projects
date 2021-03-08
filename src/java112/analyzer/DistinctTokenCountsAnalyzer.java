package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * This will count the number of unique tokens
 * The output for this will contain a row for each unique token
 * Each row will have the token, a tab character, and the number of times the token
 * occurred in the file
 * @author fraisbeck
 */

public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    // Declare instance variables
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;


    /**
     *  The zero parameter constructor that instantiates the distinctTokensCounts variable
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new HashMap<String, Integer>();
    }

    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns the map of distinct tokens count
     * @return the token itself and an integer of how many times it was found
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token) {
        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.put(token, distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
    }

    /**
     * Takes two file paths and takes data from one and writes data to the other
     * depending on the analyzer using it
     * @param inputFilePath  The file being read or data collected rom
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.distinct.counts");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (Map.Entry<String, Integer> entry : distinctTokenCounts.entrySet()) {
                output.println(entry.getKey() + "\t" + entry.getValue());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException IOException) {
            System.out.println("File could not be read");
            IOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        }
    }
}
