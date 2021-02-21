package java112.analyzer;
import java.io.*;
import java.util.*;

/** DistinctTokensAnalyzer
 * @author fraisbeck
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    /**
     *  Only allowed instance variable
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
     * @return distinctTokens the list of distinct words recorded
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * Determines if the string given has an actual length before adding it
     * to the distinctTokens set
     * @param token a single worded string
     */
    public void processToken(String token) {
        if (token.length() > 0) {
            distinctTokens.add(token);
        }
    }

    /**
     * Generates an output file that is a list of single words on each line
     * @param inputFilePath  the file to read
     * @param outputFilePath file to write each token too
     */
    public void generateOutputFile (String inputFilePath, String outputFilePath) {
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
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
