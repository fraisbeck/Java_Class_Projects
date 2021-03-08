package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * A Token analyzer interface for implimenting into other analyzer classes
 * @author fraisbeck
 */

public interface TokenAnalyzer {

    /**
     * Takes in a single word string and processes it depending on the analyzer
     * @param token Single word string value
     */
    public void processToken(String token);

    /**
     * Takes two file paths and takes data from one and writes data to the other
     * depending on the analyzer using it
     * @param inputFilePath  The file being read or data collected rom
     */
    public void generateOutputFile (String inputFilePath);
}
