package java112.analyzer;
import java.io.*;
import java.util.*;

/** FileAnalysis
 * @author fraisbeck
 */

public class FileAnalysis {

    /** Declare constant variables
     */
    private static final int validCommandLineArguments = 1;


    /** Declare instance variables of each analyzer class
     */
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;
    private List<String> arrayOfTokens;


    public void analyze(String[] arguments) {
        if (arguments.length != validCommandLineArguments) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            FileAnalysis fileAnalysis = new FileAnalysis();
            fileAnalysis.run(arguments[0]);
        }
    }

    public void run(String input) {
        instantiateVariables();
        openFile(input);
        passTokens();
        writeOutputFiles(input);
    }

    public void instantiateVariables() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
        arrayOfTokens = new ArrayList<String>();
    }

    public void openFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.ready()) {
                String lineOfTokenInfo = reader.readLine();
                String[] lineInfo = parseLineOfFile(lineOfTokenInfo);
                tokenGenerator(lineInfo);
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

    public String[] parseLineOfFile(String inputLine) {
        return inputLine.split("\\W");
    }

    public void tokenGenerator(String[] line) {
        for (int index = line.length-1; index>=0; index--) {
            if (line[index].length() != 0) {
                arrayOfTokens.add(line[index]);
            }
        }
    }

    public void passTokens() {
        for (String token : arrayOfTokens) {
            distinctAnalyzer.processToken(token);
            summaryAnalyzer.processToken(token);
        }
    }

    public void writeOutputFiles(String inputFile) {
        distinctAnalyzer.generateOutputFile(inputFile, "distinct_tokens.txt");
        summaryAnalyzer.generateOutputFile("distinct_tokens.txt", "summary.txt");

    }
}
