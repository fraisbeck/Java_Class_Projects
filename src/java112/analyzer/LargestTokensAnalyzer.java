package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * Stores unique tokens that are greater than or equal to a specified number.
 * The output for this will look like the distinct tokens data file, except it will
 * have fewer words.
 * The specified number for the minimum length token must come from the project Properties
 * object and can't be hard-coded into the class
 * @author fraisbeck
 */

public class LargestTokensAnalyzer implements TokenAnalyzer {

    // Declare instance variables
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     *  The zero parameter constructor that accesses the minimum length from the
     *  property
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<String>();
    }

    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length"));
    }

    /**
     * Get's the largets token list
     * @return the list of largest token words
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
     * Generates an output file that is a list of single words on each line based on the size of the word
     * @param inputFilePath  The file being read or data collected from
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.largest.words");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (String token : largestTokens) {
                output.println(token);
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
