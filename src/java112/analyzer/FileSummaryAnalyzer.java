package java112.analyzer;
import java.io.*;
import java.util.*;
import java.text.*;
import java112.utilities.*;

/**
 * Gathers information about an input file and displays the File data to a new document
 * @author fraisbeck
 */

public class FileSummaryAnalyzer implements TokenAnalyzer {

    /**
     *  New Instance variables
     */
    private int totalTokensCount;
    private Properties properties;

    /**
     * The zero parameter constructor that starts the
     * token count at 0
     */
    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }

    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns the total number of tokens counted from the input file
     * @return the total number of tokens counted
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     * Adds 1 to the int value of the class whenever it's called with a string
     * @param token a single word gatherd from the input file
     */
    public void processToken(String token) {
            totalTokensCount++;
    }

    /**
     * Reads the input file given and gathers several pieces of data and writes
     * that information to the output file entered
     *   the absolute path
     *   the date it was read
     *   the date it was last modified
     *   the size of the file
     *   the exact URI of the file
     *   the total number of words in the file
     *
     * @param inputFilePath  the file being read
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.summary");
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            File inputFile = new File(inputFilePath);

            output.println("Application: " + properties.getProperty("application.name"));
            output.println("Author: " + properties.getProperty("author"));
            output.println("Author Email: " + properties.getProperty("author.email.address"));
            output.println("File: " + inputFile.getAbsolutePath());
            java.util.Date date = new java.util.Date();
            output.println("Date of analysis: " + date);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
            output.println("Last Modified: " + sdf.format(inputFile.lastModified()));
            output.println("File Size: " + inputFile.length());
            output.println("File URI: " + inputFile.toURI());
            output.println("Total Tokens: " + totalTokensCount);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found " + inputFilePath);
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
