package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * This will determine where search tokens are located in the input file.
 * "where" in the file is defined to be the token count number
 * @author fraisbeck
 */

public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    // Declare instance variables
    private Properties properties;
    private Map<String, List<Integer>> foundLocations;
    private int currentTokenLocation;

    /**
     * The zero parameter constructor that instantiates the foundLocations variable
     */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<String, List<Integer>>();
        currentTokenLocation = 0;

    }

    /**
     * A one parameter constructor that assigns the properties instance variable
     * @param properties a properties file
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        readInFileKeyWords();
    }

    /**
     * gets the location in the file where mapped String value is
     * @return the location of the current String being searched for
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token) {
        currentTokenLocation++;
        List<Integer> list;
        if (foundLocations.containsKey(token)) {
            list = foundLocations.get(token);
            list.add(currentTokenLocation);
            foundLocations.put(token, list);
        }
    }

    /**
     * Reads in a file of key words to search the inputFile for
     */
    public void readInFileKeyWords() {
        try (
            InputStream inputStream = this.getClass().getResourceAsStream(properties.getProperty("classpath.search.tokens"));
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)) {
                while (searchTokensReader.ready()) {
                    String keyWord = searchTokensReader.readLine();
                    keyWord = keyWord.trim();
                    if (keyWord.length() > 0) {
                        foundLocations.put(keyWord, new ArrayList<Integer>());
                    }
                }
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    /**
     * Takes a file and outputs a txt document consisting of the String and the list of integers where they are located in the document.
     * @param inputFilePath  The file being read or data collected from
     */
    public void generateOutputFile (String inputFilePath) {
        String outputFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.search.locations");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (Map.Entry<String, List<Integer>> entry : foundLocations.entrySet()) {
                output.println(entry.getKey() + " =" + "\n" + printArrayList(entry.getValue()));
                output.println("");
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
     * Takes the List of integers from the value in the map and produces a
     * String value that doesn't exceed 80 characters per line.
     * @param  list The List<Integer> from the Map's value slot.
     * @return      a clean string of values where the keyword was found in the inputfile.
     */
    public String printArrayList (List<Integer> list) {
        Iterator itr = list.iterator();
        String outputFull = "[";
        String outputLine = "";
        while (itr.hasNext()) {
            outputLine += itr.next();
            if (itr.hasNext()) {
                outputLine += ",";
            } else {
                outputFull += outputLine;
            }
            if (outputLine.length() > 70) {
                outputFull += outputLine;
                outputLine = "\n";
            } else {
                outputLine += " ";
            }
        }
        outputFull += "]";
        return outputFull;
    }
}
