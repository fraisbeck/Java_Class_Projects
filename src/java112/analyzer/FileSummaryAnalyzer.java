package java112.analyzer;
import java.io.*;
import java.util.*;

/** FileSummaryAnalyzer
 * @author fraisbeck
 */

public class FileSummaryAnalyzer implements TokenAnalyzer {

    // Only allowed instance variable
    private int totalTokensCount;

    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }

    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    public void processToken(String token) {
        totalTokensCount++;
    }

    public void generateOutputFile (String inputFilePath, String outputFilePath) {
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output/" + outputFilePath)))) {

            while (input.ready()) {
            }
            output.println("Hello");
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
