package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 * Sepparates single worded string values into a unique list
 * by comparing them to the current list before storing them
 * then prints them to a new file document
 * @author fraisbeck
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    /**
     *  Declare Instance Variable used for storing distinct single word Strings
     *  from a given file
     */
    private Set<String> distinctTokens;

    /**
     *  The zero parameter constructor that instantiates the
     *  distinctTokens variable into a new TreeSet
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<String>();
    }

    /**
     * Returns the set of distinctTokens
     * @return the list of distinct words recorded
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * Adds the given single word string value to the list when called
     * @param token a single worded string
     */
    public void processToken(String token) {
            distinctTokens.add(token);
    }

    /**
     * Generates an output file that is a list of single words on each line
     * @param inputFilePath  the file to read
     * @param outputFilePath file to write each token too
     */
    public void generateOutputFile (String inputFilePath, String outputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (String token : distinctTokens) {
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
