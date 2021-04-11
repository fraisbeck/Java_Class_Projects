package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * This anaylzer will determin the length distribution of the tokens in the
 * input file and display the distribution in two formats
 * @author fraisbeck
 */

public class TokenLengthsAnalyzer implements TokenAnalyzer {

    // Declare instance variables
    private Map<Integer, Integer> tokenLengths;
    private Properties properties;

    /**
     *  The zero parameter constructor that instantiates the tokenLengths variable
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<Integer, Integer>();
    }

    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Takes the information of the Map and returns the token lengths
     * @return the length of the current token
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token) {
        int tokenSize = token.length();
        if (tokenLengths.containsKey(tokenSize)) {
            tokenLengths.put(tokenSize, tokenLengths.get(tokenSize) + 1);
        } else {
            tokenLengths.put(tokenSize, 1);
        }
    }

    /**
     * The output file will consist of two parts
     * The first part will be a listing of sizes of tokens and the number of tokens that are that size excluding 0
     * The second part will display a histogram of the results.
     * The display will be adjusted for each file to not exceed 80 characters while still showing at least 1 *
     * @param inputFilePath  The file being read or data collected from
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.lengths");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
                if (entry.getKey() != 0) {
                    output.println(entry.getKey() + "\t" + entry.getValue());
                }
            }
            output.println("");
            for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
                if (entry.getKey() != 0) {
                    output.println(entry.getKey() + "\t" + valueToAstrisk(entry.getValue()));
                }
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

    /**
     * Turns the value in a map set to a string of asterisks
     * @param  value a number value taken from a map set
     * @return       a string of asterisks shown in a percentage form
     */
    public String valueToAstrisk(int value) {
        int amountOfStars = 0;
        String stars = "";
        amountOfStars = valuePercentage(value);
        stars = intToAstrisk(amountOfStars);
        return stars;
    }

    /**
     * Converts an integer to a percentage based on the
     * largest value of the map set
     * @param  value the value of the entry
     * @return       the percentage size based on the max value in the map set
     */
    public int valuePercentage (int value) {
        int largestInt = maxValue();
        int total = 0;
        total =  Math.round(((value/(float)largestInt)*80));
        return total;
    }

    /**
     * converts the int value into that many asterisks
     * @param  value the value percentage of the entry
     * @return       a string of asterisks representing the size of the value
     */
    public String intToAstrisk(int value) {
        String stars = "";
        if (value < 1) {
            value = 1;
        }
        for (int i = 0; i < value; i++) {
            stars += "*";
        }
        return stars;
    }

    /**
     * loops through tokenLengths to find the largest int in the Value spot
     * @return the largest value of tokenLengths
     */
    public int maxValue() {
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        return maxValue;
    }
}
