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

public class LexicalDensityAnalyzer implements TokenAnalyzer {

    // Declare instance variables
    private Properties properties;
    private Set<String> nonLexicalWords;
    private Set<String> allWordsFound;
    private Set<String> lexicalWordsFound;

    /**
     * The zero parameter constructor
     */
    public LexicalDensityAnalyzer() {
        nonLexicalWords = new TreeSet<String>();
        allWordsFound = new TreeSet<String>();
        lexicalWordsFound = new TreeSet<String>();
        setLexicalDensityWords("config/NonLexicalWords.txt");
    }


    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public LexicalDensityAnalyzer(Properties properties) {
        this();
        this.properties = properties;

    }

    public void setLexicalDensityWords(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.ready()) {
                String tokensInfo = reader.readLine();
                String[] tokensMade = wordGenerator(tokensInfo);
                nonLexicalSetProcessor(tokensMade);
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
    public String[] wordGenerator(String inputLine) {
        return inputLine.split("\\W");
    }

    /**
     *  Loops through an array of strings and sends each string that is
     *  longer than 0 characters through
     *  two different processors
     *  @param tokens an array of strings
     */
    public void nonLexicalSetProcessor(String[] tokens) {
        for (String word : tokens) {
            nonLexicalWords.add(word.toLowerCase());
        }
    }

    /**
     * Returns the map of non lexical tokens
     * @return the words and an integer of how they are listed
     */
    public Set<String> getNonLexicalWords() {
        return nonLexicalWords;
    }

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token) {
        String lowerCaseToken = token.toLowerCase();
        allWordsFound.add(lowerCaseToken);
        if (!nonLexicalWords.contains(lowerCaseToken) && lowerCaseToken.matches("[a-zA-Z]+")) {
            lexicalWordsFound.add(lowerCaseToken);
        }
    }

    public Float lexicalDensityCalculator() {
        Float lexicalDensity = ((100 * (float)lexicalWordsFound.size()) / allWordsFound.size());
        return lexicalDensity;

    }

    /**
     * Takes the file paths and takes data from one and writes data to the other
     * depending on the analyzer using it
     * @param inputFilePath  The file being read or data collected rom
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.lexical.words");
        Float percentage = lexicalDensityCalculator();
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            output.println("The lexical density of " + inputFilePath + " is " + String.format("%.0f%%",percentage));
            for (String token : lexicalWordsFound) {
                output.println(token);
            }
            //output.println(allWordsFound);
            //output.println(nonLexicalWords);
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
