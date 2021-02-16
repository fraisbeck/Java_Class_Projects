package java112.analyzer;
import java.io.*;
import java.util.*;

/** DistinctTokensAnalyzer
 * @author fraisbeck
 */

public class DistinctTokensAnalyzer implements TokenAnalyzer {

    // Only allowed instance variable
    Set<String> distinctTokens;

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<String>();
    }

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    public void processToken(String token) {
        distinctTokens.add(token);
    }

    public void generateOutputFile (String inputFilePath, String outputFilePath) {
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output/" + outputFilePath)))) {

            while (input.ready()) {
            
            }
            for (String token : distinctTokens) {
                output.println(token);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("File could not be read");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        }
    }
}
