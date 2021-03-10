package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 *  Opens a given file and reads every line in the document
 *  While sending the results to two different analyzer classes to store the
 *  data read
 *  @author fraisbeck
 */

public class FileAnalysis implements PropertiesLoader {

    /**
     *  Declare constant variable for how many files are to be allowed into the program at once
     */
    private static final int validCommandLineArguments = 2;

    /**
     * Declare instance variables
     */
    List<TokenAnalyzer> myAnalyzers;

    /**
     *  Determines if the amount of arguments or files that are given meet the
     *  number requirments to properly run the program and if not kill the code
     *  @param arguments Command Line arguments of an input file
     */
    public void analyze(String[] arguments) {
        if (arguments.length != validCommandLineArguments) {
            System.out.println("Please enter two arguments on the command line, an input file name and a properties file");
        } else {
            instantiateVariables(loadProperties(arguments[1]));
            run(arguments[0]);
        }
    }

    /**
     *  Runs several methods of the class in order
     *  @param input file to be read
     */
    public void run(String input) {
        openFile(input);
        writeOutputFiles(input);
    }

    /**
     *  Instantiate instances of analyzers
     */
    public void instantiateVariables(Properties property) {
        myAnalyzers = new ArrayList<TokenAnalyzer>();
        myAnalyzers.add(new FileSummaryAnalyzer(property));
        myAnalyzers.add(new DistinctTokensAnalyzer(property));
        myAnalyzers.add(new LargestTokensAnalyzer(property));
        myAnalyzers.add(new DistinctTokenCountsAnalyzer(property));
        myAnalyzers.add(new LexicalDensityAnalyzer(property));
    }

    /**
     *  Opens the input file and beings to read it line by line
     *  then separates those lines into arrays of words
     *  then takes those words and processes them
     *  @param inputFile the file to be read
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
     *  Splits words in a line based on non-word characters
     *  @param inputLine a multiworded string to be broken down
     */
    public String[] tokenGenerator(String inputLine) {
        return inputLine.split("\\W");
    }

    /**
     *  Loops through an array of strings and sends each string that is
     *  longer than 0 characters through
     *  two different processors
     *  @param tokens an array of strings
     */
    public void tokenProcessor(String[] tokens) {
        for (String word : tokens) {
            if (word.length() > 0) {
                analyzerProcessorLoop(word);
            }
        }
    }

    /**
     * Loops through all the analyzers we have and runs the processToken method
     * @param token a single string value
     */
    public void analyzerProcessorLoop(String token) {
        for (TokenAnalyzer list : myAnalyzers) {
            list.processToken(token);
        }
    }

    /**
     *  Sends the input file through all analyzers to generate files based on
     *  the input file given
     *  @param inputFile the input file to use for output data
     */
    public void writeOutputFiles(String inputFile) {
        for (TokenAnalyzer list : myAnalyzers) {
            list.generateOutputFile(inputFile);
        }
    }
}
