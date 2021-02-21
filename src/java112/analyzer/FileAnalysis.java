package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *  FileAnalysis
 *  @author fraisbeck
 */

public class FileAnalysis {

    /**
     *  Declare constant variables
     */
    private static final int validCommandLineArguments = 1;


    /**
     *  Declare instance variables of each analyzer class
     */
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;

    /**
     *  Main method to run our program
     *  @param arguments Command Line arguments of an input file
     */
    public void analyze(String[] arguments) {
        if (arguments.length != validCommandLineArguments) {
            System.out.println("Please enter one argument on the command line, an input file name");
        } else {
            FileAnalysis fileAnalysis = new FileAnalysis();
            fileAnalysis.run(arguments[0]);
        }
    }

    /**
     *  Runs several methods in the function in order
     *  @param input input file to read
     */
    public void run(String input) {
        instantiateVariables();
        openFile(input);
        writeOutputFiles(input);
    }

    /**
     *  Instantiate variables
     */
    public void instantiateVariables() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }

    /**
     *  Opens the input file and beings to read it line by line
     *  then separates those lines into arrays of words
     *  then takes those words and processes them
     *  @param inputFile the input file to read
     */
    public void openFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.ready()) {
                String lineOfTokenInfo = reader.readLine();
                String[] tokensMade = tokenGenerator(lineOfTokenInfo);
                tokenProcessor(tokensMade);
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
     *  Splits words in a line based on empty characters
     *  @param inputLine a multiworded string to be broken down
     */
    public String[] tokenGenerator(String inputLine) {
        return inputLine.split("\\W");
    }

    /**
     *  Loops through an array of strings and sends each word through
     *  two different processors
     *  @param tokens an array of strings
     */
    public void tokenProcessor(String[] tokens) {
        for (int counter = 0; counter < tokens.length; counter++) {
            distinctAnalyzer.processToken(tokens[counter]);
            summaryAnalyzer.processToken(tokens[counter]);
        }
    }

    /**
     *  Sends the input file through all analyzers to generate files based on
     *  the input file given
     *  @param inputFile the input file to use for output data
     */
    public void writeOutputFiles(String inputFile) {
        distinctAnalyzer.generateOutputFile(inputFile, "output/distinct_tokens.txt");
        summaryAnalyzer.generateOutputFile(inputFile, "output/summary.txt");

    }
}
